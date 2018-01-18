package goldmannsachs;
import java.util.Stack;

public class Test {

	static int closingBracePosition(String inputSentence, int openingBraceNum) {
		Stack<Character> myStack = new Stack<Character>();
		int counter=0,closingPosition=-1;
		boolean found=true;
		char[] myArray = inputSentence.toCharArray();
				for(int i =0;i<myArray.length;i++){
				    if(myArray[i] == '('){
				      openingBraceNum--;
				      if(openingBraceNum==0)
				    	  counter++;
				      myStack.push(myArray[i]);
				    }
				    if(myArray[i] == ')'){
				    	counter--;
				    	if(!myStack.isEmpty())
				    	myStack.pop();
				      
				    }
				    
				    if(openingBraceNum==0 && counter==0 && found){
				    	closingPosition=i;
				    	found = false;
				    }
				    
				    
				}
				
				if(!myStack.isEmpty()){
					return -1;
				}
				else{
					return closingPosition+1;
				}
				

    }
	
	static int closingBracePositionNew(String inputSentence, int openingBraceNum){
		Stack<Character> myStack = new Stack<Character>();
		char[] inputSequenceArr = inputSentence.toCharArray();
		int stackSizeTillOpeningPosition=-1;
		int closingPosition = -1;
		boolean found = true;
		for(int i=0; i<inputSequenceArr.length; i++){
			if(inputSequenceArr[i] == '('){
				openingBraceNum--;
				if(openingBraceNum == 0){
					stackSizeTillOpeningPosition = myStack.size();
				}
				myStack.push('(');
			}
			if(inputSequenceArr[i] == ')'){
				myStack.pop();
				if(stackSizeTillOpeningPosition == myStack.size() && found){
					closingPosition = i+1;
					found=false;
				}
			}
		}
		
		if(myStack.isEmpty()){
			return closingPosition;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		String input = "(I want (to write a language parser), would (you) help me)";
		System.out.println(closingBracePositionNew(input,2));
	}
	
}
