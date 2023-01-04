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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "action")
@NamedQueries({
    @NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a"),
    @NamedQuery(name = "Action.findByActionId", query = "SELECT a FROM Action a WHERE a.actionId = :actionId"),
    @NamedQuery(name = "Action.findByActionCode", query = "SELECT a FROM Action a WHERE a.actionCode = :actionCode")})
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "action_id")
    private Integer actionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "action_code")
    private String actionCode;
    @JoinTable(name = "actionrole", joinColumns = {
        @JoinColumn(name = "action_id", referencedColumnName = "action_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany
    private Collection<Role> roleCollection;

    public Action() {
    }

    public Action(Integer actionId) {
        this.actionId = actionId;
    }

    public Action(Integer actionId, String actionCode) {
        this.actionId = actionId;
        this.actionCode = actionCode;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionId != null ? actionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Action)) {
            return false;
        }
        Action other = (Action) object;
        if ((this.actionId == null && other.actionId != null) || (this.actionId != null && !this.actionId.equals(other.actionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Action[ actionId=" + actionId + " ]";
    }
    
}
