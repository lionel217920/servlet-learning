/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompositeELResolver
/*     */   extends ELResolver
/*     */ {
/*  60 */   private int size = 0;
/*  61 */   private ELResolver[] elResolvers = new ELResolver[16];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(ELResolver elResolver) {
/*  75 */     if (elResolver == null) {
/*  76 */       throw new NullPointerException();
/*     */     }
/*     */     
/*  79 */     if (this.size >= this.elResolvers.length) {
/*  80 */       ELResolver[] newResolvers = new ELResolver[this.size * 2];
/*  81 */       System.arraycopy(this.elResolvers, 0, newResolvers, 0, this.size);
/*  82 */       this.elResolvers = newResolvers;
/*     */     } 
/*     */     
/*  85 */     this.elResolvers[this.size++] = elResolver;
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
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/* 143 */     context.setPropertyResolved(false);
/*     */     
/* 145 */     Object value = null;
/* 146 */     for (int i = 0; i < this.size; i++) {
/* 147 */       value = this.elResolvers[i].getValue(context, base, property);
/* 148 */       if (context.isPropertyResolved()) {
/* 149 */         return value;
/*     */       }
/*     */     } 
/* 152 */     return null;
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
/*     */   public Object invoke(ELContext context, Object base, Object method, Class<?>[] paramTypes, Object[] params) {
/* 211 */     context.setPropertyResolved(false);
/*     */ 
/*     */     
/* 214 */     for (int i = 0; i < this.size; i++) {
/* 215 */       Object value = this.elResolvers[i].invoke(context, base, method, paramTypes, params);
/*     */       
/* 217 */       if (context.isPropertyResolved()) {
/* 218 */         return value;
/*     */       }
/*     */     } 
/* 221 */     return null;
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
/*     */   public Class<?> getType(ELContext context, Object base, Object property) {
/* 282 */     context.setPropertyResolved(false);
/*     */ 
/*     */     
/* 285 */     for (int i = 0; i < this.size; i++) {
/* 286 */       Class<?> type = this.elResolvers[i].getType(context, base, property);
/* 287 */       if (context.isPropertyResolved()) {
/* 288 */         return type;
/*     */       }
/*     */     } 
/* 291 */     return null;
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
/*     */   public void setValue(ELContext context, Object base, Object property, Object val) {
/* 349 */     context.setPropertyResolved(false);
/*     */     
/* 351 */     for (int i = 0; i < this.size; i++) {
/* 352 */       this.elResolvers[i].setValue(context, base, property, val);
/* 353 */       if (context.isPropertyResolved()) {
/*     */         return;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/* 416 */     context.setPropertyResolved(false);
/*     */ 
/*     */     
/* 419 */     for (int i = 0; i < this.size; i++) {
/* 420 */       boolean readOnly = this.elResolvers[i].isReadOnly(context, base, property);
/* 421 */       if (context.isPropertyResolved()) {
/* 422 */         return readOnly;
/*     */       }
/*     */     } 
/* 425 */     return false;
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 457 */     return new CompositeIterator(this.elResolvers, this.size, context, base);
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
/*     */   public Class<?> getCommonPropertyType(ELContext context, Object base) {
/* 483 */     Class<?> commonPropertyType = null;
/* 484 */     for (int i = 0; i < this.size; i++) {
/*     */       
/* 486 */       Class<?> type = this.elResolvers[i].getCommonPropertyType(context, base);
/* 487 */       if (type != null)
/*     */       {
/*     */         
/* 490 */         if (commonPropertyType == null) {
/* 491 */           commonPropertyType = type;
/* 492 */         } else if (!commonPropertyType.isAssignableFrom(type)) {
/*     */           
/* 494 */           if (type.isAssignableFrom(commonPropertyType)) {
/* 495 */             commonPropertyType = type;
/*     */           } else {
/*     */             
/* 498 */             return null;
/*     */           } 
/*     */         }  } 
/* 501 */     }  return commonPropertyType;
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
/*     */   public Object convertToType(ELContext context, Object obj, Class<?> targetType) {
/* 522 */     context.setPropertyResolved(false);
/*     */     
/* 524 */     Object value = null;
/* 525 */     for (int i = 0; i < this.size; i++) {
/* 526 */       value = this.elResolvers[i].convertToType(context, obj, targetType);
/* 527 */       if (context.isPropertyResolved()) {
/* 528 */         return value;
/*     */       }
/*     */     } 
/* 531 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class CompositeIterator
/*     */     implements Iterator<FeatureDescriptor>
/*     */   {
/*     */     ELResolver[] resolvers;
/*     */     
/*     */     int size;
/*     */     
/* 542 */     int index = 0;
/* 543 */     Iterator<FeatureDescriptor> propertyIter = null;
/*     */     
/*     */     ELContext context;
/*     */     
/*     */     Object base;
/*     */ 
/*     */     
/*     */     CompositeIterator(ELResolver[] resolvers, int size, ELContext context, Object base) {
/* 551 */       this.resolvers = resolvers;
/* 552 */       this.size = size;
/* 553 */       this.context = context;
/* 554 */       this.base = base;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 558 */       if (this.propertyIter == null || !this.propertyIter.hasNext()) {
/* 559 */         while (this.index < this.size) {
/* 560 */           ELResolver elResolver = this.resolvers[this.index++];
/* 561 */           this.propertyIter = elResolver.getFeatureDescriptors(this.context, this.base);
/*     */           
/* 563 */           if (this.propertyIter != null) {
/* 564 */             return this.propertyIter.hasNext();
/*     */           }
/*     */         } 
/* 567 */         return false;
/*     */       } 
/* 569 */       return this.propertyIter.hasNext();
/*     */     }
/*     */     
/*     */     public FeatureDescriptor next() {
/* 573 */       if (this.propertyIter == null || !this.propertyIter.hasNext()) {
/* 574 */         while (this.index < this.size) {
/* 575 */           ELResolver elResolver = this.resolvers[this.index++];
/* 576 */           this.propertyIter = elResolver.getFeatureDescriptors(this.context, this.base);
/*     */           
/* 578 */           if (this.propertyIter != null) {
/* 579 */             return this.propertyIter.next();
/*     */           }
/*     */         } 
/* 582 */         return null;
/*     */       } 
/* 584 */       return this.propertyIter.next();
/*     */     }
/*     */     
/*     */     public void remove() {
/* 588 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/CompositeELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */