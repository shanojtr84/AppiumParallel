package com.settings1;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import auto.common.InitAppium2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import page.common.App;

//public class settings11 extends InitAppium2{
	
public class settings11 extends App{

/*	
	@Test
	public void testMobile() throws InterruptedException{
		
		settingsPage.tapMobileOption();
		
		settingsPage.tapPersonalHotspotOption();
		
		settingsPage.NavigateBack();
		
		settingsPage.NavigateBack();
		
		Assert.assertNotNull(settingsPage.getSettings());
		
	}*/
	


 



//	@Test
//	public void testsec2() throws InterruptedException{
//		
//		settingsPage.tapMobileOption();
//		settingsPage.tapMobileDataOptions();
//		settingsPage.tapMobileDataNetwork();
//		
//		settingsPage.NavigateBack();
//		settingsPage.tapMobileDataOptions();
//		settingsPage.NavigateBack();
//		settingsPage.NavigateBack();
//		
//		settingsPage.NavigateBack();
//	}
//	
	
/*comment test*/
//   @Test
//	public void testsec1() throws MalformedURLException  {
//	   
//
//	  //  WebElement wb= (WebElement) ((IOSDriver) driver).findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText' AND name == 'Mobile'");
//	 //  System.out.println("@@@@@@@@@@@@@@"+wb.getText());
//	 //   wb.click();  
//	   System.out.println("App Obj "+appObj.settingsPage);
//	   appObj.settingsPage.tapMobileOption();
//	   appObj.settingsPage.NavigateBack();
//	   appObj.settingsPage.tapMobileOption();
//	   
//	  //((IOSDriver) driver).findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Mobile Data Opt'").click();
//
//	   appObj.settingsPage.tapMobileDataOptions();
//	  // driver.runAppInBackground(Duration.ofSeconds(1));
//	   //driver.activateApp("com.apple.Preferences");
//	   appObj.settingsPage.NavigateBack();
//	   appObj.settingsPage.tapMobileDataOptions();
//	   appObj.settingsPage.tapMobileDataNetwork();
//	   appObj.settingsPage.NavigateBack();
//	   appObj.settingsPage.NavigateBack();
//	   appObj.settingsPage.NavigateBack();
//
//}
   
   @Test
	public void testsec1() throws MalformedURLException  {
	   

	  //  WebElement wb= (WebElement) ((IOSDriver) driver).findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText' AND name == 'Mobile'");
	 //  System.out.println("@@@@@@@@@@@@@@"+wb.getText());
	 //   wb.click();  
	   //System.out.println("App Obj "+appObj.settingsPage);
	   
	   settingsPage.tapMobileOption();
	   settingsPage.NavigateBack();
	   settingsPage.tapMobileOption();
	   
	  //((IOSDriver) driver).findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Mobile Data Opt'").click();

	  settingsPage.tapMobileDataOptions();
	  // driver.runAppInBackground(Duration.ofSeconds(1));
	   //driver.activateApp("com.apple.Preferences");
	   settingsPage.NavigateBack();
	   settingsPage.tapMobileDataOptions();
	   settingsPage.tapMobileDataNetwork();
	   settingsPage.NavigateBack();
	   settingsPage.NavigateBack();
	   settingsPage.NavigateBack();

}
   
 
   

	
	

}
