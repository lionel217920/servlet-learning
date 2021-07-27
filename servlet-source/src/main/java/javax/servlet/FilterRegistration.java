package javax.servlet;

import java.util.Collection;
import java.util.EnumSet;

public interface FilterRegistration extends Registration {
  void addMappingForServletNames(EnumSet<DispatcherType> paramEnumSet, boolean paramBoolean, String... paramVarArgs);
  
  Collection<String> getServletNameMappings();
  
  void addMappingForUrlPatterns(EnumSet<DispatcherType> paramEnumSet, boolean paramBoolean, String... paramVarArgs);
  
  Collection<String> getUrlPatternMappings();
  
  public static interface Dynamic extends FilterRegistration, Registration.Dynamic {}
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/FilterRegistration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */