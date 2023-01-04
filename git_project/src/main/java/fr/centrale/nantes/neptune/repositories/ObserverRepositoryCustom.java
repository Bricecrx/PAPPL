/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ObserverRepositoryCustom {

    /**
     * Create new Observer
     * @param personId
     * @param observatoinpointId
     * @return Observer
     */
    public Observer create(int personId, int observatoinpointId);

    /**
     * Remove Observer
     * @param item
     */
    public void remove(Observer item);

    /**
     * Get a Observer from its ID
     * @param personId
     * @param observatoinpointId
     * @return Observer
     */
    public Observer getByObserverPK(int personId, int observatoinpointId);

}
