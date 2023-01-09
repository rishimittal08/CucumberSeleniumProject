package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	@FindBy(id="Email")
	WebElement uname_tf;
	@FindBy(id="Password")
	WebElement pwd_tf;
	@FindBy(xpath="//button[@type='submit']")
	WebElement login_btn;
	@FindBy(linkText="Logout")
	WebElement logout_link;
			
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	public void uname_tf(String uname)
	{
		uname_tf.clear();
		uname_tf.sendKeys(uname);
	}
	public void password_tf(String password)
	{
		pwd_tf.clear();
		pwd_tf.sendKeys(password);
	}
	public void sbmt_btn()
	{
		login_btn.click();
	}
	public void logout_lnk()
	{
		logout_link.click();
	}
	
}
