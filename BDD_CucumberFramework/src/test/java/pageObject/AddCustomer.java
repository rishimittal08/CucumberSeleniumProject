package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer 
{
	public WebDriver ldriver ;
	
	@FindBy(id="Email")	WebElement uname_tf;
	
	@FindBy(id="Password")	WebElement pwd_tf;
	
	@FindBy(xpath="//button[@type='submit']")	WebElement login_btn;
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")	WebElement cust_link;
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")	WebElement cust_drp;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")	WebElement addnew_btn;
	
	@FindBy(id="Email")	WebElement email_tf;
	
	@FindBy(id="Password")	WebElement pwdnew_tf;
	
	@FindBy(id="FirstName")	WebElement fname_tf;
	
	@FindBy(id="LastName")	WebElement lname_tf;
	
	@FindBy(id="Gender_Male")	WebElement gender_cbox;
	
	@FindBy(id="DateOfBirth")	WebElement cal_tf;
	
	@FindBy(id="Company")	WebElement company_tf;
	
	@FindBy(id="SelectedCustomerRoleIds_taglist")	WebElement roles_drp;
	
	@FindBy(xpath="//*[@id=\"VendorId\"]")	WebElement vendor_drp;
	
	@FindBy(id="Active")	WebElement active_cbox;
	
	@FindBy(id="AdminComment")	WebElement acomment_tf;
	
	@FindBy(xpath="//button[@name='save']")	WebElement save_btn;
	
	@FindBy(linkText="Logout")	WebElement logout_link;
	
	
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	public String getPageTitle()
	{
		return ldriver.getTitle();
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
	public void customer_link()
	{
		cust_link.click();
	}
	public void customer_drp()
	{
		cust_drp.click();
	}
	public void add_btn()
	{
		addnew_btn.click();
	}
	public void addemail_tf(String email)
	{
		email_tf.sendKeys(email);
	}
	public void addpwd_tf(String pwd)
	{
		pwdnew_tf.sendKeys(pwd);
	}
	public void addfname_tf(String fname)
	{
		fname_tf.sendKeys(fname);
	}
	public void addlname_tf(String lname)
	{
		lname_tf.sendKeys(lname);
	}
	public void addgender_cbox()
	{
		gender_cbox.click();
	}
	public void Dob(String dob)
	{
		cal_tf.sendKeys(dob);
	}
	public void cname(String com)
	{
		company_tf.sendKeys(com);
	}
	public void role_drp(String role) throws InterruptedException
	{
		if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
		{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		}
		
		ldriver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']")).click();
					
		WebElement listitem;
		
		Thread.sleep(3000);
					
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(By.xpath("//li[contains(text(),'Administrators')]")); 
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(By.xpath("//li[contains(text(),'Registered')]"));
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(By.xpath("//li[contains(text(),'Guests')]"));
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(By.xpath("//li[contains(text(),'Vendors')]"));
		}
		else
		{
			listitem=ldriver.findElement(By.xpath("//li[contains(text(),'Guests')]"));
		}
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		

	}
	public void manager_vendor_drp(String value)
	{
		Select s1=new Select(vendor_drp);
		s1.selectByValue(value);
	}
	public void act_cbox()
	{
		active_cbox.click();;
	}
	public void admin_tf(String content)
	{
		acomment_tf.sendKeys(content);
	}
	public void click_save_btn()
	{
		save_btn.click();
	}
	
	
	public void logout_lnk()
	{
		logout_link.click();
	}
}
