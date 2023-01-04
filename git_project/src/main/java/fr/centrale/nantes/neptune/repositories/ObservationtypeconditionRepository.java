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
public interface ObservationtypeconditionRepository extends JpaRepository<Observationtypecondition, Integer>, ObservationtypeconditionRepositoryCustom {

    public Collection<Observationtypecondition> findByObservationtypeconditionId(@Param("observationtypeconditionId")Integer observationtypeconditionId);

    public Collection<Observationtypecondition> findByObservationtypeconditionValue(@Param("observationtypeconditionValue")String observationtypeconditionValue);

}
