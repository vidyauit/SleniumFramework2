package Automation.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder {

public static void main(String arg[]) throws InterruptedException {
	//public void submitorder() throws InterruptedException, IOException {
	  String productname = "ZARA COAT 3";
	  String email = "shubhi@example.com";
	  String pass = "Test@123";
	  String expected = "THANKYOU FOR THE ORDER.";
	  WebDriverManager.chromedriver().setup();
      WebDriver driver  = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
      LoginPage loginpage = new LoginPage(driver);
	  loginpage.goTo();
      ProductCatalogue productcatalogue = loginpage.loginApplication(email, pass);
      List<WebElement> proList = productcatalogue.getProductList();
      productcatalogue.addProductTOCart(productname);
      CartPage cartpage = productcatalogue.goToCartPage();
      Boolean match = cartpage.verifyProduct(productname);
      Assert.assertTrue(match);
      cartpage.goToCheckOut();
      CheckoutPage checkout = new CheckoutPage(driver);
      checkout.selectCountry("India");
      checkout.placeOrder();
      String actual = checkout.verifyConformeMessage();
      Assert.assertEquals(expected, actual);
      System.out.println("Order completed");
      
	}
}
	

