package page.common;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import auto.common.InitAppium2;

import page.Settings.SettingsPage;


   public class App extends InitAppium2 {
	

	

	public SettingsPage settingsPage = null;
	

	public App() {
			
		settingsPage = new SettingsPage();
		
		  
	
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void setupmethod() throws IOException {

		//appObj = super.getAppObject();
		
		System.out.println("Starting test case execution");
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public  void teardownmethod() throws IOException {
		
		
		System.out.println("Ending test case execution");
		
		
	}
	  
	
}
