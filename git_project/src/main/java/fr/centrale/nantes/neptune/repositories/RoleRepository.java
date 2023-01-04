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
public interface RoleRepository extends JpaRepository<Role, Integer>, RoleRepositoryCustom {

    public Collection<Role> findByRoleId(@Param("roleId")Integer roleId);

    public Collection<Role> findByRoleTitle(@Param("roleTitle")String roleTitle);

}
