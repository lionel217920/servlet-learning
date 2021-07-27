/*      */ package javax.servlet.jsp.el;
/*      */ 
/*      */ import javax.servlet.jsp.PageContext;

import java.beans.FeatureDescriptor;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.el.ELContext;
/*      */ import javax.el.ELResolver;
/*      */ import javax.el.PropertyNotWritableException;
/*      */ import javax.servlet.ServletContext;
/*      */ import javax.servlet.http.Cookie;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import javax.servlet.jsp.JspContext;
/*      */

/*      */
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ImplicitObjectELResolver
/*      */   extends ELResolver
/*      */ {
/*      */   public Object getValue(ELContext context, Object base, Object property) {
/*  159 */     if (context == null) {
/*  160 */       throw new NullPointerException();
/*      */     }
/*      */     
/*  163 */     if (base != null) {
/*  164 */       return null;
/*      */     }
/*      */     
/*  167 */     PageContext ctxt = (PageContext)context.getContext(JspContext.class);
/*      */     
/*  169 */     if ("pageContext".equals(property)) {
/*  170 */       context.setPropertyResolved(true);
/*  171 */       return ctxt;
/*      */     } 
/*  173 */     ImplicitObjects implicitObjects = ImplicitObjects.getImplicitObjects(ctxt);
/*      */     
/*  175 */     if ("pageScope".equals(property)) {
/*  176 */       context.setPropertyResolved(true);
/*  177 */       return implicitObjects.getPageScopeMap();
/*      */     } 
/*  179 */     if ("requestScope".equals(property)) {
/*  180 */       context.setPropertyResolved(true);
/*  181 */       return implicitObjects.getRequestScopeMap();
/*      */     } 
/*  183 */     if ("sessionScope".equals(property)) {
/*  184 */       context.setPropertyResolved(true);
/*  185 */       return implicitObjects.getSessionScopeMap();
/*      */     } 
/*  187 */     if ("applicationScope".equals(property)) {
/*  188 */       context.setPropertyResolved(true);
/*  189 */       return implicitObjects.getApplicationScopeMap();
/*      */     } 
/*  191 */     if ("param".equals(property)) {
/*  192 */       context.setPropertyResolved(true);
/*  193 */       return implicitObjects.getParamMap();
/*      */     } 
/*  195 */     if ("paramValues".equals(property)) {
/*  196 */       context.setPropertyResolved(true);
/*  197 */       return implicitObjects.getParamsMap();
/*      */     } 
/*  199 */     if ("header".equals(property)) {
/*  200 */       context.setPropertyResolved(true);
/*  201 */       return implicitObjects.getHeaderMap();
/*      */     } 
/*  203 */     if ("headerValues".equals(property)) {
/*  204 */       context.setPropertyResolved(true);
/*  205 */       return implicitObjects.getHeadersMap();
/*      */     } 
/*  207 */     if ("initParam".equals(property)) {
/*  208 */       context.setPropertyResolved(true);
/*  209 */       return implicitObjects.getInitParamMap();
/*      */     } 
/*  211 */     if ("cookie".equals(property)) {
/*  212 */       context.setPropertyResolved(true);
/*  213 */       return implicitObjects.getCookieMap();
/*      */     } 
/*  215 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class getType(ELContext context, Object base, Object property) {
/*  246 */     if (context == null) {
/*  247 */       throw new NullPointerException();
/*      */     }
/*      */     
/*  250 */     if ((base == null && ("pageContext".equals(property) || "pageScope".equals(property))) || "requestScope".equals(property) || "sessionScope".equals(property) || "applicationScope".equals(property) || "param".equals(property) || "paramValues".equals(property) || "header".equals(property) || "headerValues".equals(property) || "initParam".equals(property) || "cookie".equals(property))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  261 */       context.setPropertyResolved(true);
/*      */     }
/*  263 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(ELContext context, Object base, Object property, Object val) {
/*  296 */     if (context == null) {
/*  297 */       throw new NullPointerException();
/*      */     }
/*      */     
/*  300 */     if ((base == null && ("pageContext".equals(property) || "pageScope".equals(property))) || "requestScope".equals(property) || "sessionScope".equals(property) || "applicationScope".equals(property) || "param".equals(property) || "paramValues".equals(property) || "header".equals(property) || "headerValues".equals(property) || "initParam".equals(property) || "cookie".equals(property))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  311 */       throw new PropertyNotWritableException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/*  342 */     if (context == null) {
/*  343 */       throw new NullPointerException();
/*      */     }
/*      */     
/*  346 */     if ((base == null && ("pageContext".equals(property) || "pageScope".equals(property))) || "requestScope".equals(property) || "sessionScope".equals(property) || "applicationScope".equals(property) || "param".equals(property) || "paramValues".equals(property) || "header".equals(property) || "headerValues".equals(property) || "initParam".equals(property) || "cookie".equals(property)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  357 */       context.setPropertyResolved(true);
/*  358 */       return true;
/*      */     } 
/*  360 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/*  400 */     ArrayList<FeatureDescriptor> list = new ArrayList<>(11);
/*      */ 
/*      */ 
/*      */     
/*  404 */     FeatureDescriptor descriptor = new FeatureDescriptor();
/*  405 */     descriptor.setName("pageContext");
/*  406 */     descriptor.setDisplayName("pageContext");
/*      */     
/*  408 */     descriptor.setExpert(false);
/*  409 */     descriptor.setHidden(false);
/*  410 */     descriptor.setPreferred(true);
/*  411 */     descriptor.setValue("type", PageContext.class);
/*  412 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  413 */     list.add(descriptor);
/*      */ 
/*      */     
/*  416 */     descriptor = new FeatureDescriptor();
/*  417 */     descriptor.setName("pageScope");
/*  418 */     descriptor.setDisplayName("pageScope");
/*      */     
/*  420 */     descriptor.setExpert(false);
/*  421 */     descriptor.setHidden(false);
/*  422 */     descriptor.setPreferred(true);
/*  423 */     descriptor.setValue("type", Map.class);
/*  424 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  425 */     list.add(descriptor);
/*      */ 
/*      */     
/*  428 */     descriptor = new FeatureDescriptor();
/*  429 */     descriptor.setName("requestScope");
/*  430 */     descriptor.setDisplayName("requestScope");
/*      */     
/*  432 */     descriptor.setExpert(false);
/*  433 */     descriptor.setHidden(false);
/*  434 */     descriptor.setPreferred(true);
/*  435 */     descriptor.setValue("type", Map.class);
/*  436 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  437 */     list.add(descriptor);
/*      */ 
/*      */     
/*  440 */     descriptor = new FeatureDescriptor();
/*  441 */     descriptor.setName("sessionScope");
/*  442 */     descriptor.setDisplayName("sessionScope");
/*      */     
/*  444 */     descriptor.setExpert(false);
/*  445 */     descriptor.setHidden(false);
/*  446 */     descriptor.setPreferred(true);
/*  447 */     descriptor.setValue("type", Map.class);
/*  448 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  449 */     list.add(descriptor);
/*      */ 
/*      */     
/*  452 */     descriptor = new FeatureDescriptor();
/*  453 */     descriptor.setName("applicationScope");
/*  454 */     descriptor.setDisplayName("applicationScope");
/*      */     
/*  456 */     descriptor.setExpert(false);
/*  457 */     descriptor.setHidden(false);
/*  458 */     descriptor.setPreferred(true);
/*  459 */     descriptor.setValue("type", Map.class);
/*  460 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  461 */     list.add(descriptor);
/*      */ 
/*      */     
/*  464 */     descriptor = new FeatureDescriptor();
/*  465 */     descriptor.setName("param");
/*  466 */     descriptor.setDisplayName("param");
/*      */     
/*  468 */     descriptor.setExpert(false);
/*  469 */     descriptor.setHidden(false);
/*  470 */     descriptor.setPreferred(true);
/*  471 */     descriptor.setValue("type", Map.class);
/*  472 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  473 */     list.add(descriptor);
/*      */ 
/*      */     
/*  476 */     descriptor = new FeatureDescriptor();
/*  477 */     descriptor.setName("paramValues");
/*  478 */     descriptor.setDisplayName("paramValues");
/*      */     
/*  480 */     descriptor.setExpert(false);
/*  481 */     descriptor.setHidden(false);
/*  482 */     descriptor.setPreferred(true);
/*  483 */     descriptor.setValue("type", Map.class);
/*  484 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  485 */     list.add(descriptor);
/*      */ 
/*      */     
/*  488 */     descriptor = new FeatureDescriptor();
/*  489 */     descriptor.setName("header");
/*  490 */     descriptor.setDisplayName("header");
/*      */     
/*  492 */     descriptor.setExpert(false);
/*  493 */     descriptor.setHidden(false);
/*  494 */     descriptor.setPreferred(true);
/*  495 */     descriptor.setValue("type", Map.class);
/*  496 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  497 */     list.add(descriptor);
/*      */ 
/*      */     
/*  500 */     descriptor = new FeatureDescriptor();
/*  501 */     descriptor.setName("headerValues");
/*  502 */     descriptor.setDisplayName("headerValues");
/*      */     
/*  504 */     descriptor.setExpert(false);
/*  505 */     descriptor.setHidden(false);
/*  506 */     descriptor.setPreferred(true);
/*  507 */     descriptor.setValue("type", Map.class);
/*  508 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  509 */     list.add(descriptor);
/*      */ 
/*      */     
/*  512 */     descriptor = new FeatureDescriptor();
/*  513 */     descriptor.setName("cookie");
/*  514 */     descriptor.setDisplayName("cookie");
/*      */     
/*  516 */     descriptor.setExpert(false);
/*  517 */     descriptor.setHidden(false);
/*  518 */     descriptor.setPreferred(true);
/*  519 */     descriptor.setValue("type", Map.class);
/*  520 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  521 */     list.add(descriptor);
/*      */ 
/*      */     
/*  524 */     descriptor = new FeatureDescriptor();
/*  525 */     descriptor.setName("initParam");
/*  526 */     descriptor.setDisplayName("initParam");
/*      */     
/*  528 */     descriptor.setExpert(false);
/*  529 */     descriptor.setHidden(false);
/*  530 */     descriptor.setPreferred(true);
/*  531 */     descriptor.setValue("type", Map.class);
/*  532 */     descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/*  533 */     list.add(descriptor);
/*      */     
/*  535 */     return list.iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<String> getCommonPropertyType(ELContext context, Object base) {
/*  550 */     if (base == null) {
/*  551 */       return String.class;
/*      */     }
/*  553 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class ImplicitObjects
/*      */   {
/*      */     static final String sAttributeName = "org.apache.taglibs.standard.ImplicitObjects";
/*      */ 
/*      */ 
/*      */     
/*      */     PageContext mContext;
/*      */ 
/*      */ 
/*      */     
/*      */     Map<String, Object> mPage;
/*      */ 
/*      */     
/*      */     Map<String, Object> mRequest;
/*      */ 
/*      */     
/*      */     Map<String, Object> mSession;
/*      */ 
/*      */     
/*      */     Map<String, Object> mApplication;
/*      */ 
/*      */     
/*      */     Map<String, String> mParam;
/*      */ 
/*      */     
/*      */     Map<String, String[]> mParams;
/*      */ 
/*      */     
/*      */     Map<String, String> mHeader;
/*      */ 
/*      */     
/*      */     Map<String, String[]> mHeaders;
/*      */ 
/*      */     
/*      */     Map<String, String> mInitParam;
/*      */ 
/*      */     
/*      */     Map<String, Cookie> mCookie;
/*      */ 
/*      */ 
/*      */     
/*      */     public ImplicitObjects(PageContext pContext) {
/*  601 */       this.mContext = pContext;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ImplicitObjects getImplicitObjects(PageContext pContext) {
/*  612 */       ImplicitObjects objs = (ImplicitObjects)pContext.getAttribute("org.apache.taglibs.standard.ImplicitObjects", 1);
/*      */ 
/*      */ 
/*      */       
/*  616 */       if (objs == null) {
/*  617 */         objs = new ImplicitObjects(pContext);
/*  618 */         pContext.setAttribute("org.apache.taglibs.standard.ImplicitObjects", objs, 1);
/*      */       } 
/*      */ 
/*      */       
/*  622 */       return objs;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Object> getPageScopeMap() {
/*  632 */       if (this.mPage == null) {
/*  633 */         this.mPage = createPageScopeMap(this.mContext);
/*      */       }
/*  635 */       return this.mPage;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Object> getRequestScopeMap() {
/*  645 */       if (this.mRequest == null) {
/*  646 */         this.mRequest = createRequestScopeMap(this.mContext);
/*      */       }
/*  648 */       return this.mRequest;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Object> getSessionScopeMap() {
/*  658 */       if (this.mSession == null) {
/*  659 */         this.mSession = createSessionScopeMap(this.mContext);
/*      */       }
/*  661 */       return this.mSession;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Object> getApplicationScopeMap() {
/*  671 */       if (this.mApplication == null) {
/*  672 */         this.mApplication = createApplicationScopeMap(this.mContext);
/*      */       }
/*  674 */       return this.mApplication;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, String> getParamMap() {
/*  685 */       if (this.mParam == null) {
/*  686 */         this.mParam = createParamMap(this.mContext);
/*      */       }
/*  688 */       return this.mParam;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, String[]> getParamsMap() {
/*  699 */       if (this.mParams == null) {
/*  700 */         this.mParams = createParamsMap(this.mContext);
/*      */       }
/*  702 */       return this.mParams;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, String> getHeaderMap() {
/*  713 */       if (this.mHeader == null) {
/*  714 */         this.mHeader = createHeaderMap(this.mContext);
/*      */       }
/*  716 */       return this.mHeader;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, String[]> getHeadersMap() {
/*  727 */       if (this.mHeaders == null) {
/*  728 */         this.mHeaders = createHeadersMap(this.mContext);
/*      */       }
/*  730 */       return this.mHeaders;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, String> getInitParamMap() {
/*  741 */       if (this.mInitParam == null) {
/*  742 */         this.mInitParam = createInitParamMap(this.mContext);
/*      */       }
/*  744 */       return this.mInitParam;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Cookie> getCookieMap() {
/*  755 */       if (this.mCookie == null) {
/*  756 */         this.mCookie = createCookieMap(this.mContext);
/*      */       }
/*  758 */       return this.mCookie;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, Object> createPageScopeMap(PageContext pContext) {
/*  770 */       final PageContext context = pContext;
/*  771 */       return new ImplicitObjectELResolver.EnumeratedMap<String, Object>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  775 */             return context.getAttributeNamesInScope(1);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getValue(Object pKey) {
/*  781 */             if (pKey instanceof String) {
/*  782 */               return context.getAttribute((String)pKey, 1);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  787 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/*  793 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, Object> createRequestScopeMap(PageContext pContext) {
/*  805 */       final PageContext context = pContext;
/*  806 */       return new ImplicitObjectELResolver.EnumeratedMap<String, Object>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  810 */             return context.getAttributeNamesInScope(2);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getValue(Object pKey) {
/*  816 */             if (pKey instanceof String) {
/*  817 */               return context.getAttribute((String)pKey, 2);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  822 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/*  828 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, Object> createSessionScopeMap(PageContext pContext) {
/*  840 */       final PageContext context = pContext;
/*  841 */       return new ImplicitObjectELResolver.EnumeratedMap<String, Object>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  845 */             return context.getAttributeNamesInScope(3);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getValue(Object pKey) {
/*  851 */             if (pKey instanceof String) {
/*  852 */               return context.getAttribute((String)pKey, 3);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  857 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/*  863 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, Object> createApplicationScopeMap(PageContext pContext) {
/*  875 */       final PageContext context = pContext;
/*  876 */       return new ImplicitObjectELResolver.EnumeratedMap<String, Object>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  880 */             return context.getAttributeNamesInScope(4);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getValue(Object pKey) {
/*  886 */             if (pKey instanceof String) {
/*  887 */               return context.getAttribute((String)pKey, 4);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  892 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/*  898 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, String> createParamMap(PageContext pContext) {
/*  911 */       final HttpServletRequest request = (HttpServletRequest)pContext.getRequest();
/*      */       
/*  913 */       return new ImplicitObjectELResolver.EnumeratedMap<String, String>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  917 */             return request.getParameterNames();
/*      */           }
/*      */ 
/*      */           
/*      */           public String getValue(Object pKey) {
/*  922 */             if (pKey instanceof String) {
/*  923 */               return request.getParameter((String)pKey);
/*      */             }
/*      */             
/*  926 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/*  932 */             return false;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, String[]> createParamsMap(PageContext pContext) {
/*  945 */       final HttpServletRequest request = (HttpServletRequest)pContext.getRequest();
/*      */       
/*  947 */       return (Map<String, String[]>)new ImplicitObjectELResolver.EnumeratedMap<String, String[]>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  951 */             return request.getParameterNames();
/*      */           }
/*      */ 
/*      */           
/*      */           public String[] getValue(Object pKey) {
/*  956 */             if (pKey instanceof String) {
/*  957 */               return request.getParameterValues((String)pKey);
/*      */             }
/*      */             
/*  960 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/*  966 */             return false;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, String> createHeaderMap(PageContext pContext) {
/*  979 */       final HttpServletRequest request = (HttpServletRequest)pContext.getRequest();
/*      */       
/*  981 */       return new ImplicitObjectELResolver.EnumeratedMap<String, String>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/*  985 */             return request.getHeaderNames();
/*      */           }
/*      */ 
/*      */           
/*      */           public String getValue(Object pKey) {
/*  990 */             if (pKey instanceof String) {
/*  991 */               return request.getHeader((String)pKey);
/*      */             }
/*      */             
/*  994 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/* 1000 */             return false;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, String[]> createHeadersMap(PageContext pContext) {
/* 1013 */       final HttpServletRequest request = (HttpServletRequest)pContext.getRequest();
/*      */       
/* 1015 */       return (Map<String, String[]>)new ImplicitObjectELResolver.EnumeratedMap<String, String[]>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/* 1019 */             return request.getHeaderNames();
/*      */           }
/*      */ 
/*      */           
/*      */           public String[] getValue(Object pKey) {
/* 1024 */             if (pKey instanceof String) {
/*      */               
/* 1026 */               List<String> l = new ArrayList<>();
/* 1027 */               Enumeration<String> e = request.getHeaders((String)pKey);
/* 1028 */               if (e != null) {
/* 1029 */                 while (e.hasMoreElements()) {
/* 1030 */                   l.add(e.nextElement());
/*      */                 }
/*      */               }
/* 1033 */               return l.<String>toArray(new String[l.size()]);
/*      */             } 
/*      */             
/* 1036 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/* 1042 */             return false;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, String> createInitParamMap(PageContext pContext) {
/* 1055 */       final ServletContext context = pContext.getServletContext();
/* 1056 */       return new ImplicitObjectELResolver.EnumeratedMap<String, String>()
/*      */         {
/*      */           public Enumeration<String> enumerateKeys()
/*      */           {
/* 1060 */             return context.getInitParameterNames();
/*      */           }
/*      */ 
/*      */           
/*      */           public String getValue(Object pKey) {
/* 1065 */             if (pKey instanceof String) {
/* 1066 */               return context.getInitParameter((String)pKey);
/*      */             }
/*      */             
/* 1069 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isMutable() {
/* 1075 */             return false;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, Cookie> createCookieMap(PageContext pContext) {
/* 1089 */       HttpServletRequest request = (HttpServletRequest)pContext.getRequest();
/* 1090 */       Cookie[] cookies = request.getCookies();
/* 1091 */       Map<String, Cookie> ret = new HashMap<>();
/* 1092 */       for (int i = 0; cookies != null && i < cookies.length; i++) {
/* 1093 */         Cookie cookie = cookies[i];
/* 1094 */         if (cookie != null) {
/* 1095 */           String name = cookie.getName();
/* 1096 */           if (!ret.containsKey(name)) {
/* 1097 */             ret.put(name, cookie);
/*      */           }
/*      */         } 
/*      */       } 
/* 1101 */       return ret;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static abstract class EnumeratedMap<K, V>
/*      */     implements Map<K, V>
/*      */   {
/*      */     Map<K, V> mMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private EnumeratedMap() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1134 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object pKey) {
/* 1140 */       return (getValue(pKey) != null);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsValue(Object pValue) {
/* 1146 */       return getAsMap().containsValue(pValue);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<Map.Entry<K, V>> entrySet() {
/* 1152 */       return getAsMap().entrySet();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public V get(Object pKey) {
/* 1158 */       return getValue(pKey);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 1164 */       return !enumerateKeys().hasMoreElements();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<K> keySet() {
/* 1170 */       return getAsMap().keySet();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public V put(K pKey, V pValue) {
/* 1176 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void putAll(Map<? extends K, ? extends V> pMap) {
/* 1182 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public V remove(Object pKey) {
/* 1188 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/* 1194 */       return getAsMap().size();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Collection<V> values() {
/* 1200 */       return getAsMap().values();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<K, V> getAsMap() {
/* 1235 */       if (this.mMap != null) {
/* 1236 */         return this.mMap;
/*      */       }
/*      */       
/* 1239 */       Map<K, V> m = convertToMap();
/* 1240 */       if (!isMutable()) {
/* 1241 */         this.mMap = m;
/*      */       }
/* 1243 */       return m;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Map<K, V> convertToMap() {
/* 1254 */       Map<K, V> ret = new HashMap<>();
/* 1255 */       for (Enumeration<K> e = enumerateKeys(); e.hasMoreElements(); ) {
/* 1256 */         K key = e.nextElement();
/* 1257 */         V value = getValue(key);
/* 1258 */         ret.put(key, value);
/*      */       } 
/* 1260 */       return ret;
/*      */     }
/*      */     
/*      */     public abstract Enumeration<K> enumerateKeys();
/*      */     
/*      */     public abstract boolean isMutable();
/*      */     
/*      */     public abstract V getValue(Object param1Object);
/*      */   }
/*      */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/el/ImplicitObjectELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */