package javax.servlet.jsp.jstl.sql;

import java.util.SortedMap;

public interface Result {
  SortedMap[] getRows();
  
  Object[][] getRowsByIndex();
  
  String[] getColumnNames();
  
  int getRowCount();
  
  boolean isLimitedByMaxRows();
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/sql/Result.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */