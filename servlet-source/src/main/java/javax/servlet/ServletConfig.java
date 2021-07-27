package javax.servlet;

import java.util.Enumeration;

public interface ServletConfig {
  String getServletName();
  
  ServletContext getServletContext();
  
  String getInitParameter(String paramString);
  
  Enumeration<String> getInitParameterNames();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */