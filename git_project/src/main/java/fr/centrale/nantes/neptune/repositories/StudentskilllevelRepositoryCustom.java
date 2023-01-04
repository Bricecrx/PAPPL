/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface StudentskilllevelRepositoryCustom {

    /**
     * Create new Studentskilllevel
     * @param studentId
     * @param diplomId
     * @param componentId
     * @return Studentskilllevel
     */
    public Studentskilllevel create(int studentId, int diplomId, int componentId);

    /**
     * Remove Studentskilllevel
     * @param item
     */
    public void remove(Studentskilllevel item);

    /**
     * Get a Studentskilllevel from its ID
     * @param studentId
     * @param diplomId
     * @param componentId
     * @return Studentskilllevel
     */
    public Studentskilllevel getByStudentskilllevelPK(int studentId, int diplomId, int componentId);

}
