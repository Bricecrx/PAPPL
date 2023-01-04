/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ObservationtypeconditionRepositoryCustom {

    /**
     * Create new Observationtypecondition
     * @param observationtypeconditionValue
     * @return Observationtypecondition
     */
    public Observationtypecondition create(String observationtypeconditionValue);

    /**
     * Remove Observationtypecondition
     * @param item
     */
    public void remove(Observationtypecondition item);

    /**
     * Get a Observationtypecondition from its ID
     * @param observationtypeconditionId
     * @return Observationtypecondition
     */
    public Observationtypecondition getByObservationtypeconditionId(Integer observationtypeconditionId);

}
