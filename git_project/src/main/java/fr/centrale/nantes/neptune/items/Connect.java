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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "connect")
@NamedQueries({
    @NamedQuery(name = "Connect.findAll", query = "SELECT c FROM Connect c"),
    @NamedQuery(name = "Connect.findByConnectCode", query = "SELECT c FROM Connect c WHERE c.connectCode = :connectCode"),
    @NamedQuery(name = "Connect.findByConnectExpire", query = "SELECT c FROM Connect c WHERE c.connectExpire = :connectExpire"),
    @NamedQuery(name = "Connect.findByConnectIp", query = "SELECT c FROM Connect c WHERE c.connectIp = :connectIp")})
public class Connect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "connect_code")
    private String connectCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "connect_expire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date connectExpire;
    @Size(max = 32)
    @Column(name = "connect_ip")
    private String connectIp;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;

    public Connect() {
    }

    public Connect(String connectCode) {
        this.connectCode = connectCode;
    }

    public Connect(String connectCode, Date connectExpire) {
        this.connectCode = connectCode;
        this.connectExpire = connectExpire;
    }

    public String getConnectCode() {
        return connectCode;
    }

    public void setConnectCode(String connectCode) {
        this.connectCode = connectCode;
    }

    public Date getConnectExpire() {
        return connectExpire;
    }

    public void setConnectExpire(Date connectExpire) {
        this.connectExpire = connectExpire;
    }

    public String getConnectIp() {
        return connectIp;
    }

    public void setConnectIp(String connectIp) {
        this.connectIp = connectIp;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (connectCode != null ? connectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Connect)) {
            return false;
        }
        Connect other = (Connect) object;
        if ((this.connectCode == null && other.connectCode != null) || (this.connectCode != null && !this.connectCode.equals(other.connectCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Connect[ connectCode=" + connectCode + " ]";
    }
    
}
