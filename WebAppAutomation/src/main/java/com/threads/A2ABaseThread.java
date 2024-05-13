package com.threads;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A2ABaseThread {
	static WebDriver driver;
	public void setupDriver(String browserName)
	{
		switch(browserName)
		{
			case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Not a valid browser given");
			
		}
		driver.get("https://rama-chitturi.github.io/App2AutomateRepo/WebSite2Automate/Pages/HomePage.html");
		driver.manage().window().maximize();
	}
	
	public void openotherURl()
	{
	Actions acObj = new Actions(driver);
//		acObj.keyDown(Keys.CONTROL).sendKeys("T").keyUp(Keys.CONTROL).sendKeys("T").perform();
//		
		driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
		WebElement ele = driver.findElement(By.xpath("(.//div/a/strong[contains(text(),'GitHub')])[1]"));
		acObj.moveToElement(ele).build().perform();
		ele.click();
	}
	public void HandleWindows()
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> windowsObj = driver.getWindowHandles();
		System.out.println("no of active windows: "+windowsObj.size());
		Iterator<String> it = windowsObj.iterator();
		String window;
		while(it.hasNext())
		{
			window = it.next();
			driver.switchTo().window(window);
		System.out.println(driver.getCurrentUrl());
			
		}
		driver.switchTo().window(parentWindow);
		//driver.close();
		driver.switchTo().window(it.next());
//		Dimension d = new Dimension(20,70);
//		driver.manage().window().setSize(d);
//		driver.switchTo().defaultContent();
//	String	childwindow =driver.getWindowHandle();
//	driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		
		
		
	}
	public void closeBrowser()
	{
		driver.quit();
	}

}
