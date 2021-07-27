/*    */ package javax.servlet;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServletRequestEvent
/*    */   extends EventObject
/*    */ {
/*    */   private static final long serialVersionUID = -7467864054698729101L;
/*    */   private final transient ServletRequest request;
/*    */   
/*    */   public ServletRequestEvent(ServletContext sc, ServletRequest request) {
/* 80 */     super(sc);
/* 81 */     this.request = request;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServletRequest getServletRequest() {
/* 88 */     return this.request;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServletContext getServletContext() {
/* 95 */     return (ServletContext)getSource();
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletRequestEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */