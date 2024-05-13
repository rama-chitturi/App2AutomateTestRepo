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
		verifySideMenuItemLinks();
		verifyDragNDrop();
		verifyModalButton();
		verifyAlertButton();
		verifySnackBar();
		verifyFlipcard();
		verifyThumbSwitching();
		verifySliderSwitching();
		verifyChatBox();
		verifySearchBar("Automation");
		verifySearchFucntionality("Automation");
		verifyBackArrowNavigation();
	}

	/** Verifying All Side Hover menu Items Navigations
	 * @throws InterruptedException **/
	public void verifySideMenuItemLinks() throws InterruptedException
	{
		Actions actObj = new Actions(driver);
		Thread.sleep(5000);
		actObj.moveToElement(sideMenuAboutEle).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenuBlogEle).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenuProjectsEle).click().release().perform();
		driver.navigate().back();
		actObj.moveToElement(sideMenucontactEle).click().release().perform();
		driver.navigate().back();
	}

	public void verifyDragNDrop() throws IOException
	{
		Actions actObj = new Actions(driver);
		actObj.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();
		getScreenshot(dropEle, "dragged");
		if(dropEle.getText().equalsIgnoreCase("Dropped!"))
			System.out.println("Card is successfully dropped to destination as expected");
		else
			System.out.println("Card is not dropped to destination");
	}
	/**Verifying Modal open and close(By clicking on X and outside of modal) **/
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

	/** Verification of Chat box functionality 
	 * @throws IOException **/ 
	public void verifyChatBox() throws IOException
	{
		
		clickElement(openChatBtnEle);
		inputKeys(msgTextAreaEle, "A Big Hi to you!");
		clickElement(sendBtnEle);
		System.out.println(getEleText(chatmessageTxtEle));
		
		driver.navigate().back();
		clickElement(closeBtnEle);
	
	}

	/** Verify search bar input **/
	public void verifySearchBar(String DataToSearch)
	{
		searchBarEle.sendKeys(DataToSearch);
	}
	
	
	/** Verification of Search functionality among Table data **/ 
	public void verifySearchFucntionality(String dataTosearch)
	{
		//Fetch table content 
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
			if((searchedData.get(loopcount)).contains(dataTosearch))
			{
				System.out.println("Filtered data " +searchedData.get(loopcount)+" is matched with search keyword "+dataTosearch+" as expected");
				searchCount++;
			}
			else
				System.out.println("Filtered data " +searchedData.get(loopcount)+" is not matched with search keyword "+dataTosearch);
		}
		System.out.println("Total matches with Search keyword:"+dataTosearch+" are "+searchCount);
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



