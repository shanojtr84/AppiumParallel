package com.settings1;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import auto.common.InitAppium2;

import page.common.App;

public class Settings12 extends App{
	
	

	@Test
	public void testfirst201() throws MalformedURLException{
		
	
		settingsPage.tapNotificationsOption();
		settingsPage.NavigateBack();
		settingsPage.tapNotificationsOption();
		settingsPage.NavigateBack();
		settingsPage.tapNotificationsOption();
		settingsPage.NavigateBack();
		settingsPage.tapNotificationsOption();
		settingsPage.NavigateBack();
		settingsPage.tapNotificationsOption();
		settingsPage.NavigateBack();
		settingsPage.tapNotificationsOption();
		settingsPage.NavigateBack();
		
		
		
	}
	
	
	
	

}
