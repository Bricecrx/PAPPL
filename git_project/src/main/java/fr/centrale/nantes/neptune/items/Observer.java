/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "observer")
@NamedQueries({
    @NamedQuery(name = "Observer.findAll", query = "SELECT o FROM Observer o"),
    @NamedQuery(name = "Observer.findByPersonId", query = "SELECT o FROM Observer o WHERE o.observerPK.personId = :personId"),
    @NamedQuery(name = "Observer.findByObservatoinpointId", query = "SELECT o FROM Observer o WHERE o.observerPK.observatoinpointId = :observatoinpointId")})
public class Observer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObserverPK observerPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observer")
    private Collection<Observedcondition> observedconditionCollection;
    @JoinColumn(name = "observatoinpoint_id", referencedColumnName = "observatoinpoint_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Observatoinpoint observatoinpoint;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public Observer() {
    }

    public Observer(ObserverPK observerPK) {
        this.observerPK = observerPK;
    }

    public Observer(int personId, int observatoinpointId) {
        this.observerPK = new ObserverPK(personId, observatoinpointId);
    }

    public ObserverPK getObserverPK() {
        return observerPK;
    }

    public void setObserverPK(ObserverPK observerPK) {
        this.observerPK = observerPK;
    }

    public Collection<Observedcondition> getObservedconditionCollection() {
        return observedconditionCollection;
    }

    public void setObservedconditionCollection(Collection<Observedcondition> observedconditionCollection) {
        this.observedconditionCollection = observedconditionCollection;
    }

    public Observatoinpoint getObservatoinpoint() {
        return observatoinpoint;
    }

    public void setObservatoinpoint(Observatoinpoint observatoinpoint) {
        this.observatoinpoint = observatoinpoint;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observerPK != null ? observerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observer)) {
            return false;
        }
        Observer other = (Observer) object;
        if ((this.observerPK == null && other.observerPK != null) || (this.observerPK != null && !this.observerPK.equals(other.observerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Observer[ observerPK=" + observerPK + " ]";
    }
    
}
