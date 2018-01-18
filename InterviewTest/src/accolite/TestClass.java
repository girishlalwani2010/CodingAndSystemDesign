package accolite;

public class TestClass {
	
	static String decode(String s){
		char[] charArray = s.toCharArray();
		StringBuilder output = new StringBuilder();
		output.append(charArray[charArray.length-1]);
		for(int i=charArray.length-2; i>=0; i--){
			if(output.length() % 2 ==0){
				output.insert(output.length()/2, charArray[i]); 
			}
			else{
				output.insert(output.length()/2, charArray[i]);
			}
		}
		return output.toString();
    }
	
	public static void main(String[] args) {
		
		String s = "wrien";
		System.out.println(decode(s));
		
	}

}

