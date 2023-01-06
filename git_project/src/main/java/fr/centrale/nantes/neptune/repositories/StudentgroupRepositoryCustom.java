/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

/**
 *
 * @author conra
 */
public interface StudentgroupRepositoryCustom {

    /**
     * Create new Studentgroup
     * @param studentgroupName
     * @return Studentgroup
     */
    public Studentgroup create(String studentgroupName);

    /**
     * Remove Studentgroup
     * @param item
     */
    public void remove(Studentgroup item);

    /**
     * Get a Studentgroup from its ID
     * @param studentgroupId
     * @return Studentgroup
     */
    public Studentgroup getByStudentgroupId(Integer studentgroupId);
    
    /**
     *
     * @param group
     * @param studentgroupName
     * @param departAnneeAcademique
     * @param diplome
     * @return
     */
    public Studentgroup update(Studentgroup group, String studentgroupName, Academicyear departAnneeAcademique, Diplom diplome);
    
    /**
     *
     * @param group
     * @param studentgroupName
     * @param prog
     * @return
     */
    public Studentgroup update(Studentgroup group, String studentgroupName, Program prog);
    
    /**
     *
     * @param group
     * @param sR
     * @return
     */
    public Studentgroup update(Studentgroup group, Collection<Studentregistration> sR);
    
    /**
     *
     * @param group
     * @param studentgroupName
     * @param departAnneeAcademique
     * @param diplome
     * @return
     */
    public Studentgroup create(String studentgroupName, Academicyear departAnneeAcademique, Diplom diplome);

}
