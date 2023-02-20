package controller;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import beans.FileUploadForm;
 
public class FileUploadAction extends DispatchAction {
       public ActionForward fileUploadAction( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
          ActionErrors errors = new ActionErrors();
          ActionForward forward = new ActionForward();
          FileUploadForm uploadForm = (FileUploadForm) form;
          String target = "";
                  try {
                    FormFile dataFile = uploadForm.getDataFile();
                    String fileName = dataFile.getFileName();
                    int  fileSize = dataFile.getFileSize();
                    byte[] fileData = dataFile.getFileData(); 
                   
                    
                    FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\a856947\\\\Documents\\\\" + fileName);
                    String a="C:\\Users\\a856947\\Documents\\"+fileName;
                  
                    
                  FileInputStream fileIn = new FileInputStream(a);
                    // Load the Excel file 

                  XSSFWorkbook workbook = new XSSFWorkbook(a);
//                  org.apache.poi.ss.usermodel.Workbook workbook = new XSSFWorkbook(a);
                 
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
        		
//                        System.out.println("test 4 "+cell1.getStringCellValue());

                        // Set the values of the prepared statement
                        stmt.setDouble(1, cell1.getNumericCellValue());
                        stmt.setString(2, cell2.getStringCellValue());
                        stmt.setString(3, cell3.getStringCellValue());
                        stmt.setDouble(4, cell4.getNumericCellValue());
        			
                        System.out.println("test 5");
                        // Execute the insert statement
                       stmt.executeUpdate();
                    }
                    
                    fileOut.write(fileData, 0, fileSize);
                    fileOut.flush();
                     fileOut.close();
                     } catch (Exception e) {
                         System.out.println("Error ="+e.toString());
                                errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.upload", e.toString()));
                                target = "uploadform";
                              }
                    if (!errors.isEmpty()) {
                          saveErrors(request, errors);
                          target = "uploadform";
                      } else { target = "success";    }
                   //}
            forward = mapping.findForward(target);
            return mapping.findForward("success");
          }
         }