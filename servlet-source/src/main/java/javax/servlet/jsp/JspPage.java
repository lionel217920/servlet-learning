package javax.servlet.jsp;

import javax.servlet.Servlet;

public interface JspPage extends Servlet {
  void jspInit();
  
  void jspDestroy();
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/JspPage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */