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
public interface ComponentRepository extends JpaRepository<Component, Integer>, ComponentRepositoryCustom {

    public Collection<Component> findByComponentId(@Param("componentId")Integer componentId);

    public Collection<Component> findByComponentName(@Param("componentName")String componentName);

    public Collection<Component> findByComponentActive(@Param("componentActive")boolean componentActive);

}
