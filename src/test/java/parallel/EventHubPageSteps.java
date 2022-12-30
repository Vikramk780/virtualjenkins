package parallel;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.EventHubPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.TicketExecutionPage;

public class EventHubPageSteps {
	

	private TicketExecutionPage ticketExecutionPage = new TicketExecutionPage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	private EventHubPage eventHubPage;

	@Given("user logs in servicenow")
	public void user_logs_in_servicenow() throws InterruptedException {
		ticketExecutionPage.enterUrlserviceNow("https://dev59080.service-now.com/");

		ticketExecutionPage.entersUsername("admin");
		ticketExecutionPage.entersPassword("eh8+IZ%zZiU8");
	}

	@When("user creates two tickets")
	public void user_creates_two_tickets() throws InterruptedException, UnsupportedFlavorException, IOException {
		ticketExecutionPage.entersDescription1();
		ticketExecutionPage.entersDescription2();
	}

	@Given("Userlogin to stageapp")
	public void userlogin_to_stageapp() throws InterruptedException {
		DriverFactory.getDriver().get("https://stageapp.botprise.com/");
		homePage = loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
	}

	@When("user goes to eventhub page")
	public void user_goes_to_eventhub_page() throws InterruptedException {
		eventHubPage=homePage.gotoEventHubpage();
	}

	@Then("user creates BTU")
	public void user_creates_btu() throws InterruptedException, AWTException {
		
		eventHubPage.createBTU();
	}

}
