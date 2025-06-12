package Automation.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.FrameworkDesign.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver ;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	 
	 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement> products;
    @FindBy(css=".ng-animating")
    WebElement spiner;
    @FindBy(css="[routerlink*='cart']")
    WebElement cartClick;
    By productBy = By.cssSelector(".mb-3");
    By toasMessage = By.cssSelector("#toast-container");
    By addTocart = By.cssSelector(".card-body button:last-of-type");
    
    
 public List<WebElement> getProductList() {
	 waitforElementTOAppear(productBy);
	 return products;
	 
 }
 
 public WebElement getproductByName(String productName) {
	 
	     WebElement prod = getProductList().stream().filter(product -> 
	     product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	     return prod;
 }
 
 public void addProductTOCart(String productName) throws InterruptedException {
	      WebElement prod = getproductByName(productName);
	      prod.findElement(addTocart).click();
	      Thread.sleep(4000);
	    //  waitforElementTOAppear(toasMessage);
	      waitforElementTODisappear(spiner);
	      
 }
 

 
}
