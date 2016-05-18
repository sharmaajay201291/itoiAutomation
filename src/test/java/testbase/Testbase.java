package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.TemporaryFilesystem;

import utility.Xls_Reader;

public class Testbase {
	// public static Logger APP_LOGS=null;
	public static Properties CONFIG = new Properties();
	public static boolean isInitalized = false;
	public static boolean isBrowserOpened = false;
	public static Hashtable<String, String> sessionData = new Hashtable<String, String>();
	public static Xls_Reader scenario = null;

	public static WebDriver driver = null;

	// initializing the Tests
	public void initialize() throws Exception {
		if (!isInitalized) {
			// Config file configuration
			FileInputStream ip = new FileInputStream("src/test/java/config/config.properties");
			CONFIG.load(ip);
			System.out.println(CONFIG.getProperty("test"));
			
			// xlsx file configuration
			scenario = new utility.Xls_Reader("src/test/resources/scenario.xlsx");
			isInitalized = true;
		}

	}

	// Webdriver
	// open a browser if its not opened
	public static void openBrowser() throws IOException {
		if (!isBrowserOpened) {
			String browser = CONFIG.getProperty("browserType");
			System.out.println(browser);
			if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
				System.out.println("Opening Firefox");
			} else if (browser.equals("IE")) {
				driver = new InternetExplorerDriver();
			} else if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			}

			isBrowserOpened = true;
			String url = CONFIG.getProperty("url");
			driver.get(url);
			String waitTime=CONFIG.getProperty("default_implicitWait");
			driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime),
			TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
	}

	// close browser
	public void closeBrowser() {
		driver.quit();
		TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		isBrowserOpened = false;
	}
}
