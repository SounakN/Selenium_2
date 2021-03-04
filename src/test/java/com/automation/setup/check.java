package com.automation.setup;




import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class check {
	
	public static WebDriver driver = null;
	public static void main(String[] args) throws ParseException, InterruptedException {
		String ChromeDriverServer = System.getProperty("user.dir") + "/browserserver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverServer);
		driver = new ChromeDriver();
		
		driver.get("https://www.javatpoint.com/selenium-tutorial");
		List<WebElement> check= driver.findElements(By.xpath("//div[@id='menu']/div[@class='leftmenu2']"));
		 WebElement iframe1=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		List<String> headers = new ArrayList<String>(); 
		headers.add("Selenium Tutorial");
		headers.add("Selenium IDE");
		String headername = "Selenium Tutorial";
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(iframe1);
		/* driver.switchTo().alert(). */





	}

}
