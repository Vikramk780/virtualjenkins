package parallel;

import java.awt.AWTException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.BauModellerPage;
import qa.pages.HomePage;
import qa.pages.IntegrationModellerPage;
import qa.pages.LoginPage;

public class BAuModellerSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	private BauModellerPage BauModellerPage;
	private IntegrationModellerPage integrationModellerPage;
	
	@Given("login to stageappp")
	public void login_to_stageapp() throws InterruptedException {
		DriverFactory.getDriver().get("https://stageapp.botprise.com/");
		homePage = loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
	}

	
	
	
	@When("go to BAUmodeller page")
	public void go_to_ba_umodeller_page() throws InterruptedException {
		BauModellerPage=homePage.gotoInBauModellerPage();
		
		
	}
	@Then("create ec2BAU through modeller")
	public void create_ec2bau_through_modeller() throws InterruptedException, AWTException {
		BauModellerPage.createEc2bau();
	}

	@Then("create BAU through modeller")
	public void create_bau_through_modeller() throws InterruptedException, AWTException {
	   
		BauModellerPage.CreateBAUThroughModeller();
	}
	
	
}
