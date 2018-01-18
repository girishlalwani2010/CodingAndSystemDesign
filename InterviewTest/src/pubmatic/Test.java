package pubmatic;

public class Test {
	
	private static void incCountArr(String str, int[] count) {
		
	}
	private static void decCountArr(String str, int[] count) {
		for(int i=0; i<str.length();i++){
			count[str.charAt(i)-'a']--;
		}
	}
	
	
	static int[] getMinimumDifference(String[] a, String[] b) {
		int output[] = new int[a.length];
		for(int i=0; i<a.length;i++){
			if(a[i].length()!=b[i].length()){
				output[i] = -1;
				continue;
			}
			int count[] = new int[26];
			for(int k=0; k<a[i].length();k++){
				count[a[i].charAt(k)-'a']++;
			}
			for(int l=0; l<b[i].length();l++){
				if(count[b[i].charAt(l)-'a']>0)
					count[b[i].charAt(l)-'a']--;
			}
			int sum=0;
			for(int j=0; j<count.length; j++){
				sum = sum + count[j];
			}
			output[i] = sum;
		}
		
		return output;
    }

	
	
	public static void main(String[] args) {
		String[] a = {"a","jk","abb","mn","abc"};
		String b[] = {"bb","kj","bbc","op","def"};
		int output[] = getMinimumDifference(a,b);
		for(int i=0; i<output.length; i++){
			System.out.println(output[i]);
		}
	}
}
