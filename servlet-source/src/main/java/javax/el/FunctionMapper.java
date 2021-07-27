package javax.el;

import java.lang.reflect.Method;

public abstract class FunctionMapper {
  public abstract Method resolveFunction(String paramString1, String paramString2);
  
  public void mapFunction(String prefix, String localName, Method meth) {}
}


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/FunctionMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */