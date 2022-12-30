package qa.pages;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class IntegrationbMeshPage {
	private static WebDriver driver;
	
	
	private By addbtn =By.xpath("(//p[contains(text(),\"Add Integration\")])[1]");
	private By sidebaritsm =By.xpath("//span[normalize-space()='ITSM']");
	private By selectservicenowradiobtn =By.xpath("//img[@alt='ServiceNow']");
	private By nextbtn =By.xpath("//span[contains(text(),\"Next\")]");
	private By name =By.xpath("//input[@name='name']");
	private By password =By.xpath("//input[@name='password']");
	private By username =By.xpath("//input[@name='username']");
	private By urls =By.xpath("//input[@name='servicenow_instance']");
	private By testbtn =By.xpath("//div[contains(text(),\"Test\")]");
	private By nextbtnn =By.xpath("//span[normalize-space()='Next']");
	private By skpandsave =By.xpath("//span[normalize-space()='Skip & Save']");
	
	
	
	
	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(3000);

		return compnamefromlocator;

	}
	
	public IntegrationbMeshPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createIntegration(String un,String pw,String url) throws InterruptedException {
		
		fluentwaitt(addbtn).click();
		fluentwaitt(sidebaritsm).click();
		fluentwaitt(selectservicenowradiobtn).click();
		fluentwaitt(nextbtn).click();
		
		String randomeBTUname =RandomStringUtils.random(4,"abz_cd");
		String randomeBTUname1 =RandomStringUtils.random(4,"qwez_");
		randomeBTUname="testvk_automation".concat(randomeBTUname);
		randomeBTUname=randomeBTUname.concat(randomeBTUname1);
		
		fluentwaitt(name).sendKeys(randomeBTUname);
		fluentwaitt(password).sendKeys(pw);
		fluentwaitt(username).sendKeys(un);
		fluentwaitt(urls).sendKeys(url);
		fluentwaitt(testbtn).click();
		Thread.sleep(4000);
		fluentwaitt(nextbtnn).click();
		Thread.sleep(4000);
		fluentwaitt(skpandsave).click();
		Thread.sleep(4000);
	}
}
