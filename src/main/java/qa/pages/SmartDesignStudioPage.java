package qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SmartDesignStudioPage {
	private WebDriver driver;
	Waithelper waithelper;
	private static String randomenamewithTestText111;

	private String propertiesworkflownametext;

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
		waithelper = new Waithelper(driver);
	}

	public void viewWorkflow() throws InterruptedException {
		driver.navigate().refresh();
		waithelper.forThisElementWait(workflowSelection, 20).click();
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

		waithelper.forThisElementWait(workflowSelection, 20).click();
		waithelper.forThisElementWait(actionDropDown, 20).click();

		waithelper.forThisElementWait(propertiesBtn, 20).click();

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
		waithelper.forThisElementWait(workflowSelection, 20).click();
		waithelper.forThisElementWait(actionDropDown, 20).click();
		Thread.sleep(2000);

		waithelper.forThisElementWait(propertiesBtn, 20).click();
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
		waithelper.forThisElementWait(workflowSelection, 20).click();
		waithelper.forThisElementWait(actionDropDown, 20).click();
		waithelper.forThisElementWait(clonebtn, 20).click();
		String alphabet = "abc";
		String s = RandomStringUtils.random(8, alphabet);

		randomenamewithTestText111 = "clone".concat(s);
		Thread.sleep(2000);
		waithelper.forThisElementWait(nametocloneWorkflow, 20).sendKeys(randomenamewithTestText111);
		waithelper.forThisElementWait(descriptiontocloneWorkflow, 20).sendKeys(randomenamewithTestText111);
		waithelper.forThisElementWait(savebtnofproperties, 20).click();
		waithelper.forThisElementWait(cloneclosebtn, 20).click();
		driver.navigate().refresh();
		Thread.sleep(3000);

		System.out.println("This is name of cloned workflow:" + randomenamewithTestText111);

	}

	public String deleteClonedOne() throws InterruptedException {
		waithelper.forThisElementWait(locatorforautualworkflowname, 20).click();
		waithelper.forThisElementWait(actionDropDown, 20).click();

		waithelper.forThisElementWait(deletBtn, 20).click();

		String successfullmsg = driver.findElement(deletionsuccessfullmsg).getText();

		return successfullmsg;

	}

	public String EditWorkflow() throws InterruptedException {
		waithelper.forThisElementWait(workflowSelection, 20).click();
		driver.findElement(actionDropDown).click();
		Thread.sleep(3000);
		driver.findElement(editbtn).click();

		Thread.sleep(4000);
		waithelper.forThisElementWait(studioactionDropDown, 20).click();
		waithelper.forThisElementWait(stdioworkflowsavebtn, 20).click();
		String successmsgfromstudio = driver.findElement(workflowsavesuccessmdg).getText();
		System.out.println("This is successfull saved text from get text" + successmsgfromstudio);
		Thread.sleep(1000);

		return successmsgfromstudio;

	}

}
