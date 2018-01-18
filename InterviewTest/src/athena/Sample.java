package athena;
import java.util.ArrayList;
import java.util.List;

public class Sample {
	
	
	static List<String> possibleStrings = new ArrayList<String>();
	static int magicalStrings(int n) {
		char set1[] = {'a','e','i','o','u'};
		List<String> possibleCombinations = printAllKLength(set1, n);
		int count=0;
		if(n==1){
			return 5;
		}
		else{
		for(String str : possibleCombinations){
			boolean isValid = false;
			boolean istempValid = true;
			char[] charArr = str.toCharArray();
			for(int i =0; i<charArr.length-1; i++){
				if(charArr[i] == 'a' && charArr[i+1] == 'e'){
						isValid = istempValid && true;
				}
				else if(charArr[i] == 'e' && (charArr[i+1] == 'a' || charArr[i+1] == 'i')){
						isValid = istempValid && true;
				}
				else if(charArr[i] == 'i' && (charArr[i+1] == 'a' || charArr[i+1] == 'e' || charArr[i+1] == 'o' || charArr[i+1] == 'u')){
						isValid = istempValid && true;
				}
				else if(charArr[i] == 'o' && (charArr[i+1] == 'i' || charArr[i+1] == 'u')){
						isValid = istempValid && true;
				}
				else if(charArr[i] == 'u' && (charArr[i+1] == 'a')){
						isValid = istempValid && true;
				}
				else{
					istempValid = isValid && false;
					
				}
			}
			
			if(isValid && istempValid){
				count++;
			}
		}
		}
		
		
		
		return count;
		

    }
	
	
	
	
	
	
	public static void main(String[] args) {             
        int n = 2;
       System.out.println(magicalStrings(n));
         
    }    
 
    static List<String> printAllKLength(char set[], int k) {
        int n = set.length;        
        return printAllKLengthRec(set, "", n, k);
    }
 
    static List<String> printAllKLengthRec(char set[], String prefix, int n, int k) {
         
        if (k == 0) {
        	possibleStrings.add(prefix);
            return possibleStrings;
        }
 
        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i]; 
             
            printAllKLengthRec(set, newPrefix, n, k - 1); 
        }
		return possibleStrings;
    }

}
