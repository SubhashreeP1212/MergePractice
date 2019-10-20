package Parallel;

import java.util.Arrays;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;


public class SuiteParallel {
 
	
	public static void main(String args[]) {
		
		TestNG  testng = new TestNG();
		
		//first way of parallel execution of suite
		//List suites = Lists.newArrayList();
		//suites.add(System.getProperty("user.dir")+"//parallel.xml");
		
		//2nd way of paralle execution of suite
	String[] a = new String[] {System.getProperty("user.dir")+"//parallel.xml"};
	List<String> list= Arrays.asList(a);
	
		
		testng.setTestSuites(list);
		testng.setSuiteThreadPoolSize(2);
		testng.run();
		
		
	}
}
