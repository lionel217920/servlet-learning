package javax.servlet;

import java.io.IOException;

public interface Filter {
  void init(FilterConfig paramFilterConfig) throws ServletException;
  
  void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain) throws IOException, ServletException;
  
  void destroy();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/Filter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */