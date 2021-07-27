/*    */ package javax.servlet.http;
/*    */ 
/*    */ import java.util.EventObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpSessionEvent
/*    */   extends EventObject
/*    */ {
/*    */   private static final long serialVersionUID = -7622791603672342895L;
/*    */   
/*    */   public HttpSessionEvent(HttpSession source) {
/* 75 */     super(source);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpSession getSession() {
/* 82 */     return (HttpSession)getSource();
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpSessionEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */