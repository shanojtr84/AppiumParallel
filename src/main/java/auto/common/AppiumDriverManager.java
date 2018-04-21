package auto.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class AppiumDriverManager {

	private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<AppiumDriver>();

	public static AppiumDriver getAppiumDriver() {

		return appiumDriver.get();
	}

	public static void setAppiumDriver(AppiumDriver drive) {

		appiumDriver.set(drive);

	}
	
	
	
	

}
