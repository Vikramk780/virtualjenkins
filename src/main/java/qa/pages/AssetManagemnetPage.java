package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
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

public class AssetManagemnetPage {

	private static WebDriver driver;
	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(3000);

		return compnamefromlocator;

	}
	
	private By createbtn = By.xpath("(//p[contains(text(),\"Add\")])[1]");
	
	private By devicename = By.xpath("//input[@id='device_list_name']");
	private By description = By.xpath("//input[@id='description']");
	private By devicetype = By.xpath("//div[@id='device_type']");
	private By alkatel = By.xpath("//li[normalize-space()='Alcatel']");
	private By choosebtn = By.xpath("//label[@for='item']");
	private By savebtn = By.xpath("//button[@type='submit']");
	private By searchbar = By.xpath("//button[@title='Search']");
	private By searchbartextfield = By.xpath("//input[@placeholder=\"Search\"]");
	private By select = By.xpath("//td[3]");
	private By cross = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]");
	
	private By action = By.xpath("//div[@aria-label='Table Toolbar']//div[4]");
	
	
	public AssetManagemnetPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void createAsset() throws InterruptedException, AWTException {
		Robot rr = new Robot();
		driver.findElement(createbtn).click();
		
		String randomeBTUname =RandomStringUtils.random(4,"ab_cd");
		String randomeBTUname1 =RandomStringUtils.random(4,"qw_e");
		randomeBTUname="test_device".concat(randomeBTUname);
		randomeBTUname=randomeBTUname.concat(randomeBTUname1);
		driver.findElement(devicename).sendKeys(randomeBTUname);
		fluentwaitt(description).sendKeys("New Description");
		fluentwaitt(devicetype).click();
		fluentwaitt(alkatel).click();
		
		
		
		fluentwaitt(choosebtn).click();
		Thread.sleep(3000);
		StringSelection filepath= new  StringSelection("C:\\desktopCopyy\\Onboarding\\asset-list-sample.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Thread.sleep(1000);
		rr.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		
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
		
		
		fluentwaitt(searchbar).click();
		Thread.sleep(2000);
		
		fluentwaitt(searchbartextfield).sendKeys(randomeBTUname);
		Thread.sleep(2000);
		fluentwaitt(select).click();
		Thread.sleep(2000);
	
		
	}
	
	
	
}
