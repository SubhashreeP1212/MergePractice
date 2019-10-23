package com.selenium.DummyMaven;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class ScreenShot extends BaseTest{
	
	public static File scrFile;

	
	public static void capturescreenshot() throws IOException {
		
		
		//SimpleDateFormat date = new SimpleDateFormat();
		
          Date dt=new Date();
          String filename	= dt.toString().replace(':', '_')+".png";
		
	File scrFile =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
		FileHandler.copy(scrFile, new File("D:\\Screenshots\\"+filename));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
