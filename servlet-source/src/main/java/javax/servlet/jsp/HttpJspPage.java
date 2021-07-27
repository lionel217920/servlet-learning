package javax.servlet.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpJspPage extends JspPage {
  void _jspService(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/HttpJspPage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */