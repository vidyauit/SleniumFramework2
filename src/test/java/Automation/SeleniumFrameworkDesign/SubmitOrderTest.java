package Automation.SeleniumFrameworkDesign;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.TestComponent.BaseTest;
import net.bytebuddy.description.type.TypeDescription.ArrayProjection;


public class SubmitOrderTest extends BaseTest {
	
//	@Test(dataProvider = "getData",groups = {"smoke"})
//	public void submitorderTest(String email ,String pass,String productname ) throws IOException, InterruptedException   {
//		
////		  String productname = "ZARA COAT 3";
////		  String email = "shubhi@example.com";
////		  String pass = "Test@123";
//		  String expected = "THANKYOU FOR THE ORDER.";
//		  ProductCatalogue productcatalogue = loginPage.loginApplication(email, pass);
//	      List<WebElement> proList = productcatalogue.getProductList();
//	      productcatalogue.addProductTOCart(productname);
//	      CartPage cartpage = productcatalogue.goToCartPage();
//	      Boolean match = cartpage.verifyProduct(productname);
//	      Assert.assertTrue(match);
//	      cartpage.goToCheckOut();
//	      CheckoutPage checkout = new CheckoutPage(driver);
//	      checkout.selectCountry("India");
//	      checkout.placeOrder();
//	      String actual = checkout.verifyConformeMessage();
//	      Assert.assertEquals(expected, actual);
//	      System.out.println("Order completed");
//	      
//		  
//		  
//	}
	
//	@Test(dataProvider = "getDatawithHashMap",groups = {"smoke"})
//	public void submitorderTest1(HashMap<String, String>input) throws IOException, InterruptedException   {
//		
////		  String productname = "ZARA COAT 3";
////		  String email = "shubhi@example.com";
////		  String pass = "Test@123";
//		  String expected = "THANKYOU FOR THE ORDER.";
//		  ProductCatalogue productcatalogue = loginPage.loginApplication(input.get("email"), input.get("pass"));
//	      List<WebElement> proList = productcatalogue.getProductList();
//	      productcatalogue.addProductTOCart(input.get("product"));
//	      CartPage cartpage = productcatalogue.goToCartPage();
//	      Boolean match = cartpage.verifyProduct(input.get("product"));
//	      Assert.assertTrue(match);
//	      cartpage.goToCheckOut();
//	      CheckoutPage checkout = new CheckoutPage(driver);
//	      checkout.selectCountry("India");
//	      checkout.placeOrder();
//	      String actual = checkout.verifyConformeMessage();
//	      Assert.assertEquals(expected, actual);
//	      System.out.println("Order completed");
//	      
//		  
//		  
//	}

	
	@Test(dataProvider = "getdataJson")
	public void submitorderTest2(HashMap<String, String>input) throws IOException, InterruptedException   {
		
		  String expected = "THANKYOU FOR THE ORDER.";
		  ProductCatalogue productcatalogue = loginPage.loginApplication(input.get("email"), input.get("pass"));
	      List<WebElement> proList = productcatalogue.getProductList();
	      productcatalogue.addProductTOCart(input.get("product"));
	      CartPage cartpage = productcatalogue.goToCartPage();
	      Boolean match = cartpage.verifyProduct(input.get("product"));
	      Assert.assertTrue(match);
	      cartpage.goToCheckOut();
	      CheckoutPage checkout = new CheckoutPage(driver);
	      checkout.selectCountry("India");
	      checkout.placeOrder();
	      String actual = checkout.verifyConformeMessage();
	      Assert.assertEquals(expected, actual);
	      System.out.println("Order completed");
	      
		  
		  
	}
	@DataProvider
	public Object[][] getDatawithHashMap() {
		HashMap<String ,String>map = new HashMap<String, String>();
		map.put("email", "shubhi@example.com");
		map.put("pass", "Test@123");
		map.put("product", "ZARA COAT 3");
		HashMap<String ,String>map1 = new HashMap<String, String>();
		map1.put("email", "shubhi@example.com");
		map1.put("pass", "Test@123");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][]  {{map},{map1}};
	}
	
	@DataProvider
	public  Object[][]  getdataJson() throws IOException {
		List<HashMap<String, String>> data = getJSONDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\Data\\purchaseOrder.JSON");
		return new Object[][]  {{data.get(0)},{data.get(1)}};
		
	}
}

