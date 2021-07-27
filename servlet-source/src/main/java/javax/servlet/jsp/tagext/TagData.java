/*     */ package javax.servlet.jsp.tagext;
/*     */ 
/*     */ import java.util.Enumeration;
/*     */ import java.util.Hashtable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TagData
/*     */   implements Cloneable
/*     */ {
/*  80 */   public static final Object REQUEST_TIME_VALUE = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Hashtable<String, Object> attributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TagData(Object[][] atts) {
/*  99 */     if (atts == null) {
/* 100 */       this.attributes = new Hashtable<>();
/*     */     } else {
/* 102 */       this.attributes = new Hashtable<>(atts.length);
/*     */     } 
/*     */     
/* 105 */     if (atts != null) {
/* 106 */       for (int i = 0; i < atts.length; i++) {
/* 107 */         this.attributes.put((String)atts[i][0], atts[i][1]);
/*     */       }
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
/*     */   public TagData(Hashtable<String, Object> attrs) {
/* 121 */     this.attributes = attrs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 132 */     return getAttributeString("id");
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
/*     */   public Object getAttribute(String attName) {
/* 152 */     return this.attributes.get(attName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttribute(String attName, Object value) {
/* 163 */     this.attributes.put(attName, value);
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
/*     */   public String getAttributeString(String attName) {
/* 175 */     Object o = this.attributes.get(attName);
/* 176 */     if (o == null) {
/* 177 */       return null;
/*     */     }
/* 179 */     return (String)o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<String> getAttributes() {
/* 189 */     return this.attributes.keys();
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/TagData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */