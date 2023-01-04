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
public class AcquisitiongradeRepositoryCustomImpl implements AcquisitiongradeRepositoryCustom {

    @Autowired
    @Lazy
    private AcquisitiongradeRepository repository;

    @Override
    public Acquisitiongrade create(String acquisitiongradeName, int acquisitiongradeLevel) {
        if ((acquisitiongradeName != null)) {
            Acquisitiongrade item = new Acquisitiongrade();
            item.setAcquisitiongradeName(acquisitiongradeName);
            item.setAcquisitiongradeLevel(acquisitiongradeLevel);
            repository.saveAndFlush(item);

            Optional<Acquisitiongrade> result = repository.findById(item.getAcquisitiongradeId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Acquisitiongrade item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Acquisitiongrade getByAcquisitiongradeId(Integer acquisitiongradeId) {
        Optional<Acquisitiongrade> result = repository.findById(acquisitiongradeId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
