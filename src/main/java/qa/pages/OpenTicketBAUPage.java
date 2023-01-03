package qa.pages;

import org.openqa.selenium.WebDriver;

public class OpenTicketBAUPage {

	private WebDriver driver;
	Waithelper waithelper; 
	
	
	public OpenTicketBAUPage(WebDriver driver) {
		
		this.driver=driver;
		waithelper = new Waithelper(driver);
	}
	
	
}
