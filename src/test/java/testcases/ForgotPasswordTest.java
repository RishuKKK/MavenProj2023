package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ForgotPasswordTest {
	
static final Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	private WebDriver dr;
	
	private TestBase tb;
	private LoginPage lp;
	private ForgotPasswordPage fgp;
	
 
  @Test(enabled = false, description="Verify Forgot Password Cancel")
  public void TC004_ForgotPasswordCancel()
  {
	  TestUtilities.attachScreenshot(dr);
	  lp.clickOnForgotPassword();
	  TestUtilities.attachScreenshot(dr);
	  fgp.enterUsername(tb.prop.getProperty("user"));
	  fgp.clickOncancel();
	  TestUtilities.attachScreenshot(dr);
	  boolean act = lp.isLoginPageDisplayed();
	  Assert.assertEquals(act, true);
	  
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  logger.info("Before Methods");
	  
	  tb = new TestBase();
	  dr = tb.getDriverInstance();
	  lp = new LoginPage(dr);
	  fgp = new ForgotPasswordPage(dr);;
  }

  @AfterClass
  public void afterClass() {
	  
	  dr.quit();
  }

}
