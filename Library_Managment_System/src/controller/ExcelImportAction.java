package controller;
import beans.ExcelFormBean;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import beans.ExcelFormBean;

public class ExcelImportAction extends Action {
	  public ActionForward execute(ActionMapping mapping, ActionForm form,
	                               HttpServletRequest request, HttpServletResponse response) throws Exception {
	    ExcelFormBean formBean = (ExcelFormBean) form;
	    FormFile formFile = formBean.getExcelFile();
	    InputStream inputStream = formFile.getInputStream();
	    List<ExcelData> excelDataList = readExcelData(inputStream);
	    formBean.setExcelDataList(excelDataList);
	    return mapping.findForward("success");
	  }
	  
	  private List<ExcelData> readExcelData(InputStream inputStream) throws Exception {
	    List<ExcelData> excelDataList = new ArrayList<ExcelData>();
	    HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	    HSSFSheet sheet = workbook.getSheetAt(0);
	    for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
	      HSSFRow row = sheet.getRow(rowNum);
	      
	      ExcelData excelData = new ExcelData();
	      excelData.setColumn1(getStringCellValue(row.getCell(0)));
	      excelData.setColumn2(getStringCellValue(row.getCell(1)));
	      excelData.setColumn3(getStringCellValue(row.getCell(2)));
	      excelDataList.add(excelData);
	    }
	    return excelDataList;
	  }
	  
	  private String getStringCellValue(HSSFCell cell) {
	    if (cell == null) {
	      return "";
	    }
	    switch (cell.getCellType()) {
	      case HSSFCell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	      case HSSFCell.CELL_TYPE_NUMERIC:
	        return String.valueOf(cell.getNumericCellValue());
	      default:
	        return "";
	    }
	  }
	}

