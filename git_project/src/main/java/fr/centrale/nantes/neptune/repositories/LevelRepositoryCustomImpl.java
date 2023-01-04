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
public class LevelRepositoryCustomImpl implements LevelRepositoryCustom {

    @Autowired
    @Lazy
    private LevelRepository repository;

    @Override
    public Level create(String levelName) {
        if ((levelName != null)) {
            Level item = new Level();
            item.setLevelName(levelName);
            repository.saveAndFlush(item);

            Optional<Level> result = repository.findById(item.getLevelId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Level item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Level getByLevelId(Integer levelId) {
        Optional<Level> result = repository.findById(levelId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
