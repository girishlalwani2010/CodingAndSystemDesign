package athena;

public class Test2 {
	
	
	static String winner(int[] andrea, int[] maria, String s) {
		
		int sumAndrea = 0;
		int sumMaria = 0;
		
		int i=0;
		if(s.equals("Odd")){
			i=1;
		}
		
		while(i<andrea.length){
			sumAndrea = sumAndrea + (andrea[i] - maria[i]);
			sumMaria = sumMaria + (maria[i] - andrea[i]);
			i=i+2;
		}
		
		if(sumAndrea>sumMaria){
			return "Andrea";
		}
		else if(sumMaria>sumAndrea){
			return "Maria";
		}
		else{
			return "Tie";
		}

    }
	
	public static void main(String[] args) {
		
	}

}
