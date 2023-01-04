/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ObservationtypeRepositoryCustom {

    /**
     * Create new Observationtype
     * @param observationtypeInfo
     * @param observationtypeWhen
     * @param observationtypeHow
     * @return Observationtype
     */
    public Observationtype create(String observationtypeInfo, String observationtypeWhen, String observationtypeHow);

    /**
     * Remove Observationtype
     * @param item
     */
    public void remove(Observationtype item);

    /**
     * Get a Observationtype from its ID
     * @param observationtypeId
     * @return Observationtype
     */
    public Observationtype getByObservationtypeId(Integer observationtypeId);

}
