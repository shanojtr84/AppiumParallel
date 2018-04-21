package auto.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.base.Function;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class AppiumWrapper extends InitAppium2 {


	

//	protected MobileDriver driverObj = null;
//	
//	public AppiumWrapper( MobileDriver driverObj) {
//		
//		this.driverObj = driverObj;
//	}

	
	/**
	 * The find method is the most frequent used method. This method takes a
	 * fixed parameter:'element By locator' and optional integer argument for
	 * timeout In cases where we need to wait longer time for an element to
	 * load, we can pass the required timeout. ex. find(userName, 10) where 10
	 * seconds timeout is requested.
	 * 
	 * @param locator
	 * @param args
	 * @return webelement
	 */
	public  static WebElement find(final By locator, int... args) {
		
		int timeout = (args.length > 0 ? args[0] : 15);
		WebElement webelement = null;
		
		System.out.println(AppiumDriverManager.getAppiumDriver());

		try {
			FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(AppiumDriverManager.getAppiumDriver()).withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(Exception.class)
					.ignoring(NoSuchElementException.class);
			
			webelement = wait.until(new Function<AppiumDriver, WebElement>() {
				public WebElement apply(AppiumDriver driver) {
					return driver.findElement(locator);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return webelement;

	}

	/**
	 * Method to perform the Tap action on an element. Takes the By locator as
	 * parameter
	 * 
	 * @param locator
	 */
	public void tapElement(By locator) {
		WebElement element = find(locator);
		element.click();
	}
	
	public void NavigateBack() throws MalformedURLException {
		AppiumDriverManager.getAppiumDriver().navigate().back();
	}
}
//	
//	public static WebElement findElementByText(String text, int... args) {
//
//		int timeout = (args.length > 0 ? args[0] : 15);
//
//		String xpath = "//android.widget.TextView[@text='" + text + "']";
//
//		By locator = By.xpath(xpath);
//
//		return find(locator, timeout);
//
//	}
//
//	/**
//	 * The find method is the most frequent used method. This method takes a
//	 * fixed parameter:'element By locator' and optional integer argument for
//	 * timeout In cases where we need to wait longer time for an element to
//	 * load, we can pass the required timeout. ex. find(userName, 10) where 10
//	 * seconds timeout is requested.
//	 * 
//	 * @param locator
//	 * @param args
//	 * @return webelement
//	 */
//	public static List<WebElement> finds(final By locator, int... args) {
//
//		int timeout = (args.length > 0 ? args[0] : 30);
//		List<WebElement> webelements = null;
//
//		try {
//			FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
//					.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(Exception.class)
//					.ignoring(NoSuchElementException.class);
//
//			webelements = wait.until(new Function<AppiumDriver, List<WebElement>>() {
//				public List<WebElement> apply(AppiumDriver driver) {
//					return (List) driver.findElements(locator);
//				}
//			});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//		}
//		return webelements;
//
//	}
//
//
//
//	public String getText(By locator) {
//		String text = find(locator).getText();
//		return text;
//	}
//
//	/**
//	 * Method to find multiple elements
//	 * 
//	 * @param locator
//	 */
//
//	public List<WebElement> findElements(By locator) {
//		List<WebElement> webelements = driver.findElements(locator);
//		return webelements;
//
//	}
//
//	/**
//	 * This method performs swipe actions on a particular element when invoked
//	 * with the Element and direction to swipe. Typically used to swipe on date
//	 * picker, list picker in iOS etc
//	 * 
//	 * @param locator
//	 * @param direction
//	 */
//	public static void swipeElement(By locator, SwipeElementDirection direction) {
//		MobileElement element = (MobileElement) find(locator);
//		element.swipe(direction, 1000);
//	}
//
//	/**
//	 * Method to simulate swipe action on the screen in desired direction
//	 * 
//	 * @param direction
//	 */
//	public static void swipeScreen(String direction) {
//
//		int y = driver.manage().window().getSize().getHeight();
//		int x = driver.manage().window().getSize().getWidth();
//		try {
//			switch (direction.toUpperCase()) {
//			case "UP":
//				// when navigating up, its opening the notifications bar. so
//				// changing the startY value from 10 to 300
//				driver.swipe(500, 300, 500, y - 10, 1000);
//				break;
//			case "DOWN":
//				driver.swipe(500, y - 10, 500, y - 1000, 1000);
//				break;
//			case "LEFT":
//				driver.swipe(50, y / 2, x - 10, y / 2, 1000);
//				break;
//			case "RIGHT":
//				driver.swipe(x - 50, y / 2, 10, y - 10, 1000);
//				break;
//			default:
//				throw new IllegalArgumentException();
//			}
//		} catch (IllegalArgumentException ix) {
//			System.out.println("Invalid directioN: Valid parameters- UP/DOWN/LEFT/RIGHT");
//		}
//
//	}
//
//	/**
//	 * Type a value into an appropriate element by passing the value to be
//	 * entered and the element locator
//	 * 
//	 * @param inputValue
//	 * @param locator
//	 */
//	public static void typeValue(String inputValue, By locator) {
//
//		find(locator).sendKeys(inputValue);
//
//	}
//
//	/**
//	 * Type a value into an appropriate element by passing the value to be
//	 * entered and the element locator
//	 * 
//	 * @param inputValue
//	 * @param locator
//	 */
//	public static void searchValue(String inputValue, By locator) {
//
//		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
//
//		// Try to send Keycode_Search again if search text field doesnt appear
//		// in first go.
//		for (int i = 0; i < 5; i++) {
//			if (find(locator) == null) {
//				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
//
//			} else
//				break;
//		}
//
//		// Clear the text field and enter the keyword to search for.
//		find(locator, 5).clear();
//		find(locator, 5).sendKeys(inputValue);
//
//		// Tap Enter to call Search operation
//		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
//
//	}
//
//	/**
//	 * This method is specifically to use when needed to set PIN in an app.
//	 * Using this sets pin very quickly.
//	 * 
//	 * @param pinValue
//	 */
//	public static void enterPin(String pinValue) {
//		driver.getKeyboard().sendKeys(pinValue);
//	}
//
//	/**
//	 * This method is specifically to use when needed to Press Done or Search
//	 * button quickly.
//	 * 
//	 * @param pinValue
//	 */
//	public static void pressSearchKey() {
//
//		driver.getKeyboard().sendKeys(Keys.ENTER);
//
//		// driver.getKeyboard().sendKeys(0x00000042);
//		// JavascriptExecutor jse = (JavascriptExecutor)driver;
//		// jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Go'].tap();");
//
//		// driver.navigate().forward();
//		// driver.getKeyboard().pressKey(AndroidKeyCode.ENTER);
//	}
//
//	/**
//	 * Read the name/text attribute of the element
//	 * 
//	 * @param locator
//	 */
//	public static String readValue(By locator) {
//		return find(locator).getText();
//	}
//
//	/**
//	 * Method to start the app
//	 */
//	public static void startApp() {
//		driver.launchApp();
//
//	}
//
//	/**
//	 * Method to close the app
//	 */
//	public static void closeApp() {
//		driver.closeApp();
//	}
//
//	/**
//	 * Method to restart the App. If appium server is configured with "full
//	 * reset" option then the App is reinstalled. This will kill the current
//	 * appium session and the test fails.
//	 */
//	public static void resetApp() {
//		driver.resetApp();
//	}
//
//	/**
//	 * Method to restart the App. If appium server is configured with "full
//	 * reset" option then the App is reinstalled. This will kill the current
//	 * appium session and the test fails.
//	 */
//	public static void restartApp() {
//
//		// Close the app
//		closeApp();
//
//		// Start the app
//		startApp();
//	}
//
//	/**
//	 * Pass the locator of WebElement on which you want to perform the precise
//	 * single tap action. Typically used in situations like click on overlaid
//	 * video play buttons etc
//	 * 
//	 * @param locator
//	 */
//	public static void preciseTap(By locator) {
//		WebElement element = find(locator);
//		Point upperLeft = element.getLocation();
//
//		final double finalXLocation = upperLeft.getX() + 5;
//		final double finalYLocation = upperLeft.getY() + 5;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("mobile: tap", new HashMap<String, Double>() {
//			{
//				put("tapCount", 1.0);
//				put("touchCount", 1.0);
//				put("duration", 1.0);
//				put("x", finalXLocation);
//				put("y", finalYLocation);
//			}
//		});
//	}
//
//	/**
//	 * This method takes a boolean parameter true/false. When user expects an
//	 * Alert then pass "true" as parameter else send "false" parameter
//	 * 
//	 * @param userExpectation
//	 * @throws NoAlertPresentException
//	 */
//	public static void verifyPopupExists(boolean userExpectation) throws NoAlertPresentException {
//		try {
//			driver.switchTo().alert();
//			Alert myAlert = driver.switchTo().alert();
//			String alertTxt = myAlert.getText();
//			if (userExpectation) {
//				Assert.assertTrue(userExpectation, "Popup dialog found with alert text :" + alertTxt);
//			} else {
//				Assert.assertTrue(!userExpectation, "No Popup is expected, but found one with alert text :" + alertTxt);
//			}
//
//		} catch (NoAlertPresentException noAlert) {
//			if (userExpectation) {
//				Assert.assertTrue(!userExpectation, "Popup is expected, but not found one");
//			} else {
//				Assert.assertFalse(userExpectation, "No Popup found as expected");
//			}
//		}
//	}
//
//	/**
//	 * Method to accept a Popup. Call verifyPopupExists method before calling
//	 * this method
//	 */
//	public void acceptPopup() {
//		Alert myAlert = driver.switchTo().alert();
//		myAlert.accept();
//	}
//
//	/**
//	 * Method to read Popup Message. Call VerifyPopupExists method before
//	 * calling this method
//	 * 
//	 * @return
//	 */
//	public String getPopupText() {
//		Alert myAlert = driver.switchTo().alert();
//		return myAlert.getText();
//	}
//
//	/**
//	 * Method to check if element exists .
//	 * 
//	 * @return
//	 */
//	public boolean checkElementExists(By locator) {
//
//		WebElement elementName;
//		boolean status = false;
//		try {
//			elementName = find(locator);
//			if (elementName == null) {
//				status = false;
//			} else {
//				status = true;
//			}
//		} catch (NoSuchElementException e) {
//
//			e.printStackTrace();
//		}
//
//		return status;
//	}
//
//	/**
//	 * Method to check if element exists with wait .
//	 * 
//	 * @return
//	 */
//	public boolean checkElementExists(By locator, int i) {
//
//		WebElement elementName;
//		boolean status = false;
//		try {
//			elementName = find(locator, i);
//			if (elementName == null) {
//				status = false;
//			} else {
//				status = true;
//			}
//		} catch (NoSuchElementException e) {
//
//			e.printStackTrace();
//		}
//		return status;
//	}
//
//	/**
//	 * Method to check if element exists by Text.
//	 * 
//	 * @return
//	 */
//	public boolean checkElementExistByText(String text) {
//
//		WebElement elementName;
//		boolean status = false;
//		String xpath = "//android.widget.TextView[@text='" + text + "']";
//		By locator = By.xpath(xpath);
//
//		try {
//			elementName = find(locator);
//			if (elementName == null) {
//				status = false;
//			} else {
//				status = true;
//			}
//		} catch (NoSuchElementException e) {
//
//			e.printStackTrace();
//		}
//		return status;
//	}
//
//	/**
//	 * Method to check if element exists by Text.
//	 * 
//	 * @return
//	 */
//	public boolean checkElementExistByText(String text, int i) {
//
//		WebElement elementName;
//		boolean status = false;
//		String xpath = "//android.widget.TextView[@text='" + text + "']";
//		By locator = By.xpath(xpath);
//
//		try {
//			elementName = find(locator, i);
//			if (elementName == null) {
//				status = false;
//			} else {
//				status = true;
//			}
//		} catch (NoSuchElementException e) {
//
//			e.printStackTrace();
//		}
//		return status;
//	}
//
//	/*
//	 * If the field is not found on the visible part of the screen, then this
//	 * method scrolls through the whole screen and tries to find the element 1.
//	 * first finds the element on the current visible screen 2. If not found
//	 * then scrolls to the next part of the screen and tries to find the element
//	 * (This check is done as mostly the current element will be shown next to
//	 * the previous element and this might be on the start of next page of the
//	 * screen when we scroll) 3. If not found in the next part, then user
//	 * scrolls to the very top of the screen and tries to find the element 4. If
//	 * not found, then as the control is on the starting of the screen, we
//	 * scroll part by part on the screen till we reach the bottom (we will be
//	 * searching for the element on each part when we are scrolling)
//	 */
//	public boolean assertField(By locator) {
//
//		boolean status = false;
//
//		for (int i = 0; i < 3; i++)
//			swipeScreen("Up");
//
//		for (int i = 0; i <= 5; i++) {
//
//			if (find(locator, 3) != null) {
//				status = true;
//				break;
//			} else {
//				// scrolling to the next part every time
//				swipeScreen("Down");
//			}
//		}
//		return status;
//
//	}
//
//	/*
//	 * To make sure that the screen has loaded, this method can be called by
//	 * passing the first element on the loading screen
//	 */
//	public void waitFor(By locator, int... args) {
//		int timeout = (args.length > 0 ? args[0] : 15);
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//		// InitAppium.driver.manage().timeouts().implicitlyWait(200,
//		// TimeUnit.SECONDS);
//	}
//
//	/**
//	 * This method is used to Tap on an element,by passing the WebElement
//	 * 
//	 * @param element,WebElement
//	 *            on which tap has to be performed
//	 * @return void
//	 */
//	public void tapElement(WebElement element) {
//		try {
//
//			element.click();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * This method is used to get the text of the specified Element
//	 * 
//	 * @param element,WebElement
//	 *            whose text needs to be fetched
//	 * @return String,The text attribute of the element
//	 */
//	public String getText(WebElement element) {
//
//		String text = element.getText();
//
//		return text;
//	}
//
//	/**
//	 * This method is used to get the value of the specified attribute of a
//	 * WebElement
//	 * 
//	 * @param element,WebElement
//	 *            whose attribute value needs to be fetched attribute,The value
//	 *            of the specified attribute of the WebElement
//	 * @return String,The value of the specified attribute of the element
//	 */
//	public String getAttribute(WebElement element, String attribute) {
//
//		String text = element.getAttribute(attribute);
//
//		return text;
//	}
//
//	/**
//	 * This method is used to get the value of the specified attribute of a
//	 * WebElement by passing the locator
//	 * 
//	 * @param locator,locator
//	 *            of the webelement whose attribute value needs to be fetched
//	 *            attribute,The value of the specified attribute of the
//	 *            WebElement
//	 * @return String,The value of the specified attribute of the element
//	 */
//	public String getAttribute(By locator, String attribute) {
//
//		WebElement element = find(locator);
//		String text = element.getAttribute(attribute);
//		return text;
//	}
//
//	/**
//	 * This method clicks on an element that contains specified text,by building
//	 * a dynamic xpath
//	 * 
//	 * @param text,the
//	 *            text based on which the xpath this built to find the element
//	 * @return void
//	 */
//	public void tapElementByText(String text) {
//
//		String xpath = "//android.widget.TextView[@text='" + text + "']";
//		By locator = By.xpath(xpath);
//
//		System.out.println("This is the XPATH we are looking for" + xpath);
//		tapElement(locator);
//
//	}
//
//	/**
//	 * This method clicks on an element that contains specified text,by building
//	 * a dynamic xpath for Radio Button
//	 * 
//	 * @param String,the
//	 *            text based on which the xpath this built to find the element
//	 * @return void
//	 */
//	public void tapElementByRadiobtnText(String text) {
//
//		String xpath = "//android.widget.RadioButton[@text='" + text + "']";
//		By locator = By.xpath(xpath);
//		tapElement(locator);
//	}
//
//	/**
//	 * This method is used to get the screen height
//	 * 
//	 * @param none
//	 * @return int
//	 */
//	public int getScreenHeight() {
//
//		return driver.manage().window().getSize().getHeight();
//
//	}
//
//	/**
//	 * This method is used to get the screen width
//	 * 
//	 * @param none
//	 * @return int
//	 */
//
//	public int getScreenWidth() {
//
//		return driver.manage().window().getSize().getWidth();
//
//	}
//
//	/**
//	 * This method is used to get the screen width
//	 * 
//	 * @param startx,starting
//	 *            x co-ordinate starty,starting y co-ordinate endx,ending x
//	 *            co-ordinate endy,ending y co-ordinate duration,amount of time
//	 *            in milliseconds for the entire swipe action to take
//	 * @return void
//	 */
//
//	public void swipeScreen(int startx, int starty, int endx, int endy, int duration) {
//
//		try {
//
//			driver.swipe(startx, starty, endx, endy, duration);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * This method is used to press on device back button
//	 * 
//	 * @param none
//	 * @return void
//	 */
//	public void pressBackButton() {
//
//		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
//
//	}
//
//	/**
//	 * This method is used to press on device back button
//	 * 
//	 * @param none
//	 * @return void
//	 */
//	public void pressHomeButton() {
//
//		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
//
//	}
//
//	/**
//	 * This method is used to scroll to the specified text and return the
//	 * corresponding element.
//	 * 
//	 * @param str,the
//	 *            text based on which the method tries to scroll and find the
//	 *            element
//	 * @return WebElement,The Webelement that was found based on the text
//	 *         attribute
//	 */
//	public WebElement ScrollToElementByText(String str) {
//
//		WebElement wb = ((AndroidDriver) driver).findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
//						+ str + "\").instance(0))");
//
//		return wb;
//
//	}
//
//	/**
//	 * This method is used to put the app to background and bring to foreground
//	 * 
//	 * @param appName,the
//	 *            name of the application to switch to
//	 * @return void
//	 */
//	public void SwitchToApp(String appName) {
//
//		((AndroidDriver) driver).runAppInBackground(5);
//		((AndroidDriver) driver).currentActivity();
//
//	}
//
//	/**
//	 * This method is used to scroll to the specified text and returns the
//	 * corresponding element.
//	 * 
//	 * @param str,the
//	 *            text based on which the method tries to scroll and find the
//	 *            element
//	 * @return WebElement,The Webelement that was found based on the
//	 *         content-desc attribute
//	 */
//	public WebElement ScrollToElementByDescription(String str) {
//
//		WebElement wb = ((AndroidDriver) driver).findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\""
//						+ str + "\").instance(0))");
//
//		return wb;
//
//	}
//
//
//
//	/**
//	 * This method is used to check whether the keyboard is currently displayed
//	 * on the screen with the help of adb command
//	 * 
//	 * @param none
//	 * @return boolean
//	 */
//
//	public boolean isKeyboardPresent() {
//
//		String status = null;
//
//		try {
//			String adbCmdOutput = null;
//
//			Runtime runtime = Runtime.getRuntime();
//			Process process = runtime.exec(new String[] { System.getenv("ANDROID_HOME") + "/platform-tools/adb",
//					"shell", "dumpsys", "input_method", "|", "grep", "mInputShown" });
//			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			adbCmdOutput = reader.readLine().trim();
//			reader.close();
//			status = adbCmdOutput.split(" ")[3].split("=")[1];
//
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return status.equals("true");
//	}
//
//	/**
//	 * This method is used to tap on the screen based on the specified x and y
//	 * screen co-ordinates
//	 * 
//	 * @param x
//	 *            and y screen co-ordinates to be taped
//	 * @return void
//	 */
//
//	public void tapElement(int start_x, int start_y) {
//
//		TouchAction touchAction = new TouchAction(driver);
//
//		touchAction.tap(start_x, start_y).perform();
//
//	}
//
//	/**
//	 * This method is used to get the current activity running on the screen
//	 * 
//	 * @param none
//	 * @return String
//	 */
//
//	public String getCurrentActivity() {
//
//		return ((AndroidDriver) driver).currentActivity();
//
//	}
//
//	/**
//	 * This method is used to press a key on the keyboard
//	 * 
//	 * @param key,keycode
//	 *            of the corresponding key
//	 * @return void
//	 */
//
//	public void pressKey(int key) {
//
//		((AndroidDriver) driver).pressKeyCode(key);
//
//	}
//
//	/**
//	 * This method is used to press a key on the keybard
//	 * 
//	 * @param key,keycode
//	 *            of the corresponding key
//	 * @return void
//	 */
//
//	public void startAndroidActivity(String appPackage, String appActivity) {
//
//		((AndroidDriver) driver).startActivity(appPackage, appActivity);
//
//	}
//
//	/**
//	 * This method is used to hide the keyboard
//	 * 
//	 * @param none
//	 * @return void
//	 */
//
//	public void dismissKeyboard() {
//
//		driver.hideKeyboard();
//
//	}
//
//}
