/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers;

import fr.centrale.nantes.neptune.controllers.tools.*;
import fr.centrale.nantes.neptune.items.*;
import fr.centrale.nantes.neptune.repositories.*;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kwyhr
 */
@Controller
public class MainController {

    @Autowired
    private ConnectRepository connectRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private DiplomRepository diplomRepository;

    @Autowired
    private AcademicyearRepository academicyearRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private FaqRepository faqRepository;

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired 
    private StudentgroupRepository groupRepository; 

    /**
     * Handle request from menu
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "navigate.do", method = RequestMethod.POST)
    public ModelAndView handleNavigate(HttpServletRequest request) {
        // Check access & get data
        Connect userConnexion = SecurityTools.checkAccess(connectRepository, request);
        String actionNav = request.getParameter("navAction");
        Menu menuSelected = menuRepository.getByMenuCode(actionNav);

        return manageRequest(userConnexion, actionNav, menuSelected);
    }

    /**
     * Handle request from action
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "action.do", method = RequestMethod.POST)
    public ModelAndView handleAction(HttpServletRequest request) {
        // Check access & get data
        Connect userConnexion = SecurityTools.checkAccess(connectRepository, request);
        String actionLaunch = request.getParameter("launchAction");
        String backAction = request.getParameter("backAction");
        String dataValue = request.getParameter("dataAction");

        return manageRequestAction(userConnexion, actionLaunch, backAction, dataValue);
    }

    /**
     * Handle requesr from action
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "executeaction.do", method = RequestMethod.POST)
    public ModelAndView handleExecuteAction(HttpServletRequest request) {
        // Check access & get data
        Connect userConnexion = SecurityTools.checkAccess(connectRepository, request);
        String actionLaunch = request.getParameter("launchAction");
        String curAction = request.getParameter("curAction");
        String backAction = request.getParameter("backAction");
        
        return manageExecuteAction(request, userConnexion, actionLaunch, curAction, backAction);
    }

    /* ------------------------------------------------------------------------------------------ */

    private ModelAndView manageRequest(Connect userConnexion, String actionNav, Menu menuSelected) {
        ModelAndView returned = null;

        // Check access
        if ((actionNav != null) && (!actionNav.isEmpty())) {
            // required action
            if (menuSelected == null) {
                // connect - disconnect only
                switch (actionNav) {
                    case "connect":
                        // Connetion page
                        returned = ToolsManager.getModel(menuRepository, "connect");
                        break;
                    case "disconnect":
                        // disconnect
                        if (userConnexion != null) {
                            connectRepository.remove(userConnexion);
                            // renove user
                            userConnexion = null;
                        }
                        break;
                }
            } else if (menuSelected.getRoleCollection().isEmpty()) {
                // Free access
                switch (actionNav) {
                    case "about":
                        returned = ToolsManager.getModel(menuRepository, actionNav, userConnexion);
                        break;
                    case "faq":
                        returned = ToolsManager.getModel(menuRepository, actionNav, userConnexion);
                        returned.addObject("listFAQ", faqRepository.findAll());
                        break;
                }
            } else if (userConnexion != null) {
                // Valid connexion
                if (ToolsManager.userGetMenu(userConnexion, menuSelected)) {
                    // Acces granted
                    switch (actionNav) {
                        case "showskills":
                            break;
                        case "skills":
                            break;
                        case "listobserv":
                            break;
                        case "observ":
                            break;
                        case "users":
                            break;
                        case "listgroups":
                            returned = ToolsManager.getModel(menuRepository, "group_list", userConnexion);
                            returned.addObject("groupsList", groupRepository.findAll());
                            break;
                        case "listusers":
                            returned = ToolsManager.getModel(menuRepository, "students", userConnexion);
                            returned.addObject("studentsList", studentRepository.findAll());
                            returned.addObject("usersList", personRepository.findAll());
                            break;
                        case "createyear":
                            returned = ToolsManager.getModel(menuRepository, "admin_year", userConnexion);
                            returned.addObject("anneesList", academicyearRepository.findAll());
                            break;
                        case "creatediplom":
                            returned = ToolsManager.getModel(menuRepository, "admin_diplom", userConnexion);
                            returned.addObject("diplomeList", diplomRepository.findAll());
                            break;
                        case "createprogram":
                            returned = ToolsManager.getModel(menuRepository, "admin_program", userConnexion);
                            returned.addObject("anneesList", academicyearRepository.findAll());
                            returned.addObject("diplomeList", diplomRepository.findAll());
                            returned.addObject("programList", programRepository.findAll());
                            break;
                        case "manageusers":
                            returned = ToolsManager.getModel(menuRepository, "admin_users", userConnexion);
                            returned.addObject("usersList", personRepository.findAll());
                            break;
                        case "managecourses":
                            returned = ToolsManager.getModel(menuRepository, "admin_courses", userConnexion);
                            returned.addObject("coursesList", courseRepository.findAll());
                            returned.addObject("programList", programRepository.findAll());
                            returned.addObject("teacherList", personRepository.findAllTeachers());
                            break;
                    }
                    if (returned != null) {
                        returned.addObject("back", actionNav);
                    }
                }
            }
        }

        if (returned == null) {
            // No possible reply found -> go back to index
            returned = ToolsManager.getModel(menuRepository, "index", userConnexion);
        }

        return returned;
    }

