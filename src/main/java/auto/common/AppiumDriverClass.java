package auto.common;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class AppiumDriverClass {

	private AppiumDriver driver = null;

	public AppiumDriver initializeDriver(String UDID, String WDAPortNum, String port) throws MalformedURLException {

		if (driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformVersion", "11.0");
			capabilities.setCapability("app", "settings");
			capabilities.setCapability("udid", UDID);
			capabilities.setCapability("wdaLocalPort", WDAPortNum);
			capabilities.setCapability("preventWDAAttachments", true);
			capabilities.setCapability("clearSystemFiles", "true");
			// capabilities.setCapability("fullReset", false);
			// capabilities.setCapability("noReset", false);

			driver = new IOSDriver(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
		}

		return driver;
	}

	public AppiumDriver initializeDriver() throws MalformedURLException {

		if (driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformVersion", "11.0");
			capabilities.setCapability("app", "settings");
			capabilities.setCapability("udid", "3bc7dd8b5c22793740afe7d216afb5ba2933e394");
			capabilities.setCapability("preventWDAAttachments", true);
			capabilities.setCapability("clearSystemFiles", "true");

			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}

		return driver;

	}
	
	public AppiumDriver getDriver() throws MalformedURLException {
		
		return driver;
	}

}
