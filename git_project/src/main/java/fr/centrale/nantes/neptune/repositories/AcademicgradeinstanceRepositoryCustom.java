/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface AcademicgradeinstanceRepositoryCustom {

    /**
     * Create new Academicgradeinstance
     * @return Academicgradeinstance
     */
    public Academicgradeinstance create();

    /**
     * Remove Academicgradeinstance
     * @param item
     */
    public void remove(Academicgradeinstance item);

    /**
     * Get a Academicgradeinstance from its ID
     * @param academicgradeinstanceId
     * @return Academicgradeinstance
     */
    public Academicgradeinstance getByAcademicgradeinstanceId(Integer academicgradeinstanceId);

}
