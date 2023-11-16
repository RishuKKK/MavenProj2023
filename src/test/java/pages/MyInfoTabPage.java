package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoTabPage {

	static final Logger logger = LogManager.getLogger(MyInfoTabPage.class.getName());
	
	private WebDriver d;
	
	public MyInfoTabPage(WebDriver dr)
	{
		logger.info("My Info  Page");
		
		this.d = dr;
		
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="[role='tablist'] a")
	private List<WebElement> menu;
	
	public int getMyInfoCount()
	{
		return menu.size();
	}
	
	public List<String> getMyInfoMenuStringList()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement e:menu)
		{
			temp.add(e.getText());
		}
		
		return temp;
	}
	
}
