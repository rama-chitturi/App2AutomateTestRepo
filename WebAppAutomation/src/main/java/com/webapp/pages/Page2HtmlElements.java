package com.webapp.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page2HtmlElements extends HTMLPageWebElements {
	
	public Page2HtmlElements() throws IOException {
		HTMLPageWebElements advhtmlObj = new HTMLPageWebElements();
	}
	
	public void triggerAllAdvElements() throws InterruptedException, IOException, AWTException
	{
		Actions actObj = new Actions(driver);
		actObj.moveToElement(sideMenuAboutEle, 80,0).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenuBlogEle, 80,0).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenuProjectsEle, 80,0).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenucontactEle, 80,0).click().release().perform();
		driver.navigate().back();
	
		modalBtnEle.click();
		modalCloseBtnEle.click();
		
		alertBtnEle.click();
		driver.switchTo().alert().accept();
		
		snackBarBtnEle.click();
				
		actObj.moveToElement(flipCardFrontEle).build().perform();
		getScreenshot(flipCardBackEle,"Flip_Card_Back_Image");
		
		thumbsUpBtnEle.click();
		thumbsDownBtnEle.click();
		
		sliderSwitchBtnEle.click();
		
		openChatBtnEle.click();
		msgTextAreaEle.sendKeys("A Big Hi to you!");
		sendBtnEle.click();
		driver.navigate().back();
		openChatBtnEle.click();
		closeBtnEle.click();
		
		searchBarEle.sendKeys("Test");
	}
	
	/** Verifying All Side Hover menu Items Navigations**/
	public void verifySideMenuItemLinks()
	{
		Actions actObj = new Actions(driver);
		actObj.moveToElement(sideMenuAboutEle, 80,0).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenuBlogEle, 80,0).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenuProjectsEle, 80,0).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenucontactEle, 80,0).click().release().perform();
		driver.navigate().back();
	}

	/**Verifying Modal open and close(By cliking on X and outside of modal) **/
	public void verifyModalButton() 
	{
		modalBtnEle.click();
		System.out.println(modalTextEle.getText());
		modalCloseBtnEle.click();
		modalBtnEle.click();
		bodyEle.click(); // to close modal by clicking outside of modal
	}

	/** Verifying Alert Ok and Cancel functionality **/
	public void verifyAlertButton()
	{
		alertBtnEle.click();
		driver.switchTo().alert().accept();
		if((alertTextEle.getText()).equalsIgnoreCase("You Selected OK!"))
			System.out.println("Alert button selected with Ok choice");
		alertBtnEle.click();
		driver.switchTo().alert().dismiss();
		if((alertTextEle.getText()).equalsIgnoreCase("You Selected Cancel!"))
			System.out.println("Alert button selected with Cancel choice");			
	}
	
	public void verifySnackBar()
	{
		snackBarBtnEle.click();
		String snackbarText = snackBarTextEle.getText();
		if(snackbarText.equalsIgnoreCase("Here is a Snack bar!"));
			System.out.println("Snack barText matched as expected");
		if(snackBarTextEle.isDisplayed())
			System.out.println("snack bar is displayed as expected.");
		else
			System.out.println("snack bar is not displayed");
	}
	
	/** Verifucation of Card flippling and get Screenshot**/
	public void verifyFlipcard() throws IOException, InterruptedException
	{
		Actions actObj = new Actions(driver);
		actObj.moveToElement(flipCardFrontEle).build().perform();
		getScreenshot(flipCardBackEle,"Flip_Card_Back_Image");
	}

	/** Verification of Thumb Up/Down functionality**/
	public void verifyThumbSwitching()
	{

		if(thumbsUpBtnEle.isEnabled())
			System.out.println("Thumbsup is displayed as default as expected");
		else
			System.out.println("Thumbsup is not default");

		thumbsUpBtnEle.click();
		if(thumbsDownBtnEle.isEnabled())
			System.out.println("ThumbsDown selection is working as expected");
		else
			System.out.println("ThumbsDown selection is not working ");

		thumbsDownBtnEle.click();
		if(thumbsUpBtnEle.isEnabled())
			System.out.println("Switching between Thumbsup/down is working as expected");
		else
			System.out.println("Switching between Thumbsup/down is not working");

	}

	/** Verification of Slider Switch functionality**/
	public void verifySliderSwitching()
	{
		if(sliderSwitchBtnEle.isSelected())
			System.out.println("SliderSwitch is not disbaled by default");
		else
			System.out.println("By default SliderSwitch is disabled as expected");

		sliderSwitchBtnEle.click();
		if(sliderSwitchBtnEle.isEnabled())
			System.out.println("SliderSwitch selection is working as expected");
		else
			System.out.println("SliderSwitch selection is not working ");

		sliderSwitchBtnEle.click();
		if(sliderSwitchBtnEle.isSelected())
			System.out.println("Switching between SliderSwitch is not working");

		else
			System.out.println("Switching between SliderSwitch is working as expected");

	}

	/** Verification of Chat box functionality **/ 
	public void verifyChatBox()
	{
		openChatBtnEle.click();
		msgTextAreaEle.sendKeys("A Big Hi to you!");
		sendBtnEle.click();
		driver.navigate().back();
		openChatBtnEle.click();
		closeBtnEle.click();
	}

	/** Verification of Search functionality among Table data **/ 
	public void verifySearchFucntionality()
	{
		String DataToSearch = "Test";
		searchBarEle.sendKeys(DataToSearch);
		List<WebElement> tableSearchList = driver.findElements(By.xpath(".//table[@id=\"myTable\"]//tr/td"));
		int tableSearchListLength, listItemcount=0, searchCount=0;
		List<String> searchedData = new ArrayList<>();
		tableSearchListLength = tableSearchList.size();

		while(listItemcount<tableSearchListLength)
		{
			searchedData.add(tableSearchList.get(listItemcount).getText());
			listItemcount++;
		}
		//Validate searched Data

		for(int loopcount=0;loopcount<tableSearchListLength;loopcount++)
		{
			if((searchedData.get(loopcount)).contains(DataToSearch))
			{
				System.out.println("Filtered data " +searchedData.get(loopcount)+" is matched with search keyword "+DataToSearch+" as expected");
				searchCount++;
			}
			else
				System.out.println("Filtered data " +searchedData.get(loopcount)+" is not matched with search keyword "+DataToSearch);
		}
		System.out.println("Total matches with Search keyword:"+DataToSearch+" are "+searchCount);
	}

	public void verifyBackArrowNavigation()
	{
		backArrowBtnEle.click();
		if(driver.getCurrentUrl().contains("WebPageElements1"))
			System.out.println("Back arrow button navigated as expected.");
		else
			System.out.println("Back Arrow navigation is as unexpected");
	}

	
	
	}  
	


