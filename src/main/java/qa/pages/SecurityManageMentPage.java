package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SecurityManageMentPage {
private By addbtn = By.xpath("(//p[contains(text(),\"Add\")])[1]");
private By addbtn2 = By.xpath("(//p[contains(text(),\"Add\")])[3]");
private By text = By.xpath("(//li[contains(text(),\"Text\")])[1]");
private By filebtn =By.xpath("(//li[contains(text(),\"File\")])[1]");
private By securitymanagerdrop = By.xpath("//div[@id='security_manager']");
private By vault = By.xpath("//li[@role='option']");
private By nameofsecret = By.xpath("//input[@id='name']");
private By textofsecret = By.xpath("//input[@id='file']");
private By savebtn = By.xpath("//button[@type='submit']");
private By chosefile = By.xpath("//label[@for='item']");
private By linkmanagement = By.xpath("//a[normalize-space()='Security Management']");
private By windowscreds = By.xpath("//body[1]/div[5]/div[3]/ul[1]/li[2]");
private By terminalcreds = By.xpath("(//li[@role='menuitem'][normalize-space()='Terminal'])[1]");
private By authscemen = By.xpath("//div[@id='auth_scheme']");
private By windowsdomain = By.xpath("//input[@id='domain']");
private By username = By.xpath("//input[@id='user_name']");
private By secretsdrop = By.xpath("//div[@id='secrets']");
private By connectionType = By.xpath("//div[@id='connection_type']");
private By ssh = By.xpath("//li[normalize-space()='SSH']");
private By port = By.xpath("//input[@id='port']");
private By authscema = By.xpath("//div[@id='auth_scheme']");
private By sshauth = By.xpath("//li[normalize-space()='SSH Password/Key']");
private By passphras = By.xpath("//div[@id='passphrase']");
private By passphrasselect = By.xpath("//li[@role='option']");
	private static WebDriver driver;
	
	private HomePage homePage;
	
	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(3000);

		return compnamefromlocator;

	}
	
	public SecurityManageMentPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public void createsecrete() throws InterruptedException {
		
		fluentwaitt(addbtn).click();
		fluentwaitt(text).click();
		fluentwaitt(securitymanagerdrop).click();
		fluentwaitt(vault).click();
		
		String randomeBTUname =RandomStringUtils.random(4,"aba_cd");
		String randomeBTUname1 = "secret".concat(randomeBTUname+"te_lst");

		fluentwaitt(nameofsecret).sendKeys(randomeBTUname1);
		fluentwaitt(textofsecret).sendKeys(randomeBTUname1);
		fluentwaitt(savebtn).click();
		Thread.sleep(2000);
	}
	
public void createfile() throws InterruptedException, AWTException {
	Robot rr = new Robot();
//		fluentwaitt(addbtn).click();
		fluentwaitt(filebtn).click();
		
		fluentwaitt(securitymanagerdrop).click();
		fluentwaitt(vault).click();
		String randomeBTUname =RandomStringUtils.random(4,"abcd");
		String randomeBTUname1 = "secret".concat(randomeBTUname+"te_st");

		fluentwaitt(nameofsecret).sendKeys(randomeBTUname1);
		fluentwaitt(chosefile).click();
		Thread.sleep(2000);
		StringSelection filepath= new  StringSelection("C:\\desktopCopyy\\DekstopTextfiles\\AllBots.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Thread.sleep(1000);
		rr.keyPress(KeyEvent.VK_CONTROL);
		
		
		rr.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		rr.keyRelease(KeyEvent.VK_V);
		rr.keyRelease(KeyEvent.VK_CONTROL);
		
		rr.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rr.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		
		
		
		fluentwaitt(savebtn).click();
		Thread.sleep(3000);
		
	}

public void createCreds() throws InterruptedException, AWTException {
	Robot rr1 = new Robot();
	driver.navigate().refresh();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", "");
	Thread.sleep(3000);
	fluentwaitt(addbtn2).click();
	fluentwaitt(windowscreds).click();
	
	String randomeBTUname11 = RandomStringUtils.random(4,"abcd");
	String randomeBTUname11aa= "test_windows".concat(randomeBTUname11+"test");
	fluentwaitt(nameofsecret).sendKeys(randomeBTUname11aa);
	fluentwaitt(authscemen).click();
	fluentwaitt(vault).click();
	fluentwaitt(windowsdomain).sendKeys("cc");
	
	fluentwaitt(username).sendKeys(randomeBTUname11aa);
	fluentwaitt(secretsdrop).click();
	rr1.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	rr1.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	fluentwaitt(savebtn).click();
	Thread.sleep(4000);
}

public void createCredsforTeminal() throws InterruptedException, AWTException {
	Robot rr2 = new Robot();
	fluentwaitt(terminalcreds).click();
	
	String randomeBTUname11 = RandomStringUtils.random(4,"abcd");
	String randomeBTUname11aa= "test_Terminal".concat(randomeBTUname11+"teso_t");
	fluentwaitt(nameofsecret).sendKeys(randomeBTUname11aa);
	
	fluentwaitt(connectionType).click();
	fluentwaitt(ssh).click();
	fluentwaitt(port).sendKeys("8080");
	fluentwaitt(authscema).click();
	fluentwaitt(sshauth).click();
	
	fluentwaitt(username).sendKeys(randomeBTUname11aa);
	fluentwaitt(secretsdrop).click();
	rr2.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	rr2.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	fluentwaitt(passphras).click();
	Thread.sleep(2000);
	
	fluentwaitt(passphrasselect).click();
	Thread.sleep(1000);
	fluentwaitt(savebtn).click();
	Thread.sleep(4000);
}



}
