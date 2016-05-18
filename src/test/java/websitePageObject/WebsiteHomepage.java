package websitePageObject;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebsiteHomepage {

	private static WebDriver driver = null;
	static Properties prop = new Properties();

	public static Logger ilogger = Logger.getLogger("infoLogger");
	public static Logger elogger = Logger.getLogger("errorLogger");

	public static By pageTile = By.xpath("");
	public static By buyBooth = By.xpath(".//*[@id='section0']/div/div[1]/div[1]/div/div/div[2]/div/a[1]");
	public static By buySubscription = By.xpath(".//*[@id='section0']/div/div[1]/div[1]/div/div/div[2]/div/a[2]");
	public static By pricing = By.xpath(".//*[@id='menu']/div/nav/div/ul/li[1]/a");
	public static By buy_app = By.xpath(".//*[@id='section0']/div/div[1]/div[2]/div/div[2]/a");

	//Creating constructor so that null driver value can be put.
	public WebsiteHomepage(WebDriver driver) {
		WebsiteHomepage.driver = driver;
	}

	public void BuyBooth() throws InterruptedException {
		System.out.println("clicking on sign in button");
		WebElement buybooth = driver.findElement(buyBooth);
		if (buybooth.isDisplayed() || buybooth.isEnabled())
			buybooth.click();
		else
			System.out.println("Element not found");
		ilogger.info("Clicking on buy booth");
	}

	public void appLinkClick() throws InterruptedException {
		WebElement buyapp = driver.findElement(buy_app);
		buyapp.click();
		ilogger.info("Clicking on buy booth");
	}

	public void BuySubscription() {
		driver.findElement(buySubscription).click();
		ilogger.info("Clicking on Buy Subscription");
	}

}
