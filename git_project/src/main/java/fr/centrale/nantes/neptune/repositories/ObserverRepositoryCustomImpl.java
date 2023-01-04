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
public class ObserverRepositoryCustomImpl implements ObserverRepositoryCustom {

    @Autowired
    @Lazy
    private ObserverRepository repository;

    @Override
    public Observer create(int personId, int observatoinpointId) {
        Observer item = new Observer(personId, observatoinpointId);
        repository.saveAndFlush(item);

        Optional<Observer> result = repository.findById(item.getObserverPK());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Observer item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Observer getByObserverPK(int personId, int observatoinpointId) {
        Optional<Observer> result = repository.findById(new ObserverPK(personId, observatoinpointId));
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
