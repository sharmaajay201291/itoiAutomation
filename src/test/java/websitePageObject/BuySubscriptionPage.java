package websitePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BuySubscriptionPage {
	
	private static WebDriver driver;
	
	
	public static By freeSelect = By.xpath(".//*[@id='1']/div/div[3]/button");
	public static By personalSelect = By.xpath(".//*[@id='2']/div/div[3]/button");
	public static By profesionalSelect = By.xpath(".//*[@id='3']/div/div[3]/button");
	
	public static By paySelectPer = By.xpath(".//*[@id='2']/div/div[1]/div/select");
	public static By paySelectPro = By.xpath(".//*[@id='3']/div/div[1]/div/select");
	
	public static By cartConfirm = By.xpath(".//*[@id='confirm-btn']");
	
	public BuySubscriptionPage(WebDriver driver){
		BuySubscriptionPage.driver = driver;
	}
	
	public void freeselect(){
		System.out.println("Selecting free subscription");
		WebElement free = driver.findElement(freeSelect);
		if(free.isDisplayed()||free.isEnabled())
			free.click();
		else System.out.println("Element not found");
	}
	
	public void perselectAnnual(){
		System.out.println("Selecting personal yearly subscription");
		WebElement per = driver.findElement(personalSelect);
		if(per.isDisplayed()||per.isEnabled())
			per.click();
		else System.out.println("Element not found");
	}
	
	public void perselectMonthly(){
		System.out.println("Selecting personal Monthly subscription ");
		Select month = new Select(driver.findElement(paySelectPer));
		month.selectByValue("1");
		WebElement per = driver.findElement(personalSelect);
		if(per.isDisplayed()||per.isEnabled())
			per.click();
		else System.out.println("Element not found");
	}
	
	public void proselectAnnual(){
		System.out.println("Selecting professional subscription");
		WebElement pro = driver.findElement(profesionalSelect);
		if(pro.isDisplayed()||pro.isEnabled())
			pro.click();
		else System.out.println("Element not found");
	}
	
	public void proselectMonthly(){
		System.out.println("Selecting professional Monthly subscription ");
		Select month = new Select(driver.findElement(paySelectPro));
		month.selectByValue("1");
		WebElement pro = driver.findElement(profesionalSelect);
		if(pro.isDisplayed()||pro.isEnabled())
			pro.click();
		else System.out.println("Element not found");
	}
	
	public void cartconfirm(){
		System.out.println("Confirming subscription cart");
		WebElement cartconfirm = driver.findElement(cartConfirm);
		if(cartconfirm.isDisplayed()||cartconfirm.isEnabled())
			cartconfirm.click();
		else System.out.println("Element not found");
	}

}
