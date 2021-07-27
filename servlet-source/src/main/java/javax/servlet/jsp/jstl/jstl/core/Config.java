/*     */ package javax.servlet.jsp.jstl.jstl.core;
/*     */ 
/*     */ import javax.servlet.jsp.PageContext;

import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Config
/*     */ {
/*     */   public static final String FMT_LOCALE = "javax.servlet.jsp.jstl.fmt.locale";
/*     */   public static final String FMT_FALLBACK_LOCALE = "javax.servlet.jsp.jstl.fmt.fallbackLocale";
/*     */   public static final String FMT_LOCALIZATION_CONTEXT = "javax.servlet.jsp.jstl.fmt.localizationContext";
/*     */   public static final String FMT_TIME_ZONE = "javax.servlet.jsp.jstl.fmt.timeZone";
/*     */   public static final String SQL_DATA_SOURCE = "javax.servlet.jsp.jstl.sql.dataSource";
/*     */   public static final String SQL_MAX_ROWS = "javax.servlet.jsp.jstl.sql.maxRows";
/*     */   private static final String PAGE_SCOPE_SUFFIX = ".page";
/*     */   private static final String REQUEST_SCOPE_SUFFIX = ".request";
/*     */   private static final String SESSION_SCOPE_SUFFIX = ".session";
/*     */   private static final String APPLICATION_SCOPE_SUFFIX = ".application";
/*     */   
/*     */   public static Object get(PageContext pc, String name, int scope) {
/* 101 */     switch (scope) {
/*     */       case 1:
/* 103 */         return pc.getAttribute(name + ".page", scope);
/*     */       case 2:
/* 105 */         return pc.getAttribute(name + ".request", scope);
/*     */       case 3:
/* 107 */         return get(pc.getSession(), name);
/*     */       case 4:
/* 109 */         return pc.getAttribute(name + ".application", scope);
/*     */     } 
/* 111 */     throw new IllegalArgumentException("unknown scope");
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
/*     */   public static Object get(ServletRequest request, String name) {
/* 130 */     return request.getAttribute(name + ".request");
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
/*     */   public static Object get(HttpSession session, String name) {
/* 149 */     Object ret = null;
/* 150 */     if (session != null) {
/*     */       try {
/* 152 */         ret = session.getAttribute(name + ".session");
/* 153 */       } catch (IllegalStateException illegalStateException) {}
/*     */     }
/* 155 */     return ret;
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
/*     */   public static Object get(ServletContext context, String name) {
/* 173 */     return context.getAttribute(name + ".application");
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
/*     */   public static void set(PageContext pc, String name, Object value, int scope) {
/* 191 */     switch (scope) {
/*     */       case 1:
/* 193 */         pc.setAttribute(name + ".page", value, scope);
/*     */         return;
/*     */       case 2:
/* 196 */         pc.setAttribute(name + ".request", value, scope);
/*     */         return;
/*     */       case 3:
/* 199 */         pc.setAttribute(name + ".session", value, scope);
/*     */         return;
/*     */       case 4:
/* 202 */         pc.setAttribute(name + ".application", value, scope);
/*     */         return;
/*     */     } 
/* 205 */     throw new IllegalArgumentException("unknown scope");
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
/*     */   public static void set(ServletRequest request, String name, Object value) {
/* 223 */     request.setAttribute(name + ".request", value);
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
/*     */   public static void set(HttpSession session, String name, Object value) {
/* 240 */     session.setAttribute(name + ".session", value);
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
/*     */   public static void set(ServletContext context, String name, Object value) {
/* 257 */     context.setAttribute(name + ".application", value);
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
/*     */   public static void remove(PageContext pc, String name, int scope) {
/* 274 */     switch (scope) {
/*     */       case 1:
/* 276 */         pc.removeAttribute(name + ".page", scope);
/*     */         return;
/*     */       case 2:
/* 279 */         pc.removeAttribute(name + ".request", scope);
/*     */         return;
/*     */       case 3:
/* 282 */         pc.removeAttribute(name + ".session", scope);
/*     */         return;
/*     */       case 4:
/* 285 */         pc.removeAttribute(name + ".application", scope);
/*     */         return;
/*     */     } 
/* 288 */     throw new IllegalArgumentException("unknown scope");
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
/*     */   public static void remove(ServletRequest request, String name) {
/* 304 */     request.removeAttribute(name + ".request");
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
/*     */   public static void remove(HttpSession session, String name) {
/* 319 */     session.removeAttribute(name + ".session");
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
/*     */   public static void remove(ServletContext context, String name) {
/* 334 */     context.removeAttribute(name + ".application");
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
/*     */   public static Object find(PageContext pc, String name) {
/* 356 */     Object ret = get(pc, name, 1);
/* 357 */     if (ret == null) {
/* 358 */       ret = get(pc, name, 2);
/* 359 */       if (ret == null) {
/* 360 */         if (pc.getSession() != null)
/*     */         {
/* 362 */           ret = get(pc, name, 3);
/*     */         }
/* 364 */         if (ret == null) {
/* 365 */           ret = get(pc, name, 4);
/* 366 */           if (ret == null) {
/* 367 */             ret = pc.getServletContext().getInitParameter(name);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 373 */     return ret;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/Config.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */