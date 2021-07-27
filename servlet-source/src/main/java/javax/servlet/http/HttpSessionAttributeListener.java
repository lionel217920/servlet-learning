package javax.servlet.http;

import java.util.EventListener;

public interface HttpSessionAttributeListener extends EventListener {
  void attributeAdded(HttpSessionBindingEvent paramHttpSessionBindingEvent);
  
  void attributeRemoved(HttpSessionBindingEvent paramHttpSessionBindingEvent);
  
  void attributeReplaced(HttpSessionBindingEvent paramHttpSessionBindingEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpSessionAttributeListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */