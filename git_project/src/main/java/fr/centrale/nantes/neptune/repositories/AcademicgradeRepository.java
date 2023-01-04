/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AcademicgradeRepository extends JpaRepository<Academicgrade, Integer>, AcademicgradeRepositoryCustom {

    public Collection<Academicgrade> findByAcademicgradeId(@Param("academicgradeId")Integer academicgradeId);

    public Collection<Academicgrade> findByAcademicgradeName(@Param("academicgradeName")String academicgradeName);

}
