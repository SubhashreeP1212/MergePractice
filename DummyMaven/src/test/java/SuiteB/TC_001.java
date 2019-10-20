package SuiteB;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TC_001 {
	
  @Test(groups = {"Regression", "Smoke"})
  public void Blue() {
	  
	  System.out.println("i am blue");
  }
  
  @Test(groups = {"Regression", "Smoke"})
  public void green() {
	  System.out.println("i am green");
	  throw new SkipException("Skipping");
  }
  
  @Test(groups = {"Regression"})
  
  public void purple() {
	  System.out.println("i am purple");
  }
  
  @Test(groups = { "Smoke"})
  
  public void mauve(){
     System.out.println("i am blue");
	  
	  }
}
