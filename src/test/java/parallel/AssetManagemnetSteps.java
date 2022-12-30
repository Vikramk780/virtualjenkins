package parallel;

import java.awt.AWTException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.AssetManagemnetPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class AssetManagemnetSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage; 
	private AssetManagemnetPage assetManagemnetPage;
	
	
	@Given("loginn to stageapp")
	public void loginn_to_stageapp() throws InterruptedException {
		DriverFactory.getDriver().get("https://stageapp.botprise.com/");
		homePage = loginPage.doLogin("admin@botprise.com", "BotpriseTeam2021$$");
	}
	
	@When("go to assetmanagement page")
	public void go_to_assetmanagement_page() throws InterruptedException {
		assetManagemnetPage=homePage.AssetManagemnetPage();
	}

	@Then("create asset")
	public void create_asset() throws InterruptedException, AWTException {
		assetManagemnetPage.createAsset();
		
	
	}
	
	
}
