package com.automation.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Browsers BrowserDriver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public DriverFactory() {
	}

	public WebDriver init_driver(String BrowserType) {
		
		BrowserDriver = Browsers.get(BrowserType);
		switch(BrowserDriver)
		{
			case IE:
				
				break;

			case FIREFOX:
				
				break;

			case CHROME:
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("disable-popup-blocking");
				options.addArguments("disable-infobars");
				options.addArguments("--allow-running-insecure-content");
				options.addArguments("--allow-insecure-websocket-from-https-origin");
				options.addArguments("disable-extensions");
				options.addArguments("allow-running-insecure-content");
				options.addArguments("--start-maximized");
				options.addArguments("disable-extensions");
				options.addArguments("disable-plugins");
				options.addArguments("--enable-precise-memory-info");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("test-type=browser");
				options.addArguments("disable-infobars");
				options.setExperimentalOption("useAutomationExtension", false);
				DesiredCapabilities cap = new DesiredCapabilities();
				/* cap.setCapability(ChromeOptions.CAPABILITY, options); */
				options.merge(cap);
				tlDriver.set(new ChromeDriver(options));
				break;
			
			default:
				break;	
		
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
