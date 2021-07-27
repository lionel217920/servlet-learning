package javax.servlet;

import java.util.EventListener;

public interface ServletRequestAttributeListener extends EventListener {
  void attributeAdded(ServletRequestAttributeEvent paramServletRequestAttributeEvent);
  
  void attributeRemoved(ServletRequestAttributeEvent paramServletRequestAttributeEvent);
  
  void attributeReplaced(ServletRequestAttributeEvent paramServletRequestAttributeEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletRequestAttributeListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */