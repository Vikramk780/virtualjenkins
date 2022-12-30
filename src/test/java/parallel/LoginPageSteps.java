package parallel;

import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.LoginPage;
import qa.util.ConfigReader;

public class LoginPageSteps {
	private ConfigReader configReader;
	
	private Properties prop;
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	

   
    
    
    
		@Given("user is on login page")
		public void user_is_on_login_page() {
			configReader = new ConfigReader();
			prop = configReader.init_prop();
			String url = prop.getProperty("url");	
			
			DriverFactory.getDriver().get(url); 
		}

		@When("user gets title")
		public void user_gets_title() {
			
			title=loginPage.getTitleOfLoginpage();
			System.out.println("title of page is:" + title);
			
		}

		@Then("title should be {string}")
		public void title_should_be(String expectedTitle) {
			Assert.assertTrue(title.contains(expectedTitle));
		    
		}

		@When("user check forgot password link is displayed")
		public void user_check_forgot_password_link_is_displayed() {
			Assert.assertTrue(loginPage.isForgotPasswordLinkAvailable());
		   
		}

		@When("user enters username {string}")
		public void user_enters_username(String username) {
			loginPage.enterUserName(username);
		    
		}

		@When("user enters pwd {string}")
		public void user_enters_pwd(String pwd) {
		  loginPage.enterPassword(pwd);
		}

		@When("user clicks on login button")
		public void user_clicks_on_login_button() {
			
			loginPage.clickOnLoginBtn();
		   
		}
		
		

		
}
