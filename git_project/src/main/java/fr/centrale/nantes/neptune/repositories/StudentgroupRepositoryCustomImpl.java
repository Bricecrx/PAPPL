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
public class StudentgroupRepositoryCustomImpl implements StudentgroupRepositoryCustom {

    @Autowired
    @Lazy
    private StudentgroupRepository repository;

    @Override
    public Studentgroup create(String studentgroupName) {
        if ((studentgroupName != null)) {
            Studentgroup item = new Studentgroup();
            item.setStudentgroupName(studentgroupName);
            repository.saveAndFlush(item);

            Optional<Studentgroup> result = repository.findById(item.getStudentgroupId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Studentgroup item) {
        if (item != null) {
            repository.delete(item);
        }
    }

    @Override
    public Studentgroup getByStudentgroupId(Integer studentgroupId) {
        Optional<Studentgroup> result = repository.findById(studentgroupId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Studentgroup update(Studentgroup group, String studentgroupName, Academicyear departAnneeAcademique, Diplom diplome) {
        System.out.println("bbbbb");
        if ((group != null) && (studentgroupName != null)) {
            System.out.println("ccccc");
            group.setStudentgroupName(studentgroupName);
            if (departAnneeAcademique != null) {
                group.getProgramId().setAcademicyearId(departAnneeAcademique);
                System.out.println(group.getProgramId().getAcademicyearId());
            }
            if (diplome != null) {
                group.getProgramId().setDiplomId(diplome);
                System.out.println(group.getProgramId().getDiplomId());
            }
            repository.saveAndFlush(group);
        }
        System.out.println(group.getProgramId().getDiplomId());
        return group;
    }

    @Override
    public Studentgroup update(Studentgroup group, String studentgroupName, Program prog){
        if ((group != null) && (studentgroupName != null)) {
            group.setStudentgroupName(studentgroupName);
            if (prog != null) {
                group.setProgramId(prog);
            }
            repository.saveAndFlush(group);
        }
        return group;
    }
    
    @Override
    public Studentgroup create(String studentgroupName, Academicyear departAnneeAcademique, Diplom diplome) {
        if (studentgroupName != null) {
            Studentgroup group = new Studentgroup();
            group.setStudentgroupName(studentgroupName);
            if (departAnneeAcademique != null) {
                //A revoir
                group.getProgramId().setAcademicyearId(departAnneeAcademique);
            }
            if (diplome != null) {
                group.getProgramId().setDiplomId(diplome);
            }
            repository.saveAndFlush(group);

            Optional<Studentgroup> result = repository.findById(group.getStudentgroupId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }
}
