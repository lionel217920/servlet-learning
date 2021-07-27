/*     */ package javax.el;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ELUtil
/*     */ {
/*  63 */   public static ExpressionFactory exprFactory = ExpressionFactory.newInstance();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private static ThreadLocal<Map<String, ResourceBundle>> instance = new ThreadLocal<Map<String, ResourceBundle>>()
/*     */     {
/*     */       protected Map<String, ResourceBundle> initialValue() {
/*  74 */         return null;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, ResourceBundle> getCurrentInstance() {
/*  86 */     Map<String, ResourceBundle> result = instance.get();
/*  87 */     if (null == result) {
/*  88 */       result = new HashMap<>();
/*  89 */       setCurrentInstance(result);
/*     */     } 
/*  91 */     return result;
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
/*     */   private static void setCurrentInstance(Map<String, ResourceBundle> context) {
/* 103 */     instance.set(context);
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
/*     */   public static String getExceptionMessageString(ELContext context, String messageId) {
/* 121 */     return getExceptionMessageString(context, messageId, null);
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
/*     */   public static String getExceptionMessageString(ELContext context, String messageId, Object[] params) {
/* 152 */     String result = "";
/* 153 */     Locale locale = null;
/*     */     
/* 155 */     if (null == context || null == messageId) {
/* 156 */       return result;
/*     */     }
/*     */     
/* 159 */     if (null == (locale = context.getLocale())) {
/* 160 */       locale = Locale.getDefault();
/*     */     }
/* 162 */     if (null != locale) {
/* 163 */       Map<String, ResourceBundle> threadMap = getCurrentInstance();
/* 164 */       ResourceBundle rb = null;
/* 165 */       if (null == (rb = threadMap.get(locale.toString()))) {
/*     */         
/* 167 */         rb = ResourceBundle.getBundle("javax.el.PrivateMessages", locale);
/*     */         
/* 169 */         threadMap.put(locale.toString(), rb);
/*     */       } 
/* 171 */       if (null != rb) {
/*     */         try {
/* 173 */           result = rb.getString(messageId);
/* 174 */           if (null != params) {
/* 175 */             result = MessageFormat.format(result, params);
/*     */           }
/* 177 */         } catch (IllegalArgumentException iae) {
/* 178 */           result = "Can't get localized message: parameters to message appear to be incorrect.  Message to format: " + messageId;
/* 179 */         } catch (MissingResourceException mre) {
/* 180 */           result = "Missing Resource in EL implementation: ???" + messageId + "???";
/* 181 */         } catch (Exception e) {
/* 182 */           result = "Exception resolving message in EL implementation: ???" + messageId + "???";
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 187 */     return result;
/*     */   }
/*     */   
/*     */   static ExpressionFactory getExpressionFactory() {
/* 191 */     return exprFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static Constructor<?> findConstructor(Class<?> klass, Class<?>[] paramTypes, Object[] params) {
/* 197 */     String methodName = "<init>";
/*     */     
/* 199 */     if (klass == null) {
/* 200 */       throw new MethodNotFoundException("Method not found: " + klass + "." + methodName + "(" + paramString(paramTypes) + ")");
/*     */     }
/*     */ 
/*     */     
/* 204 */     if (paramTypes == null) {
/* 205 */       paramTypes = getTypesFromValues(params);
/*     */     }
/*     */     
/* 208 */     Constructor[] arrayOfConstructor = (Constructor[])klass.getConstructors();
/*     */     
/* 210 */     List<Wrapper> wrappers = Wrapper.wrap((Constructor<?>[])arrayOfConstructor);
/*     */     
/* 212 */     Wrapper result = findWrapper(klass, wrappers, methodName, paramTypes, params);
/*     */ 
/*     */     
/* 215 */     if (result == null) {
/* 216 */       return null;
/*     */     }
/* 218 */     return getConstructor(klass, (Constructor)result.unWrap());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static Object invokeConstructor(ELContext context, Constructor<?> c, Object[] params) {
/* 224 */     Object[] parameters = buildParameters(context, c.getParameterTypes(), c.isVarArgs(), params);
/*     */     
/*     */     try {
/* 227 */       return c.newInstance(parameters);
/* 228 */     } catch (IllegalAccessException iae) {
/* 229 */       throw new ELException(iae);
/* 230 */     } catch (IllegalArgumentException iae) {
/* 231 */       throw new ELException(iae);
/* 232 */     } catch (InvocationTargetException ite) {
/* 233 */       throw new ELException(ite.getCause());
/* 234 */     } catch (InstantiationException ie) {
/* 235 */       throw new ELException(ie.getCause());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Method findMethod(Class<?> klass, String method, Class<?>[] paramTypes, Object[] params, boolean staticOnly) {
/* 244 */     Method m = findMethod(klass, method, paramTypes, params);
/* 245 */     if (staticOnly && !Modifier.isStatic(m.getModifiers())) {
/* 246 */       throw new MethodNotFoundException("Method " + method + "for class " + klass + " not found or accessible");
/*     */     }
/*     */ 
/*     */     
/* 250 */     return m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object invokeMethod(ELContext context, Method m, Object base, Object[] params) {
/* 260 */     Object[] parameters = buildParameters(context, m.getParameterTypes(), m.isVarArgs(), params);
/*     */     
/*     */     try {
/* 263 */       return m.invoke(base, parameters);
/* 264 */     } catch (IllegalAccessException iae) {
/* 265 */       throw new ELException(iae);
/* 266 */     } catch (IllegalArgumentException iae) {
/* 267 */       throw new ELException(iae);
/* 268 */     } catch (InvocationTargetException ite) {
/* 269 */       throw new ELException(ite.getCause());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Method findMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes, Object[] paramValues) {
/* 280 */     if (clazz == null || methodName == null) {
/* 281 */       throw new MethodNotFoundException("Method not found: " + clazz + "." + methodName + "(" + paramString(paramTypes) + ")");
/*     */     }
/*     */ 
/*     */     
/* 285 */     if (paramTypes == null) {
/* 286 */       paramTypes = getTypesFromValues(paramValues);
/*     */     }
/*     */     
/* 289 */     Method[] methods = clazz.getMethods();
/*     */     
/* 291 */     List<Wrapper> wrappers = Wrapper.wrap(methods, methodName);
/*     */     
/* 293 */     Wrapper result = findWrapper(clazz, wrappers, methodName, paramTypes, paramValues);
/*     */ 
/*     */     
/* 296 */     if (result == null) {
/* 297 */       return null;
/*     */     }
/* 299 */     return getMethod(clazz, (Method)result.unWrap());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Wrapper findWrapper(Class<?> clazz, List<Wrapper> wrappers, String name, Class<?>[] paramTypes, Object[] paramValues) {
/*     */     int paramCount;
/* 309 */     List<Wrapper> assignableCandidates = new ArrayList<>();
/* 310 */     List<Wrapper> coercibleCandidates = new ArrayList<>();
/* 311 */     List<Wrapper> varArgsCandidates = new ArrayList<>();
/*     */ 
/*     */     
/* 314 */     if (paramTypes == null) {
/* 315 */       paramCount = 0;
/*     */     } else {
/* 317 */       paramCount = paramTypes.length;
/*     */     } 
/*     */     
/* 320 */     for (Wrapper w : wrappers) {
/* 321 */       int mParamCount; Class<?>[] mParamTypes = w.getParameterTypes();
/*     */       
/* 323 */       if (mParamTypes == null) {
/* 324 */         mParamCount = 0;
/*     */       } else {
/* 326 */         mParamCount = mParamTypes.length;
/*     */       } 
/*     */ 
/*     */       
/* 330 */       if (paramCount != mParamCount && (!w.isVarArgs() || paramCount < mParamCount - 1)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 337 */       boolean assignable = false;
/* 338 */       boolean coercible = false;
/* 339 */       boolean varArgs = false;
/* 340 */       boolean noMatch = false;
/* 341 */       for (int i = 0; i < mParamCount; i++) {
/* 342 */         if (i == mParamCount - 1 && w.isVarArgs()) {
/* 343 */           varArgs = true;
/*     */           
/* 345 */           if (mParamCount != paramCount || 
/* 346 */             mParamTypes[i] != paramTypes[i]) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 352 */             Class<?> varType = mParamTypes[i].getComponentType();
/* 353 */             for (int j = i; j < paramCount; j++) {
/* 354 */               if (!isAssignableFrom(paramTypes[j], varType) && (paramValues == null || j >= paramValues.length || !isCoercibleFrom(paramValues[j], varType))) {
/*     */                 
/* 356 */                 noMatch = true; break;
/*     */               } 
/*     */             } 
/*     */           } 
/* 360 */         } else if (!mParamTypes[i].equals(paramTypes[i])) {
/* 361 */           if (isAssignableFrom(paramTypes[i], mParamTypes[i])) {
/* 362 */             assignable = true;
/*     */           } else {
/* 364 */             if (paramValues == null || i >= paramValues.length) {
/* 365 */               noMatch = true;
/*     */               break;
/*     */             } 
/* 368 */             if (isCoercibleFrom(paramValues[i], mParamTypes[i])) {
/* 369 */               coercible = true;
/*     */             } else {
/* 371 */               noMatch = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 377 */       if (noMatch) {
/*     */         continue;
/*     */       }
/*     */       
/* 381 */       if (varArgs) {
/* 382 */         varArgsCandidates.add(w); continue;
/* 383 */       }  if (coercible) {
/* 384 */         coercibleCandidates.add(w); continue;
/* 385 */       }  if (assignable) {
/* 386 */         assignableCandidates.add(w);
/*     */         
/*     */         continue;
/*     */       } 
/* 390 */       return w;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 395 */     String errorMsg = "Unable to find unambiguous method: " + clazz + "." + name + "(" + paramString(paramTypes) + ")";
/*     */     
/* 397 */     if (!assignableCandidates.isEmpty())
/* 398 */       return findMostSpecificWrapper(assignableCandidates, paramTypes, false, errorMsg); 
/* 399 */     if (!coercibleCandidates.isEmpty())
/* 400 */       return findMostSpecificWrapper(coercibleCandidates, paramTypes, true, errorMsg); 
/* 401 */     if (!varArgsCandidates.isEmpty()) {
/* 402 */       return findMostSpecificWrapper(varArgsCandidates, paramTypes, true, errorMsg);
/*     */     }
/* 404 */     throw new MethodNotFoundException("Method not found: " + clazz + "." + name + "(" + paramString(paramTypes) + ")");
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
/*     */   private static Wrapper findMostSpecificWrapper(List<Wrapper> candidates, Class<?>[] matchingTypes, boolean elSpecific, String errorMsg) {
/* 416 */     List<Wrapper> ambiguouses = new ArrayList<>();
/* 417 */     for (Wrapper candidate : candidates) {
/* 418 */       boolean lessSpecific = false;
/*     */       
/* 420 */       Iterator<Wrapper> it = ambiguouses.iterator();
/* 421 */       while (it.hasNext()) {
/* 422 */         int result = isMoreSpecific(candidate, it.next(), matchingTypes, elSpecific);
/* 423 */         if (result == 1) {
/* 424 */           it.remove(); continue;
/* 425 */         }  if (result == -1) {
/* 426 */           lessSpecific = true;
/*     */         }
/*     */       } 
/*     */       
/* 430 */       if (!lessSpecific) {
/* 431 */         ambiguouses.add(candidate);
/*     */       }
/*     */     } 
/*     */     
/* 435 */     if (ambiguouses.size() > 1) {
/* 436 */       throw new MethodNotFoundException(errorMsg);
/*     */     }
/*     */     
/* 439 */     return ambiguouses.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int isMoreSpecific(Wrapper wrapper1, Wrapper wrapper2, Class<?>[] matchingTypes, boolean elSpecific) {
/* 448 */     Class<?>[] paramTypes1 = wrapper1.getParameterTypes();
/* 449 */     Class<?>[] paramTypes2 = wrapper2.getParameterTypes();
/*     */     
/* 451 */     if (wrapper1.isVarArgs()) {
/*     */       
/* 453 */       int length = Math.max(Math.max(paramTypes1.length, paramTypes2.length), matchingTypes.length);
/* 454 */       paramTypes1 = getComparingParamTypesForVarArgsMethod(paramTypes1, length);
/* 455 */       paramTypes2 = getComparingParamTypesForVarArgsMethod(paramTypes2, length);
/*     */       
/* 457 */       if (length > matchingTypes.length) {
/* 458 */         Class<?>[] matchingTypes2 = new Class[length];
/* 459 */         System.arraycopy(matchingTypes, 0, matchingTypes2, 0, matchingTypes.length);
/* 460 */         matchingTypes = matchingTypes2;
/*     */       } 
/*     */     } 
/*     */     
/* 464 */     int result = 0;
/* 465 */     for (int i = 0; i < paramTypes1.length; i++) {
/* 466 */       if (paramTypes1[i] != paramTypes2[i]) {
/* 467 */         int r2 = isMoreSpecific(paramTypes1[i], paramTypes2[i], matchingTypes[i], elSpecific);
/* 468 */         if (r2 == 1) {
/* 469 */           if (result == -1) {
/* 470 */             return 0;
/*     */           }
/* 472 */           result = 1;
/* 473 */         } else if (r2 == -1) {
/* 474 */           if (result == 1) {
/* 475 */             return 0;
/*     */           }
/* 477 */           result = -1;
/*     */         } else {
/* 479 */           return 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 484 */     if (result == 0)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 489 */       result = Boolean.compare(wrapper1.isBridge(), wrapper2.isBridge());
/*     */     }
/*     */     
/* 492 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int isMoreSpecific(Class<?> type1, Class<?> type2, Class<?> matchingType, boolean elSpecific) {
/* 500 */     type1 = getBoxingTypeIfPrimitive(type1);
/* 501 */     type2 = getBoxingTypeIfPrimitive(type2);
/* 502 */     if (type2.isAssignableFrom(type1))
/* 503 */       return 1; 
/* 504 */     if (type1.isAssignableFrom(type2)) {
/* 505 */       return -1;
/*     */     }
/* 507 */     if (elSpecific) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 515 */       if (matchingType != null && Number.class.isAssignableFrom(matchingType)) {
/* 516 */         boolean b1 = (Number.class.isAssignableFrom(type1) || type1.isPrimitive());
/* 517 */         boolean b2 = (Number.class.isAssignableFrom(type2) || type2.isPrimitive());
/* 518 */         if (b1 && !b2)
/* 519 */           return 1; 
/* 520 */         if (b2 && !b1) {
/* 521 */           return -1;
/*     */         }
/* 523 */         return 0;
/*     */       } 
/*     */ 
/*     */       
/* 527 */       return 0;
/*     */     } 
/* 529 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?> getBoxingTypeIfPrimitive(Class<?> clazz) {
/* 539 */     if (clazz.isPrimitive()) {
/* 540 */       if (clazz == boolean.class)
/* 541 */         return Boolean.class; 
/* 542 */       if (clazz == char.class)
/* 543 */         return Character.class; 
/* 544 */       if (clazz == byte.class)
/* 545 */         return Byte.class; 
/* 546 */       if (clazz == short.class)
/* 547 */         return Short.class; 
/* 548 */       if (clazz == int.class)
/* 549 */         return Integer.class; 
/* 550 */       if (clazz == long.class)
/* 551 */         return Long.class; 
/* 552 */       if (clazz == float.class) {
/* 553 */         return Float.class;
/*     */       }
/* 555 */       return Double.class;
/*     */     } 
/*     */     
/* 558 */     return clazz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?>[] getComparingParamTypesForVarArgsMethod(Class<?>[] paramTypes, int length) {
/* 568 */     Class<?>[] result = new Class[length];
/* 569 */     System.arraycopy(paramTypes, 0, result, 0, paramTypes.length - 1);
/* 570 */     Class<?> type = paramTypes[paramTypes.length - 1].getComponentType();
/* 571 */     for (int i = paramTypes.length - 1; i < length; i++) {
/* 572 */       result[i] = type;
/*     */     }
/*     */     
/* 575 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String paramString(Class<?>[] types) {
/* 583 */     if (types != null) {
/* 584 */       StringBuilder sb = new StringBuilder();
/* 585 */       for (int i = 0; i < types.length; i++) {
/* 586 */         if (types[i] == null) {
/* 587 */           sb.append("null, ");
/*     */         } else {
/* 589 */           sb.append(types[i].getName()).append(", ");
/*     */         } 
/*     */       } 
/* 592 */       if (sb.length() > 2) {
/* 593 */         sb.setLength(sb.length() - 2);
/*     */       }
/* 595 */       return sb.toString();
/*     */     } 
/* 597 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isAssignableFrom(Class<?> src, Class<?> target) {
/* 608 */     if (src == null) {
/* 609 */       return true;
/*     */     }
/*     */     
/* 612 */     target = getBoxingTypeIfPrimitive(target);
/*     */     
/* 614 */     return target.isAssignableFrom(src);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isCoercibleFrom(Object src, Class<?> target) {
/*     */     try {
/* 626 */       getExpressionFactory().coerceToType(src, target);
/* 627 */     } catch (Exception e) {
/* 628 */       return false;
/*     */     } 
/* 630 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?>[] getTypesFromValues(Object[] values) {
/* 638 */     if (values == null) {
/* 639 */       return null;
/*     */     }
/*     */     
/* 642 */     Class<?>[] result = new Class[values.length];
/* 643 */     for (int i = 0; i < values.length; i++) {
/* 644 */       if (values[i] == null) {
/* 645 */         result[i] = null;
/*     */       } else {
/* 647 */         result[i] = values[i].getClass();
/*     */       } 
/*     */     } 
/* 650 */     return result;
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
/*     */   static Method getMethod(Class<?> type, Method m) {
/* 666 */     if (m == null || Modifier.isPublic(type.getModifiers())) {
/* 667 */       return m;
/*     */     }
/* 669 */     Class<?>[] inf = type.getInterfaces();
/* 670 */     Method mp = null;
/* 671 */     for (int i = 0; i < inf.length; i++) {
/*     */       try {
/* 673 */         mp = inf[i].getMethod(m.getName(), m.getParameterTypes());
/* 674 */         mp = getMethod(mp.getDeclaringClass(), mp);
/* 675 */         if (mp != null) {
/* 676 */           return mp;
/*     */         }
/* 678 */       } catch (NoSuchMethodException noSuchMethodException) {}
/*     */     } 
/*     */ 
/*     */     
/* 682 */     Class<?> sup = type.getSuperclass();
/* 683 */     if (sup != null) {
/*     */       try {
/* 685 */         mp = sup.getMethod(m.getName(), m.getParameterTypes());
/* 686 */         mp = getMethod(mp.getDeclaringClass(), mp);
/* 687 */         if (mp != null) {
/* 688 */           return mp;
/*     */         }
/* 690 */       } catch (NoSuchMethodException noSuchMethodException) {}
/*     */     }
/*     */ 
/*     */     
/* 694 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Constructor<?> getConstructor(Class<?> type, Constructor<?> c) {
/* 702 */     if (c == null || Modifier.isPublic(type.getModifiers())) {
/* 703 */       return c;
/*     */     }
/* 705 */     Constructor<?> cp = null;
/* 706 */     Class<?> sup = type.getSuperclass();
/* 707 */     if (sup != null) {
/*     */       try {
/* 709 */         cp = sup.getConstructor(c.getParameterTypes());
/* 710 */         cp = getConstructor(cp.getDeclaringClass(), cp);
/* 711 */         if (cp != null) {
/* 712 */           return cp;
/*     */         }
/* 714 */       } catch (NoSuchMethodException noSuchMethodException) {}
/*     */     }
/*     */ 
/*     */     
/* 718 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object[] buildParameters(ELContext context, Class<?>[] parameterTypes, boolean isVarArgs, Object[] params) {
/* 727 */     Object[] parameters = null;
/* 728 */     if (parameterTypes.length > 0) {
/* 729 */       parameters = new Object[parameterTypes.length];
/* 730 */       int paramCount = (params == null) ? 0 : params.length;
/* 731 */       if (isVarArgs) {
/* 732 */         int varArgIndex = parameterTypes.length - 1;
/*     */         
/* 734 */         for (int i = 0; i < varArgIndex && i < paramCount; i++) {
/* 735 */           parameters[i] = context.convertToType(params[i], parameterTypes[i]);
/*     */         }
/*     */ 
/*     */         
/* 739 */         if (parameterTypes.length == paramCount && parameterTypes[varArgIndex] == params[varArgIndex].getClass()) {
/*     */           
/* 741 */           parameters[varArgIndex] = params[varArgIndex];
/*     */         } else {
/* 743 */           Class<?> varArgClass = parameterTypes[varArgIndex].getComponentType();
/*     */           
/* 745 */           Object varargs = Array.newInstance(varArgClass, paramCount - varArgIndex);
/*     */ 
/*     */           
/* 748 */           for (int j = varArgIndex; j < paramCount; j++) {
/* 749 */             Array.set(varargs, j - varArgIndex, context.convertToType(params[j], varArgClass));
/*     */           }
/*     */           
/* 752 */           parameters[varArgIndex] = varargs;
/*     */         } 
/*     */       } else {
/* 755 */         for (int i = 0; i < parameterTypes.length && i < paramCount; i++) {
/* 756 */           parameters[i] = context.convertToType(params[i], parameterTypes[i]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 761 */     return parameters;
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class Wrapper
/*     */   {
/*     */     private Wrapper() {}
/*     */ 
/*     */     
/*     */     public static List<Wrapper> wrap(Method[] methods, String name) {
/* 771 */       List<Wrapper> result = new ArrayList<>();
/* 772 */       for (Method method : methods) {
/* 773 */         if (method.getName().equals(name)) {
/* 774 */           result.add(new ELUtil.MethodWrapper(method));
/*     */         }
/*     */       } 
/* 777 */       return result;
/*     */     }
/*     */     
/*     */     public static List<Wrapper> wrap(Constructor<?>[] constructors) {
/* 781 */       List<Wrapper> result = new ArrayList<>();
/* 782 */       for (Constructor<?> constructor : constructors) {
/* 783 */         result.add(new ELUtil.ConstructorWrapper(constructor));
/*     */       }
/* 785 */       return result;
/*     */     }
/*     */     
/*     */     public abstract Object unWrap();
/*     */     
/*     */     public abstract Class<?>[] getParameterTypes();
/*     */     
/*     */     public abstract boolean isVarArgs();
/*     */     
/*     */     public abstract boolean isBridge();
/*     */   }
/*     */   
/*     */   private static class MethodWrapper
/*     */     extends Wrapper {
/*     */     private final Method m;
/*     */     
/*     */     public MethodWrapper(Method m) {
/* 802 */       this.m = m;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object unWrap() {
/* 807 */       return this.m;
/*     */     }
/*     */ 
/*     */     
/*     */     public Class<?>[] getParameterTypes() {
/* 812 */       return this.m.getParameterTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isVarArgs() {
/* 817 */       return this.m.isVarArgs();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isBridge() {
/* 822 */       return this.m.isBridge();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ConstructorWrapper
/*     */     extends Wrapper
/*     */   {
/*     */     private final Constructor<?> c;
/*     */ 
/*     */     
/*     */     public ConstructorWrapper(Constructor<?> c) {
/* 834 */       this.c = c;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object unWrap() {
/* 839 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public Class<?>[] getParameterTypes() {
/* 844 */       return this.c.getParameterTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isVarArgs() {
/* 849 */       return this.c.isVarArgs();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isBridge() {
/* 854 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ELUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */