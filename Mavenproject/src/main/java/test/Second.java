package test;

import static util1.ConfigReader1.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Second {
@Test
	public static void main(String[] args)throws IOException, IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			File file = new File("F:\\admin\\input.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = workbook.getSheet("input");

			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (5)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			String location="F:\\maplogik\\admin.txt";
			FileReader fr = new FileReader(location);
			BufferedReader bfr = new  BufferedReader(fr);
			String currentLine = bfr.readLine();
			System.out.println(currentLine);
			driver.get(currentLine);


			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement Username = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-email\"]")));
			String data1 = sheet1.getRow(1).getCell(0).getStringCellValue();
			System.out.println(data1);
			Username.sendKeys(data1);

			WebElement Password = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
			String data2 = sheet1.getRow(1).getCell(1).getStringCellValue();
			System.out.println(data2);
			Password.sendKeys(data2);

			WebElement Login = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/button"));
			Login.click();
			
			WebElement college = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span"));
			college.click();
			
			WebElement importm = driver.findElement(By.xpath("//*[@id=\"datatable\"]/tbody/tr[11]/td[4]/a[ 4]"));
			importm.sendKeys(Keys.ENTER);
			
			//WebElement college1 = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[1]/div/div[2]/select"));
			//college1.click();
			
			WebElement type = driver.findElement(By.xpath("//*[@id=\"course_type\"]"));
			type.sendKeys(gettype());
			
			WebElement course = driver.findElement(By.xpath("//*[@id=\"course_name\"]"));
			course.sendKeys(getcourse());
			
			WebElement sem = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[4]/div/div[2]/select"));
			sem.sendKeys(getsem());
			
			WebElement upload = driver.findElement(By.xpath("//*[@id=\"import_file\"]"));
			upload .sendKeys(getupload());
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement submit= driver.findElement(By.xpath("//*[@id=\"submitbtn\"]"));
			wait1.until(ExpectedConditions.elementToBeClickable(submit));
			submit.sendKeys(Keys.ENTER);
			
		} catch (Exception e) {
			System.out.println("The exception is" + e);
		} 

		}



	
}
	

	
	
	

	

	
	

	
	
