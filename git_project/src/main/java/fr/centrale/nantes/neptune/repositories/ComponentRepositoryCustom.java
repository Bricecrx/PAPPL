/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ComponentRepositoryCustom {

    /**
     * Create new Component
     * @param componentName
     * @param componentActive
     * @return Component
     */
    public Component create(String componentName, boolean componentActive);

    /**
     * Remove Component
     * @param item
     */
    public void remove(Component item);

    /**
     * Get a Component from its ID
     * @param componentId
     * @return Component
     */
    public Component getByComponentId(Integer componentId);

}
