package javax.servlet;

import java.io.IOException;

public interface FilterChain {
  void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse) throws IOException, ServletException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/FilterChain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */