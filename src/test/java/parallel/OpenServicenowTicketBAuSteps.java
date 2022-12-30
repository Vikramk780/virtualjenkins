package parallel;

import java.awt.AWTException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.BauModellerPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class OpenServicenowTicketBAuSteps {

	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	HomePage homePage;
	BauModellerPage bauModellerPage;
	
	
	
	@Given("User logs in to stageapp")
	public void user_logs_in_to_stageapp() throws InterruptedException {
		
		DriverFactory.getDriver().get("https://stageapp.botprise.com/");
		homePage =loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
	   
	}

	@When("User goes to BAUModeller")
	public void user_goes_to_bau_modeller() throws InterruptedException {
		bauModellerPage = homePage.gotoInBauModellerPage();
	    
	}

	@Then("User creates OpenTicketBAU")
	public void user_creates_open_ticket_bau() throws InterruptedException, AWTException {
		bauModellerPage.createOpenTicketBAU();
	}
	
}
