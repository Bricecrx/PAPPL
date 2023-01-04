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
public class ObservationtypeRepositoryCustomImpl implements ObservationtypeRepositoryCustom {

    @Autowired
    @Lazy
    private ObservationtypeRepository repository;

    @Override
    public Observationtype create(String observationtypeInfo, String observationtypeWhen, String observationtypeHow) {
        if ((observationtypeInfo != null) && (observationtypeWhen != null) && (observationtypeHow != null)) {
            Observationtype item = new Observationtype();
            item.setObservationtypeInfo(observationtypeInfo);
            item.setObservationtypeWhen(observationtypeWhen);
            item.setObservationtypeHow(observationtypeHow);
            repository.saveAndFlush(item);

            Optional<Observationtype> result = repository.findById(item.getObservationtypeId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Observationtype item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Observationtype getByObservationtypeId(Integer observationtypeId) {
        Optional<Observationtype> result = repository.findById(observationtypeId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
