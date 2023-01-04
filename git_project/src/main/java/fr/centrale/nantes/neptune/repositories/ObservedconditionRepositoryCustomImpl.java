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
public class ObservedconditionRepositoryCustomImpl implements ObservedconditionRepositoryCustom {

    @Autowired
    @Lazy
    private ObservedconditionRepository repository;

    @Override
    public Observedcondition create(int observationtypeconditionId, int studentregistrationId) {
        Observedcondition item = new Observedcondition(observationtypeconditionId, studentregistrationId);
        repository.saveAndFlush(item);

        Optional<Observedcondition> result = repository.findById(item.getObservedconditionPK());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Observedcondition item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Observedcondition getByObservedconditionPK(int observationtypeconditionId, int studentregistrationId) {
        Optional<Observedcondition> result = repository.findById(new ObservedconditionPK(observationtypeconditionId, studentregistrationId));
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
