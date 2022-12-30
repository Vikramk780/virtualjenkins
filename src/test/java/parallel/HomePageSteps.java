package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import qa.factory.DriverFactory;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.ServicenowPage;

public class HomePageSteps {
	String companyname;
	String cmpnamefromfeatureFile;
	

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	
	
	
@Given("user has already loggen to application")

public void user_has_already_loggen_to_application(DataTable dataTable) throws InterruptedException {
   
	List<Map< String, String>> credList = dataTable.asMaps();
	
	String userName = credList.get(0).get("username");
	String password = credList.get(0).get("password");
	
	
	DriverFactory.getDriver().get("https://stageapp.botprise.com");
	
	homePage = loginPage.doLogin1(userName, password);
	
	
}

@Given("user is on home page")
public void user_is_on_home_page() {
	homePage.getHomePageTitle();
}

@Then("user gets copany name")
public void user_gets_copany_name(DataTable dataTable) {
	List<Map< String, String>> companylist =dataTable.asMaps();
	cmpnamefromfeatureFile = companylist.get(0).get("Botprise Lab");
	
}

@Then("company name should be {string}")
public void company_name_should_be(String companyName) throws InterruptedException {
	 companyname = homePage.getcomanyName();
	 
System.out.println(companyname);
SoftAssert softassert= new SoftAssert();

//softassert.assertEquals(companyname,companyName);

Assert.assertEquals(companyname,companyName);
System.out.println(companyName);


}
	
	
	
}
