package extent;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseclass.Baseclass;
import webelements.LoginWebelement;
import webelements.LoginWebelement1;
import webelements.LoginWebelement2;

import org.testng.annotations.BeforeTest;

import static util.ConfigReader.getaddress;
import static util.ConfigReader.getadname;
import static util.ConfigReader.getadnumber;
import static util.ConfigReader.getaffiliatedto;
import static util.ConfigReader.getaffiliation;
import static util.ConfigReader.getcollegetpe;
import static util.ConfigReader.getdistrict;
import static util.ConfigReader.getemail;
import static util.ConfigReader.getlogo;
import static util.ConfigReader.getname;
import static util.ConfigReader.getplemail;
import static util.ConfigReader.getplname;
import static util.ConfigReader.getplnumber;

import static util1.ConfigReader1.getcourse;
import static util1.ConfigReader1.getsem;
import static util1.ConfigReader1.gettype;
import static util1.ConfigReader1.getupload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Extentreports {
	 ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
	ExtentTest testCase;
	@Test (priority = 1)
	public  void admin() throws InterruptedException {
		
		try {
			ExtentTest test = extent.createTest("Verify college successfully added").assignAuthor("Prasitha").assignDevice("Windows");
			test.info("Iam adding the college");
			test.pass("college is added");
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

			PageFactory.initElements(driver, LoginWebelement.class);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			String data1 = sheet1.getRow(1).getCell(0).getStringCellValue();
			System.out.println(data1);
			LoginWebelement.Username.sendKeys(data1);
			
			String data2 = sheet1.getRow(1).getCell(1).getStringCellValue();
			System.out.println(data2);
			LoginWebelement. Password .sendKeys(data2);

			LoginWebelement.Login.click(); 
			LoginWebelement.college.click();
			LoginWebelement.addnew.click();
			LoginWebelement.name.sendKeys(getname());
			LoginWebelement.logo.sendKeys(getlogo());
			LoginWebelement.address.sendKeys(getaddress());
			LoginWebelement.district.sendKeys(getdistrict());
			LoginWebelement.affiliation.sendKeys(getaffiliation());
			LoginWebelement.affiliatedto.sendKeys(getaffiliatedto());
			LoginWebelement.collegetpe.sendKeys(getcollegetpe());
			LoginWebelement.ug.click();
			LoginWebelement.adname.sendKeys(getadname());
			LoginWebelement.adnumber.sendKeys(getadnumber());
			LoginWebelement.email.sendKeys(getemail());
			LoginWebelement.plname.sendKeys(getplname());
			LoginWebelement.plnumber .sendKeys(getplnumber());
			LoginWebelement.plemail.sendKeys(getplemail());

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			LoginWebelement.submit.sendKeys(Keys.ENTER);
			
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

			LoginWebelement.delete.click();

			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			System.out.println("The exception is" + e);
		} 
	}

	@Test (priority = 2)
	public  void two() throws InterruptedException {
		try {
			ExtentTest test = extent.createTest("Verify marks are successfully uploaded");
			test.info("Iam uploding the marks");
			test.pass("marks are imported successfully");
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
	@Test (priority = 3)
	
	public void student() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			ExtentTest test = extent.createTest("Verify marks are successfully updated in student page").assignCategory("functional test cases");
			test.info("Iam viewing my marks");
			test.pass("marks are verified successfully");
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
	

	@BeforeTest
	public void beforeTest() {
		extent.attachReporter(spark);
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}

}
