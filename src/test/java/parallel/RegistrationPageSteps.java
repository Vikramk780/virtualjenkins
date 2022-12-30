//package parallel;
//
//import org.junit.Assert;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import qa.factory.DriverFactory;
//import qa.pages.LoginPage;
//import qa.pages.RegistrationPage;
//
//public class RegistrationPageSteps {
//	
//	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//    
//	private RegistrationPage resistrationpage;
//	
//
//
//	@When("user clicks on signup and goes to registration page")
//		public void user_clicks_on_signup_and_goes_to_registration_page() {
//		
//		resistrationpage=loginPage.userClickOnsignUpBtn();
//	}
//
//	@Then("user fills registration form")
//	public void user_fills_registration_form() throws InterruptedException {
//		resistrationpage.UserFillsResistrationForm();
//	}
//
//	@Then("verify confirmation msg as {string}")
//	public void verify_confirmation_msg_as(String string) {
//		String userconfirmationmsg = resistrationpage.getsuccessMsg();
//		
//		Assert.assertTrue(userconfirmationmsg.contains(string));
//	}
//	
//	
//}
