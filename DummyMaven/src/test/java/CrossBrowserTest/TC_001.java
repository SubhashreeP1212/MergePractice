package CrossBrowserTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class TC_001 extends BaseTest {
  @Test
  @Parameters("browser")
  public void google(String browser) throws IOException {
	  
	   initiation();
		
		launch(browser);
		
		navigateurl("url1");
  }
  @Test
  @Parameters("browser")
  public void facebook(String browser) throws IOException {
	  

	   initiation();
		
		launch(browser);
		
		navigateurl("url3");
	  
  }
}
