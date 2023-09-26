package PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='sic__spotlight sic__spotlight--4']/div[@class='sic__panel-group ']")
	List<WebElement> insuranceType;
	
	@FindBy(xpath = "//div[@class='cta__btn']/*[text()='Get a Quote'] | //div[@class='cta__btn']/*[text()='Request a Quote']")
	WebElement getQuoteBtn;
	
	public void launchApplication()
	{
		driver.get("https://www.erieinsurance.com/");
	}
	
	public GetQuotePage selectInsuranceType(String typeOfInsurance)
	{
		for(WebElement type : insuranceType)
		{
			type.getText().contains(typeOfInsurance);
			type.click();	
			break;
		}
				
		/*
		 * for(int i=0;i<insuranceType.size();i++) 
		 * { 
		 * WebElement type = insuranceType.get(i); 
		 * 	if(type.getText().contains(typeOfInsurance)) 
		 * 	{
		 * 	type.click(); 
		 * 	}
		 * }
		 */
		
		GetQuotePage g = new GetQuotePage(driver);
		return g;
	}
	
	public void quoteBtnVisibility()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getQuoteBtn));
	}

}
