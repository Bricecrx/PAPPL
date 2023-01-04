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
public interface DiplomRepository extends JpaRepository<Diplom, Integer>, DiplomRepositoryCustom {

    public Collection<Diplom> findByDiplomId(@Param("diplomId")Integer diplomId);

    public Collection<Diplom> findByDiplomName(@Param("diplomName")String diplomName);

    public Collection<Diplom> findByDiplomActive(@Param("diplomActive")boolean diplomActive);

}
