package javax.servlet;

import java.util.Enumeration;

public interface FilterConfig {
  String getFilterName();
  
  ServletContext getServletContext();
  
  String getInitParameter(String paramString);
  
  Enumeration<String> getInitParameterNames();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/FilterConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */