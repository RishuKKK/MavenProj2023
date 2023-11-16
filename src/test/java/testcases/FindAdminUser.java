package testcases;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoTabPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class FindAdminUser {
	
	private WebDriver dr;
	
	private TestBase tb;
	private LoginPage lp;
	private DashboardPage dp;
	private AdminPage ap;
	
	
	
  @Test(description="Verify Admin User is fund in the List")
  public void TC007_VerifyAdminIsInTheAdminTable() {
	 
	  String user = "Admin";
	  String role = "Admin";
	  
	  Reporter.log("Expected User : "+user);
	  Reporter.log("Expected role : "+role);
	  
	  TestUtilities.attachScreenshot(dr);
	  
	  dp.clickOnAdmin();
	  boolean act = ap.getTheUser(user, role);
	  Assert.assertEquals(act, true);
	  
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
		tb = new TestBase();
	  	dr = tb.getDriverInstance();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		ap = new AdminPage(dr);
		
		TestUtilities.attachScreenshot(dr);
		
		lp.loginToApplication(tb.prop.getProperty("user"),tb.prop.getProperty("pass"));
		
		TestUtilities.attachScreenshot(dr);
		
		//Assert.assertEquals(dp.isUserDisplayed(), true);
		Assert.assertTrue(dp.isUserDisplayed());
		
		
  }

  @AfterClass
  public void afterClass() {
	  
	  dr.quit();
  }

}
