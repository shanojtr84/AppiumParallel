package com.settings3;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import auto.common.InitAppium2;
import page.common.App;

public class Settings32 extends App{

	@Test
	public void testfirst301() throws MalformedURLException{
		
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
