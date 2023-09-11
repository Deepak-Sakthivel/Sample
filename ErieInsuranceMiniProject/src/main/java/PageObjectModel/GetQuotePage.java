package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetQuotePage {
	
	WebDriver driver;
	
	public GetQuotePage(WebDriver driver)	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='cta__btn']/*[text()='Get a Quote'] | //div[@class='cta__btn']/*[text()='Request a Quote']")
	WebElement getQuoteBtn;
	
	public void getQuote()
	{
		getQuoteBtn.click();
	}
	

}
