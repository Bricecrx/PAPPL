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
public class ObservedconditionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "observationtypecondition_id")
    private int observationtypeconditionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "studentregistration_id")
    private int studentregistrationId;

    public ObservedconditionPK() {
    }

    public ObservedconditionPK(int observationtypeconditionId, int studentregistrationId) {
        this.observationtypeconditionId = observationtypeconditionId;
        this.studentregistrationId = studentregistrationId;
    }

    public int getObservationtypeconditionId() {
        return observationtypeconditionId;
    }

    public void setObservationtypeconditionId(int observationtypeconditionId) {
        this.observationtypeconditionId = observationtypeconditionId;
    }

    public int getStudentregistrationId() {
        return studentregistrationId;
    }

    public void setStudentregistrationId(int studentregistrationId) {
        this.studentregistrationId = studentregistrationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) observationtypeconditionId;
        hash += (int) studentregistrationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservedconditionPK)) {
            return false;
        }
        ObservedconditionPK other = (ObservedconditionPK) object;
        if (this.observationtypeconditionId != other.observationtypeconditionId) {
            return false;
        }
        if (this.studentregistrationId != other.studentregistrationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.ObservedconditionPK[ observationtypeconditionId=" + observationtypeconditionId + ", studentregistrationId=" + studentregistrationId + " ]";
    }
    
}
