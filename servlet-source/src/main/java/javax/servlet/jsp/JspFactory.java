/*     */ package javax.servlet.jsp;
/*     */ 
/*     */ import javax.servlet.Servlet;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class JspFactory
/*     */ {
/*  92 */   private static volatile JspFactory deflt = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDefaultFactory(JspFactory deflt) {
/* 111 */     JspFactory.deflt = deflt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JspFactory getDefaultFactory() {
/* 121 */     return deflt;
/*     */   }
/*     */   
/*     */   public abstract PageContext getPageContext(Servlet paramServlet, ServletRequest paramServletRequest, ServletResponse paramServletResponse, String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
/*     */   
/*     */   public abstract void releasePageContext(PageContext paramPageContext);
/*     */   
/*     */   public abstract JspEngineInfo getEngineInfo();
/*     */   
/*     */   public abstract JspApplicationContext getJspApplicationContext(ServletContext paramServletContext);
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/JspFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */