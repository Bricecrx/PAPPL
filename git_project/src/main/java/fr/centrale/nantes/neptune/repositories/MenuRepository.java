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
public interface MenuRepository extends JpaRepository<Menu, Integer>, MenuRepositoryCustom {

    public Collection<Menu> findByMenuId(@Param("menuId")Integer menuId);

    public Collection<Menu> findByMenuTitle(@Param("menuTitle")String menuTitle);

    public Collection<Menu> findByMenuCode(@Param("menuCode")String menuCode);

    /**
     * Get menu bar items
     * @return
     */
    @Query("SELECT m FROM Menu m WHERE m.menuParentId IS NULL ORDER BY m.menuId")
    public Collection<Menu> findAllMain();

}
