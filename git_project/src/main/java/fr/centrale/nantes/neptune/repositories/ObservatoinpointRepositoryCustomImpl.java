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
public class ObservatoinpointRepositoryCustomImpl implements ObservatoinpointRepositoryCustom {

    @Autowired
    @Lazy
    private ObservatoinpointRepository repository;

    @Override
    public Observatoinpoint create(String observationpointName) {
        if ((observationpointName != null)) {
            Observatoinpoint item = new Observatoinpoint();
            item.setObservationpointName(observationpointName);
            repository.saveAndFlush(item);

            Optional<Observatoinpoint> result = repository.findById(item.getObservatoinpointId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Observatoinpoint item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Observatoinpoint getByObservatoinpointId(Integer observatoinpointId) {
        Optional<Observatoinpoint> result = repository.findById(observatoinpointId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
