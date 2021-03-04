package com.automation.StepDefinitions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.automation.driver.DriverFactory;
import com.automation.utilities.PropertyReader;

public class SetUp {

	private WebDriver driver;
	private DriverFactory WebBrowser = new DriverFactory();
	public static Scenario Sc;
	public static byte[][] screenshotsArray = new byte[10][10000];
	public static String BrowserName = "";


	@Before
	public void setupTest(Scenario scenario) throws Exception {
		Sc = scenario;
		String browser=PropertyReader.getProperties("/Generic_framework/src/test/resources/PropertiesFile/qa.properties").getProperty("Browser");
		driver = WebBrowser.init_driver(BrowserName);
		System.out.println("--------");
		System.out.println(driver.toString());
		System.out.println("--------");
		System.out.println(Thread.currentThread().getId());
		Capabilities cap1 = ((RemoteWebDriver) driver).getCapabilities();
		BrowserName = cap1.getBrowserName().toLowerCase();
		System.out.println("BrowserName == " + BrowserName);
		String URL = PropertyReader.getProperties("/src/test/resources/PropertiesFile/qa.properties").getProperty("URL");
		driver.get(URL);
		Thread.sleep(3000);
	}
	

	@After()
	public void tearDown(Scenario result) throws Exception {
		System.out.println("In TearDown");
		System.out.println("result :: " + result);
		if (result.isFailed()) {
			
			String Screenshotname = result.getName().replace(" ","_");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			result.attach(screenshot, "image/png", Screenshotname);

		}
		driver.quit();

	}
}
