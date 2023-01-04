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
public class AcademicgradeinstanceRepositoryCustomImpl implements AcademicgradeinstanceRepositoryCustom {

    @Autowired
    @Lazy
    private AcademicgradeinstanceRepository repository;

    @Override
    public Academicgradeinstance create() {
        Academicgradeinstance item = new Academicgradeinstance();
        repository.saveAndFlush(item);

        Optional<Academicgradeinstance> result = repository.findById(item.getAcademicgradeinstanceId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Academicgradeinstance item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Academicgradeinstance getByAcademicgradeinstanceId(Integer academicgradeinstanceId) {
        Optional<Academicgradeinstance> result = repository.findById(academicgradeinstanceId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
