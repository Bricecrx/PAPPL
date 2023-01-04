/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author kwyhr
 */
public class ApplicationContextProvider implements ApplicationContextAware{

    private static ApplicationContext context;

    /**
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     *
     * @param ac
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }
}
