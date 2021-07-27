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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TagInfo
/*     */ {
/*     */   public static final String BODY_CONTENT_JSP = "JSP";
/*     */   public static final String BODY_CONTENT_TAG_DEPENDENT = "tagdependent";
/*     */   public static final String BODY_CONTENT_EMPTY = "empty";
/*     */   public static final String BODY_CONTENT_SCRIPTLESS = "scriptless";
/*     */   private String tagName;
/*     */   private String tagClassName;
/*     */   private String bodyContent;
/*     */   private String infoString;
/*     */   private TagLibraryInfo tagLibrary;
/*     */   private TagExtraInfo tagExtraInfo;
/*     */   private TagAttributeInfo[] attributeInfo;
/*     */   private String displayName;
/*     */   private String smallIcon;
/*     */   private String largeIcon;
/*     */   private TagVariableInfo[] tagVariableInfo;
/*     */   private boolean dynamicAttributes;
/*     */   
/*     */   public TagInfo(String tagName, String tagClassName, String bodycontent, String infoString, TagLibraryInfo taglib, TagExtraInfo tagExtraInfo, TagAttributeInfo[] attributeInfo) {
/* 125 */     this.tagName = tagName;
/* 126 */     this.tagClassName = tagClassName;
/* 127 */     this.bodyContent = bodycontent;
/* 128 */     this.infoString = infoString;
/* 129 */     this.tagLibrary = taglib;
/* 130 */     this.tagExtraInfo = tagExtraInfo;
/* 131 */     this.attributeInfo = attributeInfo;
/*     */     
/* 133 */     if (tagExtraInfo != null) {
/* 134 */       tagExtraInfo.setTagInfo(this);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TagInfo(String tagName, String tagClassName, String bodycontent, String infoString, TagLibraryInfo taglib, TagExtraInfo tagExtraInfo, TagAttributeInfo[] attributeInfo, String displayName, String smallIcon, String largeIcon, TagVariableInfo[] tvi) {
/* 172 */     this.tagName = tagName;
/* 173 */     this.tagClassName = tagClassName;
/* 174 */     this.bodyContent = bodycontent;
/* 175 */     this.infoString = infoString;
/* 176 */     this.tagLibrary = taglib;
/* 177 */     this.tagExtraInfo = tagExtraInfo;
/* 178 */     this.attributeInfo = attributeInfo;
/* 179 */     this.displayName = displayName;
/* 180 */     this.smallIcon = smallIcon;
/* 181 */     this.largeIcon = largeIcon;
/* 182 */     this.tagVariableInfo = tvi;
/*     */     
/* 184 */     if (tagExtraInfo != null) {
/* 185 */       tagExtraInfo.setTagInfo(this);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TagInfo(String tagName, String tagClassName, String bodycontent, String infoString, TagLibraryInfo taglib, TagExtraInfo tagExtraInfo, TagAttributeInfo[] attributeInfo, String displayName, String smallIcon, String largeIcon, TagVariableInfo[] tvi, boolean dynamicAttributes) {
/* 227 */     this.tagName = tagName;
/* 228 */     this.tagClassName = tagClassName;
/* 229 */     this.bodyContent = bodycontent;
/* 230 */     this.infoString = infoString;
/* 231 */     this.tagLibrary = taglib;
/* 232 */     this.tagExtraInfo = tagExtraInfo;
/* 233 */     this.attributeInfo = attributeInfo;
/* 234 */     this.displayName = displayName;
/* 235 */     this.smallIcon = smallIcon;
/* 236 */     this.largeIcon = largeIcon;
/* 237 */     this.tagVariableInfo = tvi;
/* 238 */     this.dynamicAttributes = dynamicAttributes;
/*     */     
/* 240 */     if (tagExtraInfo != null) {
/* 241 */       tagExtraInfo.setTagInfo(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTagName() {
/* 251 */     return this.tagName;
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
/*     */   public TagAttributeInfo[] getAttributes() {
/* 264 */     return this.attributeInfo;
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
/*     */   public VariableInfo[] getVariableInfo(TagData data) {
/* 277 */     VariableInfo[] result = null;
/* 278 */     TagExtraInfo tei = getTagExtraInfo();
/* 279 */     if (tei != null) {
/* 280 */       result = tei.getVariableInfo(data);
/*     */     }
/* 282 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid(TagData data) {
/* 293 */     TagExtraInfo tei = getTagExtraInfo();
/* 294 */     if (tei == null) {
/* 295 */       return true;
/*     */     }
/* 297 */     return tei.isValid(data);
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
/*     */   public ValidationMessage[] validate(TagData data) {
/* 310 */     TagExtraInfo tei = getTagExtraInfo();
/* 311 */     if (tei == null) {
/* 312 */       return null;
/*     */     }
/* 314 */     return tei.validate(data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTagExtraInfo(TagExtraInfo tei) {
/* 323 */     this.tagExtraInfo = tei;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TagExtraInfo getTagExtraInfo() {
/* 333 */     return this.tagExtraInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTagClassName() {
/* 344 */     return this.tagClassName;
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
/*     */   public String getBodyContent() {
/* 357 */     return this.bodyContent;
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
/*     */   public String getInfoString() {
/* 369 */     return this.infoString;
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
/*     */   public void setTagLibrary(TagLibraryInfo tl) {
/* 389 */     this.tagLibrary = tl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TagLibraryInfo getTagLibrary() {
/* 399 */     return this.tagLibrary;
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
/*     */   public String getDisplayName() {
/* 414 */     return this.displayName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSmallIcon() {
/* 425 */     return this.smallIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLargeIcon() {
/* 436 */     return this.largeIcon;
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
/*     */   public TagVariableInfo[] getTagVariableInfos() {
/* 448 */     return this.tagVariableInfo;
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
/*     */   public boolean hasDynamicAttributes() {
/* 461 */     return this.dynamicAttributes;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/TagInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */