package stud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import baseclass.Baseclass;
import webelements.LoginWebelement2;

public class Student extends Baseclass{
	@Test
	public static void student() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			File file = new File("F:\\admin\\output.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = workbook.getSheet("output");

			WebDriver driver = Baseclass.openChrome();

			String location="F:\\maplogik\\student.txt";
			FileReader fr = new FileReader(location);
			BufferedReader bfr = new  BufferedReader(fr);
			String currentLine = bfr.readLine();
			System.out.println(currentLine);
			driver.get(currentLine);

			PageFactory.initElements(driver, LoginWebelement2.class);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			String data1 = sheet1.getRow(1).getCell(0).getStringCellValue();
			System.out.println(data1);
			LoginWebelement2.Username.sendKeys(data1);
			double number = sheet1.getRow(1).getCell(1).getNumericCellValue();
			System.out.println(number);
			LoginWebelement2.Password.sendKeys("number");
			LoginWebelement2.Login.click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'test_otp']")));
			WebElement otp = driver.findElement(By.xpath("//*[@id=\'test_otp']"));
			String store = otp.getText();
			Row row3=sheet1.createRow(3);
			Cell cell3= row3.createCell(0);
			cell3.setCellValue(store);
			SimpleDateFormat geek = new SimpleDateFormat("dd / MM / yy");
			// Creating instance of the System date
			Calendar c = Calendar.getInstance();
			System.out.println("Present Date : " + c.getTime());
			// Formatting Date according "dd / MM / yy"
			String formattedDate = geek.format(c.getTime());
			System.out.println("Date formatted : "+formattedDate);
			Row row4=sheet1.createRow(4);
			Cell cell4= row4.createCell(0);
			cell4.setCellValue(formattedDate);
			LoginWebelement2.enterotp.sendKeys(store);
			LoginWebelement2.submit.click();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Academic Info']")));
			WebElement academic= driver.findElement(By.xpath("//span[text()='Academic Info']"));
			academic.click();
			
			File screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//Copy file at destination
			FileUtils.copyFile(screenshotfile, new File(".//screenshot/screen.png"));
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Log out']")));
			WebElement logout= driver.findElement(By.xpath("//span[text()='Log out']"));
			logout.click(); 

			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();

		} 
		catch (Exception e) {                                                    
			System.out.println("The exception is" + e);
		}

	}

}



