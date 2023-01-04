/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Optional;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class StudentskilllevelobservRepositoryCustomImpl implements StudentskilllevelobservRepositoryCustom {

    @Autowired
    @Lazy
    private StudentskilllevelobservRepository repository;

    @Override
    public Studentskilllevelobserv create(Date studentskilllevelobservDate) {
        if ((studentskilllevelobservDate != null)) {
            Studentskilllevelobserv item = new Studentskilllevelobserv();
            item.setStudentskilllevelobservDate(studentskilllevelobservDate);
            repository.saveAndFlush(item);

            Optional<Studentskilllevelobserv> result = repository.findById(item.getStudentskilllevelobservId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Studentskilllevelobserv item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Studentskilllevelobserv getByStudentskilllevelobservId(Integer studentskilllevelobservId) {
        Optional<Studentskilllevelobserv> result = repository.findById(studentskilllevelobservId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
