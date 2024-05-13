package com.webapp.pages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CanvasPageOtherMethods extends HTMLPageWebElements{


	CanvasPageOtherMethods canvasOtherObj;
	CanvasPage canvasObj;
	public CanvasPageOtherMethods() throws IOException {
		HTMLPageWebElements htmlEleObj = new HTMLPageWebElements();

	}

	public void clearCanvasMethod() throws InterruptedException
	{
		clearCanvasEle.click();
		driver.switchTo().alert().accept();
	}

	public void pickColorMethod(int colorCount)
	{
		pickColorEle.get(colorCount).click();
	}
	public void pickColorMethod(String colorName)
	{
		switch(colorName)
		{
		case "brown":
			pickColorEle.get(0).click();
			break;
		case "orange":
			pickColorEle.get(1).click();
			break;
		case "purple":
			pickColorEle.get(2).click();
			break;
		case "skyBlue":
			pickColorEle.get(3).click();
			break;
		case "rosy":
			pickColorEle.get(4).click();
			break;
		case "slateGrey":
			pickColorEle.get(5).click();
			break;
		case "seaGreen":
			pickColorEle.get(6).click();
			break;
		case "red":
			pickColorEle.get(7).click();
			break;
		case "green":
			pickColorEle.get(8).click();
			break;
		case "mustard":
			pickColorEle.get(9).click();
			break;
		case "lightGrey":
			pickColorEle.get(10).click();
			break;
		case "blue":
			pickColorEle.get(11).click();
			break;
		default:
			pickColorEle.get(6).click();


		}

	}

	public void verifyHomeNavigation()
	{
		canvasGoHomeEle.click();
		System.out.println("Oooooo!!! success in 2021 Happy New Year, success in 2024 and in future... ");			
	}
	
	public void triggerAllCanvasMethods() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		Class className = CanvasPage.class;
		canvasObj = new CanvasPage();
		Method[] methodList = className.getDeclaredMethods();
		int colorCount=0;
		for(Method methodCount : methodList)
		{
			System.out.println("Cleared Canvas for");
			clearCanvasMethod();
			pickColorMethod(colorCount);
			methodCount.invoke(canvasObj, null);
			System.out.println(methodCount.getName());
			colorCount++;
		}

	}

}

