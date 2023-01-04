/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Date;
import java.util.Collection;

public interface StudentskilllevelobservRepositoryCustom {

    /**
     * Create new Studentskilllevelobserv
     * @param studentskilllevelobservDate
     * @return Studentskilllevelobserv
     */
    public Studentskilllevelobserv create(Date studentskilllevelobservDate);

    /**
     * Remove Studentskilllevelobserv
     * @param item
     */
    public void remove(Studentskilllevelobserv item);

    /**
     * Get a Studentskilllevelobserv from its ID
     * @param studentskilllevelobservId
     * @return Studentskilllevelobserv
     */
    public Studentskilllevelobserv getByStudentskilllevelobservId(Integer studentskilllevelobservId);

}
