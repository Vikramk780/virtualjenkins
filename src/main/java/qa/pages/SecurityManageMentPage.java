package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SecurityManageMentPage {
	private By addbtn = By.xpath("(//p[contains(text(),\"Add\")])[1]");
	private By addbtn2 = By.xpath("(//p[contains(text(),\"Add\")])[3]");
	private By text = By.xpath("(//li[contains(text(),\"Text\")])[1]");
	private By filebtn = By.xpath("(//li[contains(text(),\"File\")])[1]");
	private By securitymanagerdrop = By.xpath("//input[@id='security_manager']");
	private By vault = By.xpath("//li[@role='option']");
	private By nameofsecret = By.xpath("//input[@id='name']");
	private By textofsecret = By.xpath("//input[@id='file']");
	private By savebtn = By.xpath("//button[@type='submit']");
	private By chosefile = By.xpath("//label[@for='item']");
	private By linkmanagement = By.xpath("//a[normalize-space()='Security Management']");
	private By windowscreds = By.xpath("//body[1]/div[5]/div[3]/ul[1]/li[2]");
	private By terminalcreds = By.xpath("(//li[@role='menuitem'][normalize-space()='Terminal'])[1]");
	private By authscemen = By.xpath("//input[@id='auth_scheme']");
	private By windowsdomain = By.xpath("//input[@id='domain']");
	private By username = By.xpath("//input[@id='user_name']");
	private By secretsdrop = By.xpath("//input[@id='secrets']");
	private By connectionType = By.xpath("//input[@id='connection_type']");
	private By ssh = By.xpath("//li[normalize-space()='SSH']");
	private By port = By.xpath("//input[@id='port']");
	private By authscema = By.xpath("//input[@id='auth_scheme']");
	private By sshauth = By.xpath("//li[normalize-space()='SSH Password/Key']");
	private By passphras = By.xpath("//input[@id='passphrase']");
	private By passphrasselect = By.xpath("//li[@role='option']");
	private By selectsecrete = By.xpath("//li[contains(text(),\"TestTextFile\")]");

	private WebDriver driver;
	Waithelper waithelper;

	private HomePage homePage;

	public SecurityManageMentPage(WebDriver driver) {

		this.driver = driver;
		waithelper = new Waithelper(driver);
	}

	public void createsecrete() throws InterruptedException {

		waithelper.forThisElementWait(addbtn, 10).click();
		waithelper.forThisElementWait(text, 10).click();
		waithelper.forThisElementWait(securitymanagerdrop, 15).click();
		waithelper.forThisElementWait(vault, 15).click();

		String randomeBTUname = RandomStringUtils.random(4, "aqba_cd");
		String randomeBTUname1 = "secret".concat(randomeBTUname + "te_lst");

		waithelper.forThisElementWait(nameofsecret, 15).sendKeys(randomeBTUname1);
		waithelper.forThisElementWait(textofsecret, 15).sendKeys(randomeBTUname1);
		waithelper.forThisElementWait(savebtn, 15).click();
		Thread.sleep(2000);
	}

	public void createfile() throws InterruptedException, AWTException {
		Robot rr = new Robot();
		Thread.sleep(2000);
//		waithelper.forThisElementWait(addbtn,35).click();
		waithelper.forThisElementWait(filebtn, 35).click();

		waithelper.forThisElementWait(securitymanagerdrop, 15).click();
		waithelper.forThisElementWait(vault, 15).click();
		String randomeBTUname = RandomStringUtils.random(4, "abcd");
		String randomeBTUname1 = "secret".concat(randomeBTUname + "te_st");

		waithelper.forThisElementWait(nameofsecret, 15).sendKeys(randomeBTUname1);
		waithelper.forThisElementWait(chosefile, 15).click();
		Thread.sleep(2000);
		StringSelection filepath = new StringSelection("C:\\desktopCopyy\\DekstopTextfiles\\AllBots.txt");
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

		waithelper.forThisElementWait(savebtn, 15).click();
		Thread.sleep(3000);

	}

	public void createCreds() throws InterruptedException, AWTException {

		driver.navigate().refresh();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		waithelper.forThisElementWait(addbtn2, 15).click();
		waithelper.forThisElementWait(windowscreds, 15).click();

		String randomeBTUname11 = RandomStringUtils.random(4, "abcd");
		String randomeBTUname11aa = "test_windowsc".concat(randomeBTUname11 + "test");
		waithelper.forThisElementWait(nameofsecret, 15).sendKeys(randomeBTUname11aa);
		waithelper.forThisElementWait(authscemen, 15).click();
		waithelper.forThisElementWait(vault, 15).click();
		waithelper.forThisElementWait(windowsdomain, 15).sendKeys("cc");

		waithelper.forThisElementWait(username, 15).sendKeys(randomeBTUname11aa);
		waithelper.forThisElementWait(secretsdrop, 15).click();

		waithelper.forThisElementWait(selectsecrete, 15).click();
		waithelper.forThisElementWait(savebtn, 15).click();
		Thread.sleep(4000);
	}

	public void createCredsforTeminal() throws InterruptedException, AWTException {

		waithelper.forThisElementWait(terminalcreds, 15).click();

		String randomeBTUname11 = RandomStringUtils.random(4, "abcd");
		String randomeBTUname11aa = "test_Terminalc".concat(randomeBTUname11 + "teso_t");

		waithelper.forThisElementWait(nameofsecret, 15).sendKeys(randomeBTUname11aa);

		waithelper.forThisElementWait(connectionType, 15).click();
		waithelper.forThisElementWait(ssh, 15).click();
		waithelper.forThisElementWait(port, 15).sendKeys("8080");
		waithelper.forThisElementWait(authscema, 15).click();
		waithelper.forThisElementWait(sshauth, 15).click();

		waithelper.forThisElementWait(username, 15).sendKeys(randomeBTUname11aa);
		waithelper.forThisElementWait(secretsdrop, 15).click();

		waithelper.forThisElementWait(selectsecrete, 15).click();

		waithelper.forThisElementWait(passphras, 15).click();

		waithelper.forThisElementWait(passphrasselect, 15).click();

		waithelper.forThisElementWait(savebtn, 15).click();
		Thread.sleep(4000);
	}

}
