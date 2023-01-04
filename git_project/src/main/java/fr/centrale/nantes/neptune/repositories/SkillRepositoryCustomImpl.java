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
public class SkillRepositoryCustomImpl implements SkillRepositoryCustom {

    @Autowired
    @Lazy
    private SkillRepository repository;

    @Override
    public Skill create(String skillName, boolean skillActive) {
        if ((skillName != null)) {
            Skill item = new Skill();
            item.setSkillName(skillName);
            item.setSkillActive(skillActive);
            repository.saveAndFlush(item);

            Optional<Skill> result = repository.findById(item.getSkillId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Skill item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Skill getBySkillId(Integer skillId) {
        Optional<Skill> result = repository.findById(skillId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
