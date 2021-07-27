package javax.servlet;

import java.util.Set;

public interface ServletContainerInitializer {
  void onStartup(Set<Class<?>> paramSet, ServletContext paramServletContext) throws ServletException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletContainerInitializer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */