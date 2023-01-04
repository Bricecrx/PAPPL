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
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustom {

    public Collection<Student> findByStudentId(@Param("studentId")Integer studentId);

    public Collection<Student> findByStudentIdnumber(@Param("studentIdnumber")String studentIdnumber);

}
