/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface PersonRepositoryCustom {

    /**
     * Create new Personne
     * @param firstname
     * @return Person
     */
    public Person create(String firstname);

    /**
     * Create new Personne
     * @param firstname
     * @param email
     * @return Person
     */
    public Person create(String firstname, String email);

    /**
     * Create new Personne
     * @param firstname
     * @param lastname
     * @param email
     * @return Person
     */
    public Person create(String firstname, String lastname, String email);

    /**
     * Update Personne
     * @param personId
     * @param firstname
     * @param lastname
     * @param email
     * @return Person
     */
    public Person update(int personId, String firstname, String lastname, String email);

    /**
     * Update Personne
     * @param person
     * @param firstname
     * @param lastname
     * @param email
     * @return Person
     */
    public Person update(Person person, String firstname, String lastname, String email);

    /**
     * Update Personne
     * @param person
     * @param login
     * @param password
     * @return Person
     */
    public Person updateConnection(Person person, String login, String password);

    /**
     * Remove Person
     * @param item
     */
    public void remove(Person item);

    /**
     * Get a Person from its ID
     * @param personId
     * @return Person
     */
    public Person getByPersonId(Integer personId);

    /**
     * Get a Person from its login
     * @param login
     * @return Person
     */
    public Person getByPersonLogin(String login);

    /**
     * Find people with role teacher
     * @return Collection
     */
    public Collection<Person> findAllTeachers();
}
