/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.util.Optional;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class AcademicyearRepositoryCustomImpl implements AcademicyearRepositoryCustom {

    @Autowired
    @Lazy
    private AcademicyearRepository repository;

    @Override
    public Academicyear create(String academicyearTitle, int academicyearYear) {
        return create(academicyearTitle, academicyearYear, null, null);
    }

    @Override
    public Academicyear create(String academicyearTitle, int academicyearYear, Date academicyearStart, Date academicyearEnd) {
        if ((academicyearTitle != null)) {
            Calendar aCalendar = Calendar.getInstance();
            if (academicyearStart == null) {
                aCalendar.set(academicyearYear, 8, 1);    // 01/09/year
                academicyearStart = aCalendar.getTime();
            }
            if (academicyearEnd == null) {
                aCalendar.set(academicyearYear+1, 7, 31);    // 31/08/year+1
                academicyearEnd = aCalendar.getTime();
            }

            Academicyear item = new Academicyear();
            item.setAcademicyearTitle(academicyearTitle);
            item.setAcademicyearYear(academicyearYear);
            item.setAcademicyearStart(academicyearStart);
            item.setAcademicyearEnd(academicyearEnd);
            repository.saveAndFlush(item);

            Optional<Academicyear> result = repository.findById(item.getAcademicyearId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Academicyear item) {
        if (item != null) {
            repository.delete(item);
        }
    }

    @Override
    public Academicyear getByAcademicyearId(Integer academicyearId) {
        Optional<Academicyear> result = repository.findById(academicyearId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Academicyear getByAcademicyearYear(Integer year) {
        Collection<Academicyear> result = repository.findByAcademicyearYear(year);
        if ((result != null) && (result.size() == 1)) {
            return result.iterator().next();
        }
        return null;
    }

    @Override
    public Academicyear getCurrentAcademicyear() {
        Calendar aCalendar = Calendar.getInstance();
        Date now = aCalendar.getTime();

        Collection<Academicyear> result = repository.findAllPossible(now);
        if (result.size() == 1) {
            return result.iterator().next();
        }
        return null;
    }

}
