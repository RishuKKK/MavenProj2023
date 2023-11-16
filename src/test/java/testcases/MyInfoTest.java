package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoTabPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class MyInfoTest {
	
	private WebDriver dr;
	
	private TestBase tb;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfoTabPage mip;
	
	
  @Test(priority=1, description="Verify My Info Menu Count", dependsOnMethods="TC006_VerifyTheMenuItemTextOnMyInfo")
  public void TC005_VerifyTheMenuItemCountOnMyInfo() {
	  dp.clickOnMyInfoTab();
	  int act = mip.getMyInfoCount();
	  Assert.assertEquals(act, 11);
	  
  }
  
  @Test(priority=2, description="Verify My Info Menu Text Items")
  public void TC006_VerifyTheMenuItemTextOnMyInfo()
  {
	  TestUtilities.attachScreenshot(dr);
	  dp.clickOnMyInfoTab();
	  List<String> act = mip.getMyInfoMenuStringList();
	  
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("-Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("-Immigration");
	  exp.add("Job");
	  exp.add("Salary--");
	  exp.add("Tax Exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Memberships");
	  
	//Assert.assertEquals(act, exp);   ---- Hard Assertion
	  
	  int count =0;
	  
	  SoftAssert sa = new SoftAssert();
	  
	  for(String a:exp)
	  {
		  sa.assertEquals(a, act.get(count));
		  count++;
	  }
	  
	  Reporter.log("Actual-->"+act);
	  Reporter.log("Expected-->"+exp);
	  
	  sa.assertAll();
	  
  }
  
  
  @BeforeClass
  public void beforeClass() throws IOException {
	  	tb = new TestBase();
	  	dr = tb.getDriverInstance();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		mip = new MyInfoTabPage(dr);
		
		TestUtilities.attachScreenshot(dr);
		
		lp.loginToApplication(tb.prop.getProperty("user"),tb.prop.getProperty("pass"));
		
		//Assert.assertEquals(dp.isUserDisplayed(), true);
		Assert.assertTrue(dp.isUserDisplayed());
		
		TestUtilities.attachScreenshot(dr);
		
  }

  @AfterClass
  public void afterClass() {
	  
	  dp.logout();
	  dr.quit();
  }

}
