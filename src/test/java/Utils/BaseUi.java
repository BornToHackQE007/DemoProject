package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseUi {
	public static WebDriver driver;
	public static Properties config = new Properties();
public BaseUi()
{
	

	
	FileReader reader = null;
	String path = System.getProperty("user.dir") + "/Config.properties";

	try {
		reader = new FileReader(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		config.load(reader);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static WebDriver driverInitialize(String browser) {
		// System.out.println("Enter browser name from available options: \n1.
		// Chrome\n2. Firefox\n3. Opera");
		System.out.println("Browser selected: " + browser);
		//System.out.println("\nTo change browser selection Go-To README File");
		// If browser entered is chrome, open chrome browser
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		// If browser entered is firefox, open firefox browser
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			 driver=new FirefoxDriver();

			// driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("opera")) {
			// set system property, so that we can access opera driver
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver.exe");

			// it will open the opera browser
			driver = new OperaDriver();

		}

		// Maximize window
		driver.manage().window().maximize();
		
		return driver;
	}
	public void quitBrowser() {
		driver.quit();
	}
	
	}
	

