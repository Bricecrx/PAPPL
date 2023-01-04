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
public class ComponentlevelRepositoryCustomImpl implements ComponentlevelRepositoryCustom {

    @Autowired
    @Lazy
    private ComponentlevelRepository repository;

    @Override
    public Componentlevel create() {
        Componentlevel item = new Componentlevel();
        repository.saveAndFlush(item);

        Optional<Componentlevel> result = repository.findById(item.getComponentlevelId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Componentlevel item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Componentlevel getByComponentlevelId(Integer componentlevelId) {
        Optional<Componentlevel> result = repository.findById(componentlevelId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
