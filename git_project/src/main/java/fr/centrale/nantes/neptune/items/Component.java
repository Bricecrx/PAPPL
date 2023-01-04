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
@Table(name = "component")
@NamedQueries({
    @NamedQuery(name = "Component.findAll", query = "SELECT c FROM Component c"),
    @NamedQuery(name = "Component.findByComponentId", query = "SELECT c FROM Component c WHERE c.componentId = :componentId"),
    @NamedQuery(name = "Component.findByComponentName", query = "SELECT c FROM Component c WHERE c.componentName = :componentName"),
    @NamedQuery(name = "Component.findByComponentActive", query = "SELECT c FROM Component c WHERE c.componentActive = :componentActive")})
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "component_id")
    private Integer componentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "component_name")
    private String componentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "component_active")
    private boolean componentActive;
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
    @ManyToOne(optional = false)
    private Skill skillId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private Collection<Studentskilllevel> studentskilllevelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentId")
    private Collection<Componentlevel> componentlevelCollection;

    public Component() {
    }

    public Component(Integer componentId) {
        this.componentId = componentId;
    }

    public Component(Integer componentId, String componentName, boolean componentActive) {
        this.componentId = componentId;
        this.componentName = componentName;
        this.componentActive = componentActive;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public boolean getComponentActive() {
        return componentActive;
    }

    public void setComponentActive(boolean componentActive) {
        this.componentActive = componentActive;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
    }

    public Collection<Studentskilllevel> getStudentskilllevelCollection() {
        return studentskilllevelCollection;
    }

    public void setStudentskilllevelCollection(Collection<Studentskilllevel> studentskilllevelCollection) {
        this.studentskilllevelCollection = studentskilllevelCollection;
    }

    public Collection<Componentlevel> getComponentlevelCollection() {
        return componentlevelCollection;
    }

    public void setComponentlevelCollection(Collection<Componentlevel> componentlevelCollection) {
        this.componentlevelCollection = componentlevelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentId != null ? componentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component) object;
        if ((this.componentId == null && other.componentId != null) || (this.componentId != null && !this.componentId.equals(other.componentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Component[ componentId=" + componentId + " ]";
    }
    
}
