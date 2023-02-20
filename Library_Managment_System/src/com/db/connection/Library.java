package com.db.connection;
import java.io.File;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Library {
	
//	‪C:\\Users\\a856947\\eclipse-workspaceUK\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\InsertDataFromExcelToDB\\uploads\\finalfile.xlsx

    public static void main(String[] args) {
        try {  System.out.println("test 0");

        System.out.println("test 5");  
        File file = new File("C:\\Users\\a856947\\Documents\\main.xlsx"); 
        System.out.println("test open 1 "+file);

        System.out.println("test 5");  
            // Load the Excel file                    
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\a856947\\Documents\\test.xls");
        System.out.println("test 001");
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment", "root", "889325Ca");
        // Prepare the insert statement
        PreparedStatement stmt = conn.prepareStatement("insert into Library values(?,?,?,?)");
        // Iterate through the rows in the sheet
        for (Row row : sheet) {
            Cell cell1 = row.getCell(0);
            Cell cell2 = row.getCell(1);
            Cell cell3 = row.getCell(2);
            Cell cell4 = row.getCell(3);
	       
//   System.out.println("test 6 "+cell1.getStringCellValue());

            // Set the values of the prepared statement
            stmt.setDouble(1, cell1.getNumericCellValue());
            stmt.setString(2, cell2.getStringCellValue());
            stmt.setString(3, cell3.getStringCellValue());
            stmt.setDouble(4, cell4.getNumericCellValue());
		
            System.out.println("test 5");          
            // Execute the insert statement
           stmt.executeUpdate();
          
        }
            // Close the resources
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


