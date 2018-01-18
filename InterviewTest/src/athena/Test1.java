package athena;

public class Test1 {
	
	static boolean isValidTriangle(int a, int b, int c){
		 
		int longestSide = a;
		if (b > longestSide )
		    longestSide = b;
		if(c > longestSide )
		    longestSide = c;
		return (longestSide < a + b + c - longestSide);
		
	}
	static String[] triangleOrNot(int[] a, int[] b, int[] c) {
		String[] result = new String[a.length];
		
		for(int i=0; i<a.length; i++){
			if(isValidTriangle(a[i], b[i], c[i])){
				result[i] = "Yes";
			}
			else{
				result[i] = "No";
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		
		
	}	

}
