/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface SkillreferentialRepositoryCustom {

    /**
     * Create new Skillreferential
     * @param skillreferentialActive
     * @return Skillreferential
     */
    public Skillreferential create(boolean skillreferentialActive);

    /**
     * Remove Skillreferential
     * @param item
     */
    public void remove(Skillreferential item);

    /**
     * Get a Skillreferential from its ID
     * @param skillreferentialId
     * @return Skillreferential
     */
    public Skillreferential getBySkillreferentialId(Integer skillreferentialId);

}
