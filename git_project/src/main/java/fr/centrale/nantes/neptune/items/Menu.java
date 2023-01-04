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
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuId", query = "SELECT m FROM Menu m WHERE m.menuId = :menuId"),
    @NamedQuery(name = "Menu.findByMenuTitle", query = "SELECT m FROM Menu m WHERE m.menuTitle = :menuTitle"),
    @NamedQuery(name = "Menu.findByMenuCode", query = "SELECT m FROM Menu m WHERE m.menuCode = :menuCode")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "menu_title")
    private String menuTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "menu_code")
    private String menuCode;
    @JoinTable(name = "menurole", joinColumns = {
        @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany
    private Collection<Role> roleCollection;
    @OneToMany(mappedBy = "menuParentId")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "menu_parent_id", referencedColumnName = "menu_id")
    @ManyToOne
    private Menu menuParentId;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu(Integer menuId, String menuTitle, String menuCode) {
        this.menuId = menuId;
        this.menuTitle = menuTitle;
        this.menuCode = menuCode;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Menu getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Menu menuParentId) {
        this.menuParentId = menuParentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Menu[ menuId=" + menuId + " ]";
    }
    
}
