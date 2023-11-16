package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
static final Logger logger = LogManager.getLogger(AdminPage.class.getName());
	
	private WebDriver d;
	
	public AdminPage(WebDriver dr)
	{
		logger.info("Admin Page");
		
		this.d = dr;
		
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="div[class='oxd-table']>div[class='oxd-table-body']>div>div")
	private List<WebElement> row;
	
	@FindBy(css="div[class='oxd-table']>div[class='oxd-table-body']>div:nth-child(1)>div>div")
	private List<WebElement> col;
	
	public boolean getTheUser(String str,String roleExp)
	{
		boolean b =  false;
		
		try {
			
			for(int i=1; i<row.size()-1;i++)
			{
				String s = d.findElement(By.cssSelector("div[class='oxd-table']>div[class='oxd-table-body']>div[class='oxd-table-card']:nth-child(2)>div>div:nth-child("+i+")>div")).getText(); 
				logger.info(str+ "-->"+ s);
				if(s.equalsIgnoreCase(str))
				{
					//b = true;
					logger.info("Found--->"+s);
					String role = d.findElement(By.cssSelector("div[class='oxd-table']>div[class='oxd-table-body']>div[class='oxd-table-card']:nth-child("+i+")>div>div:nth-child(3)>div")).getText();
					
					logger.info("Found--->"+role);
					if(role.equalsIgnoreCase(roleExp))
					{
						logger.info("User Found--->"+s+" and "+"Role--->"+role);
						b=true;
						break;
					}
					
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}
	

}
