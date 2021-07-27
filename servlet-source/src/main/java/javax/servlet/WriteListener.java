package javax.servlet;

import java.io.IOException;
import java.util.EventListener;

public interface WriteListener extends EventListener {
  void onWritePossible() throws IOException;
  
  void onError(Throwable paramThrowable);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/WriteListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */