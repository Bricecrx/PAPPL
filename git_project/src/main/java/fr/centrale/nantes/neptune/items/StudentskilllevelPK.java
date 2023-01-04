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
public class StudentskilllevelPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diplom_id")
    private int diplomId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "component_id")
    private int componentId;

    public StudentskilllevelPK() {
    }

    public StudentskilllevelPK(int studentId, int diplomId, int componentId) {
        this.studentId = studentId;
        this.diplomId = diplomId;
        this.componentId = componentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getDiplomId() {
        return diplomId;
    }

    public void setDiplomId(int diplomId) {
        this.diplomId = diplomId;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) diplomId;
        hash += (int) componentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentskilllevelPK)) {
            return false;
        }
        StudentskilllevelPK other = (StudentskilllevelPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.diplomId != other.diplomId) {
            return false;
        }
        if (this.componentId != other.componentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.StudentskilllevelPK[ studentId=" + studentId + ", diplomId=" + diplomId + ", componentId=" + componentId + " ]";
    }
    
}
