
package auto.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.appium.manager.ParallelThread;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import page.common.App;


public class InitAppium2 {

	private AppiumDriver driver = null;
	
 	//public App appObj = null;
	public static AppiumDriverLocalService service = null;
	public static String AppiumNodeFilePath = "/usr/local/bin/node";
	public static String AppiumJavaScriptServerFile = "/usr/local/lib/node_modules/appium/build/lib/main.js";
	public static File app = null;
	//public MobileDriver driverInstance =null;
	
	//AppiumDriverManager appiumManager = new AppiumDriverManager();
	
 @Parameters({ "deviceID", "WDAPort", "Port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String UDID, String WDAPortNum, String port) throws IOException, InterruptedException {

		System.out.println(Thread.currentThread().getId());

		//startAppiumServer(Integer.parseInt(port));
		
		driver = initializeDriver(UDID,WDAPortNum,port);
		
		AppiumDriverManager.setAppiumDriver(driver);
		
	//	driverInstance = new MobileDriver(driver);
		
	//	driverInstance.appObject();
		//appObj  = new App();
		
	}
		
//	@BeforeClass(alwaysRun = true)
//	public void setup() throws IOException, InterruptedException {
//
//		System.out.println(Thread.currentThread().getId());
//
//		//startAppiumServer(port);
//
////		intializeAppiumDriver();
////
////		intializeApp();
//		
//       // AppiumDriverManager.getAppiumDriverClass().initializeDriver();
//		
//		//setAppiumDriverClass();
//		
//		 driver = initializeDriver();
//		
//		 
//		AppiumDriverManager.setAppiumDriver(driver);
//		
//		//driverInstance =new MobileDriver(driver);
//		
//		//driverInstance.appObject();
//		
//	
//		//appObj = new App();
//
//	}
//	public void intializeApp() {
//
//		driverInstance = new MobileDriver(driver);
//
//		driverInstance.appObject();
//		// appObj = new App(driverInstance);
//
//	}

//	public App getAppObject() {
//
//		return driverInstance.appObject();
//	}

	/*public AppiumDriver intializeAppiumDriver(String UDID, String WDAPortNum,int port) throws MalformedURLException{
		
		System.out.println();
		
		if(driver==null){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformVersion", "11.0");
			capabilities.setCapability("app", "settings");
			capabilities.setCapability("udid", UDID);
			capabilities.setCapability("wdaLocalPort", WDAPortNum);
			capabilities.setCapability("preventWDAAttachments", true);
			capabilities.setCapability("clearSystemFiles", "true");
			//capabilities.setCapability("fullReset", false);
			//capabilities.setCapability("noReset", false);
		    
			driver = new IOSDriver(new URL("http://0.0.0.0:"+port+"/wd/hub"), capabilities);
			
			
			
			//driver = new IOSDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		return driver;
			
	}*/
	
/*public AppiumDriver intializeAppiumDriver() throws MalformedURLException{
		
		
		if(driver==null){
			
			System.out.println("calling driver again");
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformVersion", "11.0");
			capabilities.setCapability("app", "settings");
			capabilities.setCapability("udid", "3bc7dd8b5c22793740afe7d216afb5ba2933e394");
			capabilities.setCapability("preventWDAAttachments", true);
			capabilities.setCapability("clearSystemFiles", "true");
			//capabilities.setCapability("fullReset", false);
			//capabilities.setCapability("noReset", false);
		    
			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			
		}
		
		return driver;
			
	}*/


//	public AppiumDriverClass AppiumDriverClass() {
//		
//		return AppiumDriverManager.getAppiumDriverClass();
//	}
//	
//	
//	public void setAppiumDriverClass() {
//		
//		AppiumDriverClass appiumDriverClass = AppiumDriverFactory.createInstance();
//		AppiumDriverManager.setAppiumDriverClass(appiumDriverClass);
//		
//	}
	
	
	public static void startAppiumServer(int port) throws IOException, InterruptedException {

		System.out.println("Starting Appium Server ......");
		
		if(service ==null){
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(AppiumNodeFilePath))
						.withAppiumJS(new File(AppiumJavaScriptServerFile)).withIPAddress("0.0.0.0").usingPort(port));

		service.start();
		System.out.println("Appium Server Started !!");
		}

	}

	public static void stopAppiumServer() throws IOException {

		System.out.println("Checking If Appium Server is stopped ?");
		try {
			service.stop();
			System.out.println("Appium Server is now Stopped!!");

		} catch (NullPointerException e) {

			System.out.println("Appium Server is already Stopped !!");
		}

	}

	@AfterSuite(alwaysRun = true)
	public  void teardown() throws IOException {
        if(driver!=null){
		driver.quit();
        }
		stopAppiumServer();
	}

//	@BeforeMethod(alwaysRun = true)
//	public  void setupmethod() throws IOException {
//	
//     System.out.println("Starting test case execution");
//     
//	}
//	
//	
//	@AfterMethod(alwaysRun = true)
//	public  void teardownmethod() throws IOException {
//		
//		
//		System.out.println("Ending test case execution");
//		
//		
//	}
	
	private AppiumDriver initializeDriver(String UDID, String WDAPortNum, String port) throws MalformedURLException {

		if (driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformVersion", "11.0");
			capabilities.setCapability("app", "settings");
			capabilities.setCapability("udid", UDID);
			capabilities.setCapability("wdaLocalPort", WDAPortNum);
			capabilities.setCapability("preventWDAAttachments", true);
			capabilities.setCapability("clearSystemFiles", "true");
			// capabilities.setCapability("fullReset", false);
			// capabilities.setCapability("noReset", false);

			driver = new IOSDriver(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
		}

		return driver;
	}

	private AppiumDriver initializeDriver() throws MalformedURLException {

		if (driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformVersion", "11.0");
			capabilities.setCapability("app", "settings");
			capabilities.setCapability("udid", "3bc7dd8b5c22793740afe7d216afb5ba2933e394");
			capabilities.setCapability("preventWDAAttachments", true);
			capabilities.setCapability("clearSystemFiles", "true");

			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}

		return driver;

	}
	
}
