package qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketExecutionPage {
	private static WebDriver driver;

	public static WebElement explicitlywaitt(By propertiesBtn2) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		// click on the compose button as soon as the "compose" button is visible
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return compnamefromlocator;

	}

	private String ticketIdNumber;

	private By ticketIdNumberr = By.xpath("//div[contains(text(),'" + ticketIdNumber + "')]");

	private By username = By.id("user_name");

	private By password = By.id("user_password");
	private By loginBtn = By.id("sysverb_login");
	private By crossBtn = By.xpath("//button[@class=\"close icon-cross\"]");
	private By goestodescriptionpage = By.xpath(
			"//a[@class='sn-widget-list-item sn-widget-list-item_hidden-action favorite-list-overwrite--title favorite-list-overwrite--title--display']//span[@class='sn-widget-list-title nav-favorite-title ng-binding nav-favorite-LIST'][normalize-space()='Self-Service - Incidents']");
	private By hamburgermenu = By.xpath("//button[@id='incident_control_button']");
	private By viewbtn = By.xpath("//div[normalize-space()='View']");
	private By defaultviewbtn = By.xpath("//div[normalize-space()='Default view']");
	private By newbtn = By.xpath("//button[@id='sysverb_new']");
	private By ticketid = By.xpath("//input[@id='incident.number']");
	private By shortdescription = By.xpath("//input[@id='incident.short_description']");
	private By descriptionn = By.xpath("//textarea[@id='incident.description']");
	private By submitbtn = By.xpath("//button[@id='sysverb_insert']");
	private By successbtn = By.cssSelector(
			"body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(4) > p:nth-child(3)");

	/* loginPageLocators */

	private By emailId = By.id("email");

	private By passwordOfStageapp = By.id("password");

	private By loginButton = By.xpath("//button[@type=\"submit\"]");
	private By forgotPasswordLink = By.linkText("Forgot your password ?");

	/* loginPageLocators */

	public TicketExecutionPage(WebDriver driver) {

		this.driver = driver;
	}

	public void enterUrlserviceNow(String url) {

		driver.get(url);
	}

	public void entersUsername(String usname) {
		driver.switchTo().frame("gsft_main");
		driver.findElement(username).sendKeys(usname);

	}

	public void entersPassword(String pswd) throws InterruptedException {

		driver.findElement(password).sendKeys(pswd);

		driver.findElement(loginBtn).click();
		Thread.sleep(5000);
		driver.findElement(crossBtn).click();
		Thread.sleep(2000);
	}

	public void entersDescription(String description, String namee)
			throws InterruptedException, UnsupportedFlavorException, IOException {

		driver.findElement(goestodescriptionpage).click();
		Thread.sleep(5000);

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		driver.findElement(hamburgermenu).click();
		driver.findElement(viewbtn).click();
		driver.findElement(defaultviewbtn).click();
		driver.findElement(newbtn).click();

		driver.findElement(ticketid).click();
		driver.findElement(ticketid).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(ticketid).sendKeys(Keys.chord(Keys.CONTROL, "c"));

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		ticketIdNumber = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println("//div[contains(text(),'" + ticketIdNumber + "')]");

//		  driver.findElement(shortdescription).sendKeys(description);
//		  
//		  
//		  WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='incident.description']")));
//			// click on the compose button as soon as the "compose" button is visible
//			WebElement compnamefromlocator1 = driver.findElement(By.xpath("//textarea[@id='incident.description']"));
//			compnamefromlocator1.sendKeys(description);

		if (namee.equals("createuser")) {

			String s = RandomStringUtils.random(4, "test");
			String s1 = RandomStringUtils.random(4, "abc");

			String firstname = description.replace("Test", "test" + s);
			String lastname = firstname.replace("test2", "test" + s1);
			String email = lastname.replace("test", "user" + s1);
			String email1 = email.replace("round", "user" + s1);
           System.out.println(email1);
			driver.findElement(shortdescription).sendKeys(email1);
			driver.findElement(descriptionn).sendKeys(email1);

		} else if (namee.equals("reset")) {
			String s = RandomStringUtils.random(4, "test");
			String activedirusenamedescripton = description.replace("nisha", "user" + s);
			driver.findElement(shortdescription).sendKeys(activedirusenamedescripton);
			driver.findElement(descriptionn).sendKeys(activedirusenamedescripton);

		} else if (namee.equals("vpn")) {
			String s = RandomStringUtils.random(4, "test");
			String activedirusenamedescripton = description.replace("nisha", "user" + s);
			driver.findElement(shortdescription).sendKeys(activedirusenamedescripton);
			driver.findElement(descriptionn).sendKeys(activedirusenamedescripton);

		} else if (namee.equals("deletappuser")) {
			String s = RandomStringUtils.random(4, "test");
			String emaildescripton = description.replace("test", "abc" + s);
			String emaildesc = emaildescripton.replace("user1", "user" + s);
			System.out.println(emaildesc);
			driver.findElement(shortdescription).sendKeys(emaildesc);
			driver.findElement(descriptionn).sendKeys(emaildesc);

		} else {

			driver.findElement(shortdescription).sendKeys(description);
			driver.findElement(descriptionn).sendKeys(description);
		}

//		driver.findElement(shortdescription).sendKeys(description);
//		driver.findElement(descriptionn).sendKeys(description);
		driver.findElement(submitbtn).click();
		System.out.println(ticketIdNumber);
		Thread.sleep(2000);

	}

	public void logintoStageapp(String un, String pw) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(passwordOfStageapp).sendKeys(pw);
		driver.findElement(loginButton).click();

	}

