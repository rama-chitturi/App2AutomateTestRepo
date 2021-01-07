package com.webapp.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
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
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConfig {

	public static WebDriver driver;
	public static Properties prop;
	public BaseConfig() throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\main\\java\\com\\webapp\\config\\configDetails.properties");
		prop=  new Properties();
		prop.load(fis);
	}

	public void driverConfig()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("urlHome"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void driverConfigWithURL(String url)
	{
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rama-chitturi.github.io/App2AutomateRepo/WebSite2Automate/Pages/"+url+".html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	public void waitForEleLocated(WebElement element)
	{
		WebDriverWait wait =  new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}
	public void waitForEleClickable(WebElement element)
	{
		WebDriverWait wait =  new WebDriverWait(driver, 30);
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

	public void clickElement(WebElement ele)
	{
		ele.click();
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
	}
	
	public void closeBrowserWindow()
	{
		driver.close();
	}
}
