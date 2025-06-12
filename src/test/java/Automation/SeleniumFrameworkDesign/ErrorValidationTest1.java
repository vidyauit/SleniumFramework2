package Automation.SeleniumFrameworkDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.TestComponent.BaseTest;

public class ErrorValidationTest1 extends BaseTest{
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

}
