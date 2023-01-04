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
public interface CourseRepository extends JpaRepository<Course, Integer>, CourseRepositoryCustom {

    public Collection<Course> findByCourseId(@Param("courseId")Integer courseId);

    public Collection<Course> findByCourseTitle(@Param("courseTitle")String courseTitle);

    public Collection<Course> findByCourseAbrev(@Param("courseAbrev")String courseAbrev);

}
