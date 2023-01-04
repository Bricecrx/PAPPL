/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface ObservedconditionRepositoryCustom {

    /**
     * Create new Observedcondition
     * @param observationtypeconditionId
     * @param studentregistrationId
     * @return Observedcondition
     */
    public Observedcondition create(int observationtypeconditionId, int studentregistrationId);

    /**
     * Remove Observedcondition
     * @param item
     */
    public void remove(Observedcondition item);

    /**
     * Get a Observedcondition from its ID
     * @param observationtypeconditionId
     * @param studentregistrationId
     * @return Observedcondition
     */
    public Observedcondition getByObservedconditionPK(int observationtypeconditionId, int studentregistrationId);

}
