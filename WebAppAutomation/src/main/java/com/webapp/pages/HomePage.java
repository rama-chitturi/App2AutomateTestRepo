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
	
	@FindBy(xpath=".//div[3]/img")
	WebElement ReportsPageBtnEle;
	
	@FindBy(xpath="")
	WebElement PageBtnEle2;
	
	public HomePage()throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void pageClick(String pageName) throws IOException
	{
		switch(pageName)
		{
		case "HTML":
			clickElement(HtmlPageBtnEle);
			break;
		case "Canvas":
			clickElement(CanvasPageBtnEle);
			break;		
		case "Reports":
			clickElement(ReportsPageBtnEle);
			break;
		default:
			System.out.println("Uh oh! Given page name is not found.");
		}
	}

}
