/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "studentskilllevelobserv")
@NamedQueries({
    @NamedQuery(name = "Studentskilllevelobserv.findAll", query = "SELECT s FROM Studentskilllevelobserv s"),
    @NamedQuery(name = "Studentskilllevelobserv.findByStudentskilllevelobservId", query = "SELECT s FROM Studentskilllevelobserv s WHERE s.studentskilllevelobservId = :studentskilllevelobservId"),
    @NamedQuery(name = "Studentskilllevelobserv.findByStudentskilllevelobservDate", query = "SELECT s FROM Studentskilllevelobserv s WHERE s.studentskilllevelobservDate = :studentskilllevelobservDate")})
public class Studentskilllevelobserv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentskilllevelobserv_id")
    private Integer studentskilllevelobservId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "studentskilllevelobserv_date")
    @Temporal(TemporalType.DATE)
    private Date studentskilllevelobservDate;
    @JoinColumn(name = "acquisitiongrade_id", referencedColumnName = "acquisitiongrade_id")
    @ManyToOne(optional = false)
    private Acquisitiongrade acquisitiongradeId;
    @JoinColumn(name = "componentlevel_id", referencedColumnName = "componentlevel_id")
    @ManyToOne(optional = false)
    private Componentlevel componentlevelId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "studentregistration_id", referencedColumnName = "studentregistration_id")
    @ManyToOne(optional = false)
    private Studentregistration studentregistrationId;

    public Studentskilllevelobserv() {
    }

    public Studentskilllevelobserv(Integer studentskilllevelobservId) {
        this.studentskilllevelobservId = studentskilllevelobservId;
    }

    public Studentskilllevelobserv(Integer studentskilllevelobservId, Date studentskilllevelobservDate) {
        this.studentskilllevelobservId = studentskilllevelobservId;
        this.studentskilllevelobservDate = studentskilllevelobservDate;
    }

    public Integer getStudentskilllevelobservId() {
        return studentskilllevelobservId;
    }

    public void setStudentskilllevelobservId(Integer studentskilllevelobservId) {
        this.studentskilllevelobservId = studentskilllevelobservId;
    }

    public Date getStudentskilllevelobservDate() {
        return studentskilllevelobservDate;
    }

    public void setStudentskilllevelobservDate(Date studentskilllevelobservDate) {
        this.studentskilllevelobservDate = studentskilllevelobservDate;
    }

    public Acquisitiongrade getAcquisitiongradeId() {
        return acquisitiongradeId;
    }

    public void setAcquisitiongradeId(Acquisitiongrade acquisitiongradeId) {
        this.acquisitiongradeId = acquisitiongradeId;
    }

    public Componentlevel getComponentlevelId() {
        return componentlevelId;
    }

    public void setComponentlevelId(Componentlevel componentlevelId) {
        this.componentlevelId = componentlevelId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Studentregistration getStudentregistrationId() {
        return studentregistrationId;
    }

    public void setStudentregistrationId(Studentregistration studentregistrationId) {
        this.studentregistrationId = studentregistrationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentskilllevelobservId != null ? studentskilllevelobservId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentskilllevelobserv)) {
            return false;
        }
        Studentskilllevelobserv other = (Studentskilllevelobserv) object;
        if ((this.studentskilllevelobservId == null && other.studentskilllevelobservId != null) || (this.studentskilllevelobservId != null && !this.studentskilllevelobservId.equals(other.studentskilllevelobservId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Studentskilllevelobserv[ studentskilllevelobservId=" + studentskilllevelobservId + " ]";
    }
    
}
