package BasicSeleniumQuestions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	WebDriver driver;
	
	//@Test
	public void getallBrokenLinks() throws MalformedURLException, IOException {
		//open application and find all links
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
         String  url   = driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
         HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
         connection.getRequestMethod();
         connection.connect();
         int statuscode = connection.getResponseCode();
         System.out.println(statuscode);
         
     
	}
	
	@Test
	public void getallBrokenLinks1() throws MalformedURLException, IOException {
		//open application and find all links
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'
		
		List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

	      SoftAssert a =new SoftAssert();

	     

	      for(WebElement link : links)

	      {

	       

	          String url= link.getAttribute("href");
	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println(respCode);

	          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

	         
	
         }
	      a.assertAll();
         
		}
	}
	
	

