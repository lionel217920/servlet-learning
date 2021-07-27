/*     */ package javax.servlet.jsp.jstl.sql;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResultImpl
/*     */   implements Result, Serializable
/*     */ {
/* 103 */   private List<SortedMap<String, Object>> rowMap = new ArrayList<SortedMap<String, Object>>();
/* 104 */   private List<Object[]> rowByIndex = new ArrayList();
/*     */   public ResultImpl(ResultSet rs, int startRow, int maxRows) throws SQLException {
/* 106 */     ResultSetMetaData rsmd = rs.getMetaData();
/* 107 */     int noOfColumns = rsmd.getColumnCount();
/*     */ 
/*     */     
/* 110 */     this.columnNames = new String[noOfColumns]; int i;
/* 111 */     for (i = 1; i <= noOfColumns; i++) {
/* 112 */       this.columnNames[i - 1] = rsmd.getColumnName(i);
/*     */     }
/*     */ 
/*     */     
/* 116 */     for (i = 0; i < startRow; i++) {
/* 117 */       rs.next();
/*     */     }
/*     */ 
/*     */     
/* 121 */     int processedRows = 0;
/* 122 */     while (rs.next()) {
/* 123 */       if (maxRows != -1 && processedRows == maxRows) {
/* 124 */         this.isLimited = true;
/*     */         break;
/*     */       } 
/* 127 */       Object[] columns = new Object[noOfColumns];
/* 128 */       SortedMap<String, Object> columnMap = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
/*     */ 
/*     */ 
/*     */       
/* 132 */       for (int j = 1; j <= noOfColumns; j++) {
/* 133 */         Object value = rs.getObject(j);
/* 134 */         if (rs.wasNull()) {
/* 135 */           value = null;
/*     */         }
/* 137 */         columns[j - 1] = value;
/* 138 */         columnMap.put(this.columnNames[j - 1], value);
/*     */       } 
/* 140 */       this.rowMap.add(columnMap);
/* 141 */       this.rowByIndex.add(columns);
/* 142 */       processedRows++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] columnNames;
/*     */ 
/*     */   
/*     */   private boolean isLimited;
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedMap[] getRows() {
/* 156 */     if (this.rowMap == null) {
/* 157 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 161 */     return this.rowMap.<SortedMap>toArray(new SortedMap[0]);
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
/*     */   public Object[][] getRowsByIndex() {
/* 173 */     if (this.rowByIndex == null) {
/* 174 */       return (Object[][])null;
/*     */     }
/*     */ 
/*     */     
/* 178 */     return this.rowByIndex.<Object[]>toArray(new Object[0][0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getColumnNames() {
/* 189 */     return this.columnNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 199 */     if (this.rowMap == null) {
/* 200 */       return -1;
/*     */     }
/* 202 */     return this.rowMap.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLimitedByMaxRows() {
/* 211 */     return this.isLimited;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/sql/ResultImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */