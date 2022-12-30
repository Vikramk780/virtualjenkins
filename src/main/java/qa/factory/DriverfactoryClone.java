package qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverfactoryClone{
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public WebDriver init_driver(String browser) {
	
		System.out.println("your are using followng browser---->"+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		
	}else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		tlDriver.set(new FirefoxDriver());
		
	}else {
		System.out.println("please provide proper browser");
	}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return getDriver();
	
		
	
	
//	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//	
//	
//	public WebDriver init_Driver(String browser) {
//		
//		System.out.println("Browser is "+browser);
//		
//		if (browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver());
//		}else if(browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDriver.set(new FirefoxDriver());
//		}
//		getDriver().manage().window().maximize();
//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	
	
	
}