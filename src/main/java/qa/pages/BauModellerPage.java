package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BauModellerPage {
	WebDriver driver;
	Waithelper fluentwaitt;

	// --------///

	private By ec2catagory = By.xpath("//li[@id='module-option-0']");
	private By crratebtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	private By BauoptionFromFrop = By.xpath("(//li[contains(text(),\"BAU (Ansible)\")])[1]");
	private By ansiblecategorydrop = By.xpath("//input[@id='module']");
	By botprisestaging = By.xpath("//li[contains(text(),\"Botprise_staging\")]");

	By s3category = By.xpath("//li[contains(text(),\"amazon_aws_s3_bucket\")]");

	private By playbookdrop = By.xpath("//input[@id='playbook']");

	By s3bucketcreation = By.xpath("//li[contains(text(),\"s3_bucket_creation\")]");
	private By ec2playbook = By.xpath("//li[contains(text(),\"ec2_creation\")]");

	private By integrationProfile = By.xpath("(//button[@title='Open'])[3]");
	private By awsintegration = By.xpath("//li[contains(text(),\"AWS - Cloud\")]");

	private By functioname = By.xpath("//input[@id='name']");

	private By description = By.xpath("//textarea[@id='description']");

	private By nextbtn = By.xpath("//button[@type='submit']");
	private By integrationinstancedrop = By.xpath("//input[@id='instance']");

	private By s3bucketnameinaws = By.xpath("//input[@name='name']");

	private By textbtn = By.xpath("(//button[@type=\"button\"])[16]");
	private By checkboxaccept = By.xpath("//input[@name='accept_output']");

	private By bauSave = By.xpath("//button[@type='submit']");

	private By keyName = By.xpath("//input[@name='key_name']");
	private By namee = By.xpath("//input[@name='name']");
	private By imageid = By.xpath("//input[@name='image_id']");

	private By assignpublicip = By.xpath("//input[@name='assign_public_ip']");
	private By instance_type = By.xpath("//input[@name='instance_type']");
	private By region = By.xpath("//input[@name='region']");
	private By capabilityselectdrp = By.xpath("//input[@id='capability']");
	By othercapability = By.xpath("//li[@id='capability-option-17']");
	private By otherprofile = By.xpath("//li[normalize-space()='Other']");

//	openticket

	private By bauapibtn = By.xpath("//body/div[@id='add-menu']/div[3]/ul[1]/li[2]");
	private By servicenowprofile = By.xpath("//li[contains(text(),\"ServiceNow - ITSM\")]");
	private By baucapability = By.xpath("//input[@id='capability']");
	private By openticketcapa = By.xpath("//li[contains(text(),\"Open Ticket\")]");
	private By functName = By.xpath("//input[@id='functionName']");
	private By integratPropfiofapibau = By.xpath("(//button[@title='Open'])[1]");

	private By descriptiond = By.xpath("//textarea[@id='description']");

	private By inputparams = By.xpath("//input[@id='free-chip-input']");
	private By curltest = By.xpath("//textarea[@id='curl']");

	private By selectservicenowinstance = By.xpath("//li[contains(text(),\"ServiceNow\")]");
	private By callerId = By.xpath("//input[@name='caller_id']");
	private By shortdescription = By.xpath("//input[@name='short_description']");
	private By Descriptionn = By.xpath("//input[@name='Description']");
	private By acceptBox = By.xpath("//input[@name='accept_output']");

	public BauModellerPage(WebDriver driver) {

		this.driver = driver;
		fluentwaitt = new Waithelper(driver);
	}

	public void CreateBAUThroughModeller() throws InterruptedException, AWTException {

		driver.navigate().refresh();
		Thread.sleep(3000);
		fluentwaitt.forThisElementWait(crratebtn, 15).click();
		Thread.sleep(3000);

		driver.findElement(BauoptionFromFrop).click();
		Thread.sleep(2000);
		driver.findElement(ansiblecategorydrop).click();
		Thread.sleep(2000);
		driver.findElement(s3category).click();

		fluentwaitt.forThisElementWait(playbookdrop, 10).click();

		fluentwaitt.forThisElementWait(s3bucketcreation, 10).click();

		fluentwaitt.forThisElementWait(integrationProfile, 20).click();

		fluentwaitt.forThisElementWait(awsintegration, 20).click();

		fluentwaitt.forThisElementWait(capabilityselectdrp, 10).click();

		fluentwaitt.forThisElementWait(othercapability, 10).click();

		String randomeBTUname = RandomStringUtils.random(4, "abcd");
		String randomeBTUname1 = RandomStringUtils.random(4, "qwe");
		randomeBTUname = "test_test_Aus3Create".concat(randomeBTUname);
		randomeBTUname = randomeBTUname.concat(randomeBTUname1);
		driver.findElement(functioname).sendKeys(randomeBTUname);
		Thread.sleep(2000);
		driver.findElement(description).sendKeys(randomeBTUname);
		Thread.sleep(2000);

		driver.findElement(nextbtn).click();
		Thread.sleep(3000);
		driver.findElement(integrationinstancedrop).click();
		Thread.sleep(3000);
		fluentwaitt.forThisElementWait(botprisestaging, 15).click();
		Thread.sleep(3000);

		String randomeBAUname11 = RandomStringUtils.random(4, "abcd");
		String randomeBAUname2 = RandomStringUtils.random(4, "qwe");
		randomeBTUname = "testvk".concat(randomeBAUname11);
		randomeBTUname = randomeBTUname.concat(randomeBAUname2);

		fluentwaitt.forThisElementWait(s3bucketnameinaws, 15).sendKeys(randomeBTUname);

		fluentwaitt.forThisElementWait(textbtn, 15).click();
		Thread.sleep(15000);
		driver.findElement(checkboxaccept).click();
		Thread.sleep(2000);
		fluentwaitt.forThisElementWait(bauSave, 15).click();
		Thread.sleep(5000);

	}

	public void createEc2bau() throws InterruptedException, AWTException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		fluentwaitt.forThisElementWait(crratebtn, 15).click();

		fluentwaitt.forThisElementWait(BauoptionFromFrop, 10).click();

		fluentwaitt.forThisElementWait(ansiblecategorydrop, 10).click();

		driver.findElement(ec2catagory).click();

		fluentwaitt.forThisElementWait(playbookdrop, 15).click();

		fluentwaitt.forThisElementWait(ec2playbook, 15).click();

		fluentwaitt.forThisElementWait(integrationProfile, 15).click();

		fluentwaitt.forThisElementWait(awsintegration, 15).click();

		fluentwaitt.forThisElementWait(capabilityselectdrp, 15).click();

		fluentwaitt.forThisElementWait(othercapability, 15).click();

		String randomeBTUname = RandomStringUtils.random(4, "abcd");
		String randomeBTUname1 = RandomStringUtils.random(4, "qwe");
		randomeBTUname = "test_test_Au".concat(randomeBTUname);
		randomeBTUname = randomeBTUname.concat(randomeBTUname1);
		driver.findElement(functioname).sendKeys(randomeBTUname);
		Thread.sleep(2000);
		driver.findElement(description).sendKeys(randomeBTUname);
		Thread.sleep(2000);

		driver.findElement(nextbtn).click();
		Thread.sleep(3000);
		fluentwaitt.forThisElementWait(integrationinstancedrop,20).click();
		Thread.sleep(3000);
		fluentwaitt.forThisElementWait(botprisestaging, 15).click();
		Thread.sleep(3000);

		String randomeBAUname11 = RandomStringUtils.random(4, "abcd");
		String randomeBAUname2 = RandomStringUtils.random(4, "qwe");
		randomeBTUname = "testvkec2instace_".concat(randomeBAUname11);
		randomeBTUname = randomeBTUname.concat(randomeBAUname2);

		driver.findElement(keyName).sendKeys("demo-server-key");
		Thread.sleep(1000);
		driver.findElement(namee).sendKeys(randomeBTUname);
		Thread.sleep(1000);
		driver.findElement(imageid).sendKeys("ami-0cff7528ff583bf9a");
		Thread.sleep(1000);
		driver.findElement(assignpublicip).sendKeys("yes");
		Thread.sleep(1000);
		driver.findElement(instance_type).sendKeys("t2.micro");
		Thread.sleep(1000);
		driver.findElement(region).sendKeys("us-east-1");
		Thread.sleep(1000);

		driver.findElement(textbtn).click();
		Thread.sleep(15000);
		driver.findElement(checkboxaccept).click();
		Thread.sleep(2000);
		driver.findElement(bauSave).click();
		Thread.sleep(5000);

	}

	public void createOpenTicketBAU() throws InterruptedException, AWTException {
		Robot r = new Robot();
		fluentwaitt.forThisElementWait(crratebtn, 15).click();

		fluentwaitt.forThisElementWait(bauapibtn, 15).click();

		fluentwaitt.forThisElementWait(integratPropfiofapibau, 15).click();
		fluentwaitt.forThisElementWait(servicenowprofile, 15).click();

		fluentwaitt.forThisElementWait(baucapability, 15).click();
		fluentwaitt.forThisElementWait(openticketcapa, 15).click();

		String nameofBAu = RandomStringUtils.random(4, "a_b_cd");

		String name1 = "OpenBAU".concat(nameofBAu);
		String original = name1 + nameofBAu;
		fluentwaitt.forThisElementWait(functName, 15).sendKeys(original);
		fluentwaitt.forThisElementWait(descriptiond, 15).sendKeys("Test_" + original);
		
		Actions act = new Actions(driver);
		
//       act.moveToElement(fluentwaitt.forThisElementWait(inputparams, 15)).sendKeys("Description").sendKeys(Keys.ENTER).build().perform();
//       Thread.sleep(500);
//       act.moveToElement(fluentwaitt.forThisElementWait(inputparams, 15)).sendKeys("short_description").sendKeys(Keys.ENTER).build().perform();
//       Thread.sleep(500);
//       act.moveToElement(fluentwaitt.forThisElementWait(inputparams, 15)).sendKeys("short_description").sendKeys(Keys.ENTER).build().perform();
		
		fluentwaitt.forThisElementWait(inputparams, 15).sendKeys("Description");
		
		act.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(500);
		fluentwaitt.forThisElementWait(inputparams, 15).sendKeys("short_description");
		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(500);
		fluentwaitt.forThisElementWait(inputparams, 15).sendKeys("caller_id");
		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(500);
		fluentwaitt.forThisElementWait(curltest, 15).sendKeys(
				"curl -XPOST -H \"Content-type: application/json\" -d '{\"caller_id\":\"$caller_id\",\"short_description\":\"$short_description\",\"description\":\"$Description\"}' 'https://$servicenow_instance/api/now/table/incident' -u $username:'$password'");

		Thread.sleep(500);
		fluentwaitt.forThisElementWait(bauSave, 20).click();
		Thread.sleep(500);
		fluentwaitt.forThisElementWait(integrationinstancedrop, 23).click();

		fluentwaitt.forThisElementWait(selectservicenowinstance, 20).click();

		fluentwaitt.forThisElementWait(callerId, 15).sendKeys("admin@example.com");

		fluentwaitt.forThisElementWait(shortdescription, 15).sendKeys("Short Description");

		fluentwaitt.forThisElementWait(Descriptionn, 15).sendKeys("Description");

		fluentwaitt.forThisElementWait(textbtn, 15).click();
		Thread.sleep(6000);
		driver.findElement(checkboxaccept).click();
		Thread.sleep(4000);
		driver.findElement(bauSave).click();
		Thread.sleep(5000);
	}

}
