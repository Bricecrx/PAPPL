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
public interface ObservationtypeRepository extends JpaRepository<Observationtype, Integer>, ObservationtypeRepositoryCustom {

    public Collection<Observationtype> findByObservationtypeId(@Param("observationtypeId")Integer observationtypeId);

    public Collection<Observationtype> findByObservationtypeInfo(@Param("observationtypeInfo")String observationtypeInfo);

    public Collection<Observationtype> findByObservationtypeWhen(@Param("observationtypeWhen")String observationtypeWhen);

    public Collection<Observationtype> findByObservationtypeHow(@Param("observationtypeHow")String observationtypeHow);

}
