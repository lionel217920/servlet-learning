package javax.servlet;

import java.util.EventListener;

public interface ServletContextListener extends EventListener {
  void contextInitialized(ServletContextEvent paramServletContextEvent);
  
  void contextDestroyed(ServletContextEvent paramServletContextEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletContextListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */