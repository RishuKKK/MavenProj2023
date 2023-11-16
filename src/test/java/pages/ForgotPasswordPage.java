package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ForgotPasswordPage {
	
	static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class.getName());
	
	private WebDriver d;
	
	public ForgotPasswordPage(WebDriver dr)
	{
		logger.info("Forgot Password Page");
		
		this.d = dr;
		
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="[name='username']")
	private WebElement username;
	
	@FindBy(css="button[class*='cancel']")
	private WebElement cancel;
	
	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	
	public void clickOncancel()
	{
		cancel.click();
	}
	
	

}
