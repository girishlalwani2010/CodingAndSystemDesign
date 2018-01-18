package goldmannsachs;
import java.util.ArrayList;
import java.util.List;

public class ReplaceFromString {
	
	static String[] removeElements(String[] inputArray,String characterNeedsToRemove){
		for(int i=0; i<inputArray.length; i++){
			if(inputArray[i]!=null && inputArray[i].equals(characterNeedsToRemove))
			inputArray[i] = null;
		}
		return inputArray;
	}
	
	static String[] getShrunkArray(String[] inputArray, int burstLength) {
		
		int[] count = new int[256];
		for(int i=0; i<inputArray.length; i++){
			if(inputArray[i]!=null){
				count[inputArray[i].charAt(0)]++;
				if(count[inputArray[i].charAt(0)] == burstLength){
					inputArray = removeElements(inputArray,inputArray[i]);
				}
			}
			
		}
		
		List<String> outputList = new ArrayList<String>();
		
		for(String str : inputArray){
			if(str!=null){
				outputList.add(str);
			}
		}
		
		return (String[]) outputList.toArray(new String[outputList.size()]);

    }
	
	public static void main(String[] args) {
		//String[] inputArray = {"a","b","c","d","e","e","e","e","d","d","c","b","f"," ","g","f"}; 
		String[] inputArray = {"a","b","c","d"};
		inputArray = getShrunkArray(inputArray, 3);
		for(String str : inputArray){
			System.out.println(str);
		}
	}
}
