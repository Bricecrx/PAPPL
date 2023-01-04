/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Date;
import java.util.Collection;

public interface ConnectRepositoryCustom {

    /**
     * Create new Connexion
     * @param person
     * @param Ip
     * @return Connect
     */
    public Connect create(Person person, String Ip);

    /**
     * Remove Connect
     * @param item
     */
    public void remove(Connect item);

    /**
     * Get a Connect from its ID
     * @param connectCode
     * @return Connect
     */
    public Connect getByConnectCode(String connectCode);

    /**
     * Remove old connexions
     */
    public void removeOld();

    /**
     * Expand connexion
     * @param connexion 
     */
    public void expand(Connect connexion);

}
