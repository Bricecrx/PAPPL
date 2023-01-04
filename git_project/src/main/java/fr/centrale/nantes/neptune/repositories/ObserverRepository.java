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
public interface ObserverRepository extends JpaRepository<Observer, ObserverPK>, ObserverRepositoryCustom {

    public Collection<Observer> findByPersonId(@Param("personId")int personId);

    public Collection<Observer> findByObservatoinpointId(@Param("observatoinpointId")int observatoinpointId);

}
