package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	Waithelper waithelper;

	private By smartstudiomenu = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[3]/div[1]/div[1]");

	private By catalogmenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[4]");

	private By companyName = By.xpath("//td[normalize-space()='Botprise Lab']");
	private By eventhubmenu = By.xpath("//span[normalize-space()='Event Hub']");

	private By DevWorkbenchMenu = By.xpath("//span[contains(text(),\"Developer Workbench\")]");

	private By integrations = By.xpath("(//span[contains(text(),\"Integrations\")])[1]");

	private By hambergermenu = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/button[1]/span[1]/*[name()='svg'][1]");

	private By BAuPage = By.xpath("//span[contains(text(),'BAU (Automation Units)')]");
	private By assetmanagementMenu = By.xpath("//span[normalize-space()='Asset Management']");
	private By securitymanagemnetmenu = By.xpath("//span[contains(text(),\"Security Management\")]");
	private By inetgrationMeshMenu = By.xpath("//span[contains(text(),\"Integration Mesh\")]");
	private By Botpriselink = By.xpath("(//div[contains(text(),\"Botprise Lab\")])[1]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		waithelper = new Waithelper(driver);

	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getcomanyName() throws InterruptedException {

		String nameofbotprislab = waithelper.forThisElementWait(Botpriselink, 20).getText();
		return nameofbotprislab;

	}

	public CatalogPage gotoCatalogPage() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.forThisElementWait(catalogmenu, 20).click();
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
//		waithelper.forThisElementWait(hambergermenu).click();
		waithelper.forThisElementWait(eventhubmenu, 20).click();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		return new EventHubPage(driver);
	}

	public IntegrationModellerPage gotoIntegrationModellerPage() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.forThisElementWait(DevWorkbenchMenu, 20).click();
		waithelper.forThisElementWait(integrations, 20).click();
		Thread.sleep(3000);

		return new IntegrationModellerPage(driver);
	}

	public BauModellerPage gotoInBauModellerPage() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.forThisElementWait(DevWorkbenchMenu, 20).click();
		waithelper.forThisElementWait(BAuPage, 20).click();
		Thread.sleep(3000);

		return new BauModellerPage(driver);
	}

	public AssetManagemnetPage AssetManagemnetPage() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.forThisElementWait(assetmanagementMenu, 20).click();

		Thread.sleep(3000);

		return new AssetManagemnetPage(driver);
	}

	public SecurityManageMentPage SecurityManageMentPage() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.forThisElementWait(securitymanagemnetmenu, 20).click();

		Thread.sleep(3000);

		return new SecurityManageMentPage(driver);
	}

	public IntegrationbMeshPage IntegrationbMeshPage() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.forThisElementWait(inetgrationMeshMenu, 20).click();

		Thread.sleep(3000);
		return new IntegrationbMeshPage(driver);
	}

}
