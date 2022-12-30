package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntegrationModellerPage {
	private static WebDriver driver;
	
	private By createbtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	private By name = By.xpath("(//input[@id='name'])[2]");
	
	private By typeDrope = By.xpath("(//div[@id='type'])[2]");
	
	private By itsmvalue = By.xpath("//li[11]");
	private By selecttypeDrope = By.xpath("(//input[@type='checkbox'])[27]");
	private By supportVersion = By.xpath("(//input[@id='free-chip-input'])[5]");
	private By variableDefination = By.xpath("(//input[@id='free-chip-input'])[6]");
	private By servicenow_instance = By.xpath("(//input[@type=\"text\"])[11]");
	private By username_ = By.xpath("(//input[@type=\"text\"])[12]");
	
	private By password_ = By.xpath("(//input[@type=\"text\"])[13]");
	
	private By imageupload = By.xpath("(//label[contains(text(),\"Select file \")])[1]");
	
	private By uploadbtn = By.xpath("(//button[@type=\"button\"])[22]");
	
	private By categorydrop = By.xpath("(//input[@id='free-chip-input'])[7]"); //WebElement.sendKeys(Keys.DOWN, Keys.RETURN);
	private By curlfield = By.xpath("(//textarea[@id='curlOperation'])[2]");
	private By testBTN = By.xpath("(//button[@type=\"submit\"])[2]");
	private By nextbtn = By.xpath("(//button[@type=\"button\"])[24]");
	private By textarea = By.xpath("(//textarea[@placeholder='Write a few words about the integration and what it helps achieve'])[1]");
	private By textarea2 = By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/textarea[1]");
	private By capebilities = By.xpath("(//textarea[@name=\"capabilities\"])[1]");
	private By certification = By.xpath("(//input[@name='certificationLevel'])[5]");
	private By savebtnn = By.xpath("(//button[@type=\"submit\"])[2]");
	
	
	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(3000);

		return compnamefromlocator;

	}
	
	
	
	

	public IntegrationModellerPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void CreateIntegrationThroughmodeller() throws InterruptedException, AWTException {
		Robot rr = new Robot();
		
		fluentwaitt(createbtn).click();
		Thread.sleep(2000);
		
				
		String randomeBTUname =RandomStringUtils.random(4,"abca_d");
		String randomeBTUname1 = "testAutomation".concat(randomeBTUname+"tem_st");
//		driver.findElement(name).click();
		driver.findElement(name).sendKeys(randomeBTUname1);
		fluentwaitt(typeDrope).click();
		Thread.sleep(3000);
		driver.findElement(itsmvalue).click();
		
		Thread.sleep(2000);
		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
		
		driver.findElement(supportVersion).sendKeys("1.1");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
			
		
		fluentwaitt(variableDefination).sendKeys("servicenow_instance");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		fluentwaitt(variableDefination).sendKeys("username");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		fluentwaitt(variableDefination).sendKeys("password");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		fluentwaitt(categorydrop).click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		driver.findElement(curlfield).sendKeys("curl -XPOST -H \"Content-type: application/json\" -d '{\"description\":\"Test Description\"}' 'https://$servicenow_instance/api/now/table/incident' -u $username:'$password'");
		
		
		
		
		driver.findElement(servicenow_instance).sendKeys("dev59080.service-now.com");
		driver.findElement(username_).sendKeys("admin");
		driver.findElement(password_).sendKeys("eh8+IZ%zZiU8");

		Thread.sleep(1000);
		
JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebElement webElement = driver.findElement(By.xpath("(//label[contains(text(),\"Select file \")])[1]"));
		jse.executeScript("arguments[0].click();", webElement);
		
		
		Thread.sleep(3000);
		
		
		
		
		StringSelection filepath= new  StringSelection("C:\\Users\\kvikram\\Downloads\\SNOW.jfif");
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
		
		driver.findElement(uploadbtn).click();
		Thread.sleep(3000);
		
		
		driver.findElement(testBTN).click();
		Thread.sleep(4000);
		driver.findElement(nextbtn).click();
		Thread.sleep(3000);
//		WebElement webElement1 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]"));
//		jse.executeScript("arguments[0].value='---your email id---';", webElement1);
		
		

		
//		driver.findElement(textarea).click();
		
//	r.keyPress(KeyEvent.VK_ENTER);
//	
//		
//		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//textarea[@placeholder='Write a few words about the integration and what it helps achieve'])[2]")).sendKeys("Open Ticket ,Close Ticket");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//textarea[@placeholder='Write a few words about the capabilities and potential tasks that can be achieved by this integration - example: Open a ticker, update a ticket, assign ticket to a queue, etc.'])[2]")).sendKeys("This Integration Is having Capability to open ticket and close ticket");
		Thread.sleep(2000);
//		driver.findElement(textarea).click();
//		driver.findElement(textarea).sendKeys("New Integration For Snow,New Integration For Snow,");
//		Thread.sleep(1000);
//		driver.findElement(textarea2).sendKeys("New Integration For Snow,New Integration For Snow,");
//		
//		Thread.sleep(1000);
//		driver.findElement(capebilities).sendKeys("New Integration For Snow,New Integration For Snow, New Snow For Snow,New Integration For Snow,");
		
		
		driver.findElement(savebtnn).click();
		Thread.sleep(3000);

		

		  
		
		
		
		
		
//		WebElement webElement = driver.findElement(name);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
//		webElement.sendKeys(randomeBTUname1);
//		System.out.println(randomeBTUname1);
		
		
		 
		
		
	
		Thread.sleep(3000);
	}
}
