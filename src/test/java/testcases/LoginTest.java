package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	static final Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	private WebDriver dr;
	
	private TestBase tb;
	private LoginPage lp;
	private DashboardPage dp;
 
	
	
  @Test(priority=1, description="Login is Successful")
  public void TC001_LoginSuccessful() {
	  
	  TestUtilities.attachScreenshot(dr);
	  
	  logger.info("Start Test - Login Successfull");
	  
	  //lp.loginToApplication("Admin", "admin123");
	  
	  lp.loginToApplication(tb.prop.getProperty("user"),tb.prop.getProperty("pass"));
	  TestUtilities.attachScreenshot(dr);
	  
	  boolean act = dp.isUserDisplayed();
	  
	  logger.info("Login Status:" + act);
	  
	  Assert.assertEquals(act, true);
  }
  
  /*
  
  @Test(priority=2)
  public void TC002_LoginUnsuccessful()
  {
	  logger.info("Star Test - Login Unsuccessfull");
	  
	  lp.loginToApplication("Admin", "admin1234");
	  
	  boolean act = dp.isUserDisplayed();
	  
	  logger.info("login status: "+ act);
	  
	  Assert.assertEquals(act,false );
	  
  }
  */
  
  @Test(priority=2, description="Login is UnSuccessful")
  public void TC002_LoginUnsuccessful()
  {
	  TestUtilities.attachScreenshot(dr);
	  logger.info("Star Test - Login Unsuccessfull");
	  
	 // lp.loginToApplication("Admin", "admin1234");
	  
	  lp.loginToApplication(tb.prop.getProperty("user"),tb.prop.getProperty("wpass"));
	  
	  boolean act = lp.isErrorDisplayed();
	  
	  TestUtilities.attachScreenshot(dr);
	  
	  logger.info("login status: "+ act);
	  
	  Assert.assertEquals(act,true );
	  
  }
  
  
  
  
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException {
	  
	  logger.info("Before Methods");
	  
	  tb = new TestBase();
	  dr = tb.getDriverInstance();
	  
	  lp = new LoginPage(dr);
	  
	  dp = new DashboardPage(dr);
	  
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  
	  logger.info("After Methods ---- Quiting Browser");
	  
	  dr.quit();
	  
  }

}
