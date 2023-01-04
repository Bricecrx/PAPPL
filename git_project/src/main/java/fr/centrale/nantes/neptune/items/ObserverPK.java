/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Embeddable
public class ObserverPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private int personId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "observatoinpoint_id")
    private int observatoinpointId;

    public ObserverPK() {
    }

    public ObserverPK(int personId, int observatoinpointId) {
        this.personId = personId;
        this.observatoinpointId = observatoinpointId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getObservatoinpointId() {
        return observatoinpointId;
    }

    public void setObservatoinpointId(int observatoinpointId) {
        this.observatoinpointId = observatoinpointId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personId;
        hash += (int) observatoinpointId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObserverPK)) {
            return false;
        }
        ObserverPK other = (ObserverPK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.observatoinpointId != other.observatoinpointId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.ObserverPK[ personId=" + personId + ", observatoinpointId=" + observatoinpointId + " ]";
    }
    
}
