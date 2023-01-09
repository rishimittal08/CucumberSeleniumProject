package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import pageObject.AddCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomer;

public class BaseClass {
	public static WebDriver driver;
	public LoginPage lp1;
	public AddCustomer a1;
	public SearchCustomer sc1;
	

public void timewait()
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		

}

	
}
