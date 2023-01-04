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

public interface AcademicyearRepositoryCustom {

    /**
     * Create new Academicyear
     * @param academicyearTitle
     * @param academicyearYear
     * @return Academicyear
     */
    public Academicyear create(String academicyearTitle, int academicyearYear);

    /**
     * Create new Academicyear
     * @param academicyearTitle
     * @param academicyearYear
     * @param academicyearStart
     * @param academicyearEnd
     * @return Academicyear
     */
    public Academicyear create(String academicyearTitle, int academicyearYear, Date academicyearStart, Date academicyearEnd);

    /**
     * Remove Academicyear
     * @param item
     */
    public void remove(Academicyear item);

    /**
     * Get a Academicyear from its ID
     * @param academicyearId
     * @return Academicyear
     */
    public Academicyear getByAcademicyearId(Integer academicyearId);


    /**
     * Get a Academicyear from its year
     * @param year
     * @return Academicyear
     */
    public Academicyear getByAcademicyearYear(Integer year);

    /**
     * Get current Academicyear
     * @return Academicyear
     */
    public Academicyear getCurrentAcademicyear();

}
