import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{

	private BlockingQueue queue;
	
	public Producer(BlockingQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		// TODO Auto-generated method stub
		
	}
	
}

class Consumer implements Runnable{
    
	private BlockingQueue queue;
	
	public Consumer(BlockingQueue queue){
		this.queue = queue;
	}
	@Override
	public void run() {try {
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }}
	
}

public class BlockingQueueExample {
	
	
	
	
	public static void main(String[] args) throws Exception {
		BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
	}
	
}
