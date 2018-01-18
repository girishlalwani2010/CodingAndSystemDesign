package goldmannsachs;


public class getCountOfPossibleTeams {
	static int getCountOfPossibleTeams(int[] coders){
			int len = coders.length;
			
			int count = 0;
			for (int i=0 ; i< len-1; i++)
	        {
	            // count all smaller elements on right of arr[i]
	            int small=0;
	            for (int j=i+1; j<len; j++){
	             if(coders[i] > coders[j])
	                small++;
	            }    
	            
	            int great = 0;
	            for (int j=i-1; j>=0; j--){
	              if(coders[i] < coders[j])
	                 great++;
	              
	            }
	            count += great*small;
	            small=0;
	            for (int j=i+1; j<len; j++){
	                if(coders[i] < coders[j])
	                    small++;
	            }      
	            
	            great = 0;
	            for (int j=i-1; j>=0; j--){
	            	if(coders[i] > coders[j])
	                    great++;  
	            }
	            
	            count += great*small;
	        }
			return count;
		}
	
	private static int check(int coders[]){
		int len = coders.length;
		int count = 0;
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len; j++){
				for(int k=j+1;k<len; k++){
					if((coders[i]<coders[j] && coders[j]<coders[k]) || (coders[i]>coders[j]&&coders[j]>coders[k]))
						count++;
				}					
			}
		}
		
		return count;
	}

		
		public static void main(String[] args) {
			int order[] = {5,2,3,1,4,7};
			System.out.println(getCountOfPossibleTeams(order));
			
	
		}
}