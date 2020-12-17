package QEA.DemoProject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import Utils.*;

public class SignIn extends BaseUi {
	public static void find() throws InterruptedException {

		// driver.get("https://www.amazon.in");
		driver.get(config.getProperty("url"));
			
		// WebElement
		// signin=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		WebElement signin = driver.findElement(By.xpath(config.getProperty("signIn")));
		signin.click();
		// driver.findElement(By.name("email")).sendKeys("arijitdas.das148@gmail.com");
		driver.findElement(By.name("email")).sendKeys(config.getProperty("email"));

		driver.findElement(By.id("continue")).click();

		driver.findElement(By.name("password")).sendKeys(config.getProperty("password"));

		driver.findElement(By.id("signInSubmit")).click();

		Thread.sleep(3000);

	}
}
