package BasicSeleniumQuestions;

import java.net.http.WebSocket;
import java.sql.DriverManager;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountsTotalLinks {

	@Test
	public void countTotalLink()throws InterruptedException {
		// TODO Auto-generated method stub
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("Total Link :" +links.size());
	    WebElement footDriver = driver.findElement(By.id("gf-BIG"));
	    List<WebElement> footerlink = footDriver.findElements(By.tagName("a"));
	    
	    System.out.println("FooterLinks : " +footerlink.size());
	    
	    WebElement subfooterdriver = footDriver.findElement(By.xpath("(//div[@id='gf-BIG']/table/tbody/tr/td)[1]"));
	    List<WebElement> subFotterLink = subfooterdriver.findElements(By.tagName("a"));
	    System.out.println("SubFooterLink :" +subFotterLink.size());
	    //click on each link and check if page is opening or not
	    for(int i=1;i<subfooterdriver.findElements(By.tagName("a")).size();i++) {
	    	String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	    	subfooterdriver.findElement(By.tagName("a")).sendKeys(clickOnLinkTab);
	    	Thread.sleep(5000);
	    Set<String> windows = driver.getWindowHandles();	
	    System.out.println("Size "+ windows.size());
	    
	    }
	    


	}
	

}
