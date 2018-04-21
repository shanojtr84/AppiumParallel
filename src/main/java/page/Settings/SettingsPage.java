package page.Settings;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import auto.common.AppiumWrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class SettingsPage extends AppiumWrapper {


//
//	public SettingsPage(MobileDriver driverObj) {
//		super(driverObj);
//		
//	}



	private By wiFiOption = By.name("Wi-Fi");
	private By Settings = By.name("Wi-Fi");
	private By bluetoothOption = By.name("Bluetooth");
	//private By mobileOption = By.name("Mobile");
	private By  mobileOption = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name == 'Mobile'");
	private By personalHotspotOption = By.xpath("//XCUIElementTypeStaticText[@name='Personal Hotspot']");
	private By notificationsOption = By.name("Notifications");
	private By controlCentreOption = By.xpath("//XCUIElementTypeStaticText[@name='Control Centre']");
	private By backButton = By.id("Back");
	private By generalOption = By.name("General");
	private By aboutOption = By.name("About");
	private By legalOption = By.name("Legal");
	private By licenseOption = By.name("License");
	//private By mobileDataOptions = By.name("Mobile Data Options");
	private By mobileDataOptions = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Mobile Data Opt'");
	private By mobileDataNetwork = By.name("Mobile Data Network");

	public void tapWiFiOption() throws MalformedURLException {
		tapElement(wiFiOption);
		//getdriver().findElement(wiFiOption).click();
	}
	
	public void tapMobileDataNetwork () throws MalformedURLException {
		tapElement(mobileDataNetwork);
		//getdriver().findElement(mobileDataNetwork).click();;
	}
	
	public void tapMobileDataOptions() throws MalformedURLException {
		tapElement(mobileDataOptions);
		//getdriver().findElement(mobileDataOptions).click();;
	}

	

	public void tapLicenseOption() throws MalformedURLException {
		tapElement(licenseOption);
		//getdriver().findElement(licenseOption).click();
	}
	
	public void tapLegalOption() {
		tapElement(legalOption);
		//driver.findElement(legalOption).click();;
	}
	public void tapGeneralOption() {
		tapElement(generalOption);
		//driver.findElement(generalOption).click();
	}
	public void tapAboutOption() {
		tapElement(aboutOption);
		//driver.findElement(aboutOption).click();
	}


	public void tapBTOption() throws MalformedURLException {
		tapElement(bluetoothOption);
		//getdriver().findElement(bluetoothOption).click();
	}

	public void tapMobileOption() throws MalformedURLException {
		tapElement(mobileOption);
		//getdriver().findElement(mobileOption).click();
	}

	public void tapPersonalHotspotOption() {
		tapElement(personalHotspotOption);
		//driver.findElement(personalHotspotOption).click();
	}

	public void tapNotificationsOption() {
		tapElement(notificationsOption);
		//driver.findElement(notificationsOption).click();
	}

	public void tapControlCentreOption() {
		tapElement(controlCentreOption);
		//driver.findElement(controlCentreOption).click();
	}


	
//	public WebElement getWiFiOption() {
//		return find(wiFiOption);
//	}
//
//	public WebElement getBluetoothOption() {
//		return find(bluetoothOption);
//	}
//
//	public WebElement getMobileOption() {
//
//		return find(mobileOption);
//	}
//
//	public WebElement getPersonalHotspotOption() {
//		return find(personalHotspotOption);
//	}
//
//	public WebElement getNotificationsOption() {
//		return find(notificationsOption);
//	}
//
//	public WebElement getControlCentreOption() {
//		return find(controlCentreOption);
//	}
//
//	public WebElement getBack() {
//
//		return find(backButton);
//	}
//	
//	public WebElement getSettings() {
//
//		return find(backButton);
//	}
//	
//	public WebElement getAbout() {
//
//		return find(aboutOption);
//	}
//	public WebElement getLegal() {
//
//		return find(legalOption);
//	}
}
