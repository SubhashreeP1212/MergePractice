package CrossBrowserTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_002 extends BaseTest {
  @Test
  @Parameters("browser")
  public void google(String browser) throws IOException {
	  
	  
	  initiation();
		
		launch(browser);
		
		navigateurl("url2");
  }
}
