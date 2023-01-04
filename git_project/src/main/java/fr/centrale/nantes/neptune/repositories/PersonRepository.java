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
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {

    public Collection<Person> findByPersonId(@Param("personId")Integer personId);

    public Collection<Person> findByPersonFirstname(@Param("personFirstname")String personFirstname);

    public Collection<Person> findByPersonLastname(@Param("personLastname")String personLastname);

    public Collection<Person> findByPersonEmail(@Param("personEmail")String personEmail);

    public Collection<Person> findByPersonLogin(@Param("personLogin")String personLogin);

    public Collection<Person> findByPersonPassword(@Param("personPassword")String personPassword);

    public Collection<Person> findByPersonPhoto(@Param("personPhoto")String personPhoto);

    @Query(value = "SELECT p.* FROM Person p NATURAL JOIN HasRole NATURAL JOIN Role r WHERE r.Role_ID=:roleId", nativeQuery = true)
    public Collection<Person> findByPersonRole(@Param("roleId")int roleId);

    @Query(value = "SELECT p.* FROM Person p NATURAL JOIN HasRole NATURAL JOIN Role r WHERE r.Role_Title=:roleTitle", nativeQuery = true)
    public Collection<Person> findByPersonRole(@Param("roleTitle")String roleTitle);
}
