//
//package auto.common;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.BeforeClass;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.*;
//
//import com.appium.manager.ParallelThread;
//
//import io.appium.java_client.AppiumDriver;
//
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//
//public class InitAppium1 {
//
//	public   AppiumDriver driver = null;
//	
//	
//	public static AppiumDriverLocalService service = null;
//	public static String AppiumNodeFilePath = "/usr/local/bin/node";
//	public static String AppiumJavaScriptServerFile = "/usr/local/lib/node_modules/appium/build/lib/main.js";
//	public static File app = null;
//	public DesiredCapabilities capabilities = null;
//	
//	@Parameters({ "deviceID", "WDAPort"})
//	@BeforeClass()
//	public  void setup(String UDID, String WDAPortNum) throws IOException, InterruptedException {
//
//		
//			  startAppiumServer();
//
//		    driver = setDriver(UDID,WDAPortNum);
//			
//			
//			driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
//				
//		}
//		
//		
//
//
//		public AppiumDriver setDriver(String UDID,String WDAPortNum) throws MalformedURLException{
//			
//			if(driver == null){
//				
//				capabilities = new DesiredCapabilities();
//				capabilities.setCapability("platformName", "iOS");
//				capabilities.setCapability("deviceName", "iPhone X");
//				capabilities.setCapability("automationName", "XCUITest");
//				capabilities.setCapability("platformVersion", "11.0");
//				capabilities.setCapability("app", "settings");
//				capabilities.setCapability("udid", UDID);
//				capabilities.setCapability("wdaLocalPort", WDAPortNum);
//			    capabilities.setCapability("wdaConnectionTimeout","90000");
//				capabilities.setCapability("newCommandTimeout","80000");
//				capabilities.setCapability("fullReset", false);
//				capabilities.setCapability("noReset", true);
//				driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//			
//			}
//			
//			return driver;
//			
//		}
//	
//		
//		
//	
//
//	public static void startAppiumServer() throws IOException, InterruptedException {
//
//		System.out.println("Starting Appium Server ......");
//		
//		if(service ==null){
//		service = AppiumDriverLocalService
//				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(AppiumNodeFilePath))
//						.withAppiumJS(new File(AppiumJavaScriptServerFile)).withIPAddress("0.0.0.0").usingPort(4723));
//
//		service.start();
//		System.out.println("Appium Server Started !!");
//		}
//
//	}
//
//	public static void stopAppiumServer() throws IOException {
//
//		System.out.println("Checking If Appium Server is stopped ?");
//		try {
//			service.stop();
//			System.out.println("Appium Server is now Stopped!!");
//
//		} catch (NullPointerException e) {
//
//			System.out.println("Appium Server is already Stopped !!");
//		}
//
//	}
//
//	@AfterSuite(alwaysRun = true)
//	public  void teardown() throws IOException {
//        if(driver!=null){
//		driver.quit();
//        }
//		stopAppiumServer();
//	}
//
//	
//	
//}
