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

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "program")
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByProgramId", query = "SELECT p FROM Program p WHERE p.programId = :programId")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "program_id")
    private Integer programId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<Observatoinpoint> observatoinpointCollection;
    @JoinColumn(name = "academicyear_id", referencedColumnName = "academicyear_id")
    @ManyToOne(optional = false)
    private Academicyear academicyearId;
    @JoinColumn(name = "diplom_id", referencedColumnName = "diplom_id")
    @ManyToOne(optional = false)
    private Diplom diplomId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<Studentgroup> studentgroupCollection;

    public Program() {
    }

    public Program(Integer programId) {
        this.programId = programId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Collection<Observatoinpoint> getObservatoinpointCollection() {
        return observatoinpointCollection;
    }

    public void setObservatoinpointCollection(Collection<Observatoinpoint> observatoinpointCollection) {
        this.observatoinpointCollection = observatoinpointCollection;
    }

    public Academicyear getAcademicyearId() {
        return academicyearId;
    }

    public void setAcademicyearId(Academicyear academicyearId) {
        this.academicyearId = academicyearId;
    }

    public Diplom getDiplomId() {
        return diplomId;
    }

    public void setDiplomId(Diplom diplomId) {
        this.diplomId = diplomId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.programId == null && other.programId != null) || (this.programId != null && !this.programId.equals(other.programId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Program[ programId=" + programId + " ]";
    }
    
}
