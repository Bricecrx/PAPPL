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
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class StudentregistrationRepositoryCustomImpl implements StudentregistrationRepositoryCustom {

    @Autowired
    @Lazy
    private StudentregistrationRepository repository;

    @Override
    public Studentregistration create() {
        Studentregistration item = new Studentregistration();
        repository.saveAndFlush(item);

        Optional<Studentregistration> result = repository.findById(item.getStudentregistrationId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    
    @Override
    public Studentregistration create(Student student, Studentgroup studentGroup) {
        Studentregistration item = new Studentregistration();
        item.setStudentId(student);
        Collection<Studentgroup> csG = new LinkedList<>();
        csG.add(studentGroup);
        item.setStudentgroupCollection(csG);
        item.setDiplomId(studentGroup.getProgramId().getDiplomId());
        repository.saveAndFlush(item);

        Optional<Studentregistration> result = repository.findById(item.getStudentregistrationId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    
    @Override
    public Studentregistration create(Student student, Studentgroup studentGroup, Skillreferential skillReferential){
        Studentregistration item = new Studentregistration();
        item.setStudentId(student);
        Collection<Studentgroup> csG = new LinkedList<>();
        csG.add(studentGroup);
        item.setStudentgroupCollection(csG);
        item.setDiplomId(studentGroup.getProgramId().getDiplomId());
        item.setSkillreferentialId(skillReferential);
        repository.saveAndFlush(item);

        Optional<Studentregistration> result = repository.findById(item.getStudentregistrationId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Studentregistration item) {
        if (item != null) {
            System.out.println(item.getStudentregistrationId());
            repository.delete(item);
        }
    }

    @Override
    public Studentregistration getByStudentregistrationId(Integer studentregistrationId) {
        Optional<Studentregistration> result = repository.findById(studentregistrationId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
