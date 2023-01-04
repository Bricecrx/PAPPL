/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface AcademicgradeRepositoryCustom {

    /**
     * Create new Academicgrade
     * @param academicgradeName
     * @return Academicgrade
     */
    public Academicgrade create(String academicgradeName);

    /**
     * Remove Academicgrade
     * @param item
     */
    public void remove(Academicgrade item);

    /**
     * Get a Academicgrade from its ID
     * @param academicgradeId
     * @return Academicgrade
     */
    public Academicgrade getByAcademicgradeId(Integer academicgradeId);

}
