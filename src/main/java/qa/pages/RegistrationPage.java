package qa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private static WebDriver driver;

	public static WebElement explicitlywaitt(By propertiesBtn2) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		// click on the compose button as soon as the "compose" button is visible
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		return compnamefromlocator;

	}

	private static String randometext = RandomStringUtils.random(4, "Usernaame");
	private By signupbtn = By.xpath("//a[normalize-space()='Sign Up']");

	private By email = By.xpath("(//input[@type=\"text\"])[1]");

	private By firstname = By.xpath("//input[@id='firstName']");

	private By lastname = By.xpath("//input[@id='lastName']");

	private By comapny = By.xpath("//input[@id='company']");

	private By designation = By.xpath("//input[@id='designation']");
	private By password = By.xpath("//input[@id='password']");
	private By confirmpassword = By.xpath("//input[@id='confirmPassword']");

	private By radiobtn = By.xpath("//input[@type='radio']");

	private By submitbtn = By.xpath("//button[@type='submit']");

	private By successmsg = By.xpath("//h6[@class=\"MuiTypography-root MuiTypography-h6\"]");

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
	}

	public void UserFillsResistrationForm() throws InterruptedException {
		String randomemail = RandomStringUtils.random(4, "abcdabcd");
		explicitlywaitt(email).click();
		explicitlywaitt(email).sendKeys("vikram.kambletest" + randomemail + "@botprise.com");
		randometext = RandomStringUtils.random(4, "cbvnvm");
		driver.findElement(firstname).sendKeys("User" + randometext);
		driver.findElement(lastname).sendKeys("Latname" + randometext);

		driver.findElement(comapny).sendKeys("comapnay" + randometext);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);

		driver.findElement(designation).sendKeys("Designation" + randometext);
		driver.findElement(password).sendKeys("Zz@12345");
		driver.findElement(radiobtn).click();
		driver.findElement(confirmpassword).sendKeys("Zz@12345");

		driver.findElement(submitbtn).click();
		Thread.sleep(1000);
		driver.findElement(submitbtn).click();
		Thread.sleep(4000);

	}

	public String getsuccessMsg() {
		String userconfirmationlink = driver.findElement(successmsg).getText();

		return userconfirmationlink;
	}

}
