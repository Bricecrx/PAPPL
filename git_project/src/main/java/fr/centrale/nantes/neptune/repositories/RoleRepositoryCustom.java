/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface RoleRepositoryCustom {

    /**
     * Create new Role
     * @param roleTitle
     * @return Role
     */
    public Role create(String roleTitle);

    /**
     * Remove Role
     * @param item
     */
    public void remove(Role item);

    /**
     * Get a Role from its ID
     * @param roleId
     * @return Role
     */
    public Role getByRoleId(Integer roleId);

}
