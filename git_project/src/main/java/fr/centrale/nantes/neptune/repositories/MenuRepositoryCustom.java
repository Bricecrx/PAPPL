/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface MenuRepositoryCustom {

    /**
     * Create new Menu
     * @param menuTitle
     * @param menuCode
     * @return Menu
     */
    public Menu create(String menuTitle, String menuCode);

    /**
     * Remove Menu
     * @param item
     */
    public void remove(Menu item);

    /**
     * Get a Menu from its ID
     * @param menuId
     * @return Menu
     */
    public Menu getByMenuId(Integer menuId);

    /**
     * Get a Menu from its Code
     * @param menuCode
     * @return Menu
     */
    public Menu getByMenuCode(String menuCode);


}
