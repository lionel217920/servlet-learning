package javax.servlet.descriptor;

import java.util.Collection;

public interface JspConfigDescriptor {
  Collection<TaglibDescriptor> getTaglibs();
  
  Collection<JspPropertyGroupDescriptor> getJspPropertyGroups();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/descriptor/JspConfigDescriptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */