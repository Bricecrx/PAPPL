/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Optional;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

    @Autowired
    @Lazy
    private CourseRepository repository;

    @Override
    public Course create(String courseTitle, String courseAbrev, Program program) {
        if ((courseTitle != null) && (courseAbrev != null) && (program != null)) {
            Course item = new Course();
            item.setCourseTitle(courseTitle);
            item.setCourseAbrev(courseAbrev);
            item.setProgramId(program);
            repository.saveAndFlush(item);

            Optional<Course> result = repository.findById(item.getCourseId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Course item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Course getByCourseId(Integer courseId) {
        Optional<Course> result = repository.findById(courseId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
