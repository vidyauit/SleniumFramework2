
package Automation.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.TestComponent.BaseTest;

public class ErrorValidationTest extends BaseTest{
	
	@Test(groups = {"errorHandling","smoke"})
	public void errorValidationTest() {
		 String email = "shubhi@example.com";
		  String pass = "Test@1";
		  String expectedError = "Incorrect email password.";
		  loginPage.loginApplication(email, pass);
		  String actualError = loginPage.errorValidation();
		  Assert.assertEquals(actualError, expectedError);
		  System.out.println("Error Validation Successful");
		  
		  
		  
	}
   @Test
   public void productValidation() throws InterruptedException {
	   String productname = "ZARA COAT 3";
		  String email = "shubhi@example.com";
		  String pass = "Test@123";
		  String expected = "THANKYOU FOR THE ORDER.";
		  ProductCatalogue productcatalogue = loginPage.loginApplication(email, pass);
	      List<WebElement> proList = productcatalogue.getProductList();
	      productcatalogue.addProductTOCart(productname);
	      CartPage cartpage = productcatalogue.goToCartPage();
	      Boolean match = cartpage.verifyProduct(productname);
	      Assert.assertTrue(match);
   }

}
