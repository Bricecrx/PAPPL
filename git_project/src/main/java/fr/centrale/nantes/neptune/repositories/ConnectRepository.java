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
public interface ConnectRepository extends JpaRepository<Connect, String>, ConnectRepositoryCustom {

    public Collection<Connect> findByConnectCode(@Param("connectCode")String connectCode);

    public Collection<Connect> findByConnectExpire(@Param("connectExpire")Date connectExpire);

    public Collection<Connect> findByConnectIp(@Param("connectIp")String connectIp);

    /**
     * Get all expired connections
     * @param expireDate
     * @return
     */
    @Query("SELECT c FROM Connect c WHERE c.connectExpire < :expireDate")
    public Collection<Connect> findAllExpireBefore(@Param("expireDate")Date expireDate);

}
