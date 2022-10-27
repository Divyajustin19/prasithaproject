package webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWebelement1 {

		@FindBy(xpath = "//*[@id=\"login-email\"]")
		 public static WebElement Username;
		
		@FindBy(xpath = "//*[@id=\"login-password\"]")
		 public static WebElement Password;
	       
		@FindBy(xpath ="/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/button")
		 public static WebElement Login;	
			
		@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[3]/a/span")
		 public static WebElement college;	
		
		@FindBy(xpath = "//td[text()='SSN Engineering college']/parent::tr/child::td[4]/a[ 4]")
		 public static WebElement importm;	
		
		@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[1]/div/div[2]/select")
		 public static WebElement college1;	
		
		@FindBy(xpath = "//*[@id=\"course_type\"]")
		 public static WebElement type;	
		
		@FindBy(xpath = "//*[@id=\"course_name\"]")
		 public static WebElement course;	
		
		@FindBy(xpath = "//*[@id=\"basic-horizontal-layouts\"]/div/div/div/div/form/div/div[4]/div/div[2]/select")
		 public static WebElement sem;	
		
		@FindBy(xpath = "//*[@id=\"import_file\"]")
		 public static WebElement upload;	
		
		@FindBy(xpath = "//*[@id=\"submitbtn\"]")
		 public static WebElement submit;	
	}

