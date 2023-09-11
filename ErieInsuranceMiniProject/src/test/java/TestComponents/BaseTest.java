package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage l;
	
	public WebDriver driverInitialize() throws IOException
	{
		String GlobalDataFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\ErieInsurance\\Resources\\GlobalData.properties";

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(GlobalDataFilePath);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("CHROME"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DeepakSakthivel\\FirstProject\\chromedriver-win64\\chromedriver.exe");			
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		}
		else if(browserName.contains("EDGE"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.contains("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	
@BeforeMethod(alwaysRun = true)
public LandingPage getStart() throws IOException
{
	driver = driverInitialize();
	l = new LandingPage(driver);
	l.launchApplication();
	return l;
}

@AfterMethod(alwaysRun = true)
public void tearDown()
{
	driver.quit();
}

}
