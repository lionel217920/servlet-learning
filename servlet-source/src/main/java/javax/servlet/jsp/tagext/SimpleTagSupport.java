/*     */ package javax.servlet.jsp.tagext;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.jsp.JspContext;
/*     */ import javax.servlet.jsp.JspException;
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
/*     */ public class SimpleTagSupport
/*     */   implements SimpleTag
/*     */ {
/*     */   private JspTag parentTag;
/*     */   private JspContext jspContext;
/*     */   private JspFragment jspBody;
/*     */   
/*     */   public void doTag() throws JspException, IOException {}
/*     */   
/*     */   public void setParent(JspTag parent) {
/* 125 */     this.parentTag = parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JspTag getParent() {
/* 134 */     return this.parentTag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJspContext(JspContext pc) {
/* 146 */     this.jspContext = pc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JspContext getJspContext() {
/* 156 */     return this.jspContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJspBody(JspFragment jspBody) {
/* 168 */     this.jspBody = jspBody;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JspFragment getJspBody() {
/* 178 */     return this.jspBody;
/*     */   }
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
/*     */   public static final JspTag findAncestorWithClass(JspTag from, Class<?> klass) {
/* 223 */     boolean isInterface = false;
/*     */     
/* 225 */     if (from == null || klass == null || (!JspTag.class.isAssignableFrom(klass) && !(isInterface = klass.isInterface())))
/*     */     {
/*     */       
/* 228 */       return null;
/*     */     }
/*     */     
/*     */     while (true) {
/* 232 */       JspTag parent = null;
/* 233 */       if (from instanceof SimpleTag) {
/* 234 */         parent = ((SimpleTag)from).getParent();
/*     */       }
/* 236 */       else if (from instanceof Tag) {
/* 237 */         parent = ((Tag)from).getParent();
/*     */       } 
/* 239 */       if (parent == null) {
/* 240 */         return null;
/*     */       }
/*     */       
/* 243 */       if (parent instanceof TagAdapter) {
/* 244 */         parent = ((TagAdapter)parent).getAdaptee();
/*     */       }
/*     */       
/* 247 */       if ((isInterface && klass.isInstance(parent)) || klass.isAssignableFrom(parent.getClass()))
/*     */       {
/* 249 */         return parent;
/*     */       }
/*     */       
/* 252 */       from = parent;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/SimpleTagSupport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */