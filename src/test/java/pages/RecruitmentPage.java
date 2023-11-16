package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
	
static final Logger logger = LogManager.getLogger(RecruitmentPage.class.getName());
	
	private WebDriver d;
	
	public RecruitmentPage(WebDriver dr)
	{
		logger.info("Admin Page");
		
		this.d = dr;
		
		PageFactory.initElements(dr, this);
	}
	
	

}
