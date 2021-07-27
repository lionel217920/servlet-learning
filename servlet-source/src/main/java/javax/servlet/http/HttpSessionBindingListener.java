package javax.servlet.http;

import java.util.EventListener;

public interface HttpSessionBindingListener extends EventListener {
  void valueBound(HttpSessionBindingEvent paramHttpSessionBindingEvent);
  
  void valueUnbound(HttpSessionBindingEvent paramHttpSessionBindingEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpSessionBindingListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */