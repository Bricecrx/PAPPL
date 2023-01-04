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
@Table(name = "level")
@NamedQueries({
    @NamedQuery(name = "Level.findAll", query = "SELECT l FROM Level l"),
    @NamedQuery(name = "Level.findByLevelId", query = "SELECT l FROM Level l WHERE l.levelId = :levelId"),
    @NamedQuery(name = "Level.findByLevelName", query = "SELECT l FROM Level l WHERE l.levelName = :levelName")})
public class Level implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "level_id")
    private Integer levelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "level_name")
    private String levelName;
    @JoinColumn(name = "skillreferential_id", referencedColumnName = "skillreferential_id")
    @ManyToOne(optional = false)
    private Skillreferential skillreferentialId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    private Collection<Studentskilllevel> studentskilllevelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    private Collection<Componentlevel> componentlevelCollection;

    public Level() {
    }

    public Level(Integer levelId) {
        this.levelId = levelId;
    }

    public Level(Integer levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Skillreferential getSkillreferentialId() {
        return skillreferentialId;
    }

    public void setSkillreferentialId(Skillreferential skillreferentialId) {
        this.skillreferentialId = skillreferentialId;
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
        hash += (levelId != null ? levelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.levelId == null && other.levelId != null) || (this.levelId != null && !this.levelId.equals(other.levelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Level[ levelId=" + levelId + " ]";
    }
    
}
