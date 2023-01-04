/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.controllers.tools.SecurityTools;
import fr.centrale.nantes.neptune.items.*;
import java.util.Optional;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    @Lazy
    private PersonRepository repository;

    @Override
    public Person create(String firstname) {
        return create(firstname, null, null);
    }

    @Override
    public Person create(String firstname, String email) {
        return create(firstname, null, email);
    }

    @Override
    public Person create(String firstname, String lastname, String email) {
        if (firstname != null) {
            Person item = new Person();
            item.setPersonFirstname(firstname);
            if (lastname != null) {
                item.setPersonLastname(lastname);
            }
            if (email != null) {
                item.setPersonEmail(email);
            }
            
            repository.saveAndFlush(item);

            Optional<Person> result = repository.findById(item.getPersonId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    
    @Override
    public Person update(Person person, String firstname, String lastname, String email) {
        if ((person != null) && (firstname != null)) {
            person.setPersonFirstname(firstname);
            if (lastname != null) {
                person.setPersonLastname(lastname);
            }
            if (email != null) {
                person.setPersonEmail(email);
            }
            repository.saveAndFlush(person);
        }
        return person;
    }

    @Override
    public Person update(int personId, String firstname, String lastname, String email) {
        Person item = repository.getByPersonId(personId);
        return update(item, firstname, lastname, email);
    }

    @Override
    public Person updateConnection(Person person, String login, String password) {
        if ((person != null) && (login != null)) {
            person.setPersonLogin(login);
            if (password != null) {
                person.setPersonPassword(fr.centrale.nantes.neptune.controllers.tools.SecurityTools.encryptPassword(password));
            }
            repository.saveAndFlush(person);
        }
        return person;
    }

    @Override
    public void remove(Person item) {
        if (item != null) {
            repository.delete(item);
        }
    }

    @Override
    public Person getByPersonId(Integer personId) {
        Optional<Person> result = repository.findById(personId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Person getByPersonLogin(String login) {
        Collection<Person> result = repository.findByPersonLogin(login);
        if ((result != null) && (result.size() == 1)) {
            return result.iterator().next();
        }
        return null;
    }

    @Override
    public Collection<Person> findAllTeachers() {
        return repository.findByPersonRole(SecurityTools.TEACHERROLE);
    }
}
