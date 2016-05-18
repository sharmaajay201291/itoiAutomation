package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testbase.Testbase;
import utility.Xls_Reader;
import websitePageObject.BuySubscriptionPage;
import websitePageObject.BuyboothPage;
import websitePageObject.PaypalLoginPage;
import websitePageObject.ShippingPage;
import websitePageObject.WebsiteHomepage;

public class TestBuybooth extends Testbase {
	
	@BeforeTest
	public void init() throws Exception {
		initialize();
	}

	@Test
	public void operation() throws IOException, InterruptedException {
		//for scenario loop
		for(int i=2; i <= Xls_Reader.getRowCount("testscenario") ;i++ )
		{
			openBrowser();
			
			//buy booth
			WebsiteHomepage WH = new WebsiteHomepage(driver);
			WH.BuyBooth();
			
			//select booth
			BuyboothPage BB = new BuyboothPage(driver);
			if(Xls_Reader.getCellData("testscenario", "booth2", i).equalsIgnoreCase("TRUE")){				
				BB.boothtwo();
				System.out.println("Booth 2.0 is selected");
				Thread.sleep(5000);
			}
			else{
				BB.booththree();
				System.out.println("Booth 3.0 is selected");
				Thread.sleep(5000);
			}		
			
			//confirm booth			
			BB.cartconfirm();
			
			//select subscription
			BuySubscriptionPage BS = new BuySubscriptionPage(driver);
			if(Xls_Reader.getCellData("testscenario", "Subscribe1", i).equalsIgnoreCase("TRUE")){
				BS.freeselect();
			}
			else if(Xls_Reader.getCellData("testscenario", "Subscribe2.1", i).equalsIgnoreCase("TRUE")){
				BS.perselectAnnual();
			}
			else if(Xls_Reader.getCellData("testscenario", "Subscribe2.2", i).equalsIgnoreCase("TRUE")){
				BS.perselectMonthly();
			}
			else if(Xls_Reader.getCellData("testscenario", "Subscribe3.1", i).equalsIgnoreCase("TRUE")){
				BS.perselectAnnual();
			}
			else if(Xls_Reader.getCellData("testscenario", "Subscribe3.2", i).equalsIgnoreCase("TRUE")){
				BS.proselectMonthly();
			}
			
			
			
			//confirm
			Thread.sleep(5000);
			BS.cartconfirm();
			
//			// shipping
//			ShippingPage SP = new ShippingPage(driver);
//			SP.shippingaddress();
//			SP.individual();
//			SP.finishpayment();
//			
//			//Paypal login
//			PaypalLoginPage PP = new PaypalLoginPage(driver);
//			PP.loginpaypal();
//			
//			Thread.sleep(10000);
			closeBrowser();
			
		}
			
			

	}

//	@AfterTest
//	public void closebrowser() {
//		closeBrowser();
//	}

}
