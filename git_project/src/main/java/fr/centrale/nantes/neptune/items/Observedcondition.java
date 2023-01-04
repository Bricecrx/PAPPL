/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "observedcondition")
@NamedQueries({
    @NamedQuery(name = "Observedcondition.findAll", query = "SELECT o FROM Observedcondition o"),
    @NamedQuery(name = "Observedcondition.findByObservationtypeconditionId", query = "SELECT o FROM Observedcondition o WHERE o.observedconditionPK.observationtypeconditionId = :observationtypeconditionId"),
    @NamedQuery(name = "Observedcondition.findByStudentregistrationId", query = "SELECT o FROM Observedcondition o WHERE o.observedconditionPK.studentregistrationId = :studentregistrationId")})
public class Observedcondition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservedconditionPK observedconditionPK;
    @JoinColumn(name = "observationtypecondition_id", referencedColumnName = "observationtypecondition_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Observationtypecondition observationtypecondition;
    @JoinColumns({
        @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
        @JoinColumn(name = "observatoinpoint_id", referencedColumnName = "observatoinpoint_id")})
    @ManyToOne(optional = false)
    private Observer observer;
    @JoinColumn(name = "studentregistration_id", referencedColumnName = "studentregistration_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studentregistration studentregistration;

    public Observedcondition() {
    }

    public Observedcondition(ObservedconditionPK observedconditionPK) {
        this.observedconditionPK = observedconditionPK;
    }

    public Observedcondition(int observationtypeconditionId, int studentregistrationId) {
        this.observedconditionPK = new ObservedconditionPK(observationtypeconditionId, studentregistrationId);
    }

    public ObservedconditionPK getObservedconditionPK() {
        return observedconditionPK;
    }

    public void setObservedconditionPK(ObservedconditionPK observedconditionPK) {
        this.observedconditionPK = observedconditionPK;
    }

    public Observationtypecondition getObservationtypecondition() {
        return observationtypecondition;
    }

    public void setObservationtypecondition(Observationtypecondition observationtypecondition) {
        this.observationtypecondition = observationtypecondition;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public Studentregistration getStudentregistration() {
        return studentregistration;
    }

    public void setStudentregistration(Studentregistration studentregistration) {
        this.studentregistration = studentregistration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observedconditionPK != null ? observedconditionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observedcondition)) {
            return false;
        }
        Observedcondition other = (Observedcondition) object;
        if ((this.observedconditionPK == null && other.observedconditionPK != null) || (this.observedconditionPK != null && !this.observedconditionPK.equals(other.observedconditionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Observedcondition[ observedconditionPK=" + observedconditionPK + " ]";
    }
    
}
