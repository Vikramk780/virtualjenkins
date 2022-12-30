package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {

	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(1500);

		return compnamefromlocator;

	}

//	public static WebElement explicitlywaitt(By propertiesBtn2) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
//		// click on the compose button as soon as the "compose" button is visible
//		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);
//		
//		Thread.sleep(3000);
//
//		return compnamefromlocator;
//
//	}

	private static WebDriver driver;

	private By templateslection = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]");
	private By actionDropDown = By.xpath("(//div[@id='basic-button'])[1]");
	private By showTemplate = By.cssSelector("div[id='action-menu'] li:nth-child(3)");
	private By launchinStudioactionBtn = By.cssSelector("div[id='action-menu'] li:nth-child(2)");
	private By selectedTemplateviewpopuptext = By.xpath("//p[normalize-space()='Selected template view']");
	private By afterlaunchnextbtn = By.xpath("//span[normalize-space()='Next']");
	private By ticketingtoolsdrop = By.xpath("(//div[@role='button'])[1]");
	private By ticketingtoolsselect = By.xpath("//li[@role='option']");
	private By integrationselectbtndrop = By.xpath("(//div[@role='button'])[2]");

	private By adminintegration = By.xpath("//li[normalize-space()='admin']");

	private By btudropdown = By.xpath("(//div[@role='button'])[3]");

	private By btuselect = By.xpath("/html[1]/body[1]/div[4]/div[3]/ul[1]/li[1]");
	private By studioactionDropDown = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[17]/div[1]/*[name()='svg'][1]");
	private By propertiesbtn = By.xpath("//li[normalize-space()='Properties']");
	private By workflowname = By.xpath("//input[@id='wfName']");
	private By workflowdescrip = By.xpath("//textarea[@id='wfDesc']");
	private By automationArea = By.xpath("//div[@class='jss620 jss626']//input[@id='tags-outlined']");
	private By integrationdrop = By.xpath("(//input[@id='tags-outlined'])[2]");

	private By autocheckout = By.id("autonomous");
	private By savebtn = By.xpath("//span[normalize-space()='Save']");
	private By workflowsavesuccessmdg = By.xpath("//p[normalize-space()='Workflow saved successfully']");

	public CatalogPage(WebDriver driver) {

		this.driver = driver;
	}

	public void selectTemplate() throws InterruptedException {
		
		
		fluentwaitt(templateslection).click();
	}

	public void clickOnShowAction() throws InterruptedException {
		fluentwaitt(actionDropDown).click();
		fluentwaitt(showTemplate).click();
	}

	public void verifyTemplatesSlectedViewpopup() throws InterruptedException {
		fluentwaitt(selectedTemplateviewpopuptext).click();
	}

	public String launchinStudio() throws InterruptedException, AWTException {
		fluentwaitt(actionDropDown).click();
		fluentwaitt(launchinStudioactionBtn).click();
		fluentwaitt(afterlaunchnextbtn).click();
		fluentwaitt(ticketingtoolsdrop).click();
		fluentwaitt(ticketingtoolsselect).click();
		fluentwaitt(integrationselectbtndrop).click();
		fluentwaitt(adminintegration).click();
		fluentwaitt(btudropdown).click();
		fluentwaitt(btuselect).click();
		fluentwaitt(afterlaunchnextbtn).click();
		fluentwaitt(studioactionDropDown).click();
		fluentwaitt(propertiesbtn).click();

		String randometext2 = RandomStringUtils.random(4, "_abc");
		String randometext = RandomStringUtils.random(4, "automation_");
		String textt = "test_Automation".concat(randometext);
		fluentwaitt(workflowname).sendKeys(textt + "test" + randometext2);
		fluentwaitt(workflowdescrip).sendKeys(textt);
		fluentwaitt(integrationdrop).click();

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		fluentwaitt(afterlaunchnextbtn).click();

//		fluentwaitt(autocheckout).click();
//		fluentwaitt(savebtn).click();
		String successmsgfromstudio = driver.findElement(workflowsavesuccessmdg).getText();
		Thread.sleep(1000);

		return successmsgfromstudio;

	}

}
