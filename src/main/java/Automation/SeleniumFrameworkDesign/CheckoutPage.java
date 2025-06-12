package Automation.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.FrameworkDesign.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver drvier;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.drvier = driver;
		PageFactory.initElements(driver , this);
		
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement enterconty;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selctcontry;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorder;
	@FindBy(css=".hero-primary")
	WebElement messg;
	
	
	By  result = By.cssSelector(".ta-results");

public void selectCountry(String country) {
	Actions a = new Actions(drvier);
	a.sendKeys(enterconty, country).build().perform();
	waitforElementTOAppear(result);
	selctcontry.click();
	
}
	
public void placeOrder() {
	placeorder.click();
	
}

public String verifyConformeMessage() {
	String confirmMessage = messg.getText();
	System.out.println(confirmMessage);
	return confirmMessage;
	
	
}


}
