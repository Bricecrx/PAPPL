/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "studentskilllevel")
@NamedQueries({
    @NamedQuery(name = "Studentskilllevel.findAll", query = "SELECT s FROM Studentskilllevel s"),
    @NamedQuery(name = "Studentskilllevel.findByStudentId", query = "SELECT s FROM Studentskilllevel s WHERE s.studentskilllevelPK.studentId = :studentId"),
    @NamedQuery(name = "Studentskilllevel.findByDiplomId", query = "SELECT s FROM Studentskilllevel s WHERE s.studentskilllevelPK.diplomId = :diplomId"),
    @NamedQuery(name = "Studentskilllevel.findByComponentId", query = "SELECT s FROM Studentskilllevel s WHERE s.studentskilllevelPK.componentId = :componentId")})
public class Studentskilllevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentskilllevelPK studentskilllevelPK;
    @JoinColumn(name = "component_id", referencedColumnName = "component_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Component component;
    @JoinColumn(name = "diplom_id", referencedColumnName = "diplom_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diplom diplom;
    @JoinColumn(name = "level_id", referencedColumnName = "level_id")
    @ManyToOne(optional = false)
    private Level levelId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Studentskilllevel() {
    }

    public Studentskilllevel(StudentskilllevelPK studentskilllevelPK) {
        this.studentskilllevelPK = studentskilllevelPK;
    }

    public Studentskilllevel(int studentId, int diplomId, int componentId) {
        this.studentskilllevelPK = new StudentskilllevelPK(studentId, diplomId, componentId);
    }

    public StudentskilllevelPK getStudentskilllevelPK() {
        return studentskilllevelPK;
    }

    public void setStudentskilllevelPK(StudentskilllevelPK studentskilllevelPK) {
        this.studentskilllevelPK = studentskilllevelPK;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Diplom getDiplom() {
        return diplom;
    }

    public void setDiplom(Diplom diplom) {
        this.diplom = diplom;
    }

    public Level getLevelId() {
        return levelId;
    }

    public void setLevelId(Level levelId) {
        this.levelId = levelId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentskilllevelPK != null ? studentskilllevelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentskilllevel)) {
            return false;
        }
        Studentskilllevel other = (Studentskilllevel) object;
        if ((this.studentskilllevelPK == null && other.studentskilllevelPK != null) || (this.studentskilllevelPK != null && !this.studentskilllevelPK.equals(other.studentskilllevelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Studentskilllevel[ studentskilllevelPK=" + studentskilllevelPK + " ]";
    }
    
}
