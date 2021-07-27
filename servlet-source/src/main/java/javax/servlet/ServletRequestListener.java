package javax.servlet;

import java.util.EventListener;

public interface ServletRequestListener extends EventListener {
  void requestDestroyed(ServletRequestEvent paramServletRequestEvent);
  
  void requestInitialized(ServletRequestEvent paramServletRequestEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletRequestListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */