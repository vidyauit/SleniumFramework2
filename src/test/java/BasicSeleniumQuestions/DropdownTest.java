package BasicSeleniumQuestions;

import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	
	 WebDriver driver ;
	@Test
	public void autoSuggestDropdown() throws Exception {
		
		//https://rahulshettyacademy.com/AutomationPractice/
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.findElement(By.xpath("//input[@id ='autocomplete']")).sendKeys("Ind");
		 Thread.sleep(5000);
		 List<WebElement> options = driver.findElements(By.xpath("//ul[@id ='ui-id-1']/li"));
		 for(WebElement option :options) {
			// System.out.println(option.getText());
			 if(option.getText().equalsIgnoreCase("India")){
				 option.click();
				 
				 break;
			 }
		 }
		
	}
	
	@Test
	public void dropdown() {
		
		WebElement option = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdown =  new Select(option);
		dropdown.selectByIndex(1);
		
	}

	@Test
	public void checkbox() {
		List<WebElement> multicheck =driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement checkbox :multicheck) {
			checkbox.click();
			if(multicheck.size()==2) {
				break;
			}
		}
	}
}
