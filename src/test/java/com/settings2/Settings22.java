package com.settings2;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import auto.common.InitAppium2;

import page.common.App;

public class Settings22 extends App{

	@Test
	public void testWiFi() throws MalformedURLException{
		
		
		
		settingsPage.tapMobileOption();
		settingsPage.NavigateBack();
		settingsPage.tapMobileOption();
	    settingsPage.tapMobileDataOptions();
		settingsPage.NavigateBack();
		settingsPage.tapMobileDataOptions();
		settingsPage.tapMobileDataNetwork();
		settingsPage.NavigateBack();
		settingsPage.NavigateBack();
		settingsPage.NavigateBack();
		
	}
	

}
