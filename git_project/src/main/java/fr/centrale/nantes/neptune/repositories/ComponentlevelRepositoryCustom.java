/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ComponentlevelRepositoryCustom {

    /**
     * Create new Componentlevel
     * @return Componentlevel
     */
    public Componentlevel create();

    /**
     * Remove Componentlevel
     * @param item
     */
    public void remove(Componentlevel item);

    /**
     * Get a Componentlevel from its ID
     * @param componentlevelId
     * @return Componentlevel
     */
    public Componentlevel getByComponentlevelId(Integer componentlevelId);

}
