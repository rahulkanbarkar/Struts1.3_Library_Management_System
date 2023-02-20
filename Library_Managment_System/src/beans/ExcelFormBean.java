package beans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ExcelFormBean extends ActionForm {
	
	 private FormFile ExcelFile = null;

	public FormFile getExcelFile() {
		return ExcelFile;
	}

	public void setExcelFile(FormFile excelFile) {
		ExcelFile = excelFile;
	}

//	  private List<ExcelData> excelDataList;
	  // getters and setters for excelDataList
	}