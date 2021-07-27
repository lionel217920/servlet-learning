/*     */ package javax.servlet;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServletResponseWrapper
/*     */   implements ServletResponse
/*     */ {
/*     */   private ServletResponse response;
/*     */   
/*     */   public ServletResponseWrapper(ServletResponse response) {
/*  88 */     if (response == null) {
/*  89 */       throw new IllegalArgumentException("Response cannot be null");
/*     */     }
/*  91 */     this.response = response;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServletResponse getResponse() {
/*  99 */     return this.response;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResponse(ServletResponse response) {
/* 109 */     if (response == null) {
/* 110 */       throw new IllegalArgumentException("Response cannot be null");
/*     */     }
/* 112 */     this.response = response;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterEncoding(String charset) {
/* 123 */     this.response.setCharacterEncoding(charset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCharacterEncoding() {
/* 132 */     return this.response.getCharacterEncoding();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServletOutputStream getOutputStream() throws IOException {
/* 142 */     return this.response.getOutputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintWriter getWriter() throws IOException {
/* 152 */     return this.response.getWriter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentLength(int len) {
/* 161 */     this.response.setContentLength(len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentLengthLong(long len) {
/* 170 */     this.response.setContentLengthLong(len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentType(String type) {
/* 179 */     this.response.setContentType(type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/* 190 */     return this.response.getContentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBufferSize(int size) {
/* 198 */     this.response.setBufferSize(size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBufferSize() {
/* 206 */     return this.response.getBufferSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flushBuffer() throws IOException {
/* 215 */     this.response.flushBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCommitted() {
/* 223 */     return this.response.isCommitted();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 232 */     this.response.reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetBuffer() {
/* 241 */     this.response.resetBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocale(Locale loc) {
/* 250 */     this.response.setLocale(loc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 258 */     return this.response.getLocale();
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
/*     */   public boolean isWrapperFor(ServletResponse wrapped) {
/* 274 */     if (this.response == wrapped)
/* 275 */       return true; 
/* 276 */     if (this.response instanceof ServletResponseWrapper) {
/* 277 */       return ((ServletResponseWrapper)this.response).isWrapperFor(wrapped);
/*     */     }
/* 279 */     return false;
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
/*     */   public boolean isWrapperFor(Class<?> wrappedType) {
/* 300 */     if (!ServletResponse.class.isAssignableFrom(wrappedType)) {
/* 301 */       throw new IllegalArgumentException("Given class " + wrappedType.getName() + " not a subinterface of " + ServletResponse.class.getName());
/*     */     }
/*     */ 
/*     */     
/* 305 */     if (wrappedType.isAssignableFrom(this.response.getClass()))
/* 306 */       return true; 
/* 307 */     if (this.response instanceof ServletResponseWrapper) {
/* 308 */       return ((ServletResponseWrapper)this.response).isWrapperFor(wrappedType);
/*     */     }
/* 310 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/ServletResponseWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */