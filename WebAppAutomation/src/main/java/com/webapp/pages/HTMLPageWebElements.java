package com.webapp.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapp.base.BaseConfig;

public class HTMLPageWebElements extends BaseConfig {

	
   public HTMLPageWebElements() throws IOException {
		PageFactory.initElements(driver, this);
		
	}

   @FindBy(xpath= ".//div[@class=\"topnav\"]/a[text()=\"Basic Elements Page\"]")
   WebElement basicEleMenuBtnEle;   
   @FindBy(xpath=".//div[@class=\"topnav\"]/a[text()=\"About\"]")
   WebElement aboutMenuBtnEle;
   @FindBy(xpath=".//div[@class=\"topnav\"]/a[text()=\"Back to Home\"]")
   WebElement homeMenuBtnEle;
   @FindBy(xpath=".//div[@class=\"topnav\"]/a[text()=\"Canvas Page\"]")
   WebElement canvasMenuBtnEle;
   
   @FindBy(id="elementsDiv")
   WebElement elementsDiv;
   
   
@FindBy(xpath =".//input[contains(@placeholder,\"user name\")]")
WebElement userNameEle;
@FindBy(xpath =".//input[contains(@placeholder,\"user name\")]/following::input")
WebElement mailIdEle;
@FindBy(xpath=".//button[@type=\"submit\"]")
WebElement emailCheckBtnEle;
   
   @FindBy(id="Radio1")
   WebElement radioBtn1Ele;
   @FindBy(id="Radio2")
   WebElement radioBtn2Ele;
   @FindBy(id="Checkbox1")
   WebElement checkBox1Ele;
   @FindBy(id="Checkbox2")
   WebElement checkBox2Ele;
   
   @FindBy(className="dropdown-cls")
   WebElement dropdownEle;
   
   @FindBy(xpath =".//input[@type=\"file\"]")
   WebElement fileUploadBtnEle;
 
   
   @FindBy(className="dropbtn")
   WebElement dropupEle;
   @FindBy(xpath=".//div[@class=\"dropup-content\"]/button[1]")
   WebElement dropupItem1Ele;
   @FindBy(xpath=".//div[@class=\"dropup-content\"]/button[2]")
   WebElement dropupItem2Ele;
   @FindBy(id="lbldropuptxt")
   WebElement dropupTextEle;
   
   @FindBy(id="advBtn")
   WebElement advHtmlPageBtnEle;
   
   
   
   
   
   /** Advanced HTML elements  locator path***/
 
  
   
   @FindBy(xpath=".//div[@id=\"mySidenav\"]/a[@id='about']")
   WebElement sideMenuAboutEle;
   @FindBy(xpath=".//div[@id=\"mySidenav\"]/a[@id='blog']")
   WebElement sideMenuBlogEle;
   @FindBy(xpath=".//div[@id=\"mySidenav\"]/a[@id='projects']")
   WebElement sideMenuProjectsEle;
   @FindBy(xpath=".//div[@id=\"mySidenav\"]/a[@id='contact']")
   WebElement sideMenucontactEle;
   
 
   @FindBy(id="drag1")
   WebElement imageTodragEle;
   @FindBy(id="dragNdrop")
   WebElement imageTodropEle;
   
   @FindBy(id="myBtn")
   WebElement modalBtnEle;
   @FindBy(xpath=".//span[@class=\"close\"]")
   WebElement modalCloseBtnEle;
   @FindBy(xpath=".//div[@id=\"myModal\"]//p")
   WebElement modalTextEle;
   @FindBy(xpath=".//body")
   WebElement bodyEle;
   
   
   
   @FindBy(xpath=".//button[text()=\"Alert Message\"]")
   WebElement alertBtnEle;
   @FindBy(xpath=".//p[@id=\"ALertText\"]")
   WebElement alertTextEle;
   @FindBy(xpath=".//button[@id=\"snackBarBtn\"]")
   WebElement snackBarBtnEle;
   @FindBy(id="snackbar")
   WebElement snackBarTextEle;
   
  
   @FindBy(xpath=".//div[@class=\"flip-card\"]//div[@class=\"flip-card-front\"]")
   WebElement flipCardFrontEle;
   @FindBy(xpath=".//div[@class=\"flip-card\"]//div[@class=\"flip-card-back\"]")
   WebElement flipCardBackEle;
   
   @FindBy(xpath=".//i[@class=\"fa fa-thumbs-up fa-3x\"]")
   WebElement thumbsUpBtnEle;
   @FindBy(xpath=".//i[@class=\"fa fa-thumbs-up fa-3x fa-thumbs-down\"]")
   WebElement thumbsDownBtnEle;
   
   @FindBy(xpath=".//span[@class=\"slider round\"]")
   WebElement sliderSwitchBtnEle;
   
   @FindBy(xpath=".//button[@class=\"open-button\"]")
   WebElement openChatBtnEle;
   
   @FindBy(name="msg")
   WebElement msgTextAreaEle;
   
   @FindBy(xpath=".//button[ @type='submit']")
   WebElement sendBtnEle;
   
   @FindBy(xpath=".//button[text()='Close']")
   WebElement closeBtnEle;
   
    

   @FindBy(id="myInput")
   WebElement searchBarEle;
   @FindBy(id="myTable")
   WebElement tableEle;
    
 
   @FindBy(xpath = ".//table[@id=\"myTable\"]//tr")
   WebElement tableContentEle;
   
   @FindBy(xpath = ".//div[@class=\"tooltip\"]")
   WebElement tooltipEle;
   
   @FindBy(xpath = ".//div[@class=\"tooltip\"]/span")
   WebElement tooltipTextEle;
   
   @FindBy(xpath = ".//div[@class=\"back-button\"]/img")
   WebElement backArrowBtnEle;
   
   /** Canvas Page Elements **/
   
   @FindBy(id="can")
	WebElement canvasEle;
   
   @FindBy(id="clr")
  	WebElement clearCanvasEle;
   
   @FindBy(className="colorClsRow")
 	List<WebElement> pickColorEle;
   
   @FindBy(className="colorClsRow")
	List<WebElement> pickColorListEle;
   
   @FindBy(id="homeBtn")
 	WebElement canvasGoHomeEle;
  
   
   
}
