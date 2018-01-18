package creditsuisse;
import java.util.Scanner;

public class Test2 {
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[] = new int[N];
        s.nextLine();
        for(int i=0; i<N; i++){
        	int queryNum = s.nextInt();
        	int index = s.nextInt();
        	if(queryNum == 1){
        		arr[index] = -1;
        	}
        	else{
        		boolean found = false;
        		
        		for(int k = index; k<arr.length; k++)
        		{
        			if(arr[k] == -1){
        				System.out.println(k);
        				found = true;
        				break;
        			}
        		}
        		if(!found){
        			System.out.println(""+-1);
        		}
        	}
        }
        
        
	}

}
