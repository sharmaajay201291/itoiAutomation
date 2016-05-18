package websitePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyboothPage {
	
	private static WebDriver driver;
	
	
	public static By selectVTwo = By.xpath(".//*[@id='product-wrapper']/div/div[1]/div[1]/div/div/div/div[2]/div/div[2]/button");
	public static By selectVThree = By.xpath(".//*[@id='product-wrapper']/div/div[1]/div[1]/div/div/div/div[3]/div/div[2]/button");
	public static By cartConfirm = By.xpath(".//*[@id='confirm-btn']");
	
	public BuyboothPage(WebDriver driver){
		BuyboothPage.driver = driver;
	}
	
	public void boothtwo(){
		System.out.println("Selecting booth version 2.0");
		WebElement btwo = driver.findElement(selectVTwo);
		if(btwo.isDisplayed()||btwo.isEnabled())
			btwo.click();
		else System.out.println("Element not found");
	}
	
	public void booththree(){
		System.out.println("Selecting booth version 3.0");
		WebElement bthree = driver.findElement(selectVThree);
		if(bthree.isDisplayed()||bthree.isEnabled())
			bthree.click();
		else System.out.println("Element not found");
	}
	
	public void cartconfirm(){
		System.out.println("Confirming cart");
		WebElement cartconfirm = driver.findElement(cartConfirm);
		if(cartconfirm.isDisplayed()||cartconfirm.isEnabled())
			cartconfirm.click();
		else System.out.println("Element not found");
	}

}
