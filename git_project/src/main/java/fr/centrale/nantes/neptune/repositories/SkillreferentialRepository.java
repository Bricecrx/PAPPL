/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface SkillreferentialRepository extends JpaRepository<Skillreferential, Integer>, SkillreferentialRepositoryCustom {

    public Collection<Skillreferential> findBySkillreferentialId(@Param("skillreferentialId")Integer skillreferentialId);

    public Collection<Skillreferential> findBySkillreferentialActive(@Param("skillreferentialActive")boolean skillreferentialActive);

    public Collection<Skillreferential> findBySkillreferentialRncpdate(@Param("skillreferentialRncpdate")Date skillreferentialRncpdate);

}
