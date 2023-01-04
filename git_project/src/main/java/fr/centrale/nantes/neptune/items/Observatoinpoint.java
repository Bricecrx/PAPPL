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
@Table(name = "observatoinpoint")
@NamedQueries({
    @NamedQuery(name = "Observatoinpoint.findAll", query = "SELECT o FROM Observatoinpoint o"),
    @NamedQuery(name = "Observatoinpoint.findByObservatoinpointId", query = "SELECT o FROM Observatoinpoint o WHERE o.observatoinpointId = :observatoinpointId"),
    @NamedQuery(name = "Observatoinpoint.findByObservationpointName", query = "SELECT o FROM Observatoinpoint o WHERE o.observationpointName = :observationpointName")})
public class Observatoinpoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "observatoinpoint_id")
    private Integer observatoinpointId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "observationpoint_name")
    private String observationpointName;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne
    private Course courseId;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "studentgroup_id", referencedColumnName = "studentgroup_id")
    @ManyToOne(optional = false)
    private Studentgroup studentgroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observatoinpoint")
    private Collection<Observer> observerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observatoinpointId")
    private Collection<Observationtype> observationtypeCollection;

    public Observatoinpoint() {
    }

    public Observatoinpoint(Integer observatoinpointId) {
        this.observatoinpointId = observatoinpointId;
    }

    public Observatoinpoint(Integer observatoinpointId, String observationpointName) {
        this.observatoinpointId = observatoinpointId;
        this.observationpointName = observationpointName;
    }

    public Integer getObservatoinpointId() {
        return observatoinpointId;
    }

    public void setObservatoinpointId(Integer observatoinpointId) {
        this.observatoinpointId = observatoinpointId;
    }

    public String getObservationpointName() {
        return observationpointName;
    }

    public void setObservationpointName(String observationpointName) {
        this.observationpointName = observationpointName;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Studentgroup getStudentgroupId() {
        return studentgroupId;
    }

    public void setStudentgroupId(Studentgroup studentgroupId) {
        this.studentgroupId = studentgroupId;
    }

    public Collection<Observer> getObserverCollection() {
        return observerCollection;
    }

    public void setObserverCollection(Collection<Observer> observerCollection) {
        this.observerCollection = observerCollection;
    }

    public Collection<Observationtype> getObservationtypeCollection() {
        return observationtypeCollection;
    }

    public void setObservationtypeCollection(Collection<Observationtype> observationtypeCollection) {
        this.observationtypeCollection = observationtypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observatoinpointId != null ? observatoinpointId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observatoinpoint)) {
            return false;
        }
        Observatoinpoint other = (Observatoinpoint) object;
        if ((this.observatoinpointId == null && other.observatoinpointId != null) || (this.observatoinpointId != null && !this.observatoinpointId.equals(other.observatoinpointId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Observatoinpoint[ observatoinpointId=" + observatoinpointId + " ]";
    }
    
}
