/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ActionRepositoryCustom {

    /**
     * Create new Action
     * @param actionCode
     * @return Action
     */
    public Action create(String actionCode);

    /**
     * Remove Action
     * @param item
     */
    public void remove(Action item);

    /**
     * Get an Action from its ID
     * @param actionId
     * @return Action
     */
    public Action getByActionId(Integer actionId);

    /**
     * Get an Action from its Code
     * @param actionCode
     * @return Action
     */
    public Action getByActionCode(String actionCode);


}
