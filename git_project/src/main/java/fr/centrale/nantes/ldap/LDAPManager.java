/* --------------------------------------------------------------------------------
 * Astrolab General Tools
 * 
 * Ecole Centrale Nantes - Septembre 2015
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin, Q Roques
 * -------------------------------------------------------------------------------- */
package fr.centrale.nantes.ldap;

import java.net.DatagramSocket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Manage LDAP communication
 *
 * @author kwyhr
 */
public class LDAPManager {

    private static String ldapBasedn;
    private static String ldapHost;
    private static String ldapsecurityprotocol;
    private static boolean ldapAvailable;
    private static int connexionPort;

    /**
     *
     * @param serverName
     * @param serverDN
     * @param serverProtocol
     */
    public static void init(String serverName, String serverDN, String serverProtocol) {
        ldapHost = serverName;
        ldapBasedn = serverDN;
        ldapsecurityprotocol = serverProtocol;
        connexionPort = -1;
        ldapAvailable = false;
        if ((serverName != null) && (serverDN != null) && (serverProtocol != null)
                && (!serverName.isEmpty()) && (!serverDN.isEmpty())) {
            checkConnexion();
        }
    }

    /**
     * Check if datagram can connect to the server on the specific port
     *
     * @param socket
     * @param server
     * @param port
     */
    private static void checkDatagram(DatagramSocket socket, InetAddress server, int port) {
        connexionPort = -1;
        try {
            connexionPort = port;
            socket.connect(server, connexionPort);
            ldapAvailable = true;
            socket.disconnect();
        } catch (IllegalArgumentException | SecurityException ex) {
            connexionPort = -1;
        }
    }

    /**
     * Check if we can connect to the LDAP server
     */
    private static void checkConnexion() {
        if (!ldapAvailable) {
            // No successful connection
            try {
                InetAddress server = InetAddress.getByName(ldapHost);
                DatagramSocket socket = new DatagramSocket();
                connexionPort = -1;
                if (connexionPort == -1) {
                    checkDatagram(socket, server, 389);
                }
                if (connexionPort == -1) {
                    checkDatagram(socket, server, 636);
                }
                socket.close();
                if (connexionPort > 0) {
                    ldapAvailable = true;
                }
            } catch (UnknownHostException | SocketException ex) {
            }
        } else {
            // Already connected once
            try {
                InetAddress server = InetAddress.getByName(ldapHost);
                DatagramSocket socket = new DatagramSocket();
                checkDatagram(socket, server, connexionPort);
                socket.close();
                if (connexionPort == -1) {
                    ldapAvailable = false;
                }
            } catch (UnknownHostException | SocketException ex) {
            }
        }
    }

    /**
     *
     */
    public LDAPManager() {

    }

    /**
     * Build LDAP properties for a BIND
     *
     * @return
     */
    private Properties getLDAPProperties() {
        Properties env = new Properties();
        // Add server
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapHost);
        if (ldapsecurityprotocol.equals("ssl")) {
            // Add SSL encription
            env.put(Context.SECURITY_PROTOCOL, "ssl");
            // Use locally defined socked manager to avoid certificate validation
            env.put("java.naming.ldap.factory.socket", "org.centrale.ldap.MySSLSocketFactory");
        }

        return env;
    }

    /**
     * Build LDAP properties for a BIND
     *
     * @param field
     * @param fieldContent
     * @param password
     * @return
     */
    private Properties getLDAPProperties(String field, String fieldContent, String password) {
        Properties env = getLDAPProperties();

        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, field + "=" + fieldContent + "," + ldapBasedn);
        env.put(Context.SECURITY_CREDENTIALS, password);

        return env;
    }

    /**
     * Build LDAP properties for a BIND
     *
     * @param login
     * @param password
     * @return
     */
    private Properties getLDAPProperties(String login, String password) {
        return getLDAPProperties("uid", login, password);
    }

    /**
     * Identify with a LDAP BIND
     *
     * @param login
     * @param password
     * @return
     */
    public boolean identifyLDAP(String login, String password) {
        boolean isIdentified = false;
        if (ldapAvailable) {
            try {
                Properties env = getLDAPProperties(login, password);
                if (login != null && password != null) {
                    DirContext ctx = new InitialDirContext(env);
                    isIdentified = true;
                    ctx.close();

                }
            } catch (AuthenticationException ex) {
                // Non reconnu
            } catch (CommunicationException ex) {
                if (ldapAvailable) {
                    Logger.getLogger(LDAPManager.class
                            .getName()).log(Level.SEVERE, null, ex);
                } else {
                    ldapAvailable = false;
                }
            } catch (NamingException ex) {
                // Non reconnu
            }
        }

        return isIdentified;
    }
}
