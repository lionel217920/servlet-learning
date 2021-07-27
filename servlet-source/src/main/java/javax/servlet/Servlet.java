package javax.servlet;

import java.io.IOException;

public interface Servlet {
  void init(ServletConfig paramServletConfig) throws ServletException;
  
  ServletConfig getServletConfig();
  
  void service(ServletRequest paramServletRequest, ServletResponse paramServletResponse) throws ServletException, IOException;
  
  String getServletInfo();
  
  void destroy();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/Servlet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */