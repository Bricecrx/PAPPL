/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Optional;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class FaqRepositoryCustomImpl implements FaqRepositoryCustom {

    @Autowired
    @Lazy
    private FaqRepository repository;

    @Override
    public Faq create(String faqQuestion, String faqAnswer) {
        if ((faqQuestion != null) && (faqAnswer != null)) {
            Faq item = new Faq();
            item.setFaqQuestion(faqQuestion);
            item.setFaqAnswer(faqAnswer);
            repository.saveAndFlush(item);

            Optional<Faq> result = repository.findById(item.getFaqId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Faq item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Faq getByFaqId(Integer faqId) {
        Optional<Faq> result = repository.findById(faqId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
