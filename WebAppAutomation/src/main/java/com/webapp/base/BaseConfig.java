package com.webapp.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfig {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions chromeopt;
	public static EdgeOptions edgeOpt;
	public static WebDriverWait wait;
	public BaseConfig() throws IOException
	{
		FileReader fis = new FileReader("src\\main\\java\\com\\webapp\\config\\configDetails.properties");
		prop=  new Properties();
		prop.load(fis);
		
	}

	public void driverConfig() throws IOException
	{
		try
		{
//		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
//		driver = new ChromeDriver();
		
//		chromeopt = new ChromeOptions();
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeopt);
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("urlHome"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			getScreenshot(new Throwable().getStackTrace()[0].getMethodName());
		}
	}

	public void driverConfigWithURL(String url) throws IOException
	{
		try
		{
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rama-chitturi.github.io/App2AutomateRepo/WebSite2Automate/Pages/"+url+".html");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			getScreenshot(new Throwable().getStackTrace()[0].getMethodName());
		}
	}

	public void waitForEleLocated(WebElement element) throws IOException
	{
		try {
		wait =  new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			getScreenshot(new Throwable().getStackTrace()[0].getMethodName());
		}
	}
	public void waitForEleClickable(WebElement element)
	{
		wait =  new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void alertmessage(String message)
	{
		JFrame f;  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);  
	}

	public void getScreenshot(WebElement ele, String fileName) throws IOException
	{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImage = ImageIO.read(screenshotFile);
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		Point point = ele.getLocation();
		BufferedImage elementimage = fullImage.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(elementimage, "png", screenshotFile);

		File elementScreenshotFilePath = new File("Files\\Screenshots\\"+fileName+".png");
		FileHandler.copy(screenshotFile, elementScreenshotFilePath);

	}
	public void getScreenshot(String filename) throws IOException {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File filePath = new File("Files\\Screenshots\\"+filename+".png");
		FileHandler.copy(screenshot, filePath);
	}

	public ArrayList<Object> excelGetData(String sheetName, int rowNum, int colNum) throws InvalidFormatException, IOException
	{
		File excelFile = new File("Files\\ExcelFiles\\TestData_WebApp.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row ;
		XSSFCell cell;
		ArrayList<Object> data =  new ArrayList<Object>();
		String storeTestdata ;
		int rowCount=0;
		while(rowCount<sheet.getLastRowNum())
		{
			row=sheet.getRow(rowNum);
			try {
				cell = row.getCell(colNum);
				storeTestdata = cell.toString();
			}
			catch(NullPointerException e)
			{
				storeTestdata = "";
			}

			data.add(rowCount,storeTestdata);
			rowCount++;
			rowNum++;
		}
		return data;

	}

	public void excelSetData(String sheetName, int rowNum, int colNum, String receivedData) throws InvalidFormatException, IOException
	{
		File excelFile = new File("Files\\ExcelFiles\\TestData_WebApp.xlsx");
		FileInputStream fisObj = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fisObj);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		row.createCell(colNum).setCellValue(receivedData);
		FileOutputStream fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		fos.close();
	}

	public void clickElement(WebElement ele) throws IOException
	{
		waitForEleLocated(ele);
		ele.click();
	}
	public void inputKeys(WebElement ele, String inputToSend) throws IOException
	{
		waitForEleLocated(ele);
		ele.sendKeys(inputToSend);
	}
	public String getEleText(WebElement ele) throws IOException
	{
		waitForEleLocated(ele);
		String text = ele.getText();
		return text;
	}

	public void navigateBack()
	{
		driver.navigate().back();
	}
	public void acceptAlert(String acceptStatus)
	{
		if(acceptStatus.equalsIgnoreCase("accept"))
		driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}

	public static void closeBrowserWindow()
	{
		driver.close();
	}

	public void verifyBrokenLinks() throws MalformedURLException, IOException
	{
		String[] pagenameList = {"HomePage","WebPageElements1","WebPageElements2","Canvas"};
		int loopCount =0;
		while(loopCount<pagenameList.length)
		{
			pageLinkValidation(pagenameList[loopCount]);
			loopCount++;
		}
	}

	public void pageLinkValidation(String pagename) throws MalformedURLException, IOException
	{
		String navigateURL="https://rama-chitturi.github.io/App2AutomateRepo/WebSite2Automate/Pages/"+pagename+".html";
		driver.get(navigateURL);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int loopCount=0;
		System.out.println(links.size());

		while(loopCount<links.size())
		{
			String url = links.get(loopCount).getAttribute("href");

			HttpURLConnection hucObj = null;
			int pagResponseCode = 200;
			hucObj = (HttpURLConnection)(new URL(url).openConnection());
			hucObj.setRequestMethod("HEAD");
			hucObj.connect();

			pagResponseCode = hucObj.getResponseCode();

			if(pagResponseCode == 200){
				System.out.println("Valid link: " + url);
			}
			else if(pagResponseCode == 400 || pagResponseCode == 404 || pagResponseCode == 500 || pagResponseCode == 401)

				System.out.println("Invalid link: "+url);
			else
				System.out.println("Something went wrong with: "+ url);

			loopCount++;
		}
	}
	


}
