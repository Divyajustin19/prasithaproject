package webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWebelement2 {

	@FindBy(xpath = "//*[@id=\"login-student-id\"]")
	 public static WebElement Username;
	
	@FindBy(xpath = "//*[@id=\"login-mobile\"]")
	 public static WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"student-login\"]/button")
	 public static WebElement Login;
	
	//@FindBy(xpath = "//*[@id=\'test_otp']")
	 //public static WebElement otp;
	
	@FindBy(xpath = "//*[@id=\'login-otp']")
	 public static WebElement enterotp;
	
	@FindBy(xpath = "//*[@id=\"student-login-otp\"]/button")
	 public static WebElement submit;
	
	
	
	
	
	
	
	
	
	
	

	}


