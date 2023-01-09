package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchCustomer 
{
	WebDriver ldriver;
	@FindBy(id="SearchEmail")
	WebElement search_email_tf;
	@FindBy(id="SearchFirstName")
	WebElement search_fname_tf;
	@FindBy(id="SearchLastName")
	WebElement search_lname_tf;
	@FindBy(id="SearchMonthOfBirth")
	WebElement search_dobmonth_drp;
	@FindBy(id="SearchDayOfBirth")
	WebElement search_dobday_drp;
	@FindBy(id="search-customers")
	WebElement search_btn;
	@FindBy(id="customers-grid_wrapper")
	WebElement search_table;
	@FindBy(xpath="//*[@id=\"customers-grid\"]")
	WebElement result_table;
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> result_tablerow;
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td")
	List<WebElement> result_tablecolumn;
			
	
	public SearchCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}

	public void searchemail_tf(String email)
	{
		search_email_tf.clear();
		search_email_tf.sendKeys(email);
	}
	public void searchfname_tf(String fname)
	{
		search_fname_tf.clear();
		search_fname_tf.sendKeys(fname);
	}
	public void  searchlname_tf(String lname)
	{
		search_lname_tf.clear();
		search_lname_tf.sendKeys(lname);
	}
	public void  searchdobmoth_drp(String value)
	{
		Select s1=new Select(search_dobmonth_drp);
		s1.selectByValue(value);
	}
	public void  searchdobday_drp(String value)
	{
		Select s1=new Select(search_dobday_drp);
		s1.selectByValue(value);
	}
	public void  search_btn()
	{
		search_btn.click();
	}
	public void  search_table(String lname)
	{
		search_lname_tf.clear();
		search_lname_tf.sendKeys(lname);
	}
	public int getrows()
	{
		return result_tablerow.size();
	}
	public int getcolumns()
	{
		return result_tablecolumn.size();
	}
	public boolean searchresultsbyemail(String email)
	{
		boolean result=false;
		for(int i=1;i<getrows();i++)
		{
			String emailid=result_table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email))
			{
			result=true;
			break;
			}
		}
		return result;
	}
	
	public boolean searchresultsbyname(String name)
	{
		boolean result=false;
		for (int i=1;i<getcolumns();i++)
		{
			String name1=result_table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(name1);

			if(name1.equals(name))
			{
				result=true;
				break;
			}
		}
		return result;
	}
}
