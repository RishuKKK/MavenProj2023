package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtilities;

public class DashboardPage {
	
	private WebDriver dr;
	
	public DashboardPage(WebDriver driver)
	{
		this.dr = driver;
		
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(className ="oxd-userdropdown-name")
	private WebElement user;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInfotab;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement admin;
	
	public void clickOnMyInfoTab()
	{
		myInfotab.click();
	}
	
	public void clickOnAdmin()
	{
		admin.click();
	}
	
	public boolean isUserDisplayed()
	{
		boolean b = false;
		try
		{
			b = user.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}
	
	public void logout()
	{
		user.click();
		TestUtilities.waitForElementToClickable(dr, logout);
		logout.click();
	}

}
