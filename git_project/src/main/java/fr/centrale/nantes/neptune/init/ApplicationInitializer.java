/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import fr.centrale.nantes.ldap.LDAPManager;
import fr.centrale.nantes.neptune.items.Person;
import fr.centrale.nantes.neptune.items.Role;
import fr.centrale.nantes.neptune.controllers.tools.SecurityTools;
import fr.centrale.nantes.neptune.items.Acquisitiongrade;
import fr.centrale.nantes.neptune.items.Action;
import fr.centrale.nantes.neptune.items.Menu;
import org.springframework.stereotype.Controller;

/**
 * Application initializer
 *
 * @author kwyhr
 */
@Controller
public class ApplicationInitializer implements ServletContextListener {

    private static final String PUNAME = "fr.centrale.nantes_Neptune_war_1.0PU";
    private static EntityManager em;

    /**
     * Initialise
     * @param event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PUNAME);
        Cache theCache = emf.getCache();
        theCache.evictAll();
        em = emf.createEntityManager();
        try {
            // Get data
            Map<String, Object> properties = em.getProperties();
            String dbUser = (String) properties.get("javax.persistence.jdbc.user");
            String dbPass = (String) properties.get("javax.persistence.jdbc.password");
            String dbURL = (String) properties.get("javax.persistence.jdbc.url");
            String dbDriver = (String) properties.get("javax.persistence.jdbc.driver");
        } catch (Exception ex) {
            Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.INFO, null, ex);
        }

        // Initialize data
        initLDAP();
        createDefault();

        // close
        em.close();
        emf.close();
    }

    /**
     * End
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    /**
     * Get a String configuration from the resource file
     *
     * @param res
     * @param element
     * @param defaultValue
     * @return
     */
    private static String getResourceElement(ResourceBundle res, String element, String defaultValue) {
        String newValue;
        String returnValue;

        returnValue = defaultValue;
        if (res != null) {
            try {
                newValue = res.getString(element);
                if (!newValue.equals("")) {
                    returnValue = newValue;
                }
            } catch (Exception e) {
            }
        }
        return returnValue;
    }

    /**
     * Get a String configuration from the resource file
     *
     * @param res
     * @param element
     * @return
     */
    private static String getResourceElement(ResourceBundle res, String element) {
        return getResourceElement(res, element, "");
    }

