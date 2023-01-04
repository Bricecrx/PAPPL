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
public interface StudentskilllevelRepository extends JpaRepository<Studentskilllevel, StudentskilllevelPK>, StudentskilllevelRepositoryCustom {

    public Collection<Studentskilllevel> findByStudentId(@Param("studentId")int studentId);

    public Collection<Studentskilllevel> findByDiplomId(@Param("diplomId")int diplomId);

    public Collection<Studentskilllevel> findByComponentId(@Param("componentId")int componentId);

}
