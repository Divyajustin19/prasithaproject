package two;

import static util1.ConfigReader1.getcourse;
import static util1.ConfigReader1.getsem;
import static util1.ConfigReader1.gettype;
import static util1.ConfigReader1.getupload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import baseclass.Baseclass;
import webelements.LoginWebelement1;

public class Marks extends Baseclass{
	@Test
	public static void two() throws InterruptedException {
		try {
			File file = new File("F:\\admin\\input.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = workbook.getSheet("input");

			WebDriver driver = Baseclass.openChrome();

			String location="F:\\maplogik\\admin.txt";
			FileReader fr = new FileReader(location);
			BufferedReader bfr = new  BufferedReader(fr);
			String currentLine = bfr.readLine();
			System.out.println(currentLine);
			driver.get(currentLine);

			PageFactory.initElements(driver, LoginWebelement1.class);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			String data1 = sheet1.getRow(1).getCell(0).getStringCellValue();
			System.out.println(data1);
			LoginWebelement1.Username.sendKeys(data1);

			String data2 = sheet1.getRow(1).getCell(1).getStringCellValue();
			System.out.println(data2);
			LoginWebelement1. Password .sendKeys(data2);

			LoginWebelement1.Login.click(); 
			LoginWebelement1.college.click();
			LoginWebelement1.importm.sendKeys(Keys.ENTER);
			LoginWebelement1.type.sendKeys(gettype());
			LoginWebelement1.course.sendKeys(getcourse());
			LoginWebelement1.sem.sendKeys(getsem());
			LoginWebelement1.upload.sendKeys(getupload());
			LoginWebelement1.submit.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			System.out.println("The exception is" + e);
		} 
	}	
}		





