    private static void initLDAP() {
        try {
            ResourceBundle parametre = ResourceBundle.getBundle(ApplicationInitializer.class.getPackage().getName() + ".ldap");
            // USE config parameters
            String ldapHost = getResourceElement(parametre, "ldapHost");
            String ldapBasedn = getResourceElement(parametre, "ldapBasedn");
            String ldapsecurityprotocol = getResourceElement(parametre, "ldapsecurityprotocol");

            LDAPManager.init(ldapHost, ldapBasedn, ldapsecurityprotocol);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* ----------------------------------------------------------------------- */
    /**
     * Create default values in Database. This is called once, when application
     * starts
     */
    private void createDefault() {
        createDefaultRoles();
        createDefaultUsers();
        createDefaultMenus();
        createDefaultActions();
        createDefaultGrades();
    }

    /* ----------------------------------------------------------------------- */
    private Object getItemFromID(int id, String requestName, Class classType, String fieldName) {
        Object item = null;
        try {
            Query theQuery = em.createNamedQuery(requestName, classType);
            theQuery.setParameter(fieldName, id);
            item = theQuery.getSingleResult();
        } catch (NoResultException ex) {
        }
        return item;
    }

    private Object getItemFromString(String value, String requestName, Class classType, String fieldName) {
        Object item = null;
        try {
            Query theQuery = em.createNamedQuery(requestName, classType);
            theQuery.setParameter(fieldName, value);
            item = theQuery.getSingleResult();
        } catch (NoResultException ex) {
        }
        return item;
    }

    /* ----------------------------------------------------------------------- */
    private Role createRole(int id, String roleName) {
        Role item = (Role) getItemFromID(id, "Role.findByRoleId", Role.class, "roleId");
        if (item == null) {
            // Does not exist
            item = new Role();
            item.setRoleTitle(roleName);
            em.persist(item);
            em.flush();

            // Reload from database to be sure to get it
            item = (Role) getItemFromID(item.getRoleId(), "Role.findByRoleId", Role.class, "roleId");
            //item.setRoleId(id);
            //em.flush();
        }
        return item;
    }

    private void createDefaultRoles() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        createRole(SecurityTools.ADMINROLE, "Administrateur");
        createRole(SecurityTools.TEACHERROLE, "Enseignant");
        createRole(SecurityTools.STUDENTROLE, "Eleve");
        createRole(SecurityTools.STAFFROLE, "Administration");
        transaction.commit();
    }

    /* ----------------------------------------------------------------------- */
    private Person createUser(int id, String nom, String prenom, String email, String login, String password, Role role) {
        Person item = (Person) getItemFromID(id, "Person.findByPersonId", Person.class, "personId");
        if (item == null) {
            // Does not exist
            item = new Person();
            if (nom != null) {
                item.setPersonLastname(nom);
            }
            if (prenom != null) {
                item.setPersonFirstname(prenom);
            }
            item.setPersonEmail(email);
            if (login != null) {
                item.setPersonLogin(login);
                if (password != null) {
                    item.setPersonPassword(SecurityTools.encryptPassword(password));
                }
            }
            em.persist(item);
            em.flush();
            
            // Reload from database to be sure to get it
            item = (Person) getItemFromID(item.getPersonId(), "Person.findByPersonId", Person.class, "personId");
            // item.setPersonId(id);
            // em.flush();

            // Set role
            if (login != null) {
                if (role != null) {
                    item.getRoleCollection().add(role);
                }
            }
            em.persist(item);
            em.flush();
        }
        return item;
    }

    private void createDefaultUsers() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Role role = (Role) getItemFromID(SecurityTools.ADMINROLE, "Role.findByRoleId", Role.class, "roleId");
        createUser(1, null, "Administrateur", "svp-dsi@ec-nantes.fr", "admin", "admin", role);
        transaction.commit();
    }

    /* ----------------------------------------------------------------------- */
    private Menu createMenu(String libelle, String code, Menu parent) {
        Menu item = (Menu) getItemFromString(code, "Menu.findByMenuCode", Menu.class, "menuCode");
        if (item == null) {
            // Does not exist
            item = new Menu();
            item.setMenuTitle(libelle);
            item.setMenuCode(code);
            if (parent != null) {
                item.setMenuParentId(parent);
            }
            em.persist(item);
            em.flush();

            // Reload from database to be sure to get it
            item = (Menu) getItemFromString(code, "Menu.findByMenuCode", Menu.class, "menuCode");
        }
        return item;
    }

    private void linkMenuRole(Menu menu, Role role) {
        if ((menu != null) && (role != null)) {
            if (!menu.getRoleCollection().contains(role)) {
                menu.getRoleCollection().add(role);
                em.flush();
            }
            if (!role.getMenuCollection().contains(menu)) {
                role.getMenuCollection().add(menu);
                em.flush();
            }
        }
    }

