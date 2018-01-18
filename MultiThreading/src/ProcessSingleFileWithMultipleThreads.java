//Design and implement a multi-threaded application that finds the occurrence(s) of a string in a text file of 100GB. It should return the line-number(s) in which the match(es) is/are found. 

//Need not worry about the system constraints in spawning and running threads. There is a 32 core CPU with immense power. Huge amount of RAM. 

//The result should be returned in few sec.




import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProcessSingleFileWithMultipleThreads implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        //return the thread name executing this callable task
        return 5;
    }
    
    public static void main(String args[]){
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        //Create MyCallable instance
        Callable<Integer> callable = new ProcessSingleFileWithMultipleThreads();
        for(int i=0; i< 100; i++){
            //submit Callable tasks to be executed by thread pool
            Future<Integer> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        for(Future<Integer> fut : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "::"+fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }

}