package websitePageObject;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testbase.Testbase;

public class ShippingPage extends Testbase{
	
	private static WebDriver driver;
	
	
	public static By firstName 	= By.xpath(".//*[@id='fname']");
	public static By lastName 	= By.xpath(".//*[@id='lname']");
	public static By contactNo 	= By.xpath(".//*[@id='phone']");
	public static By emailAddr 	= By.xpath(".//*[@id='email']");
	public static By address 	= By.xpath(".//*[@id='address']");
	public static By city	 	= By.xpath(".//*[@id='city']");
	public static By zip	 	= By.xpath(".//*[@id='zip']");
	public static By state	 	= By.xpath(".//*[@id='state']"); //require drop down option	
	public static By shippingRate = By.xpath(".//*[@id='shipping_rates']");	//require drop down option
	public static By individualRadio = By.xpath(".//*[@id='customerTypeIndividual']");
	public static By buisnessRadio 	= By.xpath(".//*[@id='customerTypeBusiness']");
	public static By buisnessName = By.xpath(".//*[@id='business-name']");
	
	public static By finishPayment = By.xpath(".//*[@id='confirm-btn']");
	
	/*To select drop down read this comment
	 * Just wrap your WebElement into Select Object as shown below

	Select dropdown = new Select(driver.findElement(By.id("identifier")));
	Once this is done you can select the required value in 3 ways. Consider an HTML file like this

	<html>
	<body>
	<select id = "designation">
	<option value = "MD">MD</option>
	<option value = "prog"> Programmer </option>
	<option value = "CEO"> CEO </option>
	</option>
	</select>
	<body>
	</html>
	Now to identify dropdown do

	Select dropdown = new Select(driver.findElement(By.id("designation")));

	To select its option say 'Programmer' you can do

	dropdown.selectByVisibleText("Programmer ");

	or

	dropdown.selectByIndex(1);

	or

	 dropdown.selectByValue("prog");*/
	
	public ShippingPage(WebDriver driver){
		ShippingPage.driver = driver;
	}
	
	public void shippingaddress() throws InterruptedException{
		System.out.println("Adding customer details");
		driver.findElement(firstName).sendKeys(CONFIG.getProperty("firstname"));
		Thread.sleep(1000);
		driver.findElement(lastName).sendKeys(CONFIG.getProperty("lastname"));
		Thread.sleep(1000);
		driver.findElement(contactNo).sendKeys(CONFIG.getProperty("contactNumber"));
		Thread.sleep(1000);
		driver.findElement(emailAddr).sendKeys(CONFIG.getProperty("email"));
		Thread.sleep(1000);
		driver.findElement(address).sendKeys(CONFIG.getProperty("address"));
		Thread.sleep(1000);
		driver.findElement(city).sendKeys(CONFIG.getProperty("city"));
		Thread.sleep(1000);
		driver.findElement(zip).sendKeys(CONFIG.getProperty("zip"));
		Thread.sleep(1000);
		
		Select statedrop = new Select(driver.findElement(state));
		statedrop.selectByValue("TX");
		
		driver.findElement(shippingRate).click();
		Select shipCostDrop = new Select(driver.findElement(shippingRate));
		Thread.sleep(3000);
		shipCostDrop.selectByIndex(1);
	}
	
	public void individual(){
		driver.findElement(individualRadio).click();
	}
	
	public void business(){
		System.out.println("Selecting Buisness");
		driver.findElement(buisnessRadio).click();
		driver.findElement(buisnessName).sendKeys(CONFIG.getProperty("buisnessname"));
	}
	
	public void finishpayment(){
		System.out.println("Finish Payment");
		driver.findElement(finishPayment).click();
//		WebElement finish = driver.findElement(finishPayment);
//		if(finish.isDisplayed()||finish.isEnabled())
//			finish.click();
//		else System.out.println("Element not found");
	}

}
