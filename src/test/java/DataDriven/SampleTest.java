package DataDriven;

import java.util.ArrayList;

public class SampleTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DataDrivenTest d = new DataDrivenTest();
		 ArrayList<String> data = d.getData("Login page");
		 System.out.println(data.get(0));
		 System.out.println(data.get(1));
		 System.out.println(data.get(2));
		

	}

}
