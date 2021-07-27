package javax.servlet;

import java.io.IOException;
import java.util.EventListener;

public interface ReadListener extends EventListener {
  void onDataAvailable() throws IOException;
  
  void onAllDataRead() throws IOException;
  
  void onError(Throwable paramThrowable);
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ReadListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */