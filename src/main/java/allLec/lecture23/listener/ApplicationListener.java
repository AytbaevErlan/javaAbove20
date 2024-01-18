package allLec.lecture23.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ApplicationListener implements ServletContextListener, HttpSessionAttributeListener {
    // --- ServletContextListener
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setSessionTimeout(300);
        System.out.println("servlet context is initialized");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet context is destroyed");
    }
    // --- ServletContextListener

    // --- HttpSessionAttributeListener
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("attribute %s was added".formatted(event.getName()));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("attribute %s was removed".formatted(event.getName()));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("attribute %s was replaced".formatted(event.getName()));
    }
    // --- HttpSessionAttributeListener
}
