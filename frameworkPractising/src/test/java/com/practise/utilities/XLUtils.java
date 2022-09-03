package com.practise.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XLUtils {

	WebDriver driver;
    List<String> usernamelist = new ArrayList<String>();
    List<String> passwordlist = new ArrayList<String>();
    
    public void passvalue() {
    	for(int i=0; i<usernamelist.size(); i++) {
    		openchromebrowser(usernamelist.get(i), passwordlist.get(i));
  	   }
    }

		public void openchromebrowser(String usname, String pword) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\prave\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
		username.sendKeys(usname);
		WebElement passwrd = driver.findElement(By.xpath("//input[starts-with(@name, 'txtPass')]"));
		passwrd.sendKeys(pword);
		WebElement click = driver.findElement(By.xpath("//input[contains(@value, 'LOGIN')]"));
		click.click();
}

		public void openexcel() throws IOException {
			System.out.println("openexcel");
	FileInputStream excelsheet = new FileInputStream("C:\\Users\\prave\\Documents\\JXLTest2.xlsx");
	
	Workbook workbook = new XSSFWorkbook(excelsheet);
	System.out.println("workbookabove");
		Sheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowiterator = sheet.iterator();
		while(rowiterator.hasNext()) {
			Row rowvalue = rowiterator.next();
		    Iterator<Cell> columniterator = rowvalue.iterator();
		    int i=2;
		    while(columniterator.hasNext()) {
		    	
		    	if(i%2==0) {
		    		usernamelist.add(columniterator.next().getStringCellValue());
		    	} else {
		    		passwordlist.add(columniterator.next().getStringCellValue());
		    	}
		i++;
System.out.println("username" + usernamelist);
}
}
	}

}
