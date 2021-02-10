package com.webapp.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page1HtmlElements extends HTMLPageWebElements {
	
	public Page1HtmlElements() throws IOException
	{
		HTMLPageWebElements htmlEleObj= new HTMLPageWebElements();
	}
	
	/**Trigger method to check all elements basic fucntionality **/
	public void triggerAllElements(String userNameData, String userEmailData)
	{
		
		userNameEle.sendKeys(userNameData);
		mailIdEle.sendKeys(userEmailData);
		emailCheckBtnEle.click();
		driver.switchTo().alert().accept();
		radioBtn1Ele.click();
		radioBtn2Ele.click();
		checkBox1Ele.click();
		checkBox2Ele.click();
		Select scObj= new Select(dropdownEle);
		scObj.selectByIndex(2);
		File file =  new File("Files\\UploadFileFormats\\DocFormatFile.docx");
		fileUploadBtnEle.sendKeys(file.getAbsolutePath());
		
		Actions acObj =  new Actions(driver);
		acObj.moveToElement(dropupEle).build().perform();
		dropupItem1Ele.click();
		dropupItem2Ele.click();
		advHtmlPageBtnEle.click();
	}
	
	/** Verification of all Menu header items link navigations**/
	public void verifyMenuItemLinks()
	{
		basicEleMenuBtnEle.click();
		driver.navigate().back();
		aboutMenuBtnEle.click();
		driver.navigate().back();
		homeMenuBtnEle.click();
		driver.navigate().back();
		canvasMenuBtnEle.click();
		driver.navigate().back();
	}
	
	/** Validation of user credentials from given data **/
	
	public void verifyUserCredential(String username, String email)
	{
		userNameEle.sendKeys(username);
		mailIdEle.sendKeys(email);
		emailCheckBtnEle.click();
		driver.switchTo().alert().accept();
	}
		
	/**Validation of User credentials using data-driven**/
	public void verifyUserCredential() throws InvalidFormatException, IOException
	{
		ArrayList<Object> userNameTestData	= excelGetData("TestData1", 1, 1);
		ArrayList<Object> userEmailTestData	= excelGetData("TestData1", 1, 3);
		
		String emailTestDataResult = null, nameTestDataResult = null, alertMessage;
		int dataCount=0;
		while((dataCount<userNameTestData.size())||(dataCount<userEmailTestData.size()) )
		{
			userNameEle.clear();
			mailIdEle.clear();
			try {
			userNameEle.sendKeys(userNameTestData.get(dataCount).toString());
			}
			catch(NullPointerException e)
			{
				userNameEle.sendKeys("");
			}
			try 
			{
				mailIdEle.sendKeys(userEmailTestData.get(dataCount).toString());
			}
			catch(NullPointerException e)
			{
				mailIdEle.sendKeys("");
			}
			
			emailCheckBtnEle.click();
			
			alertMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(alertMessage.equalsIgnoreCase("Valid Credentails! Here you go!!") && elementsDiv.isDisplayed())
			{
				nameTestDataResult = "Testcase Passed";
				emailTestDataResult= "Testcase Passed";
			}
			else if(alertMessage.equalsIgnoreCase("Please enter valid credentials"))
			{
				nameTestDataResult = "Testcase Failed";
				emailTestDataResult= "Testcase Failed";
			}
			else if(alertMessage.equalsIgnoreCase("Please enter your EmailID"))
			{
				nameTestDataResult = "Testcase Passed";
				emailTestDataResult= "Testcase Failed";
			}
			else if(alertMessage.equalsIgnoreCase("Please enter your prefered User name"))
			{
				nameTestDataResult = "Testcase Failed";
				emailTestDataResult= "Testcase Passed";
			}
			else if(alertMessage.equalsIgnoreCase("You have entered an invalid email address!"))
			{
				nameTestDataResult = "Testcase Passed";
				emailTestDataResult= "Testcase Failed";
			}
			else
			{
				nameTestDataResult = "Something went wrong";
				emailTestDataResult= "Something went wrong";
			}
			
			
			excelSetData("TestData1", dataCount+1, 2, nameTestDataResult); //username
			excelSetData("TestData1", dataCount+1, 4, emailTestDataResult); //email
			dataCount++;
		}
  }
	

	/** Verification of Group Radio button functionality**/
	public void verifyGroupRadioButton()
	{
		radioBtn1Ele.click();
		radioBtn2Ele.click();
		
		if(radioBtn1Ele.isSelected() & radioBtn2Ele.isSelected())
			System.out.println("Selecting all radio buttons");
		else
			System.out.println("Group Radio button Selecting only one as expected");
	}
	
	/**Verification of Checkbox selection **/
	public void verifyCheckBox()
	{
		checkBox1Ele.click();
		checkBox2Ele.click();
		if(checkBox1Ele.isSelected() & checkBox2Ele.isSelected())
			System.out.println("Both the chekboxes are selecting as expected");
		checkBox1Ele.click();
		checkBox2Ele.click();
		if(!(checkBox1Ele.isSelected()||checkBox2Ele.isSelected()))
			System.out.println("Both the chekboxes are Deselected as expected");
			
	}
	
	/** Verification of Dropdown all Items selection**/
	public void verifyDropdownItems() 
	{
		List<WebElement> dropdownListItems =  dropdownEle.findElements(By.tagName("option"));
		int dropdownListItemLength = dropdownListItems.size();
		int loopCount=0;
		Select itemSelect = new Select(dropdownEle);
		while(loopCount<dropdownListItemLength)
		{
		itemSelect.selectByIndex(loopCount);
		loopCount++;
		if(loopCount==dropdownListItemLength)
			System.out.println("Selected all items in dropown as expected");
		}
		
	}
	/**Verification of Uploading of various file formats **/
	public void verifyUploadFileFormat() throws InterruptedException
	{
		File folderPath =  new File("Files\\UploadFileFormats");
		File[] filesList = folderPath.listFiles();
		int loopCount=0;
		try
		{
			while(loopCount<filesList.length)
			{
			fileUploadBtnEle.sendKeys(filesList[loopCount].getAbsolutePath());
			loopCount++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**Verification of Dropup Items seelction **/
	public void verifyDropupButton()
	{
		Actions acObj =  new Actions(driver);
		acObj.moveToElement(dropupEle).build().perform();
		dropupItem1Ele.click();
		if((dropupTextEle.getText()).equalsIgnoreCase("You have selected on value1 from dropup"))
			System.out.println("Dropup button 1 clicked as expected");

		dropupItem2Ele.click();
		if((dropupTextEle.getText()).equalsIgnoreCase("You have selected on value2 from dropup"))
			System.out.println("Dropup button 2 clicked as expected");

	}
	
	/** Verification of link navigation and navigated Page verification**/
	public void verifyLinkNavigation()
	{
		advHtmlPageBtnEle.click();
		if(driver.getCurrentUrl().contains("WebPageElements2"))
		{
		System.out.println("Page navigated as expected");
		
		}
		else
			System.out.println("Clicking on link not navigated to expected page");
		
	}


	public void pageClick(String pageName)
	{
		switch(pageName)
		{
		case "about":
			aboutMenuBtnEle.click();
			break;
		case "home":
			homeMenuBtnEle.click();
			break;
		case "canvas":
			canvasMenuBtnEle.click();
			break;
			
		default:
			System.out.println("Uh oh! Given page name is not found.");
		}
	}



}
