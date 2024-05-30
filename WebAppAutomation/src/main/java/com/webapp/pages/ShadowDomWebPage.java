package com.webapp.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webapp.base.BaseConfig;

import io.github.sukgu.Shadow;

public class ShadowDomWebPage extends BaseConfig {
	JavascriptExecutor jsObj;
	
	@FindBy(css = "input#Radio2")
	WebElement Radio2Ele;
	
	public ShadowDomWebPage() throws IOException {
		super();		
		super.driverConfig();
		PageFactory.initElements(driver, this);
		handleUserCredentials();
		handleOtherElements();
		handleDropdown();
		handleFileUpload();
		backToFirstPage();
		
	}
	
	public static void main(String ar[]) throws IOException
	{
		ShadowDomWebPage sj= new ShadowDomWebPage();
		System.out.println("main started");
	}

	//handling shadow DOM elements using Javascript
	public void handleUserCredentials()
	{
		driver.get("https://rama-chitturi.github.io/App2AutomateRepo/WebSite2Automate/Pages/ShadowDom.html");
		 jsObj = (JavascriptExecutor)driver;
		WebElement userEle = (WebElement) jsObj.executeScript("return document.querySelector('#shadow_host').shadowRoot.querySelector('#userName')");
		String userjs = "arguments[0].setAttribute('value','App2AutomateUser')";
		((JavascriptExecutor)driver).executeScript(userjs, userEle);
		
		WebElement emailEle = (WebElement) jsObj.executeScript("return document.querySelector('#shadow_host').shadowRoot.querySelector('#emailID')");
		String emailjs = "arguments[0].setAttribute('value','user@app2automate.com')";
		((JavascriptExecutor)driver).executeScript(emailjs, emailEle);
		
	}
	
	//handling shadow DOM elements using Search Context with selenium 4.0 
	
	public void handleOtherElements()
	{
		WebElement shadowRootEle = driver.findElement(By.id("shadow_host"));
		SearchContext shadowroot = shadowRootEle.getShadowRoot();
		System.out.println(shadowroot.toString());
		
		WebElement radioBtn1 = shadowroot.findElement(By.cssSelector("input#Radio1"));
		WebElement radioBtn2 = shadowroot.findElement(By.cssSelector("input#Radio2"));
		radioBtn2.click();
		radioBtn1.click();
		
		WebElement checkBox1 = shadowroot.findElement(By.cssSelector("input#Checkbox1"));
		WebElement checkBox2 = shadowroot.findElement(By.cssSelector("input#Checkbox2"));
		checkBox1.click();
		checkBox2.click();
		
	}
	
	// handling shadow elements using plugin
	
	public void handleDropdown()
	{
		Shadow shObj = new Shadow(driver);
		WebElement dropDownEle = shObj.findElement("div#shadow_host>select#Select1");
		
		Select sc = new Select(dropDownEle);
		sc.selectByIndex(2);
	}
	
	public void handleFileUpload()
	{
		WebElement shadow_root = driver.findElement(By.id("shadow_host"));
		SearchContext scObj = shadow_root.getShadowRoot();
		File file = new File("DocFormatFile.docx");
		WebElement fileUploadBtnEle = scObj.findElement(By.cssSelector("input#File1"));
		fileUploadBtnEle.sendKeys(file.getAbsolutePath());
	}
	
	public void backToFirstPage()
	{
		Shadow scObj = new Shadow(driver);
		WebElement firstPageLink = scObj.findElement("div#shadow_host>a#advBtn2");
		firstPageLink.click();
	}

	public WebElement getShadowRoot(String querySelector)
	{
		jsObj = (JavascriptExecutor)driver;
		return (WebElement) jsObj.executeAsyncScript("return document.querySelector("+querySelector+")");
	}
	

}
