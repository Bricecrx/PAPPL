/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface CourseRepositoryCustom {

    /**
     * Create new Course
     * @param courseTitle
     * @param courseAbrev
     * @param program
     * @return Course
     */
    public Course create(String courseTitle, String courseAbrev, Program program);

    /**
     * Remove Course
     * @param item
     */
    public void remove(Course item);

    /**
     * Get a Course from its ID
     * @param courseId
     * @return Course
     */
    public Course getByCourseId(Integer courseId);

}
