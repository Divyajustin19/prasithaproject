package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseclass.Baseclass;

public class Mapstudent  extends Baseclass{
	@Test
	public static void main(String[] args) {
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

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement Username = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-student-id\"]")));
			String data1 = sheet1.getRow(1).getCell(0).getStringCellValue();
			System.out.println(data1);
			Username.sendKeys(data1);

			WebElement Password = driver.findElement(By.xpath("//*[@id=\"login-mobile\"]"));
			double number = sheet1.getRow(1).getCell(1).getNumericCellValue();
			System.out.println(number);
			Password.sendKeys("number");

			WebElement Login = driver.findElement(By.xpath("//*[@id=\"student-login\"]/button"));
			Login.click();

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'test_otp']")));
			WebElement otp = driver.findElement(By.xpath("//*[@id=\'test_otp']"));
			String store = otp.getText();
			Row row3=sheet1.createRow(3);
			Cell cell3= row3.createCell(0);
			cell3.setCellValue(store);

			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'login-otp']"))); 
			WebElement enterotp = driver.findElement(By.xpath("//*[@id=\'login-otp']")); 
			enterotp.sendKeys(store);

			WebElement submit= driver.findElement(By.xpath("//*[@id=\"student-login-otp\"]/button"));
			submit.click();

			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Academic Info']")));
			WebElement academic= driver.findElement(By.xpath("//span[text()='Academic Info']"));
			academic.click(); 

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

