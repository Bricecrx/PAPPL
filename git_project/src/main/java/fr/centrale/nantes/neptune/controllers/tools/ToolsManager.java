/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers.tools;

import fr.centrale.nantes.neptune.controllers.tools.FileModel;
import fr.centrale.nantes.neptune.items.Action;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import fr.centrale.nantes.neptune.items.Connect;
import fr.centrale.nantes.neptune.items.Menu;
import fr.centrale.nantes.neptune.items.Person;
import fr.centrale.nantes.neptune.items.Role;
import fr.centrale.nantes.neptune.repositories.PersonRepository;
import fr.centrale.nantes.neptune.repositories.MenuRepository;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletContext;

import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kwyhr
 */
public class ToolsManager {

    /**
     * Build default view model
     *
     * @param menuRepository
     * @param modelName
     * @return
     */
    public static ModelAndView getModel(MenuRepository menuRepository, String modelName) {
        return getModel(menuRepository, modelName, null);
    }

    /**
     * Build view model for a connected user
     *
     * @param menuRepository
     * @param modelName
     * @param userConnexion
     * @return
     */
    public static ModelAndView getModel(MenuRepository menuRepository, String modelName, Connect userConnexion) {
        ModelAndView returned = new ModelAndView(modelName);
        returned.addObject("menuMainList", menuRepository.findAllMain());
        returned.addObject("menuList", menuRepository.findAll());
        if (userConnexion != null) {
            returned.addObject("user", userConnexion);
        }
        return returned;
    }

    /**
     * Get int from String
     *
     * @param value
     * @return
     */
    public static int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ToolsManager.class.getName()).log(Level.WARNING, null, ex);
        }
        return intValue;
    }

    /**
     * Get user to edit/delete, ...
     *
     * @param request
     * @param personRepository
     * @return
     */
    public static Person getUser(HttpServletRequest request, PersonRepository personRepository) {
        String value = request.getParameter("user");
        int userId = ToolsManager.getIntFromString(value);
        return personRepository.getById(userId);
    }
    

    /**
     * check is user access menu
     *
     * @param user
     * @param menu
     * @return
     */
    public static boolean userGetMenu(Person user, Menu menu) {
        if ((user != null) && (menu != null)) {
            Collection<Role> role1 = user.getRoleCollection();
            Collection<Role> role2 = menu.getRoleCollection();
            for (Role r : role1) {
                if (role2.contains(r)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check is user access menu
     *
     * @param user
     * @param menu
     * @return
     */
    public static boolean userGetMenu(Connect user, Menu menu) {
        if ((user == null) || (menu == null)) {
            return false;
        } else {
            return userGetMenu(user.getPersonId(), menu);
        }
    }

    /**
     * check is user access action
     *
     * @param user
     * @param action
     * @return
     */
    public static boolean userGetAction(Person user, Action action) {
        if ((user != null) && (action != null)) {
            Collection<Role> role1 = user.getRoleCollection();
            Collection<Role> role2 = action.getRoleCollection();
            for (Role r : role1) {
                if (role2.contains(r)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check is user access action
     *
     * @param user
     * @param action
     * @return
     */
    public static boolean userGetAction(Connect user, Action action) {
        if ((user == null) || (action == null)) {
            return false;
        } else {
            return userGetAction(user.getPersonId(), action);
        }
    }

    /**
     * check is user has specific role
     *
     * @param user
     * @param role
     * @return
     */
    public static boolean userHasRole(Person user, int role) {
        if (user != null) {
            Collection<Role> role1 = user.getRoleCollection();
            for (Role r : role1) {
                if (r.getRoleId() == role) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check is user has specific role
     *
     * @param user
     * @param role
     * @return
     */
    public static boolean userHasRole(Person user, Role role) {
        if ((user != null) && (role != null)) {
            if (user.getRoleCollection().contains(role)) {
                return true;
            }
        }
        return false;
    }

    /**
     * check is user access menu
     *
     * @param user
     * @param role
     * @return
     */
    public static boolean userHasRole(Connect user, int role) {
        if (user == null) {
            return false;
        } else {
            return userHasRole(user.getPersonId(), role);
        }
    }

    /**
     * check is user access menu
     *
     * @param user
     * @param role
     * @return
     */
    public static boolean userHasRole(Connect user, Role role) {
        if ((user == null) || (role == null)) {
            return false;
        } else {
            return userHasRole(user.getPersonId(), role);
        }
    }

    /**
     * Get uploaded file
     *
     * @param file
     * @param result
     * @param model
     * @param context
     * @return
     * @throws IOException
     */
    public static String fileUpload(FileModel file, BindingResult result, ModelMap model, ServletContext context) throws IOException {
        String filePath = null;
        if (!result.hasErrors()) {
            MultipartFile multipartFile = file.getFile();
            String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
            //Now do something with file...
            filePath = uploadPath + file.getFile().getOriginalFilename();
            FileCopyUtils.copy(file.getFile().getBytes(), new File(filePath));
            String fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName);
        }
        return filePath;
    }
}
