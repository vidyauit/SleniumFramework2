package Automation.SeleniumFrameworkDesign;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String arg[]) throws Exception {
	  String productname = "ZARA COAT 3";
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://rahulshettyacademy.com/client");
      driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("shubhi@example.com");
      driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Test@123");
      driver.findElement(By.id("login")).click();
      List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
      WebElement prod = products.stream().filter(product -> 
      product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
      prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//ng-animating
	 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
      driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
      List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
      Boolean match = cartproducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productname));
      Assert.assertTrue(match);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='totalRow']/button")));
      Thread.sleep(10);
    
		
       WebElement scanEle = driver.findElement(By.xpath("//li[@class='totalRow']/button"));
       JavascriptExecutor js  = (JavascriptExecutor)driver;
     		js.executeScript("arguments[0].click();",scanEle);
       
      // driver.findElement(By.cssSelector(".totalRow button")).click();
     		 Thread.sleep(20);
     	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
       Actions a = new Actions(driver);
       wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
      // a.moveToElement(scanEle).click().build().perform();
       //WebElement country = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
       //js.executeScript("arguments[0].setAttribute('value','India')", country);
      // js.executeScript("document.getElementByxpath(//input[@placeholder='Select Country']).value='India';");
  	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
  
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
  	
  	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
  	WebElement placorder = driver.findElement(By.xpath("//a[text()='Place Order ']"));
  	
  	a.moveToElement(placorder).click().build().perform();
  	//driver.findElement(By.cssSelector(".action__submit")).click();
  	
  	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
  	System.out.println(confirmMessage);
  	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
  	System.out.println("Order completed");
  	 driver.quit();
  	

     
    
	}

}