    private ModelAndView manageRequestAction(Connect userConnexion, String actionLaunch, String backAction, String dataValue) {
        ModelAndView returned = null;
        // Check access
        if ((userConnexion != null)
                && (actionLaunch != null) && (!actionLaunch.isEmpty())
                && (backAction != null) && (!backAction.isEmpty())) {
            // required action
            Action actionSelected = actionRepository.getByActionCode(actionLaunch);
            if (actionSelected != null) {
                // Valid connexion
                if (ToolsManager.userGetAction(userConnexion, actionSelected)) {
                    // Acces granted
                    switch (actionLaunch) {
                        case "editPerson":
                            returned = editPerson(userConnexion, dataValue);
                            break;
                        case "editGroup":
                            returned = editGroup(userConnexion, dataValue);
                            break;
                        case "editSelf":
                            returned = editSelf(userConnexion, dataValue);
                            break;
                    }
                }
            }
        }

        if (returned == null) {
            // No possible repy found -> go back to index
            returned = ToolsManager.getModel(menuRepository, "index", userConnexion);
        }
        returned.addObject("back", backAction);
        returned.addObject("current", actionLaunch);

        return returned;
    }

    private ModelAndView manageExecuteAction(HttpServletRequest request,
            Connect userConnexion, String actionLaunch, String curAction, String backAction) {
        boolean success = false;
        String dataValue = "";
        
        // Check access
        if ((userConnexion != null)
                && (actionLaunch != null) && (!actionLaunch.isEmpty())
                && (backAction != null) && (!backAction.isEmpty())) {
            // required action
            Action actionSelected = actionRepository.getByActionCode(curAction);
            if (actionSelected != null) {
                // Valid connexion
                if (ToolsManager.userGetAction(userConnexion, actionSelected)) {
                    // Acces granted
                    switch (actionLaunch) {
                        case "savePerson":
                            dataValue = request.getParameter("id");
                            success = savePerson(request);
                            break;
                    }
                }
            }
        }

        ModelAndView returned = null;
        if (success) {
            // Ok, can go back to previous action
        } else {
            // Bad data, same player shoot again
            returned = manageRequestAction(userConnexion, actionLaunch, backAction, dataValue);
        }

        return returned;
    }

    /* ------------------------------------------------------------------------------------------ */
    private ModelAndView editPerson(Connect userConnexion, Person person) {
        ModelAndView returned = null;
        if (person != null) {
            returned = ToolsManager.getModel(menuRepository, "person", userConnexion);
            returned.addObject("person", person);
        }
        return returned;
    }

    private ModelAndView editPerson(Connect userConnexion, String dataValue) {
        int idPerson = ToolsManager.getIntFromString(dataValue);
        Person person = personRepository.getByPersonId(idPerson);
        return editPerson(userConnexion, person);
    }
    
    private ModelAndView editGroup(Connect userConnexion, Studentgroup group) {
        ModelAndView returned = null;
        if (group != null) {
            returned = ToolsManager.getModel(menuRepository, "group", userConnexion);
            returned.addObject("group", group);
            returned.addObject("program", group.getProgramId());
            returned.addObject("usersList", personRepository.findAll());
        }
        return returned;
    }

    private ModelAndView editGroup(Connect userConnexion, String dataValue) {
        int idGroup = ToolsManager.getIntFromString(dataValue);
        Studentgroup group = groupRepository.getByStudentgroupId(idGroup);
        return editGroup(userConnexion, group);
    }

    private ModelAndView editSelf(Connect userConnexion, String dataValue) {
        return editPerson(userConnexion, userConnexion.getPersonId());
    }
    
    private boolean savePerson(HttpServletRequest request) {
        boolean success = false;
        
        
        return success;
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "saveUser.do", method = RequestMethod.POST)
    public ModelAndView handleSaveUser(HttpServletRequest request) {
        //TODO: Rendre fonctionnel la modif d'un autre utilisateur que soi même si on a les droits
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            Person user = null;
            if (request.getParameter("id") != null) {
                //user = ToolsManager.getUser(request, personRepository);
                user = personRepository.getByPersonId(Integer.parseInt(request.getParameter("id")));
                personRepository.update(user, request.getParameter("Firstname"), request.getParameter("Lastname"), request.getParameter("Email"));
            } else {
                user = personRepository.create(request.getParameter("Firstname"), request.getParameter("Lastname"), request.getParameter("Email"));
            }

            if (user != null) {
                model = ToolsManager.getModel(menuRepository, "person", connexion);
                model.addObject("person", user);
                model.addObject("mode", 1);
            } else {
                model = ToolsManager.getModel(menuRepository, "index", connexion);
            }
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return model;
    }
    
    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "saveGroup.do", method = RequestMethod.POST)
    public ModelAndView handleSaveGroup(HttpServletRequest request) {
        //TODO: Rendre fonctionnel la modif d'un autre utilisateur que soi même si on a les droits
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            Studentgroup user = null;
            if (request.getParameter("id") != null) {
                user = groupRepository.getByStudentgroupId(Integer.parseInt(request.getParameter("id")));
                if (user.getProgramId() != null) {
                    programRepository.update(user.getProgramId().getProgramId(), academicyearRepository.getByAcademicyearYear(Integer.parseInt(request.getParameter("departAnneeAcademique"))), diplomRepository.getByDiplomName(request.getParameter("diplome")));
                    groupRepository.update(user, request.getParameter("studentgroupName"), programRepository.getByProgramId(user.getProgramId().getProgramId()));
                } else {
                    //TODO: CREER UNE FONCTION CREATE DE PROGRAM ET ENSUITE UPDATE LE GROUPE
                    Program prog = programRepository.create(diplomRepository.getByDiplomName(request.getParameter("diplome")), academicyearRepository.getByAcademicyearYear(Integer.parseInt(request.getParameter("departAnneeAcademique"))));
                    groupRepository.update(user, request.getParameter("studentgroupName"), programRepository.getByProgramId(prog.getProgramId()));
                }   
            } else {
                user = groupRepository.create(request.getParameter("studentgroupName"), academicyearRepository.getByAcademicyearYear(Integer.parseInt(request.getParameter("departAnneeAcademique"))), diplomRepository.getByDiplomName(request.getParameter("diplome")));
            }

            if (user != null) {
                System.out.println(user.getProgramId().getDiplomId().toString());
                System.out.println(user.getStudentgroupId());
                model = ToolsManager.getModel(menuRepository, "group", connexion);
                model.addObject("group", user);
                model.addObject("mode", 1);
            } else {
                model = ToolsManager.getModel(menuRepository, "index", connexion);
            }
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return model;
    }

    /**
     *
     * @param request
     * @param file
     * @param result
     * @param model
     * @return
     */
    public ModelAndView handleUploadUsers(HttpServletRequest request, @Validated FileModel file, BindingResult result, ModelMap model) {
        ModelAndView modelAndView = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            try {
                ServletContext context = request.getServletContext();
                String filePath = ToolsManager.fileUpload(file, result, model, context);
                if ((filePath != null) && (!filePath.isEmpty())) {

                }
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (modelAndView == null) {
            modelAndView = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return modelAndView;
    }

    /**
     *
     * @param request
     * @return
     */
    public ModelAndView handleSkill(HttpServletRequest request) {
        ModelAndView returned = null;
        Connect userConnexion = SecurityTools.checkAccess(connectRepository, request);

        if (SecurityTools.hasRole(userConnexion, SecurityTools.STUDENTROLE)) {
            returned = ToolsManager.getModel(menuRepository, "skills", userConnexion);

        } else if (SecurityTools.hasRole(userConnexion, SecurityTools.ADMINROLE)) {
            // Manage skills
            returned = ToolsManager.getModel(menuRepository, "skillsmanage", userConnexion);
            returned.addObject("anneesList", academicyearRepository.findAll());
            returned.addObject("anneeCurrent", academicyearRepository.getCurrentAcademicyear());
            returned.addObject("formationList", diplomRepository.findAll());
        } else {

        }

        if (returned == null) {
            returned = ToolsManager.getModel(menuRepository, "skills", userConnexion);
        }
        return returned;
    }

    /**
     * Get competence/composante/level to edit/delete, ...
     *
     * @param request
     * @return
     */
    private Skill getSkill(HttpServletRequest request) {
        String value = request.getParameter("competence");
        int competenceId = ToolsManager.getIntFromString(value);
        return skillRepository.getById(competenceId);
    }

    /**
     * Get competence/composante/level to edit/delete, ...
     *
     * @param request
     * @return
     */
    private Component getComponent(HttpServletRequest request) {
        String value = request.getParameter("composante");
        int composanteId = ToolsManager.getIntFromString(value);
        return componentRepository.getById(composanteId);
    }

    /**
     * Get competence/composante/level to edit/delete, ...
     *
     * @param request
     * @return
     */
    private fr.centrale.nantes.neptune.items.Level getLevel(HttpServletRequest request) {
        String value = request.getParameter("niveau");
        int niveauId = ToolsManager.getIntFromString(value);
        return levelRepository.getById(niveauId);
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "skills.do", method = RequestMethod.POST)
    public ModelAndView handlePostListSkills(HttpServletRequest request) {
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            Collection<Person> listPersonnes;
            Person user;
            if (ToolsManager.userHasRole(connexion, SecurityTools.ADMINROLE)) {
                model = ToolsManager.getModel(menuRepository, "usersList", connexion);
                listPersonnes = personRepository.findAll();
                model.addObject("listPersonnes", listPersonnes);
            } else if (ToolsManager.userHasRole(connexion, SecurityTools.STAFFROLE)) {
                model = ToolsManager.getModel(menuRepository, "usersList", connexion);
                listPersonnes = personRepository.findAll();
                model.addObject("listPersonnes", listPersonnes);
            } else if (ToolsManager.userHasRole(connexion, SecurityTools.STUDENTROLE)) {
//                    model = editSkill(connexion, connexion.getLoginId().getPersonneId(), 0);
            } else if (ToolsManager.userHasRole(connexion, SecurityTools.TEACHERROLE)) {
//                    model = editSkill(connexion, connexion.getLoginId().getPersonneId(), 0);
            }

        }
        // Return value
        if (model == null) {
            model = ToolsManager.getModel(menuRepository, "index");
        }
        return model;
    }

    private ModelAndView editSkill(Connect connexion, Skill skill, int mode) {
        ModelAndView model;
        if (skill != null) {
            model = ToolsManager.getModel(menuRepository, "skill", connexion);
            Person user = connexion.getPersonId();
            model.addObject("person", user);
            model.addObject("mode", mode);
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }
        return model;
    }

    /**
     *
     * @param request
     * @return
     */
    public ModelAndView handleEditSkill(HttpServletRequest request) {
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
//            model = editSkill(connexion, ToolsManager.getUser(request, personRepository), 1);
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return model;
    }

    /**
     *
     * @param request
     * @return
     */
    public ModelAndView handleAddSkill(HttpServletRequest request) {
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            Person user = new Person();
            user.setPersonId(-1);
//            model = editSkill(connexion, user, 1);
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return model;
    }

    /**
     *
     * @param request
     * @return
     */
    public ModelAndView handleInfosSkillr(HttpServletRequest request) {
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
//            model = editUser(connexion, getSkill(request), 0);
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return model;
    }

    /**
     *
     * @param request
     * @return
     */
    public ModelAndView handleDeleteSkill(HttpServletRequest request) {
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            Person user = ToolsManager.getUser(request, personRepository);

            if ((user != null) && (!user.equals(connexion.getPersonId())) && (user.getPersonId() != 1)) {
                personRepository.remove(user);
            }
        }
        model = ToolsManager.getModel(menuRepository, "index", connexion);

        return model;
    }

    /**
     *
     * @param request
     * @return
     */
    public ModelAndView handleSaveSkill(HttpServletRequest request) {
        ModelAndView model = null;
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            Person user = null;

            if (request.getParameter("user") != null) {
                user = ToolsManager.getUser(request, personRepository);
                personRepository.update(user, request.getParameter("Firstname"), request.getParameter("Lastname"), request.getParameter("Email"));
            } else {
                user = personRepository.create(request.getParameter("Firstname"), request.getParameter("Lastname"), request.getParameter("Email"));
            }

            if (user != null) {
                model = ToolsManager.getModel(menuRepository, "user", connexion);
                model.addObject("person", user);
                model.addObject("mode", 1);
            } else {
                model = ToolsManager.getModel(menuRepository, "index", connexion);
            }
        } else {
            model = ToolsManager.getModel(menuRepository, "index", connexion);
        }

        return model;
    }
}
