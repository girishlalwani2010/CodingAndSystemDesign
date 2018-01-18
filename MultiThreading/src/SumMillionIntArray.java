import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumMillionIntArray {

	public static void main(String[] args) {
		int cpus = Runtime.getRuntime().availableProcessors();
		System.out.println(cpus);
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		int[] intArray = new int[10000];
		for(int i=0; i<10000; i++){
			intArray[i] = i;
		}
		List<Future<Integer>> tasks = new ArrayList<>();
		int blockSize = (intArray.length + cpus - 1) / cpus;
		int start1 =0;
		for (int i=0;start1<intArray.length;i++) {
		    final int start = blockSize * i;
		    start1 = start;
		    final int end = Math.min(blockSize * (i+1), intArray.length);
		    tasks.add(service.submit(new Callable<Integer>() {
		        public Integer call() {
		            int d= 0;
		            for(int j=start;j<end;j++)
		                d += intArray[j];
		            return d;
		        }
		     }));
		}
		double sum = 0;
		for(Future<Integer> task: tasks){
			try {
				sum += task.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sum);
	}
	
}
