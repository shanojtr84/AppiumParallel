//
//package auto.common;
//
//import java.io.File;
//import java.io.IOException;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
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
//public class InitAppium {
//
//	public   AppiumDriver driver = null;
//	//static
//	public static AppiumDriverLocalService service = null;
//	public static String AppiumNodeFilePath = "/usr/local/bin/node";
//	public static String AppiumJavaScriptServerFile = "/usr/local/lib/node_modules/appium/build/lib/main.js";
//	public static File app = null;
//
//	
//	
//	@Parameters({ "deviceID", "WDAPort","port","platformVersion"})
//	@Test(alwaysRun = true)
//	public  void setup(String UDID, String WDAPortNum,int port,String pVersion) throws IOException, InterruptedException {
//
//		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		if(UDID.equals("EE94D80E-0CC2-476D-8569-612B96465C")){
//		//stopAppiumServer();
//		//startAppiumServer(port);
//
//		
//		capabilities.setCapability("platformName", "iOS");
//		capabilities.setCapability("deviceName", "iPhone Sim");
//		capabilities.setCapability("automationName", "XCuiTest");
//		capabilities.setCapability("platformVersion", 11.0);
//		capabilities.setCapability("app", "settings");
//		capabilities.setCapability("udid", UDID);
//		capabilities.setCapability("wdaLocalPort", WDAPortNum);
//		
////		capabilities.setCapability("shouldUseSingletonTestManager", false);
////		capabilities.setCapability("simpleIsVisibleCheck", true);
////		capabilities.setCapability("maxTypingFrequency",10);
////		capabilities.setCapability("preventWDAAttachments", true);
////		capabilities.setCapability("clearSystemFiles", "true");
////		capabilities.setCapability("wdaLaunchTimeout","80000");
//		
//	    capabilities.setCapability("wdaConnectionTimeout","90000");
//		capabilities.setCapability("newCommandTimeout","80000");
//		
////		capabilities.setCapability("fullReset", false);
//		capabilities.setCapability("noReset", true);
//		//driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//		
//	
//		}
//		
//		if(UDID.equals("3bc7dd8b5c22793740afe7d216afb5ba2933e394")){
//			
//			//stopAppiumServer();
//			
//			//startAppiumServer(port);
//
//			
//			capabilities.setCapability("platformName", "iOS");
//			capabilities.setCapability("deviceName", "iPhone");
//			capabilities.setCapability("automationName", "XCuiTest");
//			capabilities.setCapability("platformVersion", 10.3);
//			capabilities.setCapability("app", "settings");
//			capabilities.setCapability("udid", UDID);
//			capabilities.setCapability("wdaLocalPort", WDAPortNum);
//			  
////			capabilities.setCapability("shouldUseSingletonTestManager", false);
////			capabilities.setCapability("simpleIsVisibleCheck", true);
////			capabilities.setCapability("maxTypingFrequency",10);
////			capabilities.setCapability("preventWDAAttachments", true);
////			capabilities.setCapability("clearSystemFiles", "true");
////			capabilities.setCapability("wdaLaunchTimeout","80000");
//		    capabilities.setCapability("wdaConnectionTimeout","90000");
//			capabilities.setCapability("newCommandTimeout","80000");
//			
//			//capabilities.setCapability("fullReset", false);
//			//capabilities.setCapability("noReset", true);
//			//driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//			
//				
//		}
//		
//		System.out.println(UDID+ " Port:- "+port);
//		driver = new IOSDriver(new URL("http://localhost:"+port+"/wd/hub"), capabilities);
//		//driver = new IOSDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
//		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
//	
//	
//
//		
//	
//
//	public static void startAppiumServer(int port) throws IOException, InterruptedException {
//
//		System.out.println("Starting Appium Server ......");
//		
//		if(service ==null){
//		service = AppiumDriverLocalService
//				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(AppiumNodeFilePath))
//						.withAppiumJS(new File(AppiumJavaScriptServerFile)).withIPAddress("0.0.0.0").usingPort(port));
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
