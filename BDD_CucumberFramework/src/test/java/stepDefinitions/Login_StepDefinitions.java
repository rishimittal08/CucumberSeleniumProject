package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObject.LoginPage;
import utils.BaseClass;


public class Login_StepDefinitions extends BaseClass
{
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver= new ChromeDriver();
	    lp1=new LoginPage(driver);
	}
		
	@When("User enters URL {string}")
	public void user_enters_url(String url) {		
		driver.get(url);
	    driver.manage().window().maximize();
	}
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String uname, String password) {
	   lp1.uname_tf(uname);
	   lp1.password_tf(password);
	}
	
	@When("Click on login")
	public void click_on_login() {
	    lp1.sbmt_btn();
	}

	@Then("The page title is {string}")
	public void the_page_title_is(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) 
		{
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title,driver.getTitle());
		}
	}
	@When("User clicks on logout")
	public void user_clicks_on_logout() {
	    lp1.logout_lnk();
	}
	
	@Then("page title is {string}")
	public void page_title_is(String title) {
	    Assert.assertEquals(title, driver.getTitle());
	}
	
	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	    
	}
}
