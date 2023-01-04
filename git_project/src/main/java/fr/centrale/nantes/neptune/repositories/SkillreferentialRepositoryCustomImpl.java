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
public class SkillreferentialRepositoryCustomImpl implements SkillreferentialRepositoryCustom {

    @Autowired
    @Lazy
    private SkillreferentialRepository repository;

    @Override
    public Skillreferential create(boolean skillreferentialActive) {
        Skillreferential item = new Skillreferential();
        item.setSkillreferentialActive(skillreferentialActive);
        repository.saveAndFlush(item);

        Optional<Skillreferential> result = repository.findById(item.getSkillreferentialId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(Skillreferential item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Skillreferential getBySkillreferentialId(Integer skillreferentialId) {
        Optional<Skillreferential> result = repository.findById(skillreferentialId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
