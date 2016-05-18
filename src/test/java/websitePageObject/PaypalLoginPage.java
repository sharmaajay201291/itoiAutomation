package websitePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testbase.Testbase;

public class PaypalLoginPage extends Testbase{
	
	private static WebDriver driver = null;
	
	public static By loadlogin = By.xpath(".//*[@id='loadLogin']");
	public static By email = By.xpath(".//*[@id='login_email']");
	public static By password = By.xpath(".//*[@id='login_password']");
	public static By loginBut = By.xpath(".//*[@id='submitLogin']");
	
	public static By paynow = By.xpath(".//*[@id='continue_abovefold']");
	
	
	public PaypalLoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void loginpaypal() throws InterruptedException{
		driver.findElement(loadlogin).click();
		driver.findElement(email).sendKeys(CONFIG.getProperty("paypalemail"));
		driver.findElement(password).sendKeys(CONFIG.getProperty("paypalpassword"));
		driver.findElement(loginBut).click();
		Thread.sleep(3000);
		
		driver.findElement(paynow).click();		
		
	}
	
	

}
