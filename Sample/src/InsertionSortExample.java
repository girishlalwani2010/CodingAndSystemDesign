import java.util.Arrays;

public class InsertionSortExample {

	public void insert(int lastIndex, int targetValue, int[] array){
		
		int[] tempArray = new int[array.length];
		int j=0,i;
		for(i=lastIndex; i>=0; i--){
			if(targetValue>=array[i]){
				array[i+1] = targetValue;
				break;
			}
			else{
				tempArray[j] = array[i];
				j++;
			}
		}
		int l=0;
		array = Arrays.copyOf(array,array.length+1);
		tempArray = Arrays.copyOf(tempArray, i+1);
		for(int k=0; k<tempArray.length; k++){
			
			array[lastIndex+1-k] = tempArray[l];
			l++;
		}
		
		
	}
	
	public void insertSort(int[] array){
			insert(3,4,array);
	}
	
	public static void main(String []args){
		InsertionSortExample insertionSortExample = new InsertionSortExample();
		int arr[] = {2,3,5,7};
		insertionSortExample.insertSort(arr);
	}
	
}
