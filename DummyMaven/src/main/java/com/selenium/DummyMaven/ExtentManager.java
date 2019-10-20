package com.selenium.DummyMaven;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest {

	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			
			Date date= new Date();
			
			String filepath= date.toString().replace(":", "_").replace(" ", "_")+".html";
			
			//generating extent reports
			extent=new ExtentReports(projectpath+"//HTMLReports//"+filepath);
			
			//loading configuration xml file
			extent.loadConfig(new File(projectpath+"//extentreportconfig.xml"));			
			//extra information addition
			extent.addSystemInfo("Selenium webDriver", "3.0").addSystemInfo("Enviroment", "Loacal");
		}
		return extent;
	}

}
