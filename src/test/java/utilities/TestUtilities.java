package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtilities {
	
	static final Logger logger = LogManager.getLogger(TestUtilities.class.getName());
	
	
	public static void  moveToElement(WebDriver driver, WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
	}
	
	public static void  clickOnElementWithActions(WebDriver driver, WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.click(ele).perform();
	}

	public static void waitForElementToClickable(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		 
	}
	
	public static void waitForElementToVisibleable(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void scrollToElement(WebDriver driver, WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.scrollToElement(ele).perform();
		
	}
	
	
	public static void captureScreenshot(WebDriver driver) throws IOException
	{
		//File file = new File("screenshots");
		File file = new File(TestBase.foldername);
		
		if(!file.isDirectory())
		{
			System.out.println("Folder Doesn't Exists!! Creating a New Folder");
			file.mkdirs();
		}
		else {
			System.out.println("Folder Exists!!");
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(file+"/"+getTimeStamp()+"img.jpg"));
		
	}
	
	private static String getTimeStamp()
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYY_MMM_dd_HH_mm_ss_SSS_z");
		String s = sdf.format(dt);
		return s.trim();
	}
	
	public static void attachScreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		
		String image = "<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		
		Reporter.log(image);
	}

}
