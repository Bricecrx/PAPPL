/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface StudentregistrationRepositoryCustom {

    /**
     * Create new Studentregistration
     * @return Studentregistration
     */
    public Studentregistration create();

    /**
     * Remove Studentregistration
     * @param item
     */
    public void remove(Studentregistration item);

    /**
     * Get a Studentregistration from its ID
     * @param studentregistrationId
     * @return Studentregistration
     */
    public Studentregistration getByStudentregistrationId(Integer studentregistrationId);

}
