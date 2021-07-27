package javax.servlet.http;

import java.util.Enumeration;

public interface HttpSessionContext {
  HttpSession getSession(String paramString);
  
  Enumeration<String> getIds();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpSessionContext.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */