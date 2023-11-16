package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	static final Logger logger = LogManager.getLogger(TestBase.class.getName());
	
	private WebDriver driver;
	public String browserType;
	
	public Properties prop;
	
	public static String foldername;
	
	public WebDriver getDriverInstance() throws IOException {
		
		logger.info("Reading Config File data");
		
		prop = new Properties();
		
		String configfile = "./src/main/resources/config/config.properties";
		File config = new File(configfile);
		FileInputStream inStream = new FileInputStream(config);
		
		prop.load(inStream);
		
		browserType = prop.getProperty("browser");
		
		logger.info("Browser Type ---->"+ browserType);
		
		foldername =prop.getProperty("screenshotfolder");
		
		logger.info("Screenshot Capture Folder --->"+ foldername);
		
		//System.out.println("Content of File---->" + inStream.toString());
		
		if(browserType.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriver"));
			driver = new FirefoxDriver();
			
		}else if(browserType.equalsIgnoreCase("edge"))
		{
			//System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgedriver"));
			driver = new EdgeDriver();
		}
		else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
		logger.info("Started Browser"+ browserType);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		logger.info("URL Opened --->"+ prop.getProperty("url"));
		
		return driver;
		
	}
	
	
	

}
