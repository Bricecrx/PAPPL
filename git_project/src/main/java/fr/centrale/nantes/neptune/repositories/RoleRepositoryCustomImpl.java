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
public class RoleRepositoryCustomImpl implements RoleRepositoryCustom {

    @Autowired
    @Lazy
    private RoleRepository repository;

    @Override
    public Role create(String roleTitle) {
        if ((roleTitle != null)) {
            Role item = new Role();
            item.setRoleTitle(roleTitle);
            repository.saveAndFlush(item);

            Optional<Role> result = repository.findById(item.getRoleId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Role item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Role getByRoleId(Integer roleId) {
        Optional<Role> result = repository.findById(roleId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
