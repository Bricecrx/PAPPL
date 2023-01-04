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
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    @Autowired
    @Lazy
    private StudentRepository repository;

    @Override
    public Student create(String studentIdnumber) {
        if ((studentIdnumber != null)) {
            Student item = new Student();
            item.setStudentIdnumber(studentIdnumber);
            repository.saveAndFlush(item);

            Optional<Student> result = repository.findById(item.getStudentId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }
    
    @Override
    public Student create(Person person) {
        if ((person != null)) {
            Student item = new Student();
            item.setPersonId(person);
            item.setStudentIdnumber(person.getPersonId().toString());
            repository.saveAndFlush(item);

            Optional<Student> result = repository.findById(item.getStudentId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Student item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Student getByStudentId(Integer studentId) {
        Optional<Student> result = repository.findById(studentId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
