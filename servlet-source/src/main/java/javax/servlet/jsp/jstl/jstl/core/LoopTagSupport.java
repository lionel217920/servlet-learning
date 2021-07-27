/*     */ package javax.servlet.jsp.jstl.jstl.core;
/*     */ 
/*     */ import javax.el.ELException;
/*     */ import javax.el.ValueExpression;
/*     */ import javax.el.VariableMapper;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspTagException;
/*     */ import javax.servlet.jsp.tagext.IterationTag;
/*     */ import javax.servlet.jsp.tagext.TagSupport;
/*     */ import javax.servlet.jsp.tagext.TryCatchFinally;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LoopTagSupport
/*     */   extends TagSupport
/*     */   implements LoopTag, IterationTag, TryCatchFinally
/*     */ {
/*     */   protected int begin;
/*     */   protected int end;
/*     */   protected int step;
/*     */   protected boolean beginSpecified;
/*     */   protected boolean endSpecified;
/*     */   protected boolean stepSpecified;
/*     */   protected String itemId;
/*     */   protected String statusId;
/*     */   protected ValueExpression deferredExpression;
/*     */   private ValueExpression oldMappedValue;
/*     */   private LoopTagStatus status;
/*     */   private Object item;
/*     */   private int index;
/*     */   private int count;
/*     */   private boolean last;
/*     */   private IteratedExpression iteratedExpression;
/*     */   
/*     */   public LoopTagSupport() {
/* 167 */     init();
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
/*     */   public void release() {
/* 229 */     super.release();
/* 230 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int doStartTag() throws JspException {
/* 237 */     if (this.end != -1 && this.begin > this.end)
/*     */     {
/* 239 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 243 */     this.index = 0;
/* 244 */     this.count = 1;
/* 245 */     this.last = false;
/* 246 */     this.iteratedExpression = null;
/* 247 */     this.deferredExpression = null;
/*     */ 
/*     */     
/* 250 */     prepare();
/*     */ 
/*     */     
/* 253 */     discardIgnoreSubset(this.begin);
/*     */ 
/*     */     
/* 256 */     if (hasNext()) {
/*     */       
/* 258 */       this.item = next();
/*     */     } else {
/* 260 */       return 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     discard(this.step - 1);
/*     */ 
/*     */     
/* 269 */     exposeVariables(true);
/* 270 */     calibrateLast();
/* 271 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int doAfterBody() throws JspException {
/* 281 */     this.index += this.step - 1;
/*     */ 
/*     */     
/* 284 */     this.count++;
/*     */ 
/*     */     
/* 287 */     if (hasNext() && !atEnd()) {
/* 288 */       this.index++;
/* 289 */       this.item = next();
/*     */     } else {
/* 291 */       return 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     discard(this.step - 1);
/*     */ 
/*     */     
/* 300 */     exposeVariables(false);
/* 301 */     calibrateLast();
/* 302 */     return 2;
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
/*     */   public void doFinally() {
/* 317 */     unExposeVariables();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doCatch(Throwable t) throws Throwable {
/* 324 */     throw t;
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
/*     */   public Object getCurrent() {
/* 344 */     return this.item;
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
/*     */   public LoopTagStatus getLoopStatus() {
/*     */     class Status
/*     */       implements LoopTagStatus
/*     */     {
/*     */       public Object getCurrent() {
/* 372 */         return LoopTagSupport.this.getCurrent();
/*     */       }
/*     */       public int getIndex() {
/* 375 */         return LoopTagSupport.this.index + LoopTagSupport.this.begin;
/*     */       }
/*     */       public int getCount() {
/* 378 */         return LoopTagSupport.this.count;
/*     */       }
/*     */       public boolean isFirst() {
/* 381 */         return (LoopTagSupport.this.index == 0);
/*     */       }
/*     */       public boolean isLast() {
/* 384 */         return LoopTagSupport.this.last;
/*     */       }
/*     */       public Integer getBegin() {
/* 387 */         if (LoopTagSupport.this.beginSpecified) {
/* 388 */           return Integer.valueOf(LoopTagSupport.this.begin);
/*     */         }
/* 390 */         return null;
/*     */       }
/*     */       public Integer getEnd() {
/* 393 */         if (LoopTagSupport.this.endSpecified) {
/* 394 */           return Integer.valueOf(LoopTagSupport.this.end);
/*     */         }
/* 396 */         return null;
/*     */       }
/*     */       public Integer getStep() {
/* 399 */         if (LoopTagSupport.this.stepSpecified) {
/* 400 */           return Integer.valueOf(LoopTagSupport.this.step);
/*     */         }
/* 402 */         return null;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 411 */     if (this.status == null) {
/* 412 */       this.status = new Status();
/*     */     }
/* 414 */     return this.status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDelims() {
/* 422 */     return ",";
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
/*     */   public void setVar(String id) {
/* 443 */     this.itemId = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVarStatus(String statusId) {
/* 453 */     this.statusId = statusId;
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
/*     */   protected void validateBegin() throws JspTagException {
/* 471 */     if (this.begin < 0) {
/* 472 */       throw new JspTagException("'begin' < 0");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validateEnd() throws JspTagException {
/* 480 */     if (this.end < 0) {
/* 481 */       throw new JspTagException("'end' < 0");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validateStep() throws JspTagException {
/* 489 */     if (this.step < 1) {
/* 490 */       throw new JspTagException("'step' <= 0");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init() {
/* 500 */     this.index = 0;
/* 501 */     this.count = 1;
/* 502 */     this.status = null;
/* 503 */     this.item = null;
/* 504 */     this.last = false;
/* 505 */     this.beginSpecified = false;
/* 506 */     this.endSpecified = false;
/* 507 */     this.stepSpecified = false;
/*     */ 
/*     */     
/* 510 */     this.begin = 0;
/* 511 */     this.end = -1;
/* 512 */     this.step = 1;
/* 513 */     this.itemId = null;
/* 514 */     this.statusId = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calibrateLast() throws JspTagException {
/* 523 */     this.last = (!hasNext() || atEnd() || (this.end != -1 && this.begin + this.index + this.step > this.end));
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
/*     */   private void exposeVariables(boolean firstTime) throws JspTagException {
/* 551 */     if (this.itemId != null)
/* 552 */       if (getCurrent() == null) {
/* 553 */         this.pageContext.removeAttribute(this.itemId, 1);
/* 554 */       } else if (this.deferredExpression != null) {
/* 555 */         VariableMapper vm = this.pageContext.getELContext().getVariableMapper();
/*     */         
/* 557 */         if (vm != null) {
/* 558 */           ValueExpression ve = getVarExpression(this.deferredExpression);
/* 559 */           ValueExpression tmpValue = vm.setVariable(this.itemId, ve);
/* 560 */           if (firstTime)
/* 561 */             this.oldMappedValue = tmpValue; 
/*     */         } 
/*     */       } else {
/* 564 */         this.pageContext.setAttribute(this.itemId, getCurrent());
/*     */       }  
/* 566 */     if (this.statusId != null) {
/* 567 */       if (getLoopStatus() == null) {
/* 568 */         this.pageContext.removeAttribute(this.statusId, 1);
/*     */       } else {
/* 570 */         this.pageContext.setAttribute(this.statusId, getLoopStatus());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void unExposeVariables() {
/* 581 */     if (this.itemId != null) {
/* 582 */       this.pageContext.removeAttribute(this.itemId, 1);
/* 583 */       VariableMapper vm = this.pageContext.getELContext().getVariableMapper();
/* 584 */       if (vm != null)
/* 585 */         vm.setVariable(this.itemId, this.oldMappedValue); 
/*     */     } 
/* 587 */     if (this.statusId != null) {
/* 588 */       this.pageContext.removeAttribute(this.statusId, 1);
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
/*     */   private void discard(int n) throws JspTagException {
/* 609 */     int oldIndex = this.index;
/* 610 */     while (n-- > 0 && !atEnd() && hasNext()) {
/* 611 */       this.index++;
/* 612 */       next();
/*     */     } 
/* 614 */     this.index = oldIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void discardIgnoreSubset(int n) throws JspTagException {
/* 623 */     while (n-- > 0 && hasNext()) {
/* 624 */       next();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean atEnd() {
/* 634 */     return (this.end != -1 && this.begin + this.index >= this.end);
/*     */   }
/*     */   
/*     */   private ValueExpression getVarExpression(ValueExpression expr) {
/* 638 */     Object o = expr.getValue(this.pageContext.getELContext());
/* 639 */     if (o == null) {
/* 640 */       return null;
/*     */     }
/* 642 */     if (o.getClass().isArray() || o instanceof java.util.List) {
/* 643 */       return new IndexedValueExpression(this.deferredExpression, this.index + this.begin);
/*     */     }
/*     */     
/* 646 */     if (o instanceof java.util.Collection || o instanceof java.util.Iterator || o instanceof java.util.Enumeration || o instanceof java.util.Map || o instanceof String) {
/*     */ 
/*     */ 
/*     */       
/* 650 */       if (this.iteratedExpression == null) {
/* 651 */         this.iteratedExpression = new IteratedExpression(this.deferredExpression, getDelims());
/*     */       }
/*     */       
/* 654 */       return new IteratedValueExpression(this.iteratedExpression, this.index + this.begin);
/*     */     } 
/*     */     
/* 657 */     throw new ELException("Don't know how to iterate over supplied items in forEach");
/*     */   }
/*     */   
/*     */   protected abstract Object next() throws JspTagException;
/*     */   
/*     */   protected abstract boolean hasNext() throws JspTagException;
/*     */   
/*     */   protected abstract void prepare() throws JspTagException;
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/LoopTagSupport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */