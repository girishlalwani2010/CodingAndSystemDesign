import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(3);
		intList.add(2);
		intList.add(4);
		
		for(int i=0; i<intList.size(); i++){
			intList.remove(i);
		}
		
		System.out.println(intList);
		
	}
	
	
}
