package qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartDesignStudioPage {
	private static WebDriver driver;
	private static String randomenamewithTestText111;

	private static String propertiesworkflownametext;

	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(1100);

		return compnamefromlocator;

	}

//	public static WebElement explicitlywaitt(By propertiesBtn2) {
//
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
//		// click on the compose button as soon as the "compose" button is visible
//		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);
//
//		return compnamefromlocator;
//
//	}

	private By workflowSelection = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]");

	private By actionDropDown = By.xpath("(//div[@id='basic-button'])[1]");
	private By stdioworkflowsavebtn = By.xpath("/html[1]/body[1]/div[2]/div[3]/ul[1]/li[2]");
	private By deletBtn = By.xpath("//li[normalize-space()='Delete']");

	private By clonebtn = By.xpath("//li[normalize-space()='Clone']");
	private By nametocloneWorkflow = By.xpath("//input[@id='botWorkflowName']");
	private By descriptiontocloneWorkflow = By.xpath("//textarea[@id='botWorkflowDesc']");

	private By propertiesBtn = By.xpath("//li[normalize-space()='Properties']");

	private By propertiesworkflowname = By.xpath("//input[@id='wfName']");
	private By studioactionDropDown = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[17]/div[1]/*[name()='svg'][1]");

	private By nextbtnofproperties = By.xpath("//button[@type='submit']");
	private By savebtnofproperties = By.xpath("//button[@type='submit']");

	private By workflowsavesuccessmdg = By.xpath("//p[normalize-space()='Workflow saved successfully']");

	private By viewbtn = By.cssSelector("div[id='action-menu'] li:nth-child(5)");

	private By viewedworkflowname = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/p[1]");

	private By cloneclosebtn = By.xpath("//span[normalize-space()='Close']");

	private By locatorforautualworkflowname = By.xpath("//div[contains(text(),'" + randomenamewithTestText111 + "')]");

	private By deletionsuccessfullmsg = By.xpath("(//p[contains(text(),'Workflow deleted successfully')])[2]");
	private By editbtn = By.xpath("//li[normalize-space()='Edit']");

	public SmartDesignStudioPage(WebDriver driver) {
		this.driver = driver;
	}

	public void viewWorkflow() throws InterruptedException {
		driver.navigate().refresh();
		fluentwaitt(workflowSelection).click();
		driver.findElement(actionDropDown).click();
		Thread.sleep(3000);
		driver.findElement(viewbtn).click();

		Thread.sleep(2000);

		String workflownamefromgettext = driver.findElement(viewedworkflowname).getText();
		Thread.sleep(2000);
		String newstringwithviewremove = workflownamefromgettext.replaceAll("View ", "");
		System.out.println(newstringwithviewremove);

	}

	public void propertiChange() throws UnsupportedFlavorException, IOException, InterruptedException {

		fluentwaitt(workflowSelection).click();
		fluentwaitt(actionDropDown).click();

		fluentwaitt(propertiesBtn).click();

		driver.findElement(propertiesworkflowname).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(propertiesworkflowname).sendKeys(Keys.chord(Keys.CONTROL, "c"));

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		propertiesworkflownametext = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(propertiesworkflownametext);

		String alphabet = "abc";
		String s = RandomStringUtils.random(8, alphabet);

		String randomenamewithTestText = "test".concat(s);

		System.out.println(randomenamewithTestText);

		driver.findElement(propertiesworkflowname).sendKeys(randomenamewithTestText);
		Thread.sleep(3000);
		driver.findElement(nextbtnofproperties).click();

		Thread.sleep(5000);
		driver.findElement(savebtnofproperties).click();

		Thread.sleep(5000);

		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	public void restorePropertiesChange() throws InterruptedException, UnsupportedFlavorException, IOException {
		fluentwaitt(workflowSelection).click();
		fluentwaitt(actionDropDown).click();
		Thread.sleep(2000);

		fluentwaitt(propertiesBtn).click();
		Thread.sleep(3000);
		System.out.println(propertiesworkflownametext);
		driver.findElement(propertiesworkflowname).clear();
		driver.findElement(propertiesworkflowname).sendKeys(propertiesworkflownametext);
		Thread.sleep(3000);
		driver.findElement(nextbtnofproperties).click();

		Thread.sleep(3000);
		driver.findElement(savebtnofproperties).click();

		Thread.sleep(5000);

		driver.navigate().refresh();
		Thread.sleep(5000);

	}

	public void CloneWorkflow() throws InterruptedException {
		fluentwaitt(workflowSelection).click();
		fluentwaitt(actionDropDown).click();
		fluentwaitt(clonebtn).click();
		String alphabet = "abc";
		String s = RandomStringUtils.random(8, alphabet);

		randomenamewithTestText111 = "clone".concat(s);
		Thread.sleep(2000);
		fluentwaitt(nametocloneWorkflow).sendKeys(randomenamewithTestText111);
		fluentwaitt(descriptiontocloneWorkflow).sendKeys(randomenamewithTestText111);
		fluentwaitt(savebtnofproperties).click();
		fluentwaitt(cloneclosebtn).click();
		driver.navigate().refresh();
		Thread.sleep(3000);

		System.out.println("This is name of cloned workflow:" + randomenamewithTestText111);

	}

	public String deleteClonedOne() throws InterruptedException {
		fluentwaitt(locatorforautualworkflowname).click();
		fluentwaitt(actionDropDown).click();

		fluentwaitt(deletBtn).click();

		String successfullmsg = driver.findElement(deletionsuccessfullmsg).getText();

		return successfullmsg;

	}

	public String EditWorkflow() throws InterruptedException {
		fluentwaitt(workflowSelection).click();
		driver.findElement(actionDropDown).click();
		Thread.sleep(3000);
		driver.findElement(editbtn).click();

		Thread.sleep(4000);
		fluentwaitt(studioactionDropDown).click();
		fluentwaitt(stdioworkflowsavebtn).click();
		String successmsgfromstudio = driver.findElement(workflowsavesuccessmdg).getText();
		System.out.println("This is successfull saved text from get text"+successmsgfromstudio);
		Thread.sleep(1000);

		return successmsgfromstudio;

	}

}
