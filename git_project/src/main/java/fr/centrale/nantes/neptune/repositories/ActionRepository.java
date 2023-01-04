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
public interface ActionRepository extends JpaRepository<Action, Integer>, ActionRepositoryCustom {

    public Collection<Action> findByActionId(@Param("actionId")Integer actionId);

    public Collection<Action> findByActionCode(@Param("actionCode")String actionCode);

}
