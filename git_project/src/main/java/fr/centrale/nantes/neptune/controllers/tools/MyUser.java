/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers.tools;

/**
 *
 * @author ECN
 */
public class MyUser {
    private String login;
    private String password;

    public MyUser() {
        this.login = null;
        this.password = null;
    }

    public MyUser(String user, String passwd) {
        this.login = user;
        this.password = passwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
