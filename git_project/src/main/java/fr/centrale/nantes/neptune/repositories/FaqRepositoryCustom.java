/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;

public interface FaqRepositoryCustom {

    /**
     * Create new Faq
     * @param faqQuestion
     * @param faqAnswer
     * @return Faq
     */
    public Faq create(String faqQuestion, String faqAnswer);

    /**
     * Remove Faq
     * @param item
     */
    public void remove(Faq item);

    /**
     * Get a Faq from its ID
     * @param faqId
     * @return Faq
     */
    public Faq getByFaqId(Integer faqId);

}
