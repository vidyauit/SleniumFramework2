package Automation.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.FrameworkDesign.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver drvier) {
		super(drvier);
		this.driver = drvier;
		PageFactory.initElements(drvier, this);
		
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartproducts;
	
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkout;
	
	By waitele =By.xpath("//li[@class='totalRow']/button");
	

public Boolean verifyProduct(String productName){
	Boolean match = cartproducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
	return match;
    
}

public void goToCheckOut() throws InterruptedException {
	waitforElementTOAppear(waitele);
	Thread.sleep(3000);
	checkout.click();
	
}
}
