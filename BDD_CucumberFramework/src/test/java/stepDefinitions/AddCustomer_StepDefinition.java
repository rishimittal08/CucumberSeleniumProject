package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddCustomer;
import utils.BaseClass;

public class AddCustomer_StepDefinition extends BaseClass
{
	
	@Then("User view Dashboard")
	public void user_view_dashboard() {
		a1= new AddCustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",a1.getPageTitle());
	}

	@When("User Click customer sidetab")
	public void user_click_customer_sidetab() {
		
		a1.customer_link();
	}

	@When("Click on Customer link")
	public void click_on_customer_link() {
		a1.customer_drp();
	}

	@When("Click on Add new")
	public void click_on_add_new() {
		a1.add_btn();

	}

	@Then("User can view Registration page")
	public void user_can_view_registration_page() {
		Assert.assertEquals(a1.getPageTitle(),"Add a new customer / nopCommerce administration");
	}

	@When("User fill the registration form")
	public void user_fill_the_registration_form() throws InterruptedException {
		String autoGenerate=RandomStringUtils.randomAlphabetic(5);
		String email= autoGenerate+"@gmail.com";
		a1.addemail_tf(email);
		a1.addpwd_tf(autoGenerate);
		a1.addfname_tf(autoGenerate);
		a1.addlname_tf(autoGenerate);
		a1.addgender_cbox();
		a1.Dob("10/8/1989");
		a1.cname("Tarzan");
		Thread.sleep(3000);
		a1.role_drp("Guest");
		Thread.sleep(3000);
		//a1.manager_vendor_drp("Vendor2");
		a1.act_cbox();
		a1.admin_tf("Testing");
	}

	@When("Click on Save")
	public void click_on_save() throws InterruptedException {
		a1.click_save_btn();
		Thread.sleep(2000);
	}

	@Then("User can view Confirmation {string}")
	public void user_can_view_confirmation(String text)
	{
		if (driver.getPageSource().contains(text)) 
		{
			Assert.assertTrue(true);
		}else 
		{
			driver.close();			
		}
	}
}
