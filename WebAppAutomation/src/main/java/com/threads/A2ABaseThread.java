package com.threads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