/////////////////////////////////////////////////////
	/* this is for eventhubbtucreation */
	public void entersDescription1() throws InterruptedException, UnsupportedFlavorException, IOException {

		driver.findElement(goestodescriptionpage).click();
		Thread.sleep(5000);

		driver.switchTo().frame("gsft_main");
		driver.findElement(hamburgermenu).click();
		driver.findElement(viewbtn).click();
		driver.findElement(defaultviewbtn).click();
		driver.findElement(newbtn).click();

		driver.findElement(ticketid).click();
		driver.findElement(ticketid).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(ticketid).sendKeys(Keys.chord(Keys.CONTROL, "c"));

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		ticketIdNumber = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println("//div[contains(text(),'" + ticketIdNumber + "')]");

		driver.findElement(shortdescription).sendKeys("Create s3 bucket with name testbuckte");
		driver.findElement(descriptionn).sendKeys("Create s3 bucket with name testbuckte");
		driver.findElement(submitbtn).click();
		System.out.println(ticketIdNumber);
		Thread.sleep(2000);

	}
	
	public void entersDescription2() throws InterruptedException, UnsupportedFlavorException, IOException {

		
		driver.findElement(newbtn).click();

		driver.findElement(ticketid).click();
		driver.findElement(ticketid).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(ticketid).sendKeys(Keys.chord(Keys.CONTROL, "c"));

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		ticketIdNumber = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println("//div[contains(text(),'" + ticketIdNumber + "')]");

		driver.findElement(shortdescription).sendKeys("Create s3 bucket with name testbuckte");
		driver.findElement(descriptionn).sendKeys("Create s3 bucket with name testbuckte");
		driver.findElement(submitbtn).click();
		System.out.println(ticketIdNumber);
		Thread.sleep(2000);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//////////////////////////////////////////////////////////

	public String userCheckExecutiondetails(String resultt) throws InterruptedException {
		System.out.println(ticketIdNumber);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Botprise Lab']")));
		// click on the compose button as soon as the "compose" button is visible
		WebElement compnamefromlocator = driver.findElement(By.xpath("//td[normalize-space()='Botprise Lab']"));
		compnamefromlocator.click();

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(5000);

		System.out.println(ticketIdNumber);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + ticketIdNumber + "')]")));
		// click on the compose button as soon as the "compose" button is visible
		WebElement ticketnumber = driver.findElement(By.xpath("//div[contains(text(),'" + ticketIdNumber + "')]"));
		Thread.sleep(4000);
		ticketnumber.click();

		Thread.sleep(7000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		driver.navigate().refresh();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-100)", "");
		Thread.sleep(7000);

		String output = explicitlywaitt(successbtn).getText();

		System.out.println(output);
		return output;

	}

}