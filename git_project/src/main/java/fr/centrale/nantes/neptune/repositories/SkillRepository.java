/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>, SkillRepositoryCustom {

    public Collection<Skill> findBySkillId(@Param("skillId")Integer skillId);

    public Collection<Skill> findBySkillName(@Param("skillName")String skillName);

    public Collection<Skill> findBySkillDescriptionskillDescription(@Param("skillDescriptionskillDescription")String skillDescriptionskillDescription);

    public Collection<Skill> findBySkillActive(@Param("skillActive")boolean skillActive);

}
