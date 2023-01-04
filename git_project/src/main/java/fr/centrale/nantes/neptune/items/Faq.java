/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.items;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "faq")
@NamedQueries({
    @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f"),
    @NamedQuery(name = "Faq.findByFaqId", query = "SELECT f FROM Faq f WHERE f.faqId = :faqId"),
    @NamedQuery(name = "Faq.findByFaqQuestion", query = "SELECT f FROM Faq f WHERE f.faqQuestion = :faqQuestion"),
    @NamedQuery(name = "Faq.findByFaqAnswer", query = "SELECT f FROM Faq f WHERE f.faqAnswer = :faqAnswer")})
public class Faq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faq_id")
    private Integer faqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "faq_question")
    private String faqQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "faq_answer")
    private String faqAnswer;

    public Faq() {
    }

    public Faq(Integer faqId) {
        this.faqId = faqId;
    }

    public Faq(Integer faqId, String faqQuestion, String faqAnswer) {
        this.faqId = faqId;
        this.faqQuestion = faqQuestion;
        this.faqAnswer = faqAnswer;
    }

    public Integer getFaqId() {
        return faqId;
    }

    public void setFaqId(Integer faqId) {
        this.faqId = faqId;
    }

    public String getFaqQuestion() {
        return faqQuestion;
    }

    public void setFaqQuestion(String faqQuestion) {
        this.faqQuestion = faqQuestion;
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faqId != null ? faqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.faqId == null && other.faqId != null) || (this.faqId != null && !this.faqId.equals(other.faqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.nantes.neptune.items.Faq[ faqId=" + faqId + " ]";
    }
    
}
