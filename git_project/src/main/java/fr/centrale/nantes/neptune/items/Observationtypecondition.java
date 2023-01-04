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
@Table(name = "observationtypecondition")
@NamedQueries({
    @NamedQuery(name = "Observationtypecondition.findAll", query = "SELECT o FROM Observationtypecondition o"),
    @NamedQuery(name = "Observationtypecondition.findByObservationtypeconditionId", query = "SELECT o FROM Observationtypecondition o WHERE o.observationtypeconditionId = :observationtypeconditionId"),
    @NamedQuery(name = "Observationtypecondition.findByObservationtypeconditionValue", query = "SELECT o FROM Observationtypecondition o WHERE o.observationtypeconditionValue = :observationtypeconditionValue")})
public class Observationtypecondition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "observationtypecondition_id")
    private Integer observationtypeconditionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observationtypecondition_value")
    private String observationtypeconditionValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observationtypecondition")
    private Collection<Observedcondition> observedconditionCollection;
    @JoinColumn(name = "acquisitiongrade_id", referencedColumnName = "acquisitiongrade_id")
    @ManyToOne(optional = false)
    private Acquisitiongrade acquisitiongradeId;
    @JoinColumn(name = "observationtype_id", referencedColumnName = "observationtype_id")
    @ManyToOne(optional = false)
    private Observationtype observationtypeId;

    public Observationtypecondition() {
    }

    public Observationtypecondition(Integer observationtypeconditionId) {
        this.observationtypeconditionId = observationtypeconditionId;
    }

    public Observationtypecondition(Integer observationtypeconditionId, String observationtypeconditionValue) {
        this.observationtypeconditionId = observationtypeconditionId;
        this.observationtypeconditionValue = observationtypeconditionValue;
    }

    public Integer getObservationtypeconditionId() {
        return observationtypeconditionId;
    }

    public void setObservationtypeconditionId(Integer observationtypeconditionId) {
        this.observationtypeconditionId = observationtypeconditionId;
    }

    public String getObservationtypeconditionValue() {
        return observationtypeconditionValue;
    }

    public void setObservationtypeconditionValue(String observationtypeconditionValue) {
        this.observationtypeconditionValue = observationtypeconditionValue;
    }

    public Collection<Observedcondition> getObservedconditionCollection() {
        return observedconditionCollection;
    }

    public void setObservedconditionCollection(Collection<Observedcondition> observedconditionCollection) {
        this.observedconditionCollection = observedconditionCollection;
    }

    public Acquisitiongrade getAcquisitiongradeId() {
        return acquisitiongradeId;
    }

    public void setAcquisitiongradeId(Acquisitiongrade acquisitiongradeId) {
        this.acquisitiongradeId = acquisitiongradeId;
    }

    public Observationtype getObservationtypeId() {
        return observationtypeId;
    }

    public void setObservationtypeId(Observationtype observationtypeId) {
        this.observationtypeId = observationtypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observationtypeconditionId != null ? observationtypeconditionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observationtypecondition)) {
            return false;
        }
        Observationtypecondition other = (Observationtypecondition) object;
        if ((this.observationtypeconditionId == null && other.observationtypeconditionId != null) || (this.observationtypeconditionId != null && !this.observationtypeconditionId.equals(other.observationtypeconditionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Observationtypecondition[ observationtypeconditionId=" + observationtypeconditionId + " ]";
    }
    
}
