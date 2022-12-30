package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.HomePage;
import qa.pages.IntegrationbMeshPage;
import qa.pages.LoginPage;

public class IntegrationMeshSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	IntegrationbMeshPage integrationbMeshPage;
	private HomePage homePage;
	
	@Given("User logs into stageapp")
	public void user_logs_into_stageapp() throws InterruptedException {
		DriverFactory.getDriver().get("https://stageapp.botprise.com/");
		homePage=loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
	}

	@When("User goes to Integration Mesh Page")
	public void user_goes_to_integration_mesh_page() throws InterruptedException {
		integrationbMeshPage= homePage.IntegrationbMeshPage();
	}

	@Then("User Creates Integration with username {string} password {string} and url {string}")
	public void user_creates_integration_with_username_password_and_url(String string, String string2, String string3) throws InterruptedException {
		integrationbMeshPage.createIntegration(string,string2,string3);
	}
	
}
