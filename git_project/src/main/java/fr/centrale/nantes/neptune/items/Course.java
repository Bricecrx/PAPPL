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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByCourseTitle", query = "SELECT c FROM Course c WHERE c.courseTitle = :courseTitle"),
    @NamedQuery(name = "Course.findByCourseAbrev", query = "SELECT c FROM Course c WHERE c.courseAbrev = :courseAbrev")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id")
    private Integer courseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "course_title")
    private String courseTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "course_abrev")
    private String courseAbrev;
    @JoinTable(name = "registercourse", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "studentregistration_id", referencedColumnName = "studentregistration_id")})
    @ManyToMany
    private Collection<Studentregistration> studentregistrationCollection;
    @JoinTable(name = "registercoursegroup", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "studentgroup_id", referencedColumnName = "studentgroup_id")})
    @ManyToMany
    private Collection<Studentgroup> studentgroupCollection;
    @OneToMany(mappedBy = "courseId")
    private Collection<Observatoinpoint> observatoinpointCollection;
    @JoinColumn(name = "academicgradeinstance_id", referencedColumnName = "academicgradeinstance_id")
    @ManyToOne
    private Academicgradeinstance academicgradeinstanceId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private Program programId;

    public Course() {
    }

    public Course(Integer courseId) {
        this.courseId = courseId;
    }

    public Course(Integer courseId, String courseTitle, String courseAbrev) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseAbrev = courseAbrev;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseAbrev() {
        return courseAbrev;
    }

    public void setCourseAbrev(String courseAbrev) {
        this.courseAbrev = courseAbrev;
    }

    public Collection<Studentregistration> getStudentregistrationCollection() {
        return studentregistrationCollection;
    }

    public void setStudentregistrationCollection(Collection<Studentregistration> studentregistrationCollection) {
        this.studentregistrationCollection = studentregistrationCollection;
    }

    public Collection<Studentgroup> getStudentgroupCollection() {
        return studentgroupCollection;
    }

    public void setStudentgroupCollection(Collection<Studentgroup> studentgroupCollection) {
        this.studentgroupCollection = studentgroupCollection;
    }

    public Collection<Observatoinpoint> getObservatoinpointCollection() {
        return observatoinpointCollection;
    }

    public void setObservatoinpointCollection(Collection<Observatoinpoint> observatoinpointCollection) {
        this.observatoinpointCollection = observatoinpointCollection;
    }

    public Academicgradeinstance getAcademicgradeinstanceId() {
        return academicgradeinstanceId;
    }

    public void setAcademicgradeinstanceId(Academicgradeinstance academicgradeinstanceId) {
        this.academicgradeinstanceId = academicgradeinstanceId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Course[ courseId=" + courseId + " ]";
    }
    
}
