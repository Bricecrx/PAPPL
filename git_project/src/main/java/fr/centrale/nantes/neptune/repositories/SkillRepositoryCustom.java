/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface SkillRepositoryCustom {

    /**
     * Create new Skill
     * @param skillName
     * @param skillActive
     * @return Skill
     */
    public Skill create(String skillName, boolean skillActive);

    /**
     * Remove Skill
     * @param item
     */
    public void remove(Skill item);

    /**
     * Get a Skill from its ID
     * @param skillId
     * @return Skill
     */
    public Skill getBySkillId(Integer skillId);

}
