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
@Table(name = "studentgroup")
@NamedQueries({
    @NamedQuery(name = "Studentgroup.findAll", query = "SELECT s FROM Studentgroup s"),
    @NamedQuery(name = "Studentgroup.findByStudentgroupId", query = "SELECT s FROM Studentgroup s WHERE s.studentgroupId = :studentgroupId"),
    @NamedQuery(name = "Studentgroup.findByStudentgroupName", query = "SELECT s FROM Studentgroup s WHERE s.studentgroupName = :studentgroupName")})
public class Studentgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentgroup_id")
    private Integer studentgroupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "studentgroup_name")
    private String studentgroupName;
    @JoinTable(name = "registergroup", joinColumns = {
        @JoinColumn(name = "studentgroup_id", referencedColumnName = "studentgroup_id")}, inverseJoinColumns = {
        @JoinColumn(name = "studentregistration_id", referencedColumnName = "studentregistration_id")})
    @ManyToMany
    private Collection<Studentregistration> studentregistrationCollection;
    @ManyToMany(mappedBy = "studentgroupCollection")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentgroupId")
    private Collection<Observatoinpoint> observatoinpointCollection;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private Program programId;

    public Studentgroup() {
    }

    public Studentgroup(Integer studentgroupId) {
        this.studentgroupId = studentgroupId;
    }

    public Studentgroup(Integer studentgroupId, String studentgroupName) {
        this.studentgroupId = studentgroupId;
        this.studentgroupName = studentgroupName;
    }

    public Integer getStudentgroupId() {
        return studentgroupId;
    }

    public void setStudentgroupId(Integer studentgroupId) {
        this.studentgroupId = studentgroupId;
    }

    public String getStudentgroupName() {
        return studentgroupName;
    }

    public void setStudentgroupName(String studentgroupName) {
        this.studentgroupName = studentgroupName;
    }

    public Collection<Studentregistration> getStudentregistrationCollection() {
        return studentregistrationCollection;
    }

    public void setStudentregistrationCollection(Collection<Studentregistration> studentregistrationCollection) {
        this.studentregistrationCollection = studentregistrationCollection;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Collection<Observatoinpoint> getObservatoinpointCollection() {
        return observatoinpointCollection;
    }

    public void setObservatoinpointCollection(Collection<Observatoinpoint> observatoinpointCollection) {
        this.observatoinpointCollection = observatoinpointCollection;
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
        hash += (studentgroupId != null ? studentgroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentgroup)) {
            return false;
        }
        Studentgroup other = (Studentgroup) object;
        if ((this.studentgroupId == null && other.studentgroupId != null) || (this.studentgroupId != null && !this.studentgroupId.equals(other.studentgroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Studentgroup[ studentgroupId=" + studentgroupId + " ]";
    }
    
}
