package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import static util.ConfigReader.getaddress;
import static util.ConfigReader.getadname;
import static util.ConfigReader.getadnumber;
import static util.ConfigReader.getaffiliatedto;
import static util.ConfigReader.getaffiliation;
import static util.ConfigReader.getdistrict;
import static util.ConfigReader.getemail;
import static util.ConfigReader.getlogo;
import static util.ConfigReader.getname;
import static util.ConfigReader.getplemail;
import static util.ConfigReader.getplname;
import static util.ConfigReader.getplnumber;
import static util.ConfigReader.getcollegetpe;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Maplogikadmin {
	@Test

	public static void main(String[] args) throws IOException, IllegalArgumentException {
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

			WebElement addnew = driver.findElement(By.xpath("//*[@id=\"basic-datatable\"]/div/div/div/a/span"));
			addnew.click();

			WebElement name = driver.findElement(By.xpath("//input[@id='course_name']"));
			name.sendKeys(getname());

			WebElement logo = driver.findElement(By.xpath("//input[@id='logo']"));
			logo.sendKeys(getlogo());

			WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
			address.sendKeys(getaddress());

			WebElement district = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[4]/div/div[2]/select"));
			district.sendKeys(getdistrict());

			WebElement affiliation = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[5]/div/div[2]/select"));
			affiliation.sendKeys(getaffiliation());

			WebElement affiliatedto = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[6]/div/div[2]/select"));
			affiliatedto.sendKeys(getaffiliatedto());

			WebElement collegetpe = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[7]/div/div[2]/select"));
			collegetpe.sendKeys(getcollegetpe());

			WebElement ug = driver.findElement(By.xpath("//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[8]/div/div[2]/div/div[1]/div/button"));
			ug.click();

			WebElement adname = driver.findElement(By.xpath("//*[@id=\"cnt_name\"]"));
			adname.sendKeys(getadname());

			WebElement adnumber = driver.findElement(By.xpath("//*[@id=\"cnt_number\"]"));
			adnumber.sendKeys(getadnumber());

			WebElement email = driver.findElement(By.xpath("//*[@id=\"cnt_email\"]"));
			email.sendKeys(getemail());

			WebElement plname = driver.findElement(By.xpath("//*[@id=\"cnt_name_plc\"]"));
			plname.sendKeys(getplname());

			WebElement plnumber = driver.findElement(By.xpath("//*[@id=\"cnt_number_plc\"]"));
			plnumber .sendKeys(getplnumber());

			WebElement plemail = driver.findElement(By.xpath("//*[@id=\"course_email_plc\"]"));
			plemail.sendKeys(getplemail());
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement submit= driver.findElement(By.xpath("//*[@id=\"submitbtn\"]"));
			wait1.until(ExpectedConditions.elementToBeClickable(submit));
			submit.sendKeys(Keys.ENTER);
			
			boolean logopic = driver.findElement(By.xpath("//*[@id=\"datatable\"]/tbody/tr[1]/td[1]/img")).isDisplayed();
			Assert.assertTrue(logopic);	
			System.out.println("Logo is correct");	
			
			String Actualname1=driver.findElement(By.xpath("//td[text()='Maplogik Institution']")).getText();
			String Expectedname1 = "Maplogik Institution";
			Assert.assertEquals(Actualname1,Expectedname1);
			System.out.println("collegename is correct");
			
			String Actualname=driver.findElement(By.xpath("//td[text()='Kanyakumari']")).getText();
			String Expectedname = "Kanyakumari";
			Assert.assertEquals(Actualname,Expectedname);
			System.out.println("location is correct");
			
			WebElement delete = driver.findElement(By.xpath("//td[text()='Kanyakumari']/parent::tr/child::td[4]/a[2]"));
			delete.click();
			
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			System.out.println("The exception is" + e);
		} 
	}
		}