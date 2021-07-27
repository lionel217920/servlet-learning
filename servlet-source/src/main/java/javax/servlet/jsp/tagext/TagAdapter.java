/*     */ package javax.servlet.jsp.tagext;
/*     */ 
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TagAdapter
/*     */   implements Tag
/*     */ {
/*     */   private SimpleTag simpleTagAdaptee;
/*     */   private Tag parent;
/*     */   private boolean parentDetermined;
/*     */   
/*     */   public TagAdapter(SimpleTag adaptee) {
/*  97 */     if (adaptee == null)
/*     */     {
/*  99 */       throw new IllegalArgumentException();
/*     */     }
/* 101 */     this.simpleTagAdaptee = adaptee;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageContext(PageContext pc) {
/* 111 */     throw new UnsupportedOperationException("Illegal to invoke setPageContext() on TagAdapter wrapper");
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
/*     */   public void setParent(Tag parentTag) {
/* 124 */     throw new UnsupportedOperationException("Illegal to invoke setParent() on TagAdapter wrapper");
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
/*     */   public Tag getParent() {
/* 140 */     if (!this.parentDetermined) {
/* 141 */       JspTag adapteeParent = this.simpleTagAdaptee.getParent();
/* 142 */       if (adapteeParent != null) {
/* 143 */         if (adapteeParent instanceof Tag) {
/* 144 */           this.parent = (Tag)adapteeParent;
/*     */         } else {
/*     */           
/* 147 */           this.parent = new TagAdapter((SimpleTag)adapteeParent);
/*     */         } 
/*     */       }
/* 150 */       this.parentDetermined = true;
/*     */     } 
/*     */     
/* 153 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JspTag getAdaptee() {
/* 164 */     return this.simpleTagAdaptee;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int doStartTag() throws JspException {
/* 175 */     throw new UnsupportedOperationException("Illegal to invoke doStartTag() on TagAdapter wrapper");
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
/*     */   public int doEndTag() throws JspException {
/* 187 */     throw new UnsupportedOperationException("Illegal to invoke doEndTag() on TagAdapter wrapper");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void release() {
/* 197 */     throw new UnsupportedOperationException("Illegal to invoke release() on TagAdapter wrapper");
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/TagAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */