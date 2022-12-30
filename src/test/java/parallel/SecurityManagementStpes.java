package parallel;

import java.awt.AWTException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.SecurityManageMentPage;

public class SecurityManagementStpes {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
private SecurityManageMentPage securityManageMentPage;
@Given("user login to stageapp")
public void user_login_to_stageapp() throws InterruptedException {
   DriverFactory.getDriver().get("https://stageapp.botprise.com/");
   homePage=loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
}

@When("user goes to security page")
public void user_goes_to_security_page() throws InterruptedException {
	securityManageMentPage = homePage.SecurityManageMentPage();
}

@Then("user creates secret")
public void user_creates_secret() throws InterruptedException, AWTException {
	securityManageMentPage.createsecrete();
	securityManageMentPage.createfile();
}

@Then("User Crreates Creds profile")
public void user_crreates_creds_profile() throws InterruptedException, AWTException {
	securityManageMentPage.createCreds();
	securityManageMentPage.createCredsforTeminal();
	
}
	
	
}
