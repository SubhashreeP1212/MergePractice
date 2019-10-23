package com.selenium.DummyMaven;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

public class TC_002_screenshot extends BaseTest{
	
	
	
	public static void main (String args[]) throws IOException, InterruptedException {
		

		extentTest = extentReports.startTest("TC_002_screenshot");
		initiation();
		launch("chromebrowser");
		
		navigateurl("url1");
		if(!verifytitle("title")) {
			
			failureReport("both titles are not equal");
			ScreenShot.capturescreenshot();
			
		}
		else 
			passReport( "both are equal");
		 //ScreenShot.capturescreenshot();
			
	
	extentReports.endTest(extentTest);
		extentReports.flush();
		driver.close();
		
	}

}

 
