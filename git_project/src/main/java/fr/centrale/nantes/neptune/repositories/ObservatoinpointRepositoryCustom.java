/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ObservatoinpointRepositoryCustom {

    /**
     * Create new Observatoinpoint
     * @param observationpointName
     * @return Observatoinpoint
     */
    public Observatoinpoint create(String observationpointName);

    /**
     * Remove Observatoinpoint
     * @param item
     */
    public void remove(Observatoinpoint item);

    /**
     * Get a Observatoinpoint from its ID
     * @param observatoinpointId
     * @return Observatoinpoint
     */
    public Observatoinpoint getByObservatoinpointId(Integer observatoinpointId);

}
