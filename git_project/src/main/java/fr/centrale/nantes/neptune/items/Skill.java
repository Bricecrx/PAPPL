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
@Table(name = "skill")
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
    @NamedQuery(name = "Skill.findBySkillId", query = "SELECT s FROM Skill s WHERE s.skillId = :skillId"),
    @NamedQuery(name = "Skill.findBySkillName", query = "SELECT s FROM Skill s WHERE s.skillName = :skillName"),
    @NamedQuery(name = "Skill.findBySkillDescriptionskillDescription", query = "SELECT s FROM Skill s WHERE s.skillDescriptionskillDescription = :skillDescriptionskillDescription"),
    @NamedQuery(name = "Skill.findBySkillActive", query = "SELECT s FROM Skill s WHERE s.skillActive = :skillActive")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skill_id")
    private Integer skillId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "skill_name")
    private String skillName;
    @Size(max = 2147483647)
    @Column(name = "skill_descriptionskill_description")
    private String skillDescriptionskillDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "skill_active")
    private boolean skillActive;
    @JoinColumn(name = "skillreferential_id", referencedColumnName = "skillreferential_id")
    @ManyToOne(optional = false)
    private Skillreferential skillreferentialId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private Collection<Component> componentCollection;

    public Skill() {
    }

    public Skill(Integer skillId) {
        this.skillId = skillId;
    }

    public Skill(Integer skillId, String skillName, boolean skillActive) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillActive = skillActive;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescriptionskillDescription() {
        return skillDescriptionskillDescription;
    }

    public void setSkillDescriptionskillDescription(String skillDescriptionskillDescription) {
        this.skillDescriptionskillDescription = skillDescriptionskillDescription;
    }

    public boolean getSkillActive() {
        return skillActive;
    }

    public void setSkillActive(boolean skillActive) {
        this.skillActive = skillActive;
    }

    public Skillreferential getSkillreferentialId() {
        return skillreferentialId;
    }

    public void setSkillreferentialId(Skillreferential skillreferentialId) {
        this.skillreferentialId = skillreferentialId;
    }

    public Collection<Component> getComponentCollection() {
        return componentCollection;
    }

    public void setComponentCollection(Collection<Component> componentCollection) {
        this.componentCollection = componentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Skill[ skillId=" + skillId + " ]";
    }
    
}
