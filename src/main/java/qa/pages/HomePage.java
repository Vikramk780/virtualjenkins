package qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {

	private static WebDriver driver;

	public static WebElement fluentwaitt(By propertiesBtn2) throws InterruptedException {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(propertiesBtn2));
		WebElement compnamefromlocator = driver.findElement(propertiesBtn2);

		Thread.sleep(3000);

		return compnamefromlocator;

	}


	private By smartstudiomenu = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[3]/div[1]/div[1]");

	private By catalogmenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[4]");

	private By companyName = By.xpath("//td[normalize-space()='Botprise Lab']");
	private By eventhubmenu = By.xpath("//span[normalize-space()='Event Hub']");
	
	private By DevWorkbenchMenu = By.xpath("//span[contains(text(),\"Developer Workbench\")]");

	private By integrations = By.xpath("(//span[contains(text(),\"Integrations\")])[1]");
	
	private By hambergermenu =By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/button[1]/span[1]/*[name()='svg'][1]");
	
	private By BAuPage = By.xpath("//span[contains(text(),'BAU (Automation Units)')]");
	private By assetmanagementMenu = By.xpath("//span[normalize-space()='Asset Management']");
	private By securitymanagemnetmenu = By.xpath("//span[contains(text(),\"Security Management\")]");
	private By inetgrationMeshMenu = By.xpath("//span[contains(text(),\"Integration Mesh\")]");
	private By Botpriselink = By.xpath("(//div[contains(text(),\"Botprise Lab\")])[1]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getcomanyName() throws InterruptedException {

//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Botprise Lab']")));
//		// click on the compose button as soon as the "compose" button is visible
//		WebElement compnamefromlocator = driver.findElement(By.xpath("//td[normalize-space()='Botprise Lab']"));
//		String cbotpriselabname = compnamefromlocator.getText();
//
//		return cbotpriselabname;
		String nameofbotprislab =fluentwaitt(Botpriselink).getText();
		return nameofbotprislab;
		
		
	}
	
	

	public CatalogPage gotoCatalogPage() throws InterruptedException {
		Thread.sleep(3000);
		fluentwaitt(catalogmenu).click();
		Thread.sleep(3000);

		return new CatalogPage(driver);
	}

	public SmartDesignStudioPage gotoSmartDesignStudio() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(smartstudiomenu).click();
		Thread.sleep(3000);

		return new SmartDesignStudioPage(driver);	
	}	
	
	
	public EventHubPage gotoEventHubpage() throws InterruptedException {
		Thread.sleep(3000);
//		fluentwaitt(hambergermenu).click();
		fluentwaitt(eventhubmenu).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		return new EventHubPage(driver);
	}
	
	
	public IntegrationModellerPage gotoIntegrationModellerPage() throws InterruptedException {
		Thread.sleep(3000);
		fluentwaitt(DevWorkbenchMenu).click();
		fluentwaitt(integrations).click();
		Thread.sleep(3000);

		return new IntegrationModellerPage(driver);
	}
	
	public BauModellerPage gotoInBauModellerPage() throws InterruptedException {
		Thread.sleep(3000);
		fluentwaitt(DevWorkbenchMenu).click();
		fluentwaitt(BAuPage).click();
		Thread.sleep(3000);

		return new BauModellerPage(driver);
	}
	
	public AssetManagemnetPage AssetManagemnetPage() throws InterruptedException {
		Thread.sleep(3000);
		fluentwaitt(assetmanagementMenu).click();
		
		Thread.sleep(3000);

		return new AssetManagemnetPage(driver);
	}
	
	public SecurityManageMentPage SecurityManageMentPage() throws InterruptedException {
		Thread.sleep(3000);
		fluentwaitt(securitymanagemnetmenu).click();
		
		Thread.sleep(3000);
		
		return new SecurityManageMentPage(driver);
	}
	
	public IntegrationbMeshPage IntegrationbMeshPage() throws InterruptedException {
		Thread.sleep(3000);
		fluentwaitt(inetgrationMeshMenu).click();
		
		Thread.sleep(3000);
		return new IntegrationbMeshPage(driver);
	}

	

}
