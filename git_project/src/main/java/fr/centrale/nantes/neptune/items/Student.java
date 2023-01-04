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
import javax.persistence.ManyToOne;
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
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByStudentIdnumber", query = "SELECT s FROM Student s WHERE s.studentIdnumber = :studentIdnumber")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "student_idnumber")
    private String studentIdnumber;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Studentskilllevel> studentskilllevelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<Studentregistration> studentregistrationCollection;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Student(Integer studentId, String studentIdnumber) {
        this.studentId = studentId;
        this.studentIdnumber = studentIdnumber;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentIdnumber() {
        return studentIdnumber;
    }

    public void setStudentIdnumber(String studentIdnumber) {
        this.studentIdnumber = studentIdnumber;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Collection<Studentskilllevel> getStudentskilllevelCollection() {
        return studentskilllevelCollection;
    }

    public void setStudentskilllevelCollection(Collection<Studentskilllevel> studentskilllevelCollection) {
        this.studentskilllevelCollection = studentskilllevelCollection;
    }

    public Collection<Studentregistration> getStudentregistrationCollection() {
        return studentregistrationCollection;
    }

    public void setStudentregistrationCollection(Collection<Studentregistration> studentregistrationCollection) {
        this.studentregistrationCollection = studentregistrationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Student[ studentId=" + studentId + " ]";
    }
    
}
