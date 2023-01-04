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
public class ProgramRepositoryCustomImpl implements ProgramRepositoryCustom {

    @Autowired
    @Lazy
    private ProgramRepository repository;
    
    @Override
    public Program update(int programId, Academicyear departAnneeAcademique, Diplom diplome){
        Program prog = repository.findByProgramId(programId).iterator().next();
        if (prog != null) {
            if (departAnneeAcademique != null) {
                prog.setAcademicyearId(departAnneeAcademique);
            }
            if (diplome != null) {
                prog.setDiplomId(diplome);
            }
            repository.saveAndFlush(prog);
        }
        return prog;
    }

    @Override
    public Program create(Diplom diplomId, Academicyear academicyearId) {
        Program item = new Program();
        item.setAcademicyearId(academicyearId);
        item.setDiplomId(diplomId);
        repository.saveAndFlush(item);

        Optional<Program> result = repository.findById(item.getProgramId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Program item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Program getByProgramId(Integer programId) {
        Optional<Program> result = repository.findById(programId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
