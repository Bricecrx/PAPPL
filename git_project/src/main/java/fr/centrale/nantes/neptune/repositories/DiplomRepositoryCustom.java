/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import java.util.Optional;

public interface DiplomRepositoryCustom {

    /**
     * Create new Diplom
     * @param diplomName
    * @return Diplom
     */
    public Diplom create(String diplomName);

    /**
     * Remove Diplom
     * @param item
     */
    public void remove(Diplom item);

    /**
     * Get a Diplom from its ID
     * @param diplomId
     * @return Diplom
     */
    public Diplom getByDiplomId(Integer diplomId);
    
    /**
     * Get a Diplom from its ID
     * @param diplomName
     * @return Diplom
     */
    public Diplom getByDiplomName(String diplomName);

}
