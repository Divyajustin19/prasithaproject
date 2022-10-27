package admin;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;

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
import org.testng.annotations.Test;
import webelements.LoginWebelement;
import baseclass.Baseclass;

public class Adminmap extends Baseclass{
	@Test
	public  void admin() throws InterruptedException {
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

	
}


