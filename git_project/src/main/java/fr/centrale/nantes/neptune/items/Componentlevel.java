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
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "componentlevel")
@NamedQueries({
    @NamedQuery(name = "Componentlevel.findAll", query = "SELECT c FROM Componentlevel c"),
    @NamedQuery(name = "Componentlevel.findByComponentlevelId", query = "SELECT c FROM Componentlevel c WHERE c.componentlevelId = :componentlevelId"),
    @NamedQuery(name = "Componentlevel.findByComponentlevelDescription", query = "SELECT c FROM Componentlevel c WHERE c.componentlevelDescription = :componentlevelDescription")})
public class Componentlevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "componentlevel_id")
    private Integer componentlevelId;
    @Size(max = 2147483647)
    @Column(name = "componentlevel_description")
    private String componentlevelDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentlevelId")
    private Collection<Observationtype> observationtypeCollection;
    @JoinColumn(name = "component_id", referencedColumnName = "component_id")
    @ManyToOne(optional = false)
    private Component componentId;
    @JoinColumn(name = "level_id", referencedColumnName = "level_id")
    @ManyToOne(optional = false)
    private Level levelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentlevelId")
    private Collection<Studentskilllevelobserv> studentskilllevelobservCollection;

    public Componentlevel() {
    }

    public Componentlevel(Integer componentlevelId) {
        this.componentlevelId = componentlevelId;
    }

    public Integer getComponentlevelId() {
        return componentlevelId;
    }

    public void setComponentlevelId(Integer componentlevelId) {
        this.componentlevelId = componentlevelId;
    }

    public String getComponentlevelDescription() {
        return componentlevelDescription;
    }

    public void setComponentlevelDescription(String componentlevelDescription) {
        this.componentlevelDescription = componentlevelDescription;
    }

    public Collection<Observationtype> getObservationtypeCollection() {
        return observationtypeCollection;
    }

    public void setObservationtypeCollection(Collection<Observationtype> observationtypeCollection) {
        this.observationtypeCollection = observationtypeCollection;
    }

    public Component getComponentId() {
        return componentId;
    }

    public void setComponentId(Component componentId) {
        this.componentId = componentId;
    }

    public Level getLevelId() {
        return levelId;
    }

    public void setLevelId(Level levelId) {
        this.levelId = levelId;
    }

    public Collection<Studentskilllevelobserv> getStudentskilllevelobservCollection() {
        return studentskilllevelobservCollection;
    }

    public void setStudentskilllevelobservCollection(Collection<Studentskilllevelobserv> studentskilllevelobservCollection) {
        this.studentskilllevelobservCollection = studentskilllevelobservCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentlevelId != null ? componentlevelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componentlevel)) {
            return false;
        }
        Componentlevel other = (Componentlevel) object;
        if ((this.componentlevelId == null && other.componentlevelId != null) || (this.componentlevelId != null && !this.componentlevelId.equals(other.componentlevelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Componentlevel[ componentlevelId=" + componentlevelId + " ]";
    }
    
}
