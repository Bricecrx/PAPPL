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
public interface ObservatoinpointRepository extends JpaRepository<Observatoinpoint, Integer>, ObservatoinpointRepositoryCustom {

    public Collection<Observatoinpoint> findByObservatoinpointId(@Param("observatoinpointId")Integer observatoinpointId);

    public Collection<Observatoinpoint> findByObservationpointName(@Param("observationpointName")String observationpointName);

}
