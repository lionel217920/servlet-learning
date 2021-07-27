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
/*     */ public abstract class TagLibraryInfo
/*     */ {
/*     */   protected String prefix;
/*     */   protected String uri;
/*     */   protected TagInfo[] tags;
/*     */   protected TagFileInfo[] tagFiles;
/*     */   protected FunctionInfo[] functions;
/*     */   protected String tlibversion;
/*     */   protected String jspversion;
/*     */   protected String shortname;
/*     */   protected String urn;
/*     */   protected String info;
/*     */   
/*     */   protected TagLibraryInfo(String prefix, String uri) {
/*  81 */     this.prefix = prefix;
/*  82 */     this.uri = uri;
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
/*     */   public String getURI() {
/*  95 */     return this.uri;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrefixString() {
/* 105 */     return this.prefix;
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
/*     */   public String getShortName() {
/* 118 */     return this.shortname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReliableURN() {
/* 129 */     return this.urn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInfoString() {
/* 140 */     return this.info;
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
/*     */   public String getRequiredVersion() {
/* 152 */     return this.jspversion;
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
/*     */   public TagInfo[] getTags() {
/* 164 */     return this.tags;
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
/*     */   public TagFileInfo[] getTagFiles() {
/* 176 */     return this.tagFiles;
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
/*     */   public TagInfo getTag(String shortname) {
/* 190 */     TagInfo[] tags = getTags();
/*     */     
/* 192 */     if (tags == null || tags.length == 0) {
/* 193 */       return null;
/*     */     }
/*     */     
/* 196 */     for (int i = 0; i < tags.length; i++) {
/* 197 */       if (tags[i].getTagName().equals(shortname)) {
/* 198 */         return tags[i];
/*     */       }
/*     */     } 
/* 201 */     return null;
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
/*     */   public TagFileInfo getTagFile(String shortname) {
/* 214 */     TagFileInfo[] tagFiles = getTagFiles();
/*     */     
/* 216 */     if (tagFiles == null || tagFiles.length == 0) {
/* 217 */       return null;
/*     */     }
/*     */     
/* 220 */     for (int i = 0; i < tagFiles.length; i++) {
/* 221 */       if (tagFiles[i].getName().equals(shortname)) {
/* 222 */         return tagFiles[i];
/*     */       }
/*     */     } 
/* 225 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionInfo[] getFunctions() {
/* 236 */     return this.functions;
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
/*     */   public FunctionInfo getFunction(String name) {
/* 251 */     if (this.functions == null || this.functions.length == 0) {
/* 252 */       System.err.println("No functions");
/* 253 */       return null;
/*     */     } 
/*     */     
/* 256 */     for (int i = 0; i < this.functions.length; i++) {
/* 257 */       if (this.functions[i].getName().equals(name)) {
/* 258 */         return this.functions[i];
/*     */       }
/*     */     } 
/* 261 */     return null;
/*     */   }
/*     */   
/*     */   public abstract TagLibraryInfo[] getTagLibraryInfos();
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/TagLibraryInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */