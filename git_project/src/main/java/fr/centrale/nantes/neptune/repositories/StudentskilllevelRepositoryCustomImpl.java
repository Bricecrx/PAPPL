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
public class StudentskilllevelRepositoryCustomImpl implements StudentskilllevelRepositoryCustom {

    @Autowired
    @Lazy
    private StudentskilllevelRepository repository;

    @Override
    public Studentskilllevel create(int studentId, int diplomId, int componentId) {
        Studentskilllevel item = new Studentskilllevel(studentId, diplomId, componentId);
        repository.saveAndFlush(item);

        Optional<Studentskilllevel> result = repository.findById(item.getStudentskilllevelPK());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Studentskilllevel item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Studentskilllevel getByStudentskilllevelPK(int studentId, int diplomId, int componentId) {
        Optional<Studentskilllevel> result = repository.findById(new StudentskilllevelPK(studentId, diplomId, componentId));
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
