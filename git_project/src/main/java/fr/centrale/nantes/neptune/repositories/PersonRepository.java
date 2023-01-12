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
    
        
    @Query(value = "SELECT \n" +
                    "	p.person_id as person_id, p.person_lastname as person_lastname, p.person_firstname as person_firstname, course.course_abrev as course_abrev\n" +
                    "FROM \n" +
                    "	course NATURAL JOIN registercourse NATURAL JOIN \n" +
                    "	studentregistration INNER JOIN student ON(student.student_id=studentregistration.student_id)\n" +
                    "	INNER JOIN person p ON(student.person_id=p.person_id)\n" +
                    "WHERE \n" +
                    "	course.person_id=?1 " +
                    "ORDER BY person_lastname ASC",
            
    nativeQuery = true)
    public Collection<String[]> findByObserver(Integer observerId);
    
}
