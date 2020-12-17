package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Utils.*;

public class BaseClass extends BaseUi {
public static WebDriver driver;
	@BeforeSuite
	public void openWebsite()
	{
		
		
		driver = driverInitialize("Chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	
	@AfterSuite
	public void exitBrowser()
	{
		quitBrowser();
	}

}
