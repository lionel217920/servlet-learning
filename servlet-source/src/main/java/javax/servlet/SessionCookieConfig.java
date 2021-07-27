package javax.servlet;

public interface SessionCookieConfig {
  void setName(String paramString);
  
  String getName();
  
  void setDomain(String paramString);
  
  String getDomain();
  
  void setPath(String paramString);
  
  String getPath();
  
  void setComment(String paramString);
  
  String getComment();
  
  void setHttpOnly(boolean paramBoolean);
  
  boolean isHttpOnly();
  
  void setSecure(boolean paramBoolean);
  
  boolean isSecure();
  
  void setMaxAge(int paramInt);
  
  int getMaxAge();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/SessionCookieConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */