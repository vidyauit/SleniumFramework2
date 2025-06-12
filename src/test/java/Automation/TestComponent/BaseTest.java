package Automation.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;

import Automation.SeleniumFrameworkDesign.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;

	//@BeforeSuite
	public WebDriver initializeDriver() throws IOException

	{
          
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\SeleniumFrameworkDesign\\Resource\\resource.properties");
		  prop.load(fis);
		  String browserName = prop.getProperty("browser");
		  
		  System.out.println("BrowserName : " +browserName);
		  if(browserName.equalsIgnoreCase("chrome")) {
			  
		  WebDriverManager.chromedriver().setup();
		  
		  driver  = new ChromeDriver();
		  
		  System.out.println("Driver :"+driver);
		  }
		  else if(browserName.equalsIgnoreCase("FireFoxe")) {
			  //FF
		  }
			  
		  else if(browserName.equalsIgnoreCase("edge")) {
			  //
		  }
			
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
		  return driver;

    }
	
	public List<HashMap<String,String>> getJSONDataToMap(String filepath) throws IOException {
		//read JSON to String
		   String jesoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		//String to HashMap
		  
		  ObjectMapper mapper = new ObjectMapper();
		               List<HashMap<String, String>> data = mapper.readValue(jesoncontent, new TypeReference<List<HashMap<String,String>>>() {
					});
		               return data;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File(System.getProperty("user.dir")+"//Reports//"+testCaseName +".png");
		 FileUtils.copyFile(source, dest);
		 return System.getProperty("user.dir"+"//Reports//"+testCaseName +".png");
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage lunchApplication() throws IOException {
		 driver = initializeDriver();
		 loginPage = new LoginPage(driver);
		 loginPage.goTo();
		 return loginPage;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closebrowser() {
		driver.quit();
	}
	}

    


