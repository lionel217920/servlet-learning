package javax.servlet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlesTypes {
  Class<?>[] value();
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/annotation/HandlesTypes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */