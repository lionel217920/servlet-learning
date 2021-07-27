/*     */ package javax.servlet.jsp.jstl.fmt;
/*     */ 
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Locale;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import javax.servlet.jsp.jstl.core.Config;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LocaleSupport
/*     */ {
/*     */   private static final String UNDEFINED_KEY = "???";
/*     */   private static final char HYPHEN = '-';
/*     */   private static final char UNDERSCORE = '_';
/*     */   private static final String REQUEST_CHAR_SET = "javax.servlet.jsp.jstl.fmt.request.charset";
/*  50 */   private static final Locale EMPTY_LOCALE = new Locale("", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLocalizedMessage(PageContext pageContext, String key) {
/*  73 */     return getLocalizedMessage(pageContext, key, null, null);
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
/*     */   public static String getLocalizedMessage(PageContext pageContext, String key, String basename) {
/*  96 */     return getLocalizedMessage(pageContext, key, null, basename);
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
/*     */   public static String getLocalizedMessage(PageContext pageContext, String key, Object[] args) {
/* 120 */     return getLocalizedMessage(pageContext, key, args, null);
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
/*     */   public static String getLocalizedMessage(PageContext pageContext, String key, Object[] args, String basename) {
/* 146 */     LocalizationContext locCtxt = null;
/* 147 */     String message = "???" + key + "???";
/*     */     
/* 149 */     if (basename != null) {
/* 150 */       locCtxt = getLocalizationContext(pageContext, basename);
/*     */     } else {
/* 152 */       locCtxt = getLocalizationContext(pageContext);
/*     */     } 
/*     */     
/* 155 */     if (locCtxt != null) {
/* 156 */       ResourceBundle bundle = locCtxt.getResourceBundle();
/* 157 */       if (bundle != null) {
/*     */         try {
/* 159 */           message = bundle.getString(key);
/* 160 */           if (args != null) {
/* 161 */             MessageFormat formatter = new MessageFormat("");
/* 162 */             if (locCtxt.getLocale() != null) {
/* 163 */               formatter.setLocale(locCtxt.getLocale());
/*     */             }
/* 165 */             formatter.applyPattern(message);
/* 166 */             message = formatter.format(args);
/*     */           } 
/* 168 */         } catch (MissingResourceException missingResourceException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 173 */     return message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static LocalizationContext getLocalizationContext(PageContext pc) {
/* 183 */     LocalizationContext locCtxt = null;
/*     */     
/* 185 */     Object obj = Config.find(pc, "javax.servlet.jsp.jstl.fmt.localizationContext");
/* 186 */     if (obj == null) {
/* 187 */       return null;
/*     */     }
/*     */     
/* 190 */     if (obj instanceof LocalizationContext) {
/* 191 */       locCtxt = (LocalizationContext)obj;
/*     */     } else {
/*     */       
/* 194 */       locCtxt = getLocalizationContext(pc, (String)obj);
/*     */     } 
/*     */     
/* 197 */     return locCtxt;
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
/*     */   private static LocalizationContext getLocalizationContext(PageContext pc, String basename) {
/* 226 */     LocalizationContext locCtxt = null;
/* 227 */     ResourceBundle bundle = null;
/*     */     
/* 229 */     if (basename == null || basename.equals("")) {
/* 230 */       return new LocalizationContext();
/*     */     }
/*     */ 
/*     */     
/* 234 */     Locale pref = getLocale(pc, "javax.servlet.jsp.jstl.fmt.locale");
/* 235 */     if (pref != null) {
/*     */       
/* 237 */       bundle = findMatch(basename, pref);
/* 238 */       if (bundle != null) {
/* 239 */         locCtxt = new LocalizationContext(bundle, pref);
/*     */       }
/*     */     } else {
/*     */       
/* 243 */       locCtxt = findMatch(pc, basename);
/*     */     } 
/*     */     
/* 246 */     if (locCtxt == null) {
/*     */       
/* 248 */       pref = getLocale(pc, "javax.servlet.jsp.jstl.fmt.fallbackLocale");
/* 249 */       if (pref != null) {
/* 250 */         bundle = findMatch(basename, pref);
/* 251 */         if (bundle != null) {
/* 252 */           locCtxt = new LocalizationContext(bundle, pref);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     if (locCtxt == null) {
/*     */       
/*     */       try {
/* 260 */         bundle = ResourceBundle.getBundle(basename, EMPTY_LOCALE, Thread.currentThread().getContextClassLoader());
/*     */         
/* 262 */         if (bundle != null) {
/* 263 */           locCtxt = new LocalizationContext(bundle, null);
/*     */         }
/* 265 */       } catch (MissingResourceException missingResourceException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 270 */     if (locCtxt != null) {
/*     */       
/* 272 */       if (locCtxt.getLocale() != null) {
/* 273 */         setResponseLocale(pc, locCtxt.getLocale());
/*     */       }
/*     */     } else {
/*     */       
/* 277 */       locCtxt = new LocalizationContext();
/*     */     } 
/*     */     
/* 280 */     return locCtxt;
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
/*     */   private static LocalizationContext findMatch(PageContext pageContext, String basename) {
/* 298 */     LocalizationContext locCtxt = null;
/*     */ 
/*     */ 
/*     */     
/* 302 */     Enumeration<Locale> enum_ = getRequestLocales((HttpServletRequest)pageContext.getRequest());
/*     */     
/* 304 */     while (enum_.hasMoreElements()) {
/* 305 */       Locale pref = enum_.nextElement();
/* 306 */       ResourceBundle match = findMatch(basename, pref);
/* 307 */       if (match != null) {
/* 308 */         locCtxt = new LocalizationContext(match, pref);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 313 */     return locCtxt;
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
/*     */   private static ResourceBundle findMatch(String basename, Locale pref) {
/* 332 */     ResourceBundle match = null;
/*     */     
/*     */     try {
/* 335 */       ResourceBundle bundle = ResourceBundle.getBundle(basename, pref, Thread.currentThread().getContextClassLoader());
/*     */ 
/*     */       
/* 338 */       Locale avail = bundle.getLocale();
/* 339 */       if (pref.equals(avail))
/*     */       {
/* 341 */         match = bundle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 357 */       else if (pref.getLanguage().equals(avail.getLanguage()) && ("".equals(avail.getCountry()) || pref.getCountry().equals(avail.getCountry())))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 374 */         match = bundle;
/*     */       }
/*     */     
/* 377 */     } catch (MissingResourceException missingResourceException) {}
/*     */ 
/*     */     
/* 380 */     return match;
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
/*     */   private static Locale getLocale(PageContext pageContext, String name) {
/* 402 */     Locale loc = null;
/*     */     
/* 404 */     Object obj = Config.find(pageContext, name);
/* 405 */     if (obj != null) {
/* 406 */       if (obj instanceof Locale) {
/* 407 */         loc = (Locale)obj;
/*     */       } else {
/* 409 */         loc = parseLocale((String)obj);
/*     */       } 
/*     */     }
/*     */     
/* 413 */     return loc;
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
/*     */   private static void setResponseLocale(PageContext pc, Locale locale) {
/* 432 */     ServletResponse response = pc.getResponse();
/* 433 */     response.setLocale(locale);
/*     */ 
/*     */     
/* 436 */     if (pc.getSession() != null) {
/*     */       try {
/* 438 */         pc.setAttribute("javax.servlet.jsp.jstl.fmt.request.charset", response.getCharacterEncoding(), 3);
/*     */       
/*     */       }
/* 441 */       catch (IllegalStateException illegalStateException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Locale parseLocale(String locale) {
/* 449 */     return parseLocale(locale, null);
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
/*     */   private static Locale parseLocale(String locale, String variant) {
/* 472 */     Locale ret = null;
/* 473 */     String language = locale;
/* 474 */     String country = null;
/* 475 */     int index = -1;
/*     */     
/* 477 */     if ((index = locale.indexOf('-')) > -1 || (index = locale.indexOf('_')) > -1) {
/*     */       
/* 479 */       language = locale.substring(0, index);
/* 480 */       country = locale.substring(index + 1);
/*     */     } 
/*     */     
/* 483 */     if (language == null || language.length() == 0) {
/* 484 */       throw new IllegalArgumentException("Missing language component in 'value' attribute in setLocale");
/*     */     }
/*     */ 
/*     */     
/* 488 */     if (country == null)
/* 489 */     { if (variant != null)
/* 490 */       { ret = new Locale(language, "", variant); }
/*     */       else
/* 492 */       { ret = new Locale(language, ""); }  }
/* 493 */     else if (country.length() > 0)
/* 494 */     { if (variant != null) {
/* 495 */         ret = new Locale(language, country, variant);
/*     */       } else {
/* 497 */         ret = new Locale(language, country);
/*     */       }  }
/* 499 */     else { throw new IllegalArgumentException("Empty country component in 'value' attribute in setLocale"); }
/*     */ 
/*     */ 
/*     */     
/* 503 */     return ret;
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
/*     */   private static Enumeration getRequestLocales(HttpServletRequest request) {
/* 516 */     Enumeration values = request.getHeaders("accept-language");
/* 517 */     if (values.hasMoreElements())
/*     */     {
/*     */ 
/*     */       
/* 521 */       return request.getLocales();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 526 */     return values;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/fmt/LocaleSupport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */