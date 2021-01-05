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
		case "orange":
			pickColorEle.get(1).click();
		case "purple":
			pickColorEle.get(2).click();
		case "skyBlue":
			pickColorEle.get(3).click();
		case "rosy":
			pickColorEle.get(4).click();
		case "slateGrey":
			pickColorEle.get(5).click();

		case "seaGreen":
			pickColorEle.get(6).click();
		case "red":
			pickColorEle.get(7).click();
		case "green":
			pickColorEle.get(8).click();
		case "mustard":
			pickColorEle.get(9).click();
		case "lightGrey":
			pickColorEle.get(10).click();
		case "blue":
			pickColorEle.get(11).click();
		default:
			pickColorEle.get(6).click();


		}

	}

	public void verifyHomeNavigation()
	{
		canvasGoHomeEle.click();
		System.out.println("Ohooooo!!!! success in 2021... Happy New Year");			
	}

	public void triggerAllCanvasMethods() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		Class className = CanvasPage.class;
		canvasObj = new CanvasPage();
		Method[] methodList = className.getDeclaredMethods();
		int colorCount=0;
		for(Method loopCount : methodList)
		{

			pickColorMethod(colorCount);
			loopCount.invoke(canvasObj, null);
			clearCanvasMethod();
			colorCount++;
		}

	}

}

