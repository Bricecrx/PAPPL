/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface LevelRepositoryCustom {

    /**
     * Create new Level
     * @param levelName
     * @return Level
     */
    public Level create(String levelName);

    /**
     * Remove Level
     * @param item
     */
    public void remove(Level item);

    /**
     * Get a Level from its ID
     * @param levelId
     * @return Level
     */
    public Level getByLevelId(Integer levelId);

}
