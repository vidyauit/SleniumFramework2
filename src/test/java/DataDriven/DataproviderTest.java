package DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {

	@Test(dataProvider = "driveTest")
	public void getdata(String greeting,String message,int i) {
		System.out.println(greeting +message+i );
		
	}
	
	@DataProvider(name="driveTest")
	public Object[][] setdata() {
		Object[][] data = {{"Hello","text",1},{"Bye","message",123},{"goodBye","cell",2341}};
		return data;
		
	}
}
