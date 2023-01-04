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
@Table(name = "observationtype")
@NamedQueries({
    @NamedQuery(name = "Observationtype.findAll", query = "SELECT o FROM Observationtype o"),
    @NamedQuery(name = "Observationtype.findByObservationtypeId", query = "SELECT o FROM Observationtype o WHERE o.observationtypeId = :observationtypeId"),
    @NamedQuery(name = "Observationtype.findByObservationtypeInfo", query = "SELECT o FROM Observationtype o WHERE o.observationtypeInfo = :observationtypeInfo"),
    @NamedQuery(name = "Observationtype.findByObservationtypeWhen", query = "SELECT o FROM Observationtype o WHERE o.observationtypeWhen = :observationtypeWhen"),
    @NamedQuery(name = "Observationtype.findByObservationtypeHow", query = "SELECT o FROM Observationtype o WHERE o.observationtypeHow = :observationtypeHow")})
public class Observationtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "observationtype_id")
    private Integer observationtypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observationtype_info")
    private String observationtypeInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observationtype_when")
    private String observationtypeWhen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observationtype_how")
    private String observationtypeHow;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observationtypeId")
    private Collection<Observationtypecondition> observationtypeconditionCollection;
    @JoinColumn(name = "componentlevel_id", referencedColumnName = "componentlevel_id")
    @ManyToOne(optional = false)
    private Componentlevel componentlevelId;
    @JoinColumn(name = "observatoinpoint_id", referencedColumnName = "observatoinpoint_id")
    @ManyToOne(optional = false)
    private Observatoinpoint observatoinpointId;

    public Observationtype() {
    }

    public Observationtype(Integer observationtypeId) {
        this.observationtypeId = observationtypeId;
    }

    public Observationtype(Integer observationtypeId, String observationtypeInfo, String observationtypeWhen, String observationtypeHow) {
        this.observationtypeId = observationtypeId;
        this.observationtypeInfo = observationtypeInfo;
        this.observationtypeWhen = observationtypeWhen;
        this.observationtypeHow = observationtypeHow;
    }

    public Integer getObservationtypeId() {
        return observationtypeId;
    }

    public void setObservationtypeId(Integer observationtypeId) {
        this.observationtypeId = observationtypeId;
    }

    public String getObservationtypeInfo() {
        return observationtypeInfo;
    }

    public void setObservationtypeInfo(String observationtypeInfo) {
        this.observationtypeInfo = observationtypeInfo;
    }

    public String getObservationtypeWhen() {
        return observationtypeWhen;
    }

    public void setObservationtypeWhen(String observationtypeWhen) {
        this.observationtypeWhen = observationtypeWhen;
    }

    public String getObservationtypeHow() {
        return observationtypeHow;
    }

    public void setObservationtypeHow(String observationtypeHow) {
        this.observationtypeHow = observationtypeHow;
    }

    public Collection<Observationtypecondition> getObservationtypeconditionCollection() {
        return observationtypeconditionCollection;
    }

    public void setObservationtypeconditionCollection(Collection<Observationtypecondition> observationtypeconditionCollection) {
        this.observationtypeconditionCollection = observationtypeconditionCollection;
    }

    public Componentlevel getComponentlevelId() {
        return componentlevelId;
    }

    public void setComponentlevelId(Componentlevel componentlevelId) {
        this.componentlevelId = componentlevelId;
    }

    public Observatoinpoint getObservatoinpointId() {
        return observatoinpointId;
    }

    public void setObservatoinpointId(Observatoinpoint observatoinpointId) {
        this.observatoinpointId = observatoinpointId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observationtypeId != null ? observationtypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observationtype)) {
            return false;
        }
        Observationtype other = (Observationtype) object;
        if ((this.observationtypeId == null && other.observationtypeId != null) || (this.observationtypeId != null && !this.observationtypeId.equals(other.observationtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Observationtype[ observationtypeId=" + observationtypeId + " ]";
    }
    
}
