package com.selenium.DummyMaven;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_001 extends BaseTest {
	
	
	private static final Logger log=Logger.getLogger(TC_001.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		extentTest = extentReports.startTest("TC_001");
		
		
		initiation();
		
		launch("chromebrowser");
		
		//log4j log
		log.info("initialising property files");
		log.info("launched browser:"+p.getProperty("chromebrowser"));
		
		//extentreport log
		extentTest.log(LogStatus.INFO, "initiating the browser"+p.getProperty("chromebrowser"));
		
		
		navigateurl("url1");
		log.info("navigating to url"+p.getProperty("url1"));
		extentTest.log(LogStatus.INFO, "initiating the browser"+p.getProperty("chromebrowser"));
		
		Thread.sleep(5000);
		
		signin("sign_in__partiallinktext");
		log.info("Signing in Amazon.in.."+or.getProperty("url1"));
		extentTest.log(LogStatus.INFO, "Signing in Amazon.in" +or.getProperty("url1"));
		
		email("email_id", "mailid");
		log.info("providing login id..");
		extentTest.log(LogStatus.INFO, "providing login id..");
		
		button1("Continue_button_id");
		log.info("to continue to provide password..");
		extentTest.log(LogStatus.INFO, "to continue to provide password..");
		
		password("password_id", "password");
		log.info("Providing password");
		extentTest.log(LogStatus.INFO, "password provided");
		
		button2("Login_button_id");
		log.info("logged into Amazon");
		extentTest.log(LogStatus.INFO, "signed into amazon account");
		
		
		Thread.sleep(1000);
		driver.close();
		extentTest.log(LogStatus.INFO, "driver closed");
		
		

	}

}
