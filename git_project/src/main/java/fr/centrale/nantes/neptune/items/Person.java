/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByPersonFirstname", query = "SELECT p FROM Person p WHERE p.personFirstname = :personFirstname"),
    @NamedQuery(name = "Person.findByPersonLastname", query = "SELECT p FROM Person p WHERE p.personLastname = :personLastname"),
    @NamedQuery(name = "Person.findByPersonEmail", query = "SELECT p FROM Person p WHERE p.personEmail = :personEmail"),
    @NamedQuery(name = "Person.findByPersonLogin", query = "SELECT p FROM Person p WHERE p.personLogin = :personLogin"),
    @NamedQuery(name = "Person.findByPersonPassword", query = "SELECT p FROM Person p WHERE p.personPassword = :personPassword")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "person_firstname")
    private String personFirstname;
    @Size(max = 128)
    @Column(name = "person_lastname")
    private String personLastname;
    @Size(max = 256)
    @Column(name = "person_email")
    private String personEmail;
    @Size(max = 128)
    @Column(name = "person_login")
    private String personLogin;
    @Size(max = 4096)
    @Column(name = "person_password")
    private String personPassword;
    @Lob
    @Column(name = "person_photo")
    private byte[] personPhoto;
    @JoinTable(name = "hasrole", joinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "person_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany
    private Collection<Role> roleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Observer> observerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Connect> connectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Studentskilllevelobserv> studentskilllevelobservCollection;

    public Person() {
    }
    
    public Person(Person p) {
        this.personFirstname = p.personFirstname;
        this.personLastname = p.personLastname;
        this.personEmail = p.personEmail;
        this.personLogin = p.personLogin;
        this.personPassword = p.personPassword;
        this.personPhoto = p.personPhoto;
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Person(Integer personId, String personFirstname) {
        this.personId = personId;
        this.personFirstname = personFirstname;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonFirstname() {
        return personFirstname;
    }

    public void setPersonFirstname(String personFirstname) {
        this.personFirstname = personFirstname;
    }

    public String getPersonLastname() {
        return personLastname;
    }

    public void setPersonLastname(String personLastname) {
        this.personLastname = personLastname;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonLogin() {
        return personLogin;
    }

    public void setPersonLogin(String personLogin) {
        this.personLogin = personLogin;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public byte[] getPersonPhoto() {
        return personPhoto;
    }

    public void setPersonPhoto(byte[] personPhoto) {
        this.personPhoto = personPhoto;
    }

    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Collection<Observer> getObserverCollection() {
        return observerCollection;
    }

    public void setObserverCollection(Collection<Observer> observerCollection) {
        this.observerCollection = observerCollection;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Collection<Connect> getConnectCollection() {
        return connectCollection;
    }

    public void setConnectCollection(Collection<Connect> connectCollection) {
        this.connectCollection = connectCollection;
    }

    public Collection<Studentskilllevelobserv> getStudentskilllevelobservCollection() {
        return studentskilllevelobservCollection;
    }

    public void setStudentskilllevelobservCollection(Collection<Studentskilllevelobserv> studentskilllevelobservCollection) {
        this.studentskilllevelobservCollection = studentskilllevelobservCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Person[ personId=" + personId + " ]";
    }
    
}
