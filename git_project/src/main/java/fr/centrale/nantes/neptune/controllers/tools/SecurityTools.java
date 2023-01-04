/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers.tools;

import java.security.SecureRandom;
import javax.servlet.http.HttpServletRequest;
import fr.centrale.nantes.neptune.items.Connect;
import fr.centrale.nantes.neptune.items.Role;
import fr.centrale.nantes.neptune.repositories.ConnectRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author kwyhr
 */
public class SecurityTools {

    private static final String[] HEADERS_TO_TRY = {
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"};

    public static final int ADMINROLE = 1;
    public static final int TEACHERROLE = 2;
    public static final int STUDENTROLE = 3;
    public static final int STAFFROLE = 4;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = null;

    /**
     * Check connexion access did not expire
     *
     * @param repository
     * @param request
     * @param code
     * @return
     */
    public static Connect checkAccess(ConnectRepository repository, HttpServletRequest request, String code) {
        // Remove existing old connections
        repository.removeOld();

        // Check connection
        Connect item = repository.getByConnectCode(code);
        if (item != null) {
            String ip = getClientIpAddress(request);
            if (item.getConnectIp().equals(ip)) {
                // Connection with the same  code and the same IP
                repository.expand(item);
            } else {
                // IP changed while connected => refused
                item = null;
            }
        }
        return item;
    }

    /**
     * Check connexion access did not expire
     *
     * @param repository
     * @param request
     * @return
     */
    public static Connect checkAccess(ConnectRepository repository, HttpServletRequest request) {
        String code = request.getParameter("connexion");
        return checkAccess(repository, request, code);
    }

    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }

        return request.getRemoteAddr();
    }

    private static void checkEncryptionGenerator() {
        if (bCryptPasswordEncoder == null) {
            int strength = 10;
            bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        }
    }

    public static String encryptPassword(String plainPassword) {
        checkEncryptionGenerator();
        if (bCryptPasswordEncoder != null) {
            return bCryptPasswordEncoder.encode(plainPassword);
        }
        return null;
    }

    public static boolean checkPassword(String encodedPassword, String plainPassword) {
        checkEncryptionGenerator();
        if (bCryptPasswordEncoder != null) {
            return bCryptPasswordEncoder.matches(plainPassword, encodedPassword);
        }
        return false;
    }

    public static boolean hasRole(Connect connexion, int roleId) {
        if (connexion != null) {
            for (Role role : connexion.getPersonId().getRoleCollection()) {
                if (role.getRoleId() == roleId) {
                    return true;
                }
            }                
        }
        return false;
    }

}
