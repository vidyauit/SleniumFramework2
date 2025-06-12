package Automation.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.FrameworkDesign.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver ;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	   
    @FindBy(id="userEmail")
    WebElement username;
    
    @FindBy(xpath="//input[@id='userPassword']")
    WebElement userPassword;
    
    @FindBy(id="login")
    WebElement login;
    @FindBy(css="[class*='flyInOut']")
    WebElement errmessage;
    
    
  public ProductCatalogue loginApplication(String email , String password) {
	  
	  username.sendKeys(email);
	  userPassword.sendKeys(password);
	  login.click();
	  ProductCatalogue productcatalogue= new ProductCatalogue(driver);
	  return productcatalogue;
	  
  }  
  
  public void goTo() {
	  
	  driver.get("https://rahulshettyacademy.com/client");
  }
  
  public String errorValidation() {
	  waitforElementTOAppear(errmessage);
	  String errmsg = errmessage.getText();
	  return errmsg;
	  
	  
  }
}
