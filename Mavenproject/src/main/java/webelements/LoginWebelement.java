package webelements;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class LoginWebelement {
	
	@FindBy(xpath = "//*[@id=\"login-email\"]")
	 public static WebElement Username;
		
	@FindBy(xpath = "//*[@id=\"login-password\"]")
	 public static WebElement Password;
       
	@FindBy(xpath ="/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/button")
	 public static WebElement Login;	
		
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[3]/a/span")
	 public static WebElement college;	
		
	@FindBy(xpath = "//*[@id=\"basic-datatable\"]/div/div/div/a/span")
	 public static WebElement addnew;	
	
	@FindBy(xpath = "//input[@id='course_name']")
	 public static WebElement name;
	
	@FindBy(xpath = "//input[@id='logo']")
	 public static WebElement logo;
	
	@FindBy(xpath = "//input[@id='address']")
	 public static WebElement address;
	
	@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[4]/div/div[2]/select")
	 public static WebElement district;
	
	@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[5]/div/div[2]/select")
	 public static WebElement affiliation;
	
	@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[6]/div/div[2]/select")
	 public static WebElement affiliatedto;
	
	@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[7]/div/div[2]/select")
	 public static WebElement collegetpe;
	
	@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[8]/div/div[2]/div/div[1]/div/button")
	 public static WebElement ug;
	
	@FindBy(xpath = "//*[@id=\"cnt_name\"]")
	 public static WebElement adname;
	
	@FindBy(xpath = "//*[@id=\"cnt_number\"]")
	 public static WebElement adnumber;
	
	@FindBy(xpath = "//*[@id=\"cnt_email\"]")
	 public static WebElement email;
	
	@FindBy(xpath = "//*[@id=\"cnt_name_plc\"]")
	 public static WebElement plname;
	
	@FindBy(xpath = "//*[@id=\"cnt_number_plc\"]")
	 public static WebElement plnumber;
	
	@FindBy(xpath = "//*[@id=\"course_email_plc\"]")
	 public static WebElement plemail;
	
	@FindBy(xpath ="//*[@id=\"submitbtn\"]")
	 public static WebElement submit;
	
	//@FindBy(xpath ="//*[@id=\"datatable\"]/tbody/tr[1]/td[1]/img")
	// public static boolean logopic;
	
	//@FindBy(xpath ="//td[text()='Maplogik Institution']")
	// public static String Actualname1;
	
	//@FindBy(xpath ="//td[text()='Kanyakumari']")
	// public static String Actualname;
	
	@FindBy(xpath ="//*[@id=\"datatable\"]/tbody/tr[1]/td[4]/a[2]")
	 public static WebElement delete;

	
	}


