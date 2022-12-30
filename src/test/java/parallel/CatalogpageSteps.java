package parallel;

import java.awt.AWTException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.CatalogPage;
import qa.pages.HomePage;

public class CatalogpageSteps {
	
	private CatalogPage catalogPage;
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	
	@Given("user goes to catalog page")
	public void user_goes_to_catalog_page() throws InterruptedException {
		catalogPage = homePage.gotoCatalogPage();
		
	}

	@When("user selects the tempalet")
	public void user_selects_the_tempalet() throws InterruptedException {
		catalogPage.selectTemplate();
		
	}

	@Then("user views it and verify result")
	public void user_views_it_and_verify_result() throws InterruptedException {
		catalogPage.clickOnShowAction();
		
		
	}

	@Then("user launchit in studio and save it {string}")
	public void user_launchit_in_studio_and_save_it(String string) throws InterruptedException, AWTException {
		
		String msgfromworkflowsvesuccess = catalogPage.launchinStudio();
		Assert.assertTrue(msgfromworkflowsvesuccess.contains(string));
	}

}
