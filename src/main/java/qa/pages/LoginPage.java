package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

//	private WebDriver driver;
	private WebDriver driver;
	Waithelper waithelper;

	private By emailId = By.id("email");

	private By password = By.id("password");

	private By loginButton = By.xpath("//button[@type=\"submit\"]");
	private By forgotPasswordLink = By.linkText("Forgot your password ?");
	private By signupbtn = By.xpath("//a[normalize-space()='Sign Up']");
	private By Botpriselink = By.xpath("(//div[contains(text(),\"Botprise Lab\")])[1]");
	private By hambergermenu = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/button[1]/span[1]/*[name()='svg'][1]");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		waithelper = new Waithelper(driver);
	}

	public RegistrationPage userClickOnsignUpBtn() {

		driver.findElement(signupbtn).click();
		return new RegistrationPage(driver);
	}

	public String getTitleOfLoginpage() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkAvailable() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLoginBtn() {
		driver.findElement(loginButton).click();
	}

	public HomePage doLogin(String un, String pw) throws InterruptedException {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginButton).click();
		Thread.sleep(2000);
		waithelper.forThisElementWait(Botpriselink, 18).click();
		Thread.sleep(2000);
		driver.findElement(hambergermenu).click();
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	public HomePage doLogin1(String un, String pw) throws InterruptedException {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginButton).click();
		Thread.sleep(2000);

		return new HomePage(driver);
	}

}
