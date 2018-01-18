package walmart;

public class Test {
	private int count = 0;
	private int prvAction=-1;
	private int getMinimumRestDays(int [] arr){
		for(int i=0; i<arr.length;i++){
			if(arr[i]==0){
				count++;
				prvAction=0;
			}
			else if(arr[i]==1){
				if(prvAction==1){
					count++;
				}
				prvAction=1;
			}
			else if(arr[i]==2){
				if(prvAction==2){
					count++;
				}
				prvAction=2;
			}
			else{
				if((arr[i]-prvAction) == arr[i]){
					count++;
				}
				prvAction=arr[i]-prvAction;
			}
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		//int arr[] = {2,2};
		//int arr[] = {1,3,2,0};
		//int arr[] = {1,3,3,2,1,2,3};
		//int arr[] = {3,3,3,3};
		//int arr[] = {1,2,3,3,2};
		//int arr[] = {1,2,0,2,1};
		int arr[] = {1,2,0,1,2};
		Test test = new Test();
		System.out.println(test.getMinimumRestDays(arr));
		
	}
	
}
