package javax.servlet;

import java.util.EventListener;

public interface ServletContextAttributeListener extends EventListener {
  void attributeAdded(ServletContextAttributeEvent paramServletContextAttributeEvent);
  
  void attributeRemoved(ServletContextAttributeEvent paramServletContextAttributeEvent);
  
  void attributeReplaced(ServletContextAttributeEvent paramServletContextAttributeEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletContextAttributeListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */