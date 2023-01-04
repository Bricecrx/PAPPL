/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers;

import fr.centrale.nantes.neptune.controllers.tools.ToolsManager;
import fr.centrale.nantes.neptune.controllers.tools.SecurityTools;
import fr.centrale.nantes.neptune.controllers.tools.MyUser;
import javax.servlet.http.HttpServletRequest;
import fr.centrale.nantes.ldap.LDAPManager;
import fr.centrale.nantes.neptune.items.Connect;
import fr.centrale.nantes.neptune.items.Person;
import fr.centrale.nantes.neptune.repositories.ConnectRepository;
import fr.centrale.nantes.neptune.repositories.MenuRepository;
import fr.centrale.nantes.neptune.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ECN
 */
@Controller
public class LoginController {

    @Autowired
    private ConnectRepository connectRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Default connection
     * @return 
     */
    @RequestMapping(value = "index.do")
    public ModelAndView handleIndexGet() {
        return ToolsManager.getModel(menuRepository, "index");
    }

    /**
     * Get connetion page - should not be called
     * @return 
     */
    @RequestMapping(value = "connect.do", method = RequestMethod.GET)
    public ModelAndView handleConnectGet() {
        return ToolsManager.getModel(menuRepository, "connect");
    }

    /**
     * Check login / password to create a connection
     * @param request
     * @param user
     * @return 
     */
    @RequestMapping(value = "connect.do", method = RequestMethod.POST)
    public ModelAndView handleConnectPost(HttpServletRequest request, MyUser user) {
        Connect userConnexion = null;
        String modelName = "connect";

        String login = user.getLogin();
        String pass = user.getPassword();

        if ((login != null) && (pass != null)) {
            Person anUser = personRepository.getByPersonLogin(login);

            if (anUser != null) {
                LDAPManager manager = new LDAPManager();
                if (manager.identifyLDAP(login, pass)) {
                    userConnexion = connectRepository.create(anUser, SecurityTools.getClientIpAddress(request));
                    modelName = "start";
                } else if (SecurityTools.checkPassword(anUser.getPersonPassword(), pass)) {
                    userConnexion = connectRepository.create(anUser, SecurityTools.getClientIpAddress(request));
                    modelName = "start";
                }
            }
        }
        return ToolsManager.getModel(menuRepository, modelName, userConnexion);
    }

    /**
     * docinnect - should not be applied
     * @param request
     * @return 
     */
    @RequestMapping(value = "disconnect.do")
    public ModelAndView handleDisconnect(HttpServletRequest request) {
        Connect connexion = SecurityTools.checkAccess(connectRepository, request);
        if (connexion != null) {
            connectRepository.remove(connexion);
        }

        return ToolsManager.getModel(menuRepository, "index");
    }

}
