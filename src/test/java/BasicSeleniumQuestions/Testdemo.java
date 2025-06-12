package BasicSeleniumQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Testdemo {

	@Test
	public void demo() {
		
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		act.doubleClick();
		act.contextClick();
		driver.get("");
		
		driver.switchTo().window("");
		driver.navigate().to("");
		

	}

}
