package qa.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.factory.DriverFactory;


public class ServicenowPage {
	Properties prop;
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private By serusername = By.id("user_name");
		private By serpassword = By.id("user_password");
		private By serlgtbtn = By.id("sysverb_login");
		
		public ServicenowPage(WebDriver driver) {
			this.driver=driver;
		}
		
		
		
		public void LoginToServiceNow(String url ) {
//			String BrowserName = prop.getProperty("browser");
//			driverFactory.init_driver(BrowserName);
			driver.get(url);
			driver.findElement(serusername).sendKeys("admin");
			
			driver.findElement(serpassword).sendKeys("nsHD9Dzn9JXm");
			driver.findElement(serlgtbtn).click();
			
			
		}

}
