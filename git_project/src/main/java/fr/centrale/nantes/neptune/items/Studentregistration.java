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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "studentregistration")
@NamedQueries({
    @NamedQuery(name = "Studentregistration.findAll", query = "SELECT s FROM Studentregistration s"),
    @NamedQuery(name = "Studentregistration.findByStudentregistrationId", query = "SELECT s FROM Studentregistration s WHERE s.studentregistrationId = :studentregistrationId")})
public class Studentregistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentregistration_id")
    private Integer studentregistrationId;
    @ManyToMany(mappedBy = "studentregistrationCollection")
    private Collection<Course> courseCollection;
    @ManyToMany(mappedBy = "studentregistrationCollection")
    private Collection<Studentgroup> studentgroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentregistration")
    private Collection<Observedcondition> observedconditionCollection;
    @JoinColumn(name = "diplom_id", referencedColumnName = "diplom_id")
    @ManyToOne(optional = false)
    private Diplom diplomId;
    @JoinColumn(name = "skillreferential_id", referencedColumnName = "skillreferential_id")
    @ManyToOne(optional = false)
    private Skillreferential skillreferentialId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(optional = false)
    private Student studentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentregistrationId")
    private Collection<Studentskilllevelobserv> studentskilllevelobservCollection;

    public Studentregistration() {
    }

    public Studentregistration(Integer studentregistrationId) {
        this.studentregistrationId = studentregistrationId;
    }

    public Integer getStudentregistrationId() {
        return studentregistrationId;
    }

    public void setStudentregistrationId(Integer studentregistrationId) {
        this.studentregistrationId = studentregistrationId;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Collection<Studentgroup> getStudentgroupCollection() {
        return studentgroupCollection;
    }

    public void setStudentgroupCollection(Collection<Studentgroup> studentgroupCollection) {
        this.studentgroupCollection = studentgroupCollection;
    }

    public Collection<Observedcondition> getObservedconditionCollection() {
        return observedconditionCollection;
    }

    public void setObservedconditionCollection(Collection<Observedcondition> observedconditionCollection) {
        this.observedconditionCollection = observedconditionCollection;
    }

    public Diplom getDiplomId() {
        return diplomId;
    }

    public void setDiplomId(Diplom diplomId) {
        this.diplomId = diplomId;
    }

    public Skillreferential getSkillreferentialId() {
        return skillreferentialId;
    }

    public void setSkillreferentialId(Skillreferential skillreferentialId) {
        this.skillreferentialId = skillreferentialId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
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
        hash += (studentregistrationId != null ? studentregistrationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentregistration)) {
            return false;
        }
        Studentregistration other = (Studentregistration) object;
        if ((this.studentregistrationId == null && other.studentregistrationId != null) || (this.studentregistrationId != null && !this.studentregistrationId.equals(other.studentregistrationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Studentregistration[ studentregistrationId=" + studentregistrationId + " ]";
    }
    
}
