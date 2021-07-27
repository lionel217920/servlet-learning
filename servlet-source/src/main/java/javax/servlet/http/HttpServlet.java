/*     */ package javax.servlet.http;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Enumeration;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.servlet.GenericServlet;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class HttpServlet
/*     */   extends GenericServlet
/*     */ {
/*     */   private static final String METHOD_DELETE = "DELETE";
/*     */   private static final String METHOD_HEAD = "HEAD";
/*     */   private static final String METHOD_GET = "GET";
/*     */   private static final String METHOD_OPTIONS = "OPTIONS";
/*     */   private static final String METHOD_POST = "POST";
/*     */   private static final String METHOD_PUT = "PUT";
/*     */   private static final String METHOD_TRACE = "TRACE";
/*     */   private static final String HEADER_IFMODSINCE = "If-Modified-Since";
/*     */   private static final String HEADER_LASTMOD = "Last-Modified";
/*     */   private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
/* 131 */   private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 212 */     String protocol = req.getProtocol();
/* 213 */     String msg = lStrings.getString("http.method_get_not_supported");
/* 214 */     if (protocol.endsWith("1.1")) {
/* 215 */       resp.sendError(405, msg);
/*     */     } else {
/* 217 */       resp.sendError(400, msg);
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
/*     */   protected long getLastModified(HttpServletRequest req) {
/* 246 */     return -1L;
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
/*     */   protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 286 */     NoBodyResponse response = new NoBodyResponse(resp);
/*     */     
/* 288 */     doGet(req, response);
/* 289 */     response.setContentLength();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 354 */     String protocol = req.getProtocol();
/* 355 */     String msg = lStrings.getString("http.method_post_not_supported");
/* 356 */     if (protocol.endsWith("1.1")) {
/* 357 */       resp.sendError(405, msg);
/*     */     } else {
/* 359 */       resp.sendError(400, msg);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 409 */     String protocol = req.getProtocol();
/* 410 */     String msg = lStrings.getString("http.method_put_not_supported");
/* 411 */     if (protocol.endsWith("1.1")) {
/* 412 */       resp.sendError(405, msg);
/*     */     } else {
/* 414 */       resp.sendError(400, msg);
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
/*     */   protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 456 */     String protocol = req.getProtocol();
/* 457 */     String msg = lStrings.getString("http.method_delete_not_supported");
/* 458 */     if (protocol.endsWith("1.1")) {
/* 459 */       resp.sendError(405, msg);
/*     */     } else {
/* 461 */       resp.sendError(400, msg);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Method[] getAllDeclaredMethods(Class<? extends HttpServlet> c) {
/* 468 */     Class<?> clazz = c;
/* 469 */     Method[] allMethods = null;
/*     */     
/* 471 */     while (!clazz.equals(HttpServlet.class)) {
/* 472 */       Method[] thisMethods = clazz.getDeclaredMethods();
/* 473 */       if (allMethods != null && allMethods.length > 0) {
/* 474 */         Method[] subClassMethods = allMethods;
/* 475 */         allMethods = new Method[thisMethods.length + subClassMethods.length];
/*     */         
/* 477 */         System.arraycopy(thisMethods, 0, allMethods, 0, thisMethods.length);
/*     */         
/* 479 */         System.arraycopy(subClassMethods, 0, allMethods, thisMethods.length, subClassMethods.length);
/*     */       } else {
/*     */         
/* 482 */         allMethods = thisMethods;
/*     */       } 
/*     */       
/* 485 */       clazz = clazz.getSuperclass();
/*     */     } 
/*     */     
/* 488 */     return (allMethods != null) ? allMethods : new Method[0];
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
/*     */   protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 526 */     Method[] methods = getAllDeclaredMethods((Class)getClass());
/*     */     
/* 528 */     boolean ALLOW_GET = false;
/* 529 */     boolean ALLOW_HEAD = false;
/* 530 */     boolean ALLOW_POST = false;
/* 531 */     boolean ALLOW_PUT = false;
/* 532 */     boolean ALLOW_DELETE = false;
/* 533 */     boolean ALLOW_TRACE = true;
/* 534 */     boolean ALLOW_OPTIONS = true;
/*     */     
/* 536 */     for (int i = 0; i < methods.length; i++) {
/* 537 */       String methodName = methods[i].getName();
/*     */       
/* 539 */       if (methodName.equals("doGet")) {
/* 540 */         ALLOW_GET = true;
/* 541 */         ALLOW_HEAD = true;
/* 542 */       } else if (methodName.equals("doPost")) {
/* 543 */         ALLOW_POST = true;
/* 544 */       } else if (methodName.equals("doPut")) {
/* 545 */         ALLOW_PUT = true;
/* 546 */       } else if (methodName.equals("doDelete")) {
/* 547 */         ALLOW_DELETE = true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 554 */     StringBuilder allow = new StringBuilder();
/* 555 */     if (ALLOW_GET) {
/* 556 */       allow.append("GET");
/*     */     }
/* 558 */     if (ALLOW_HEAD) {
/* 559 */       if (allow.length() > 0) {
/* 560 */         allow.append(", ");
/*     */       }
/* 562 */       allow.append("HEAD");
/*     */     } 
/* 564 */     if (ALLOW_POST) {
/* 565 */       if (allow.length() > 0) {
/* 566 */         allow.append(", ");
/*     */       }
/* 568 */       allow.append("POST");
/*     */     } 
/* 570 */     if (ALLOW_PUT) {
/* 571 */       if (allow.length() > 0) {
/* 572 */         allow.append(", ");
/*     */       }
/* 574 */       allow.append("PUT");
/*     */     } 
/* 576 */     if (ALLOW_DELETE) {
/* 577 */       if (allow.length() > 0) {
/* 578 */         allow.append(", ");
/*     */       }
/* 580 */       allow.append("DELETE");
/*     */     } 
/* 582 */     if (ALLOW_TRACE) {
/* 583 */       if (allow.length() > 0) {
/* 584 */         allow.append(", ");
/*     */       }
/* 586 */       allow.append("TRACE");
/*     */     } 
/* 588 */     if (ALLOW_OPTIONS) {
/* 589 */       if (allow.length() > 0) {
/* 590 */         allow.append(", ");
/*     */       }
/* 592 */       allow.append("OPTIONS");
/*     */     } 
/*     */     
/* 595 */     resp.setHeader("Allow", allow.toString());
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
/*     */   protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 629 */     String CRLF = "\r\n";
/* 630 */     StringBuilder buffer = (new StringBuilder("TRACE ")).append(req.getRequestURI()).append(" ").append(req.getProtocol());
/*     */ 
/*     */     
/* 633 */     Enumeration<String> reqHeaderEnum = req.getHeaderNames();
/*     */     
/* 635 */     while (reqHeaderEnum.hasMoreElements()) {
/* 636 */       String headerName = reqHeaderEnum.nextElement();
/* 637 */       buffer.append(CRLF).append(headerName).append(": ").append(req.getHeader(headerName));
/*     */     } 
/*     */ 
/*     */     
/* 641 */     buffer.append(CRLF);
/*     */     
/* 643 */     int responseLength = buffer.length();
/*     */     
/* 645 */     resp.setContentType("message/http");
/* 646 */     resp.setContentLength(responseLength);
/* 647 */     ServletOutputStream out = resp.getOutputStream();
/* 648 */     out.print(buffer.toString());
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
/*     */   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/* 680 */     String method = req.getMethod();
/*     */     
/* 682 */     if (method.equals("GET")) {
/* 683 */       long lastModified = getLastModified(req);
/* 684 */       if (lastModified == -1L) {
/*     */ 
/*     */         
/* 687 */         doGet(req, resp);
/*     */       } else {
/* 689 */         long ifModifiedSince = req.getDateHeader("If-Modified-Since");
/* 690 */         if (ifModifiedSince < lastModified) {
/*     */ 
/*     */ 
/*     */           
/* 694 */           maybeSetLastModified(resp, lastModified);
/* 695 */           doGet(req, resp);
/*     */         } else {
/* 697 */           resp.setStatus(304);
/*     */         }
/*     */       
/*     */       } 
/* 701 */     } else if (method.equals("HEAD")) {
/* 702 */       long lastModified = getLastModified(req);
/* 703 */       maybeSetLastModified(resp, lastModified);
/* 704 */       doHead(req, resp);
/*     */     }
/* 706 */     else if (method.equals("POST")) {
/* 707 */       doPost(req, resp);
/*     */     }
/* 709 */     else if (method.equals("PUT")) {
/* 710 */       doPut(req, resp);
/*     */     }
/* 712 */     else if (method.equals("DELETE")) {
/* 713 */       doDelete(req, resp);
/*     */     }
/* 715 */     else if (method.equals("OPTIONS")) {
/* 716 */       doOptions(req, resp);
/*     */     }
/* 718 */     else if (method.equals("TRACE")) {
/* 719 */       doTrace(req, resp);
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 727 */       String errMsg = lStrings.getString("http.method_not_implemented");
/* 728 */       Object[] errArgs = new Object[1];
/* 729 */       errArgs[0] = method;
/* 730 */       errMsg = MessageFormat.format(errMsg, errArgs);
/*     */       
/* 732 */       resp.sendError(501, errMsg);
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
/*     */   private void maybeSetLastModified(HttpServletResponse resp, long lastModified) {
/* 746 */     if (resp.containsHeader("Last-Modified"))
/*     */       return; 
/* 748 */     if (lastModified >= 0L) {
/* 749 */       resp.setDateHeader("Last-Modified", lastModified);
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
/*     */   public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
/* 782 */     if (!(req instanceof HttpServletRequest) || !(res instanceof HttpServletResponse))
/*     */     {
/* 784 */       throw new ServletException("non-HTTP request or response");
/*     */     }
/*     */     
/* 787 */     HttpServletRequest request = (HttpServletRequest)req;
/* 788 */     HttpServletResponse response = (HttpServletResponse)res;
/*     */     
/* 790 */     service(request, response);
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/http/HttpServlet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */