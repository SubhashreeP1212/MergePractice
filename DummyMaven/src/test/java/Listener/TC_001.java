package Listener;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class TC_001 extends BaseTest {
	
 
 
  @Test
  public void urlcall() throws IOException {
	  
	   initiation();
	   Reporter.log("initialising");
		
		launch("chromebrowser");
		Reporter.log("Launching browser");
		
		navigateurl("url1");
		Reporter.log("amazon url");
  }
  
 
 @Test
 public void login2222() {
 System.out.println("logged in");
 Reporter.log("loggedin");
}
  

}
