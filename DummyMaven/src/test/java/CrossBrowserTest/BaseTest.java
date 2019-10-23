package CrossBrowserTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;


public class BaseTest {
	
	
	public static WebDriver driver;
	public static String projectpath = System.getProperty("user.dir");
	public static Properties p;
	public static Properties or;
	//public static ExtentReports extentReports = ExtentManager.getInstance();
	public static ExtentTest extentTest;
	
	
	
	public static void initiation() throws IOException {
		
		FileInputStream file1 =new FileInputStream(projectpath+"//data.properties");
		 p= new Properties();
		 p.load(file1);
		
		FileInputStream file2=new FileInputStream(projectpath+"//or.properties");
		or= new Properties();
		or.load(file2);
		
		//PropertyConfigurator.configure(projectpath+"//log4j.properties");
	}
	
	public static void launch(String browser) {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivernew//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");
		
		 driver=new ChromeDriver(options);
		
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.geckodriver.driver", projectpath+"//Driver//geckodriver.exe");
			ProfilesIni profilesIni =new ProfilesIni();
			FirefoxProfile profile = profilesIni.getProfile("subha");
			FirefoxOptions options= new FirefoxOptions();
			options.setProfile(profile);
			
			driver=new FirefoxDriver(options);
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectpath+"//Driver//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
	}
	
	public static void navigateurl(String url) throws IOException {
		driver.get(p.getProperty(url));
		driver.manage().window().maximize();
		//ScreenShot.capturescreenshot();
		}
	public static WebElement webelement(String loactaorkey) {
		
		
		return null;
		
		
	}
	
	public static WebElement getElement(String locatorKey) {
		
		WebElement element= null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		
	return element;
		
	}
	
	public static void signin(String locatorKey) {
		
		getElement(locatorKey).click();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		
	}
	
	public static void email(String locatorKey, String email) {		
	getElement(locatorKey).sendKeys(or.getProperty(email));
	
	}
	public static void button1(String locatorKey) {
		getElement(locatorKey).click();
		
	}
	public static void password(String locatorKey,String password) {
		getElement(locatorKey).sendKeys(or.getProperty(password));
	}
	public static void button2(String locatorKey) throws InterruptedException {
		
	     getElement(locatorKey).click();
		
	}
	
	public static void verifySearch(String locatorKey, String SearchText) {
		
		WebElement element= getElement(locatorKey);
		element.sendKeys(or.getProperty(SearchText));
		element.getAttribute("value");
		
	}
	public static void verifyLink(String locatorKey) {
		getElement(locatorKey).getText();
	}
	
	public static Boolean verifytitle(String expectedTest) {
	String actualTest=	driver.getTitle();
	if(actualTest.equalsIgnoreCase(or.getProperty(expectedTest))) {
		
	return true;
	}
	else return false;
	}
	
	public static void failureReport (String failMessage) {
		
		extentTest.log(LogStatus.FAIL,failMessage);
		
	}
	
	public static void passReport(String passMessage){
		
		extentTest.log(LogStatus.PASS, passMessage);
		
	}
	{
		
	}
}	
