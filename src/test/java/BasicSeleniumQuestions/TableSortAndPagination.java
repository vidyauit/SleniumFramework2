package BasicSeleniumQuestions;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableSortAndPagination {
	WebDriver driver;
	
	@Test
	public void sortTableTest() {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
		 //click into the coulnm
		 driver.findElement(By.xpath("//tr/th[1]")).click();
		//Capture all element into the list
		 List<String> price;
		 do

		 {
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		//capture all the webelements into the new (Orinal)list 
		List<String> orgList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort the original list into sorted list
		List<String> sortedList= orgList.stream().sorted().collect(Collectors.toList());
		//compare original lsit vs sortedlist
		Assert.assertTrue(orgList.equals(sortedList));
		//Scan the name column with getText->Beans-> print the price of Beans
		/*List<String> price = elementList.stream().filter(s->s.getText().contains("Beans"))
		.map(s->getVeggiesPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		*/
		
		//Scan the name column with getText->Rice-> print the price of Rice
				price = elementList.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getVeggiesPrice(s)).collect(Collectors.toList());
				price.forEach(s->System.out.println(s));
				if(price.size()<1) {
					driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}
		 }while(price.size()<1);
		 
	}

	private static String getVeggiesPrice(WebElement s) {

         String vegiprice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
         
		 return vegiprice;
	}

    @Test
	public void searchItem() {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		 driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		 List<WebElement> vegilist = driver.findElements(By.xpath("//tr/td[1]"));
		 List<WebElement> listofele = vegilist.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
	     Assert.assertEquals(vegilist.size(), listofele.size());
	
	}
	

	}

