package qa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegrationbMeshPage {
	private WebDriver driver;
	Waithelper waithelper;

	private By addbtn = By.xpath("(//p[contains(text(),\"Add Integration\")])[1]");
	private By sidebaritsm = By.xpath("//span[normalize-space()='ITSM']");
	private By selectservicenowradiobtn = By.xpath("//img[@alt='ServiceNow']");
	private By nextbtn = By.xpath("//span[contains(text(),\"Next\")]");
	private By name = By.xpath("//input[@name='name']");
	private By password = By.xpath("//input[@name='password']");
	private By username = By.xpath("//input[@name='username']");
	private By urls = By.xpath("//input[@name='servicenow_instance']");
	private By testbtn = By.xpath("//div[contains(text(),\"Test\")]");
	private By nextbtnn = By.xpath("//span[normalize-space()='Next']");
	private By skpandsave = By.xpath("//span[normalize-space()='Skip & Save']");

	public IntegrationbMeshPage(WebDriver driver) {
		this.driver = driver;
		waithelper = new Waithelper(driver);
	}

	public void createIntegration(String un, String pw, String url) throws InterruptedException {

		waithelper.forThisElementWait(addbtn, 20).click();
		waithelper.forThisElementWait(sidebaritsm, 20).click();
		waithelper.forThisElementWait(selectservicenowradiobtn, 20).click();
		waithelper.forThisElementWait(nextbtn, 20).click();

		String randomeBTUname = RandomStringUtils.random(4, "abz_cd");
		String randomeBTUname1 = RandomStringUtils.random(4, "qwez_");
		randomeBTUname = "testvk_automation".concat(randomeBTUname);
		randomeBTUname = randomeBTUname.concat(randomeBTUname1);

		waithelper.forThisElementWait(name, 20).sendKeys(randomeBTUname);
		waithelper.forThisElementWait(password, 20).sendKeys(pw);
		waithelper.forThisElementWait(username, 20).sendKeys(un);
		waithelper.forThisElementWait(urls, 20).sendKeys(url);
		waithelper.forThisElementWait(testbtn, 20).click();
		Thread.sleep(4000);
		waithelper.forThisElementWait(nextbtnn, 20).click();
		Thread.sleep(4000);
		waithelper.forThisElementWait(skpandsave, 20).click();
		Thread.sleep(4000);
	}
}
