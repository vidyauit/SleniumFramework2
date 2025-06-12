package BasicSeleniumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreems {
	
	    @Test(priority = 1)
		public void regular() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("Alekhya");
			list.add("Aman");
			list.add("Shubhi");
			list.add("Abhaya");
			int count =0;
			for(int i=0;i<list.size();i++) {
				String actual =list.get(i);
				if(actual.startsWith("A")) {
					count++;
				}
				
			}
			System.out.println("total name start with A is : "+count );
		}
	    
	    @Test(priority = 2)
	    public void streamfilter() {
	    	ArrayList<String> list = new ArrayList<String>();
			list.add("Alekhya");
			list.add("Aman");
			list.add("Shubhi");
			list.add("Abhaya");
			list.add("Done");
			long c = list.stream().filter(s->s.startsWith("A")).count();
			System.out.println(c);
			
			list.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
			System.out.println("-------------------");
			list.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	    }
	    
	    @Test(priority = 3)
	    public void hashmap() {
	    	System.out.println("---------------");
	    	Stream.of("Alekhya","Aman","Abhaya","Done").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
	    	.forEach(s->System.out.println(s));
	    	
	    	//convert array to arraylist list
	    	System.out.println("-----------------");
	    	List<String> name = Arrays.asList("Alekhya","Aman","Abhaya","Done");
	    	name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase())
	    	.forEach(s->System.out.println(s));
	    	
	    	//concatinate two list using stresm
	    	List<String> name1 = Arrays.asList("Shonam","Neha","Test");
	    	Stream<String> newStram = Stream.concat(name.stream(), name1.stream());
	    	//newStram.sorted().forEach(s->System.out.println(s));
	    	boolean flag = newStram.anyMatch(s->s.equalsIgnoreCase("Done"));
	    	Assert.assertTrue(flag);
	    	System.out.println(flag);

}
	    
	    @Test(priority = 4)
	    public void collect() {
	    	List<Integer> values = Arrays.asList(2,3,6,7,9,1,5,6);
	    	//print unique number of this array
	    	//sort the array
	    	//values.stream().distinct().forEach(s->System.out.println(s));
	    	//values.stream().sorted().forEach(s->System.out.println(s));
	    	List<Integer> ls = values.stream().distinct().sorted().collect(Collectors.toList());
	    	System.out.println(ls.get(5));
	    }
}
