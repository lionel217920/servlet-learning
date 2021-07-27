/*     */ package javax.servlet.jsp.tagext;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Hashtable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TagSupport
/*     */   implements IterationTag, Serializable
/*     */ {
/*     */   private Tag parent;
/*     */   private Hashtable<String, Object> values;
/*     */   protected String id;
/*     */   protected PageContext pageContext;
/*     */   
/*     */   public static final Tag findAncestorWithClass(Tag from, Class<?> klass) {
/* 123 */     boolean isInterface = false;
/*     */     
/* 125 */     if (from == null || klass == null || (!Tag.class.isAssignableFrom(klass) && !(isInterface = klass.isInterface())))
/*     */     {
/*     */ 
/*     */       
/* 129 */       return null;
/*     */     }
/*     */     
/*     */     while (true) {
/* 133 */       Tag tag = from.getParent();
/*     */       
/* 135 */       if (tag == null) {
/* 136 */         return null;
/*     */       }
/*     */       
/* 139 */       if ((isInterface && klass.isInstance(tag)) || klass.isAssignableFrom(tag.getClass()))
/*     */       {
/* 141 */         return tag;
/*     */       }
/* 143 */       from = tag;
/*     */     } 
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
/*     */   public int doStartTag() throws JspException {
/* 168 */     return 0;
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
/*     */   public int doEndTag() throws JspException {
/* 181 */     return 6;
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
/*     */   public int doAfterBody() throws JspException {
/* 195 */     return 0;
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
/*     */   public void release() {
/* 208 */     this.parent = null;
/* 209 */     this.id = null;
/* 210 */     if (this.values != null) {
/* 211 */       this.values.clear();
/*     */     }
/* 213 */     this.values = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(Tag t) {
/* 224 */     this.parent = t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tag getParent() {
/* 235 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String id) {
/* 245 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 255 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageContext(PageContext pageContext) {
/* 266 */     this.pageContext = pageContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String k, Object o) {
/* 277 */     if (this.values == null) {
/* 278 */       this.values = new Hashtable<>();
/*     */     }
/* 280 */     this.values.put(k, o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String k) {
/* 291 */     if (this.values == null) {
/* 292 */       return null;
/*     */     }
/* 294 */     return this.values.get(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeValue(String k) {
/* 305 */     if (this.values != null) {
/* 306 */       this.values.remove(k);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<String> getValues() {
/* 318 */     if (this.values == null) {
/* 319 */       return null;
/*     */     }
/* 321 */     return this.values.keys();
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/TagSupport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */