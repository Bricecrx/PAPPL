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
public class AcademicgradeRepositoryCustomImpl implements AcademicgradeRepositoryCustom {

    @Autowired
    @Lazy
    private AcademicgradeRepository repository;

    @Override
    public Academicgrade create(String academicgradeName) {
        if ((academicgradeName != null)) {
            Academicgrade item = new Academicgrade();
            item.setAcademicgradeName(academicgradeName);
            repository.saveAndFlush(item);

            Optional<Academicgrade> result = repository.findById(item.getAcademicgradeId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Academicgrade item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Academicgrade getByAcademicgradeId(Integer academicgradeId) {
        Optional<Academicgrade> result = repository.findById(academicgradeId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
