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
public class ComponentRepositoryCustomImpl implements ComponentRepositoryCustom {

    @Autowired
    @Lazy
    private ComponentRepository repository;

    @Override
    public Component create(String componentName, boolean componentActive) {
        if ((componentName != null)) {
            Component item = new Component();
            item.setComponentName(componentName);
            item.setComponentActive(componentActive);
            repository.saveAndFlush(item);

            Optional<Component> result = repository.findById(item.getComponentId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Component item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Component getByComponentId(Integer componentId) {
        Optional<Component> result = repository.findById(componentId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
