/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import java.util.Observer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface ObservedconditionRepository extends JpaRepository<Observedcondition, ObservedconditionPK>, ObservedconditionRepositoryCustom {

    public Collection<Observedcondition> findByObservationtypeconditionId(@Param("observationtypeconditionId")int observationtypeconditionId);

    public Collection<Observedcondition> findByStudentregistrationId(@Param("studentregistrationId")int studentregistrationId);

}
