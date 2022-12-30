package parallel;

import java.awt.AWTException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.HomePage;
import qa.pages.IntegrationModellerPage;
import qa.pages.LoginPage;

public class IntegrationModellerSteps {

	private LoginPage loginPage =new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	private IntegrationModellerPage integrationModellerPage;
	
	@Given("login to stageapp")
	public void login_to_stageapp() throws InterruptedException {
		DriverFactory.getDriver().get("https://stageapp.botprise.com/");
		homePage = loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
	}

	@When("go to integrations page")
	public void go_to_integrations_page() throws InterruptedException {
		integrationModellerPage=homePage.gotoIntegrationModellerPage();
		
	}

//	@Then("create integration through modeller with curl {string} username {string} servicenow_instance {string} password {string}")
//	public void create_integration_through_modeller_with_curl_username_servicenow_instance_password(String string, String string2, String string3, String string4) throws InterruptedException, AWTException {
//		integrationModellerPage.CreateIntegrationThroughmodeller();
//	}
	
	
	
		@Then("create integration through modeller with curl \"curl -XPOST -H \"Content-type: application\\/json\" -d {string} {string} -u $username:{string}\" username \"admin\" servicenow_instance \"dev59080.service-now.com\" password \"eh8+IZ%zZiU8\"")
		public void create_integration_through_modeller_with_curl_curl_xpost_h_content_type_application_json_d_u_$username_username_admin_servicenow_instance_dev59080_service_now_com_password_eh8_iz_z_zi_u8(String string, String string2, String string3) throws InterruptedException, AWTException {
		    // Write code here that turns the phrase above into concrete actions
		integrationModellerPage.CreateIntegrationThroughmodeller();
		}



	

	
}
