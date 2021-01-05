package com.webapp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapp.base.BaseConfig;

public class HomePage extends BaseConfig 
	{
	
	@FindBy(xpath=".//img[@alt=\"Go to Canvas\"]")
	WebElement CanvasPageBtnEle;
	
	@FindBy(xpath=".//img[@alt=\"Go to Html elements page\"]")
	WebElement HtmlPageBtnEle;
	
	@FindBy(xpath="")
	WebElement PageBtnEle;
	
	@FindBy(xpath="")
	WebElement PageBtnEle2;
	
	public HomePage()throws IOException 
	{
		PageFactory.initElements(driver, this);
		System.out.println(driver.getTitle());
		System.out.println("initalized landing page elements");
		
	}
	
	public void pageClick(String pageName)
	{
		switch(pageName)
		{
		case "canvas":
			CanvasPageBtnEle.click();
			break;
		case "htmlelements":
			HtmlPageBtnEle.click();
			break;
		default:
			System.out.println("Uh oh! Given page name is not found.");
		}
	}

}
