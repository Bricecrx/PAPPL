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
public class ActionRepositoryCustomImpl implements ActionRepositoryCustom {

    @Autowired
    @Lazy
    private ActionRepository repository;

    @Override
    public Action create(String actionCode) {
        if (actionCode != null) {
            Action item = new Action();
            item.setActionCode(actionCode);
            repository.saveAndFlush(item);

            Optional<Action> result = repository.findById(item.getActionId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Action item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Action getByActionId(Integer actionId) {
        Optional<Action> result = repository.findById(actionId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    
    @Override
    public Action getByActionCode(String actionCode) {
        Collection<Action> result = repository.findByActionCode(actionCode);
        if ((result != null) && (result.size() == 1)) {
            return result.iterator().next();
        }
        return null;        
    }
}
