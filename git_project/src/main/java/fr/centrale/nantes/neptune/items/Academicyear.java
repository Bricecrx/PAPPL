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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "academicyear")
@NamedQueries({
    @NamedQuery(name = "Academicyear.findAll", query = "SELECT a FROM Academicyear a"),
    @NamedQuery(name = "Academicyear.findByAcademicyearId", query = "SELECT a FROM Academicyear a WHERE a.academicyearId = :academicyearId"),
    @NamedQuery(name = "Academicyear.findByAcademicyearTitle", query = "SELECT a FROM Academicyear a WHERE a.academicyearTitle = :academicyearTitle"),
    @NamedQuery(name = "Academicyear.findByAcademicyearYear", query = "SELECT a FROM Academicyear a WHERE a.academicyearYear = :academicyearYear"),
    @NamedQuery(name = "Academicyear.findByAcademicyearStart", query = "SELECT a FROM Academicyear a WHERE a.academicyearStart = :academicyearStart"),
    @NamedQuery(name = "Academicyear.findByAcademicyearEnd", query = "SELECT a FROM Academicyear a WHERE a.academicyearEnd = :academicyearEnd")})
public class Academicyear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "academicyear_id")
    private Integer academicyearId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "academicyear_title")
    private String academicyearTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "academicyear_year")
    private int academicyearYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "academicyear_start")
    @Temporal(TemporalType.DATE)
    private Date academicyearStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "academicyear_end")
    @Temporal(TemporalType.DATE)
    private Date academicyearEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academicyearId")
    private Collection<Program> programCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academicyearId")
    private Collection<Academicgradeinstance> academicgradeinstanceCollection;

    public Academicyear() {
    }

    public Academicyear(Integer academicyearId) {
        this.academicyearId = academicyearId;
    }

    public Academicyear(Integer academicyearId, String academicyearTitle, int academicyearYear, Date academicyearStart, Date academicyearEnd) {
        this.academicyearId = academicyearId;
        this.academicyearTitle = academicyearTitle;
        this.academicyearYear = academicyearYear;
        this.academicyearStart = academicyearStart;
        this.academicyearEnd = academicyearEnd;
    }

    public Integer getAcademicyearId() {
        return academicyearId;
    }

    public void setAcademicyearId(Integer academicyearId) {
        this.academicyearId = academicyearId;
    }

    public String getAcademicyearTitle() {
        return academicyearTitle;
    }

    public void setAcademicyearTitle(String academicyearTitle) {
        this.academicyearTitle = academicyearTitle;
    }

    public int getAcademicyearYear() {
        return academicyearYear;
    }

    public void setAcademicyearYear(int academicyearYear) {
        this.academicyearYear = academicyearYear;
    }

    public Date getAcademicyearStart() {
        return academicyearStart;
    }

    public void setAcademicyearStart(Date academicyearStart) {
        this.academicyearStart = academicyearStart;
    }

    public Date getAcademicyearEnd() {
        return academicyearEnd;
    }

    public void setAcademicyearEnd(Date academicyearEnd) {
        this.academicyearEnd = academicyearEnd;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Collection<Academicgradeinstance> getAcademicgradeinstanceCollection() {
        return academicgradeinstanceCollection;
    }

    public void setAcademicgradeinstanceCollection(Collection<Academicgradeinstance> academicgradeinstanceCollection) {
        this.academicgradeinstanceCollection = academicgradeinstanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (academicyearId != null ? academicyearId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Academicyear)) {
            return false;
        }
        Academicyear other = (Academicyear) object;
        if ((this.academicyearId == null && other.academicyearId != null) || (this.academicyearId != null && !this.academicyearId.equals(other.academicyearId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Academicyear[ academicyearId=" + academicyearId + " ]";
    }
    
}
