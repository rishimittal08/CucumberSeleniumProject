package stepDefinitions;

import io.cucumber.java.en.*;
import pageObject.SearchCustomer;

import org.junit.Assert;

import utils.BaseClass;

public class Search_StepDefinition extends BaseClass
{
	/********   Search by Email  ************/
	
	
	@Then("User can view Search page")
	public void user_can_view_search_page() {
		sc1=new SearchCustomer(driver);
		Assert.assertEquals("Customers / nopCommerce administration",sc1.getPageTitle());
	    }

	@When("User enters customer email")
	public void user_enters_customer_email() {
		sc1.searchemail_tf("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search")
	public void click_on_search() throws InterruptedException {
	    sc1.search_btn();
	    Thread.sleep(2000);
	}

	@Then("User can view email in search table")
	public void user_can_view_email_in_search_table() {
	   sc1.searchresultsbyemail("victoria_victoria@nopCommerce.com");
	}

	/********   Search by Name   ************/
	@When("User enters customer name")
	public void user_enters_customer_name() {
		sc1.searchfname_tf("Virat");
		sc1.searchlname_tf("Kohli");
	}
	
	@Then("User can view name in search table")
	public void user_can_view_name_in_search_table() {
		   sc1.searchresultsbyname("Virat Kohli");
	}

}
