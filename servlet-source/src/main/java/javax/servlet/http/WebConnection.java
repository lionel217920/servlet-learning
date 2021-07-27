package javax.servlet.http;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

public interface WebConnection extends AutoCloseable {
  ServletInputStream getInputStream() throws IOException;
  
  ServletOutputStream getOutputStream() throws IOException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/WebConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */