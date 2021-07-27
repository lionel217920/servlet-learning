package javax.servlet.http;

import java.util.EventListener;

public interface HttpSessionIdListener extends EventListener {
  void sessionIdChanged(HttpSessionEvent paramHttpSessionEvent, String paramString);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpSessionIdListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */