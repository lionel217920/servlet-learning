/*     */ package javax.servlet.jsp.tagext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TagAttributeInfo
/*     */ {
/*     */   public static final String ID = "id";
/*     */   private String name;
/*     */   private String type;
/*     */   private boolean reqTime;
/*     */   private boolean required;
/*     */   private boolean fragment;
/*     */   private boolean deferredValue;
/*     */   private boolean deferredMethod;
/*     */   private String expectedTypeName;
/*     */   private String methodSignature;
/*     */   private String description;
/*     */   
/*     */   public TagAttributeInfo(String name, boolean required, String type, boolean reqTime) {
/*  97 */     this.name = name;
/*  98 */     this.required = required;
/*  99 */     this.type = type;
/* 100 */     this.reqTime = reqTime;
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
/*     */   public TagAttributeInfo(String name, boolean required, String type, boolean reqTime, boolean fragment) {
/* 120 */     this(name, required, type, reqTime);
/* 121 */     this.fragment = fragment;
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
/*     */   public TagAttributeInfo(String name, boolean required, String type, boolean reqTime, boolean fragment, String description, boolean deferredValue, boolean deferredMethod, String expectedTypeName, String methodSignature) {
/* 157 */     this(name, required, type, reqTime, fragment);
/* 158 */     this.description = description;
/* 159 */     this.deferredValue = deferredValue;
/* 160 */     this.deferredMethod = deferredMethod;
/* 161 */     this.expectedTypeName = expectedTypeName;
/* 162 */     this.methodSignature = methodSignature;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 172 */     return this.name;
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
/*     */   public String getTypeName() {
/* 192 */     return this.type;
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
/*     */   public boolean canBeRequestTime() {
/* 205 */     return this.reqTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/* 214 */     return this.required;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TagAttributeInfo getIdAttribute(TagAttributeInfo[] a) {
/* 225 */     for (int i = 0; i < a.length; i++) {
/* 226 */       if (a[i].getName().equals("id")) {
/* 227 */         return a[i];
/*     */       }
/*     */     } 
/* 230 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFragment() {
/* 241 */     return this.fragment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 251 */     return this.description;
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
/*     */   public boolean isDeferredValue() {
/* 272 */     return this.deferredValue;
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
/*     */   public boolean isDeferredMethod() {
/* 294 */     return this.deferredMethod;
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
/*     */   public String getExpectedTypeName() {
/* 308 */     return this.expectedTypeName;
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
/*     */   public String getMethodSignature() {
/* 321 */     return this.methodSignature;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 331 */     StringBuffer b = new StringBuffer();
/* 332 */     b.append("name = " + this.name + " ");
/* 333 */     b.append("type = " + this.type + " ");
/* 334 */     b.append("reqTime = " + this.reqTime + " ");
/* 335 */     b.append("required = " + this.required + " ");
/* 336 */     b.append("fragment = " + this.fragment + " ");
/* 337 */     b.append("deferredValue = " + this.deferredValue + " ");
/* 338 */     b.append("deferredMethod = " + this.deferredMethod + " ");
/* 339 */     b.append("expectedTypeName = " + this.expectedTypeName + " ");
/* 340 */     b.append("methodSignature = " + this.methodSignature + " ");
/* 341 */     return b.toString();
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/TagAttributeInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */