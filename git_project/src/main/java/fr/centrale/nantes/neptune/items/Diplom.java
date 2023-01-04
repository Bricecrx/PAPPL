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
@Table(name = "diplom")
@NamedQueries({
    @NamedQuery(name = "Diplom.findAll", query = "SELECT d FROM Diplom d"),
    @NamedQuery(name = "Diplom.findByDiplomId", query = "SELECT d FROM Diplom d WHERE d.diplomId = :diplomId"),
    @NamedQuery(name = "Diplom.findByDiplomName", query = "SELECT d FROM Diplom d WHERE d.diplomName = :diplomName"),
    @NamedQuery(name = "Diplom.findByDiplomActive", query = "SELECT d FROM Diplom d WHERE d.diplomActive = :diplomActive")})
public class Diplom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diplom_id")
    private Integer diplomId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "diplom_name")
    private String diplomName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diplom_active")
    private boolean diplomActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplomId")
    private Collection<Program> programCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplomId")
    private Collection<Skillreferential> skillreferentialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplom")
    private Collection<Studentskilllevel> studentskilllevelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplomId")
    private Collection<Studentregistration> studentregistrationCollection;

    public Diplom() {
    }

    public Diplom(Integer diplomId) {
        this.diplomId = diplomId;
    }

    public Diplom(Integer diplomId, String diplomName, boolean diplomActive) {
        this.diplomId = diplomId;
        this.diplomName = diplomName;
        this.diplomActive = diplomActive;
    }

    public Integer getDiplomId() {
        return diplomId;
    }

    public void setDiplomId(Integer diplomId) {
        this.diplomId = diplomId;
    }

    public String getDiplomName() {
        return diplomName;
    }

    public void setDiplomName(String diplomName) {
        this.diplomName = diplomName;
    }

    public boolean getDiplomActive() {
        return diplomActive;
    }

    public void setDiplomActive(boolean diplomActive) {
        this.diplomActive = diplomActive;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Collection<Skillreferential> getSkillreferentialCollection() {
        return skillreferentialCollection;
    }

    public void setSkillreferentialCollection(Collection<Skillreferential> skillreferentialCollection) {
        this.skillreferentialCollection = skillreferentialCollection;
    }

    public Collection<Studentskilllevel> getStudentskilllevelCollection() {
        return studentskilllevelCollection;
    }

    public void setStudentskilllevelCollection(Collection<Studentskilllevel> studentskilllevelCollection) {
        this.studentskilllevelCollection = studentskilllevelCollection;
    }

    public Collection<Studentregistration> getStudentregistrationCollection() {
        return studentregistrationCollection;
    }

    public void setStudentregistrationCollection(Collection<Studentregistration> studentregistrationCollection) {
        this.studentregistrationCollection = studentregistrationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diplomId != null ? diplomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diplom)) {
            return false;
        }
        Diplom other = (Diplom) object;
        if ((this.diplomId == null && other.diplomId != null) || (this.diplomId != null && !this.diplomId.equals(other.diplomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Diplom[ diplomId=" + diplomId + " ]";
    }
    
}
