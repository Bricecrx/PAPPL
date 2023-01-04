/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.repositories;

import fr.centrale.nantes.neptune.items.*;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class ConnectRepositoryCustomImpl implements ConnectRepositoryCustom {

    private static final long DELTA = 30 * 60 * 1000L;

    @Autowired
    @Lazy
    private ConnectRepository repository;

    /**
     * Create pseudo-random code
     *
     * @param login
     * @param now
     * @return
     */
    private static String createCode(String login, Date now) {
        StringBuilder newCode = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

        for (int i = 0; i < 5; i++) {
            char c = (char) ('A' + (int) (Math.random() * 26));
            newCode.append(c);
        }
        newCode.append(login.toUpperCase().charAt(0));
        newCode.append(sdf.format(now));
        for (int i = 0; i < 3; i++) {
            char c = (char) ('A' + (int) (Math.random() * 26));
            newCode.append(c);
        }
        return newCode.toString();
    }

    @Override
    public Connect create(Person person, String Ip) {
        if ((person != null) && (Ip != null)) {
            Calendar aCalendar = Calendar.getInstance();
            Date now = aCalendar.getTime();
            Date expire = aCalendar.getTime();
            expire.setTime(now.getTime() + DELTA);

            String connexionId = createCode(person.getPersonLogin(), now);
            Connect item = new Connect();
            item.setConnectCode(connexionId);
            item.setConnectExpire(expire);
            item.setPersonId(person);
            item.setConnectIp(Ip);
            repository.saveAndFlush(item);

            Optional<Connect> result = repository.findById(item.getConnectCode());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(Connect item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Connect getByConnectCode(String connexionCode) {
        Optional<Connect> result = repository.findById(connexionCode);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void removeOld() {
        Calendar aCalendar = Calendar.getInstance();
        Date now = aCalendar.getTime();

        Collection<Connect> oldConnections = repository.findAllExpireBefore(now);
    }
    
    @Override
    public void expand(Connect item) {
        if (item != null) {
            Calendar aCalendar = Calendar.getInstance();
            Date now = aCalendar.getTime();
            Date expire = aCalendar.getTime();
            expire.setTime(now.getTime() + DELTA);
            
            item.setConnectExpire(expire);
            repository.saveAndFlush(item);
        }
    }
}
