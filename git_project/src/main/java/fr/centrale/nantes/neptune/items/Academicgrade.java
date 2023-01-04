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
@Table(name = "academicgrade")
@NamedQueries({
    @NamedQuery(name = "Academicgrade.findAll", query = "SELECT a FROM Academicgrade a"),
    @NamedQuery(name = "Academicgrade.findByAcademicgradeId", query = "SELECT a FROM Academicgrade a WHERE a.academicgradeId = :academicgradeId"),
    @NamedQuery(name = "Academicgrade.findByAcademicgradeName", query = "SELECT a FROM Academicgrade a WHERE a.academicgradeName = :academicgradeName")})
public class Academicgrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "academicgrade_id")
    private Integer academicgradeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "academicgrade_name")
    private String academicgradeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academicgradeId")
    private Collection<Academicgradeinstance> academicgradeinstanceCollection;

    public Academicgrade() {
    }

    public Academicgrade(Integer academicgradeId) {
        this.academicgradeId = academicgradeId;
    }

    public Academicgrade(Integer academicgradeId, String academicgradeName) {
        this.academicgradeId = academicgradeId;
        this.academicgradeName = academicgradeName;
    }

    public Integer getAcademicgradeId() {
        return academicgradeId;
    }

    public void setAcademicgradeId(Integer academicgradeId) {
        this.academicgradeId = academicgradeId;
    }

    public String getAcademicgradeName() {
        return academicgradeName;
    }

    public void setAcademicgradeName(String academicgradeName) {
        this.academicgradeName = academicgradeName;
    }

    public Collection<Academicgradeinstance> getAcademicgradeinstanceCollection() {
        return academicgradeinstanceCollection;
    }

    public void setAcademicgradeinstanceCollection(Collection<Academicgradeinstance> academicgradeinstanceCollection) {
        this.academicgradeinstanceCollection = academicgradeinstanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (academicgradeId != null ? academicgradeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Academicgrade)) {
            return false;
        }
        Academicgrade other = (Academicgrade) object;
        if ((this.academicgradeId == null && other.academicgradeId != null) || (this.academicgradeId != null && !this.academicgradeId.equals(other.academicgradeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Academicgrade[ academicgradeId=" + academicgradeId + " ]";
    }
    
}
