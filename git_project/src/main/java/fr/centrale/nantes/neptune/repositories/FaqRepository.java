/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>, FaqRepositoryCustom {

    public Collection<Faq> findByFaqId(@Param("faqId")Integer faqId);

    public Collection<Faq> findByFaqQuestion(@Param("faqQuestion")String faqQuestion);

    public Collection<Faq> findByFaqAnswer(@Param("faqAnswer")String faqAnswer);

}
