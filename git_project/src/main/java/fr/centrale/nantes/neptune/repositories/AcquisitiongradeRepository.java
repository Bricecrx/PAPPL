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
public interface AcquisitiongradeRepository extends JpaRepository<Acquisitiongrade, Integer>, AcquisitiongradeRepositoryCustom {

    public Collection<Acquisitiongrade> findByAcquisitiongradeId(@Param("acquisitiongradeId")Integer acquisitiongradeId);

    public Collection<Acquisitiongrade> findByAcquisitiongradeName(@Param("acquisitiongradeName")String acquisitiongradeName);

    public Collection<Acquisitiongrade> findByAcquisitiongradeLevel(@Param("acquisitiongradeLevel")int acquisitiongradeLevel);

}
