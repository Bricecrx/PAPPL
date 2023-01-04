/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Optional;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom {

    @Autowired
    @Lazy
    private MenuRepository repository;

    @Override
    public Menu create(String menuTitle, String menuCode) {
        if ((menuTitle != null) && (menuCode != null)) {
            Menu item = new Menu();
            item.setMenuTitle(menuTitle);
            item.setMenuCode(menuCode);
            repository.saveAndFlush(item);

            Optional<Menu> result = repository.findById(item.getMenuId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Menu item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Menu getByMenuId(Integer menuId) {
        Optional<Menu> result = repository.findById(menuId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    
    @Override
    public Menu getByMenuCode(String menuCode) {
        Collection<Menu> result = repository.findByMenuCode(menuCode);
        if ((result != null) && (result.size() == 1)) {
            return result.iterator().next();
        }
        return null;        
    }
}
