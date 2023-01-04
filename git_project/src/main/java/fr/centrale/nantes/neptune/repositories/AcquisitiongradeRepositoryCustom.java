/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface AcquisitiongradeRepositoryCustom {

    /**
     * Create new Acquisitiongrade
     * @param acquisitiongradeName
     * @param acquisitiongradeLevel
     * @return Acquisitiongrade
     */
    public Acquisitiongrade create(String acquisitiongradeName, int acquisitiongradeLevel);

    /**
     * Remove Acquisitiongrade
     * @param item
     */
    public void remove(Acquisitiongrade item);

    /**
     * Get a Acquisitiongrade from its ID
     * @param acquisitiongradeId
     * @return Acquisitiongrade
     */
    public Acquisitiongrade getByAcquisitiongradeId(Integer acquisitiongradeId);

}
