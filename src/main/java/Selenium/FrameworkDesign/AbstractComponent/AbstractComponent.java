package Selenium.FrameworkDesign.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.SeleniumFrameworkDesign.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(css="[routerlink*='cart']")
    WebElement goToCart;

	public void waitforElementTOAppear(By findBy) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	  	
		
	}
	
	public void waitforElementTOAppear(WebElement elem) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.visibilityOf(elem));
		
	}

	public void waitforElementTODisappear(WebElement ele) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	 public CartPage goToCartPage() throws InterruptedException {
		 JavascriptExecutor js  = (JavascriptExecutor)driver;
  		 js.executeScript("arguments[0].click();",goToCart);
  		Thread.sleep(4000);
		 //goToCart.click();
		 CartPage cartpage = new CartPage(driver);
		 return cartpage;
		 
	 }
}