    private void createDefaultMenus() {
        EntityTransaction transaction = em.getTransaction();
        Collection<Role> listRoles = new ArrayList<Role>();
        try {
            Query theQuery = em.createNamedQuery("Role.findAll", Role.class);
            listRoles = theQuery.getResultList();
        } catch (NoResultException ex) {
        }
        Role roleAdmin = (Role) getItemFromID(SecurityTools.ADMINROLE, "Role.findByRoleId", Role.class, "roleId");
        Role roleStudent = (Role) getItemFromID(SecurityTools.STUDENTROLE, "Role.findByRoleId", Role.class, "roleId");

        transaction.begin();
        Menu item;
        Menu subitem;
        
        createMenu("About", "about", null);
        
        createMenu("FAQ", "faq", null);
        
        item =createMenu("ShowSkills", "showskills", null);
        linkMenuRole(item, roleStudent);

        item = createMenu("Skills", "skills", null);
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkMenuRole(item, role);
            }
        }
        subitem = createMenu("ListObserv", "listobserv", item);
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkMenuRole(subitem, role);
            }
        }
        subitem = createMenu("Observ", "observ", item);
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkMenuRole(subitem, role);
            }
        }
                
        item = createMenu("Users", "users", null);
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkMenuRole(item, role);
            }
        }
        subitem = createMenu("ListGroups", "listgroups", item);
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkMenuRole(subitem, role);
            }
        }
        subitem = createMenu("ListUsers", "listusers", item);
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkMenuRole(subitem, role);
            }
        }
        
        item = createMenu("Admin", "admin", null);
        linkMenuRole(item, roleAdmin);
        subitem = createMenu("CreateYear", "createyear", item);
        linkMenuRole(subitem, roleAdmin);
        subitem = createMenu("CreateDiplom", "creatediplom", item);
        linkMenuRole(subitem, roleAdmin);
        subitem = createMenu("CreateProgram", "createprogram", item);
        linkMenuRole(subitem, roleAdmin);
        subitem = createMenu("ManageUsers", "manageusers", item);
        linkMenuRole(subitem, roleAdmin);
        subitem = createMenu("ManageCourses", "managecourses", item);
        linkMenuRole(subitem, roleAdmin);
        
        transaction.commit();
    }


    /* ----------------------------------------------------------------------- */
    private Action createAction(String code) {
        Action item = (Action) getItemFromString(code, "Action.findByActionCode", Action.class, "actionCode");
        if (item == null) {
            // Does not exist
            item = new Action();
            item.setActionCode(code);
            em.persist(item);
            em.flush();

            // Reload from database to be sure to get it
            item = (Action) getItemFromString(code, "Action.findByActionCode", Action.class, "actionCode");
        }
        return item;
    }

    private void linkActionRole(Action action, Role role) {
        if ((action != null) && (role != null)) {
            if (!action.getRoleCollection().contains(role)) {
                action.getRoleCollection().add(role);
                em.flush();
            }
            if (!role.getActionCollection().contains(action)) {
                role.getActionCollection().add(action);
                em.flush();
            }
        }
    }

    private void createDefaultActions() {
        EntityTransaction transaction = em.getTransaction();
        Collection<Role> listRoles = new ArrayList<Role>();
        try {
            Query theQuery = em.createNamedQuery("Role.findAll", Role.class);
            listRoles = theQuery.getResultList();
        } catch (NoResultException ex) {
        }
        Role roleAdmin = (Role) getItemFromID(SecurityTools.ADMINROLE, "Role.findByRoleId", Role.class, "roleId");
        Role roleStudent = (Role) getItemFromID(SecurityTools.STUDENTROLE, "Role.findByRoleId", Role.class, "roleId");

        transaction.begin();
        Action item;
        
        item =createAction("editPerson");
        linkActionRole(item, roleAdmin);

        item =createAction("editSelf");
        for (Role role : listRoles) {
            if (! role.equals(roleStudent)) {
                linkActionRole(item, role);
            }
        }

        item =createAction("editCourse");
        linkActionRole(item, roleAdmin);

        transaction.commit();
    }
    /* ----------------------------------------------------------------------- */
    private Acquisitiongrade createGrade(int id, String name, int level) {
        Acquisitiongrade item = (Acquisitiongrade) getItemFromID(id, "Acquisitiongrade.findByAcquisitiongradeId", Acquisitiongrade.class, "acquisitiongradeId");
        if (item == null) {
            // Does not exist
            item = new Acquisitiongrade();
            item.setAcquisitiongradeName(name);
            item.setAcquisitiongradeLevel(level);
            em.persist(item);
            em.flush();
            
            // Reload from database to be sure to get it
            item = (Acquisitiongrade) getItemFromID(item.getAcquisitiongradeId(), "Acquisitiongrade.findByAcquisitiongradeId", Acquisitiongrade.class, "acquisitiongradeId");
        }
        return item;
    }

    private void createDefaultGrades() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        createGrade(1, "Success", 1);
        createGrade(1, "Success+", 2);
        createGrade(1, "Failed", -1);
        transaction.commit();
    }

    /* ----------------------------------------------------------------------- */

}
