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
@Table(name = "academicgradeinstance")
@NamedQueries({
    @NamedQuery(name = "Academicgradeinstance.findAll", query = "SELECT a FROM Academicgradeinstance a"),
    @NamedQuery(name = "Academicgradeinstance.findByAcademicgradeinstanceId", query = "SELECT a FROM Academicgradeinstance a WHERE a.academicgradeinstanceId = :academicgradeinstanceId")})
public class Academicgradeinstance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "academicgradeinstance_id")
    private Integer academicgradeinstanceId;
    @OneToMany(mappedBy = "academicgradeinstanceId")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "academicgrade_id", referencedColumnName = "academicgrade_id")
    @ManyToOne(optional = false)
    private Academicgrade academicgradeId;
    @JoinColumn(name = "academicyear_id", referencedColumnName = "academicyear_id")
    @ManyToOne(optional = false)
    private Academicyear academicyearId;

    public Academicgradeinstance() {
    }

    public Academicgradeinstance(Integer academicgradeinstanceId) {
        this.academicgradeinstanceId = academicgradeinstanceId;
    }

    public Integer getAcademicgradeinstanceId() {
        return academicgradeinstanceId;
    }

    public void setAcademicgradeinstanceId(Integer academicgradeinstanceId) {
        this.academicgradeinstanceId = academicgradeinstanceId;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Academicgrade getAcademicgradeId() {
        return academicgradeId;
    }

    public void setAcademicgradeId(Academicgrade academicgradeId) {
        this.academicgradeId = academicgradeId;
    }

    public Academicyear getAcademicyearId() {
        return academicyearId;
    }

    public void setAcademicyearId(Academicyear academicyearId) {
        this.academicyearId = academicyearId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (academicgradeinstanceId != null ? academicgradeinstanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Academicgradeinstance)) {
            return false;
        }
        Academicgradeinstance other = (Academicgradeinstance) object;
        if ((this.academicgradeinstanceId == null && other.academicgradeinstanceId != null) || (this.academicgradeinstanceId != null && !this.academicgradeinstanceId.equals(other.academicgradeinstanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Academicgradeinstance[ academicgradeinstanceId=" + academicgradeinstanceId + " ]";
    }
    
}
