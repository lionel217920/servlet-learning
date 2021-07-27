package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public interface Tag extends JspTag {
  public static final int SKIP_BODY = 0;
  
  public static final int EVAL_BODY_INCLUDE = 1;
  
  public static final int SKIP_PAGE = 5;
  
  public static final int EVAL_PAGE = 6;
  
  void setPageContext(PageContext paramPageContext);
  
  void setParent(Tag paramTag);
  
  Tag getParent();
  
  int doStartTag() throws JspException;
  
  int doEndTag() throws JspException;
  
  void release();
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/Tag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */