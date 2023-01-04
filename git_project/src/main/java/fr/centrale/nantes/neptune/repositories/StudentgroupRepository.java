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
public interface StudentgroupRepository extends JpaRepository<Studentgroup, Integer>, StudentgroupRepositoryCustom {

    public Collection<Studentgroup> findByStudentgroupId(@Param("studentgroupId")Integer studentgroupId);

    public Collection<Studentgroup> findByStudentgroupName(@Param("studentgroupName")String studentgroupName);

}
