package qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class whatsapp{
	
	private static WebDriver driver;
	
//	webDriverwait
	
	public static void webDriverwaitt() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Botprise Lab']")));
	}
	// click on the compose button as soon as the "compose" button is visible
	
	
//	fluentWait
	public static WebElement fluentwaiit(By element) {
		
		
		
		
	Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);               
	 wait1.until(ExpectedConditions.visibilityOfElementLocated(element));
	
	 WebElement newelemet = driver.findElement(element);
	 return newelemet;
	}
	

	
	
	

	
	
	
	void send(String msg1) {
		System.out.println("sending..mg in text format"+msg1);
	}
}

class whatsapp2 extends whatsapp{
	void send(String msg,int no) {
		System.out.println("Sending msg..in string and number format"+msg+no);
		super.send("Hello version 1");
	}
}
public class JAVAPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		whatsapp2 w2 = new whatsapp2();
		w2.send("hello", 786);
		

	}

}
