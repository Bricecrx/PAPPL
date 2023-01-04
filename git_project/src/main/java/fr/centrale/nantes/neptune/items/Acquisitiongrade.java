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
@Table(name = "acquisitiongrade")
@NamedQueries({
    @NamedQuery(name = "Acquisitiongrade.findAll", query = "SELECT a FROM Acquisitiongrade a"),
    @NamedQuery(name = "Acquisitiongrade.findByAcquisitiongradeId", query = "SELECT a FROM Acquisitiongrade a WHERE a.acquisitiongradeId = :acquisitiongradeId"),
    @NamedQuery(name = "Acquisitiongrade.findByAcquisitiongradeName", query = "SELECT a FROM Acquisitiongrade a WHERE a.acquisitiongradeName = :acquisitiongradeName"),
    @NamedQuery(name = "Acquisitiongrade.findByAcquisitiongradeLevel", query = "SELECT a FROM Acquisitiongrade a WHERE a.acquisitiongradeLevel = :acquisitiongradeLevel")})
public class Acquisitiongrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acquisitiongrade_id")
    private Integer acquisitiongradeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "acquisitiongrade_name")
    private String acquisitiongradeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acquisitiongrade_level")
    private int acquisitiongradeLevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acquisitiongradeId")
    private Collection<Observationtypecondition> observationtypeconditionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acquisitiongradeId")
    private Collection<Studentskilllevelobserv> studentskilllevelobservCollection;

    public Acquisitiongrade() {
    }

    public Acquisitiongrade(Integer acquisitiongradeId) {
        this.acquisitiongradeId = acquisitiongradeId;
    }

    public Acquisitiongrade(Integer acquisitiongradeId, String acquisitiongradeName, int acquisitiongradeLevel) {
        this.acquisitiongradeId = acquisitiongradeId;
        this.acquisitiongradeName = acquisitiongradeName;
        this.acquisitiongradeLevel = acquisitiongradeLevel;
    }

    public Integer getAcquisitiongradeId() {
        return acquisitiongradeId;
    }

    public void setAcquisitiongradeId(Integer acquisitiongradeId) {
        this.acquisitiongradeId = acquisitiongradeId;
    }

    public String getAcquisitiongradeName() {
        return acquisitiongradeName;
    }

    public void setAcquisitiongradeName(String acquisitiongradeName) {
        this.acquisitiongradeName = acquisitiongradeName;
    }

    public int getAcquisitiongradeLevel() {
        return acquisitiongradeLevel;
    }

    public void setAcquisitiongradeLevel(int acquisitiongradeLevel) {
        this.acquisitiongradeLevel = acquisitiongradeLevel;
    }

    public Collection<Observationtypecondition> getObservationtypeconditionCollection() {
        return observationtypeconditionCollection;
    }

    public void setObservationtypeconditionCollection(Collection<Observationtypecondition> observationtypeconditionCollection) {
        this.observationtypeconditionCollection = observationtypeconditionCollection;
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
        hash += (acquisitiongradeId != null ? acquisitiongradeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acquisitiongrade)) {
            return false;
        }
        Acquisitiongrade other = (Acquisitiongrade) object;
        if ((this.acquisitiongradeId == null && other.acquisitiongradeId != null) || (this.acquisitiongradeId != null && !this.acquisitiongradeId.equals(other.acquisitiongradeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Acquisitiongrade[ acquisitiongradeId=" + acquisitiongradeId + " ]";
    }
    
}
