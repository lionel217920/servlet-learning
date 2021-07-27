/*     */ package javax.servlet.http;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.security.Principal;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequestWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpServletRequestWrapper
/*     */   extends ServletRequestWrapper
/*     */   implements HttpServletRequest
/*     */ {
/*     */   public HttpServletRequestWrapper(HttpServletRequest request) {
/*  86 */     super(request);
/*     */   }
/*     */   
/*     */   private HttpServletRequest _getHttpServletRequest() {
/*  90 */     return (HttpServletRequest)getRequest();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthType() {
/*  99 */     return _getHttpServletRequest().getAuthType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Cookie[] getCookies() {
/* 108 */     return _getHttpServletRequest().getCookies();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDateHeader(String name) {
/* 117 */     return _getHttpServletRequest().getDateHeader(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHeader(String name) {
/* 126 */     return _getHttpServletRequest().getHeader(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<String> getHeaders(String name) {
/* 135 */     return _getHttpServletRequest().getHeaders(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<String> getHeaderNames() {
/* 144 */     return _getHttpServletRequest().getHeaderNames();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntHeader(String name) {
/* 153 */     return _getHttpServletRequest().getIntHeader(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMethod() {
/* 162 */     return _getHttpServletRequest().getMethod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPathInfo() {
/* 171 */     return _getHttpServletRequest().getPathInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPathTranslated() {
/* 180 */     return _getHttpServletRequest().getPathTranslated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContextPath() {
/* 189 */     return _getHttpServletRequest().getContextPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQueryString() {
/* 198 */     return _getHttpServletRequest().getQueryString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRemoteUser() {
/* 207 */     return _getHttpServletRequest().getRemoteUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUserInRole(String role) {
/* 216 */     return _getHttpServletRequest().isUserInRole(role);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Principal getUserPrincipal() {
/* 225 */     return _getHttpServletRequest().getUserPrincipal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRequestedSessionId() {
/* 234 */     return _getHttpServletRequest().getRequestedSessionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRequestURI() {
/* 243 */     return _getHttpServletRequest().getRequestURI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuffer getRequestURL() {
/* 252 */     return _getHttpServletRequest().getRequestURL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServletPath() {
/* 261 */     return _getHttpServletRequest().getServletPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpSession getSession(boolean create) {
/* 270 */     return _getHttpServletRequest().getSession(create);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpSession getSession() {
/* 279 */     return _getHttpServletRequest().getSession();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String changeSessionId() {
/* 290 */     return _getHttpServletRequest().changeSessionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequestedSessionIdValid() {
/* 299 */     return _getHttpServletRequest().isRequestedSessionIdValid();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequestedSessionIdFromCookie() {
/* 308 */     return _getHttpServletRequest().isRequestedSessionIdFromCookie();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequestedSessionIdFromURL() {
/* 317 */     return _getHttpServletRequest().isRequestedSessionIdFromURL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequestedSessionIdFromUrl() {
/* 326 */     return _getHttpServletRequest().isRequestedSessionIdFromUrl();
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
/*     */   public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
/* 338 */     return _getHttpServletRequest().authenticate(response);
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
/*     */   public void login(String username, String password) throws ServletException {
/* 350 */     _getHttpServletRequest().login(username, password);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logout() throws ServletException {
/* 361 */     _getHttpServletRequest().logout();
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
/*     */   public Collection<Part> getParts() throws IOException, ServletException {
/* 375 */     return _getHttpServletRequest().getParts();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Part getPart(String name) throws IOException, ServletException {
/* 386 */     return _getHttpServletRequest().getPart(name);
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
/*     */   public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
/* 399 */     return _getHttpServletRequest().upgrade(handlerClass);
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpServletRequestWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */