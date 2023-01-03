package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

	private WebDriver driver;
	Waithelper waithelper;

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
		waithelper = new Waithelper(driver);
	}

	public void selectTemplate() throws InterruptedException {

		waithelper.forThisElementWait(templateslection, 20).click();
	}

	public void clickOnShowAction() throws InterruptedException {
		waithelper.forThisElementWait(actionDropDown, 20).click();
		waithelper.forThisElementWait(showTemplate, 20).click();
	}

	public void verifyTemplatesSlectedViewpopup() throws InterruptedException {
		waithelper.forThisElementWait(selectedTemplateviewpopuptext, 20).click();
	}

	public String launchinStudio() throws InterruptedException, AWTException {
		waithelper.forThisElementWait(actionDropDown, 20).click();
		waithelper.forThisElementWait(launchinStudioactionBtn, 20).click();
		waithelper.forThisElementWait(afterlaunchnextbtn, 20).click();
		waithelper.forThisElementWait(ticketingtoolsdrop, 20).click();
		waithelper.forThisElementWait(ticketingtoolsselect, 20).click();
		waithelper.forThisElementWait(integrationselectbtndrop, 20).click();
		waithelper.forThisElementWait(adminintegration, 20).click();
		waithelper.forThisElementWait(btudropdown, 20).click();
		waithelper.forThisElementWait(btuselect, 20).click();
		waithelper.forThisElementWait(afterlaunchnextbtn, 20).click();
		waithelper.forThisElementWait(studioactionDropDown, 20).click();
		waithelper.forThisElementWait(propertiesbtn, 20).click();

		String randometext2 = RandomStringUtils.random(4, "_abc");
		String randometext = RandomStringUtils.random(4, "automation_");
		String textt = "test_Automation".concat(randometext);
		waithelper.forThisElementWait(workflowname, 20).sendKeys(textt + "test" + randometext2);
		waithelper.forThisElementWait(workflowdescrip, 20).sendKeys(textt);
		waithelper.forThisElementWait(integrationdrop, 20).click();

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		waithelper.forThisElementWait(afterlaunchnextbtn, 20).click();

//		waithelper.forThisElementWait(autocheckout).click();
//		waithelper.forThisElementWait(savebtn).click();
		String successmsgfromstudio = driver.findElement(workflowsavesuccessmdg).getText();
		Thread.sleep(1000);

		return successmsgfromstudio;

	}

}
