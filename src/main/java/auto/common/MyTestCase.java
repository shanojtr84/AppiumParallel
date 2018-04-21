//
//package auto.common;
//
//import java.io.IOException;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import com.appium.executor.MyTestExecutor;
//
//import io.appium.java_client.AppiumDriver;
//import page.common.App;
//
//
//public class MyTestCase extends InitAppium2{
//	
//	public App app = null;
//	
//	@BeforeMethod(alwaysRun = true)
//	public void setupmethod() throws IOException {
//
//		appObj = super.getAppObject();
//		
//		System.out.println("Starting test case execution");
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
//	
//	
//	
//}
