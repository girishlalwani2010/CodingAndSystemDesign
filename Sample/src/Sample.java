import java.util.ArrayList;
import java.util.List;

public class Sample {

	public static void main(String args[]){
		 String str1 = "hello";
		 String str2 = "world";
		String str3 = (str1+str2);
		
		String str4 = "helloworld";
		System.out.println(((Object)str4).hashCode());
		System.out.println((Object)str3.hashCode());
	}
	
}
