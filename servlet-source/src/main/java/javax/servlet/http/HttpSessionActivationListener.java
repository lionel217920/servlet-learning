package javax.servlet.http;

import java.util.EventListener;

public interface HttpSessionActivationListener extends EventListener {
  void sessionWillPassivate(HttpSessionEvent paramHttpSessionEvent);
  
  void sessionDidActivate(HttpSessionEvent paramHttpSessionEvent);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpSessionActivationListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */