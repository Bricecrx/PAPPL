/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AcademicyearRepository extends JpaRepository<Academicyear, Integer>, AcademicyearRepositoryCustom {

    public Collection<Academicyear> findByAcademicyearId(@Param("academicyearId")Integer academicyearId);

    public Collection<Academicyear> findByAcademicyearTitle(@Param("academicyearTitle")String academicyearTitle);

    public Collection<Academicyear> findByAcademicyearYear(@Param("academicyearYear")int academicyearYear);

    public Collection<Academicyear> findByAcademicyearStart(@Param("academicyearStart")Date academicyearStart);

    public Collection<Academicyear> findByAcademicyearEnd(@Param("academicyearEnd")Date academicyearEnd);

    /**
     * Get all possible Academicyear
     * @param aDate
     * @return
     */
    @Query("SELECT a FROM Academicyear a WHERE a.academicyearStart <= :aDate AND :aDate <= a.academicyearEnd")
    public Collection<Academicyear> findAllPossible(@Param("aDate")Date aDate);

}
