/*     */ package javax.servlet.jsp.jstl.jstl.tlv;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.servlet.jsp.tagext.PageData;
/*     */ import javax.servlet.jsp.tagext.TagLibraryValidator;
/*     */ import javax.servlet.jsp.tagext.ValidationMessage;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.helpers.DefaultHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PermittedTaglibsTLV
/*     */   extends TagLibraryValidator
/*     */ {
/*  56 */   private final String PERMITTED_TAGLIBS_PARAM = "permittedTaglibs";
/*     */ 
/*     */   
/*  59 */   private final String JSP_ROOT_URI = "http://java.sun.com/JSP/Page";
/*     */ 
/*     */   
/*  62 */   private final String JSP_ROOT_NAME = "root";
/*     */ 
/*     */   
/*  65 */   private final String JSP_ROOT_QN = "jsp:root";
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> permittedTaglibs;
/*     */ 
/*     */   
/*     */   private boolean failed;
/*     */ 
/*     */   
/*     */   private String uri;
/*     */ 
/*     */ 
/*     */   
/*     */   public PermittedTaglibsTLV() {
/*  80 */     init();
/*     */   }
/*     */   
/*     */   private void init() {
/*  84 */     this.permittedTaglibs = null;
/*  85 */     this.failed = false;
/*     */   }
/*     */   
/*     */   public void release() {
/*  89 */     super.release();
/*  90 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized ValidationMessage[] validate(String prefix, String uri, PageData page) {
/*     */     try {
/* 102 */       this.uri = uri;
/* 103 */       this.permittedTaglibs = readConfiguration();
/*     */ 
/*     */       
/* 106 */       DefaultHandler h = new PermittedTaglibsHandler();
/*     */ 
/*     */       
/* 109 */       SAXParserFactory f = SAXParserFactory.newInstance();
/* 110 */       f.setValidating(true);
/* 111 */       SAXParser p = f.newSAXParser();
/* 112 */       p.parse(page.getInputStream(), h);
/*     */       
/* 114 */       if (this.failed) {
/* 115 */         return vmFromString("taglib " + prefix + " (" + uri + ") allows only the " + "following taglibs to be imported: " + this.permittedTaglibs);
/*     */       }
/*     */ 
/*     */       
/* 119 */       return null;
/*     */     }
/* 121 */     catch (SAXException ex) {
/* 122 */       return vmFromString(ex.toString());
/* 123 */     } catch (ParserConfigurationException ex) {
/* 124 */       return vmFromString(ex.toString());
/* 125 */     } catch (IOException ex) {
/* 126 */       return vmFromString(ex.toString());
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
/*     */   private Set<String> readConfiguration() {
/* 138 */     Set<String> s = new HashSet<String>();
/*     */ 
/*     */     
/* 141 */     String uris = (String)getInitParameters().get("permittedTaglibs");
/*     */ 
/*     */     
/* 144 */     StringTokenizer st = new StringTokenizer(uris);
/* 145 */     while (st.hasMoreTokens()) {
/* 146 */       s.add(st.nextToken());
/*     */     }
/*     */     
/* 149 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ValidationMessage[] vmFromString(String message) {
/* 155 */     return new ValidationMessage[] { new ValidationMessage(null, message) };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class PermittedTaglibsHandler
/*     */     extends DefaultHandler
/*     */   {
/*     */     private PermittedTaglibsHandler() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void startElement(String ns, String ln, String qn, Attributes a) {
/* 172 */       if (!qn.equals("jsp:root") && (!ns.equals("http://java.sun.com/JSP/Page") || !ln.equals("root"))) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 177 */       for (int i = 0; i < a.getLength(); i++) {
/* 178 */         String name = a.getQName(i);
/*     */ 
/*     */         
/* 181 */         if (name.startsWith("xmlns:") && !name.equals("xmlns:jsp")) {
/*     */ 
/*     */           
/* 184 */           String value = a.getValue(i);
/*     */           
/* 186 */           if (!value.equals(PermittedTaglibsTLV.this.uri))
/*     */           {
/*     */ 
/*     */             
/* 190 */             if (!PermittedTaglibsTLV.this.permittedTaglibs.contains(value))
/* 191 */               PermittedTaglibsTLV.this.failed = true; 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/tlv/PermittedTaglibsTLV.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */