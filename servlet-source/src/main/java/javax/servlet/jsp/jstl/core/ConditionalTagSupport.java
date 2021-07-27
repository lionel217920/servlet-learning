/*     */ package javax.servlet.jsp.jstl.core;
/*     */ 
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspTagException;
/*     */ import javax.servlet.jsp.tagext.TagSupport;
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
/*     */ public abstract class ConditionalTagSupport
/*     */   extends TagSupport
/*     */ {
/*     */   private boolean result;
/*     */   private String var;
/*     */   private int scope;
/*     */   
/*     */   protected abstract boolean condition() throws JspTagException;
/*     */   
/*     */   public ConditionalTagSupport() {
/*  72 */     init();
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
/*     */   public int doStartTag() throws JspException {
/*  85 */     this.result = condition();
/*     */ 
/*     */     
/*  88 */     exposeVariables();
/*     */ 
/*     */     
/*  91 */     if (this.result) {
/*  92 */       return 1;
/*     */     }
/*  94 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void release() {
/* 101 */     super.release();
/* 102 */     init();
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
/*     */   public void setVar(String var) {
/* 123 */     this.var = var;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScope(String scope) {
/* 132 */     if (scope.equalsIgnoreCase("page")) {
/* 133 */       this.scope = 1;
/* 134 */     } else if (scope.equalsIgnoreCase("request")) {
/* 135 */       this.scope = 2;
/* 136 */     } else if (scope.equalsIgnoreCase("session")) {
/* 137 */       this.scope = 3;
/* 138 */     } else if (scope.equalsIgnoreCase("application")) {
/* 139 */       this.scope = 4;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void exposeVariables() {
/* 149 */     if (this.var != null) {
/* 150 */       this.pageContext.setAttribute(this.var, Boolean.valueOf(this.result), this.scope);
/*     */     }
/*     */   }
/*     */   
/*     */   private void init() {
/* 155 */     this.result = false;
/* 156 */     this.var = null;
/* 157 */     this.scope = 1;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/ConditionalTagSupport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */