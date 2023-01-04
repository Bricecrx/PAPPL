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
public class ObservationtypeconditionRepositoryCustomImpl implements ObservationtypeconditionRepositoryCustom {

    @Autowired
    @Lazy
    private ObservationtypeconditionRepository repository;

    @Override
    public Observationtypecondition create(String observationtypeconditionValue) {
        if ((observationtypeconditionValue != null)) {
            Observationtypecondition item = new Observationtypecondition();
            item.setObservationtypeconditionValue(observationtypeconditionValue);
            repository.saveAndFlush(item);

            Optional<Observationtypecondition> result = repository.findById(item.getObservationtypeconditionId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Observationtypecondition item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Observationtypecondition getByObservationtypeconditionId(Integer observationtypeconditionId) {
        Optional<Observationtypecondition> result = repository.findById(observationtypeconditionId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
