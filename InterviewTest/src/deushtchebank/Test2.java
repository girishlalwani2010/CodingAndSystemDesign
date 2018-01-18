package deushtchebank;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("AAA");
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
			list.add("BBB");
		}
	}
	
}
