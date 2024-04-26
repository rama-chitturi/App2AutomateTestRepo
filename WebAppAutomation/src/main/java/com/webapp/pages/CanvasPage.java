package com.webapp.pages;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;

public class CanvasPage extends HTMLPageWebElements{

	public CanvasPage() throws IOException {
		HTMLPageWebElements htmlEleObj = new HTMLPageWebElements();
	}

	public void drawSquareMethod()
	{
		Actions builderSquare = new Actions(driver);
		builderSquare.clickAndHold(canvasEle).
		moveByOffset(50, 0).
		moveByOffset(0,-50).
		moveByOffset(-50,0).
		moveByOffset(0,50).release().perform();
	}

	public void drawRhombusMethod()
	{
		Actions builderRhombus = new Actions(driver);
		builderRhombus.clickAndHold(canvasEle).
		moveByOffset(50, 50).
		moveByOffset(-50,50).
		moveByOffset(-50,-50).
		moveByOffset(50,-50).release().perform();
	}
	
	public void drawPentagonMethod()
	{
		Actions builderPentagon = new Actions(driver);
		builderPentagon.clickAndHold(canvasEle).
		moveByOffset(50, 0).
		moveByOffset(0,30).
		moveByOffset(-25,25).
		moveByOffset(-25,-25).
		moveByOffset(0,-30).release().perform();
	}
	public void drawTraingleMethod()
	{
		Actions builderTrai = new Actions(driver);
		builderTrai.clickAndHold(canvasEle).
		moveByOffset(50, 0).
		moveByOffset(-25,-50).
		moveByOffset(-25,50).release().perform();
	}

	public void drawCharSMethod()
	{
		Actions builderS = new Actions(driver);
		builderS.moveToElement(canvasEle).moveByOffset(150, -150).clickAndHold(canvasEle).
		moveByOffset(-50,0).
		moveByOffset(0,50).
		moveByOffset(50, 0).
		moveByOffset(0,50).
		moveByOffset(-50,0).release().perform();	
	}

	public void drawCharMethod()
	{
		Actions builderTR = new Actions(driver);
		builderTR.moveByOffset(50, -50).clickAndHold(canvasEle).
		moveByOffset(0,-100).
		moveByOffset(-50, 0).
		moveByOffset(100,0).
		moveByOffset(-50, 50).
		moveByOffset(50,50).release().perform();	
		
	}

	public void drawCharVMethod()
	{
		Actions builderV = new Actions(driver);
		builderV.moveByOffset(50, -50).clickAndHold(canvasEle).
		moveByOffset(50,50).
		moveByOffset(50,-50).
		release().perform();	
	}
	
	public void drawOuterborderMethod()
	{
		Actions builder2 = new Actions(driver);
		builder2.clickAndHold(canvasEle).
		moveByOffset(-200,-200).
		moveByOffset(0,399).
		moveByOffset(399,0).
		moveByOffset(0,-399).
		moveByOffset(-400,0).
		release().perform();	
	}
	

	public void navigateToHome() throws IOException
	{
		clickElement(canvasGoHomeEle);
	}

}
