package frameworkLearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class learnApachePOI {

	File file;
	FileInputStream inputstream;
	XSSFWorkbook workbook;
	public void openExcel() 
	{
	try {
	file = new File("D:\\Praveen_Selenium\\excelData-Input.xlsx");
	inputstream = new FileInputStream(file);
	workbook = new XSSFWorkbook(inputstream);
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	XSSFSheet sheet = workbook.getSheetAt(0);
	


}
}