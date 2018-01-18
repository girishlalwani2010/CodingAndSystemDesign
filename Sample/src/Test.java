import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	
	class Customer{
		private int age;
		private String name;
		
		public int hashCode(){
			return name.hashCode();
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	
	public static void main(String args[])
	{
		Map<Test.Customer,String> map = new HashMap<Test.Customer, String>();
		Test.Customer c1 = new Test().new Customer();
		c1.setAge(27);
		c1.setName("girish");
		map.put(c1, "hello");
		System.out.println(map.get(c1));
		c1.setName("lalwani");
		System.out.println(map.get(c1));
	}

	
	 
	
}
