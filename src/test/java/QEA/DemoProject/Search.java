package QEA.DemoProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import Utils.BaseUi;
public class Search extends BaseUi {
public static void find() throws InterruptedException
{

	// driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("tv");
	driver.findElement(By.xpath(config.getProperty("searchBox"))).sendKeys("tv");
	// driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
	driver.findElement(By.xpath(config.getProperty("clickEnter"))).click();
	Thread.sleep(5000);
	Select drp = new Select(driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]")));

	drp.selectByIndex(1);
	Thread.sleep(5000);
	// String lowestName=driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")).getText();
	String lowestName = driver.findElement(By.xpath(config.getProperty("lowestName"))).getText();
	System.out.println("Name  : \n" + lowestName);
	
	// lowestPrice=driver.findElement(By.xpath("//span[@class=\"a-price-whole\"]")).getText();
	
	//String parentWindow=driver.getWindowHandle();
	driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a")).click();
	//List<String> s= new ArrayList<String>(4); 
	//s=(List<String>) driver.getWindowHandles();
	Set<String> s= driver.getWindowHandles();
	List<String> wh = new ArrayList<String>();
	wh.addAll(s);
	driver.switchTo().window(wh.get(2));
	Thread.sleep(5000);
	System.out.println("In second Window");
	String lowestPrice = driver.findElement(By.xpath(config.getProperty("lowestPrice"))).getText();
	System.out.println("Price: \n" + lowestPrice.substring(2));
	// driver.quit();	
}
}
