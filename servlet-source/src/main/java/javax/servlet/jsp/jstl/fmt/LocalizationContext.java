/*    */ package javax.servlet.jsp.jstl.fmt;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import java.util.ResourceBundle;
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
/*    */ public class LocalizationContext
/*    */ {
/*    */   private final ResourceBundle bundle;
/*    */   private final Locale locale;
/*    */   
/*    */   public LocalizationContext() {
/* 49 */     this.bundle = null;
/* 50 */     this.locale = null;
/*    */   }
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
/*    */   public LocalizationContext(ResourceBundle bundle, Locale locale) {
/* 64 */     this.bundle = bundle;
/* 65 */     this.locale = locale;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LocalizationContext(ResourceBundle bundle) {
/* 77 */     this.bundle = bundle;
/* 78 */     this.locale = bundle.getLocale();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ResourceBundle getResourceBundle() {
/* 88 */     return this.bundle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Locale getLocale() {
/* 99 */     return this.locale;
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/fmt/LocalizationContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */