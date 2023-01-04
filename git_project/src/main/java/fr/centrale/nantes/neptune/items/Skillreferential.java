/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "skillreferential")
@NamedQueries({
    @NamedQuery(name = "Skillreferential.findAll", query = "SELECT s FROM Skillreferential s"),
    @NamedQuery(name = "Skillreferential.findBySkillreferentialId", query = "SELECT s FROM Skillreferential s WHERE s.skillreferentialId = :skillreferentialId"),
    @NamedQuery(name = "Skillreferential.findBySkillreferentialActive", query = "SELECT s FROM Skillreferential s WHERE s.skillreferentialActive = :skillreferentialActive"),
    @NamedQuery(name = "Skillreferential.findBySkillreferentialRncpdate", query = "SELECT s FROM Skillreferential s WHERE s.skillreferentialRncpdate = :skillreferentialRncpdate")})
public class Skillreferential implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skillreferential_id")
    private Integer skillreferentialId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "skillreferential_active")
    private boolean skillreferentialActive;
    @Column(name = "skillreferential_rncpdate")
    @Temporal(TemporalType.DATE)
    private Date skillreferentialRncpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillreferentialId")
    private Collection<Skill> skillCollection;
    @JoinColumn(name = "diplom_id", referencedColumnName = "diplom_id")
    @ManyToOne(optional = false)
    private Diplom diplomId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillreferentialId")
    private Collection<Level> levelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillreferentialId")
    private Collection<Studentregistration> studentregistrationCollection;

    public Skillreferential() {
    }

    public Skillreferential(Integer skillreferentialId) {
        this.skillreferentialId = skillreferentialId;
    }

    public Skillreferential(Integer skillreferentialId, boolean skillreferentialActive) {
        this.skillreferentialId = skillreferentialId;
        this.skillreferentialActive = skillreferentialActive;
    }

    public Integer getSkillreferentialId() {
        return skillreferentialId;
    }

    public void setSkillreferentialId(Integer skillreferentialId) {
        this.skillreferentialId = skillreferentialId;
    }

    public boolean getSkillreferentialActive() {
        return skillreferentialActive;
    }

    public void setSkillreferentialActive(boolean skillreferentialActive) {
        this.skillreferentialActive = skillreferentialActive;
    }

    public Date getSkillreferentialRncpdate() {
        return skillreferentialRncpdate;
    }

    public void setSkillreferentialRncpdate(Date skillreferentialRncpdate) {
        this.skillreferentialRncpdate = skillreferentialRncpdate;
    }

    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    public Diplom getDiplomId() {
        return diplomId;
    }

    public void setDiplomId(Diplom diplomId) {
        this.diplomId = diplomId;
    }

    public Collection<Level> getLevelCollection() {
        return levelCollection;
    }

    public void setLevelCollection(Collection<Level> levelCollection) {
        this.levelCollection = levelCollection;
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
        hash += (skillreferentialId != null ? skillreferentialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skillreferential)) {
            return false;
        }
        Skillreferential other = (Skillreferential) object;
        if ((this.skillreferentialId == null && other.skillreferentialId != null) || (this.skillreferentialId != null && !this.skillreferentialId.equals(other.skillreferentialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Skillreferential[ skillreferentialId=" + skillreferentialId + " ]";
    }
    
}
