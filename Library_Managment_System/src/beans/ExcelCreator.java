package beans;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCreator {

    public HSSFWorkbook createWorkbook(List<Library> userList) throws Exception {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Library Data");

        /**
         * Setting the width of the first four columns.
         */
        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 7500);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 4500);
        
        
        /**
         * Style for the header cells.
         */
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow headerrow = sheet.createRow(0);
        
		
		  HSSFCell cell = headerrow.createCell(0); 
		  cell.setCellStyle(headerCellStyle);
		  cell.setCellValue(new HSSFRichTextString("bookname"));
		 
        
        
        cell = headerrow.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("author "));
        
        cell = headerrow.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("boookcost"));
        
        cell = headerrow.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("bookid"));
        
int row=1;
        for (int index = 0; index < userList.size(); index++) {
        	headerrow = sheet.createRow(row);
        	row++;
          
            cell = headerrow.createCell(0);
            Library userData = (Library) userList.get(index);
            HSSFRichTextString name = new HSSFRichTextString(userData.getBookname());
            cell.setCellValue(name);
            
            cell = headerrow.createCell(1);
            HSSFRichTextString bookname = new HSSFRichTextString(userData.getAuthor());
            cell.setCellValue(bookname);
            
            cell = headerrow.createCell(2);
            HSSFRichTextString author = new HSSFRichTextString(userData.getBookcost());
            cell.setCellValue(author);
            
            cell = headerrow.createCell(3);
            HSSFRichTextString bookid = new HSSFRichTextString(userData.getBookid());
            cell.setCellValue(bookid);
            
        }
        return wb;
    }
}
