

import java.util.concurrent.SynchronousQueue;

/**
 * 
 * @author anirudh
 *
 */
public class QueueConsumer implements Runnable {

	private SynchronousQueue queue;

	public QueueConsumer(SynchronousQueue queue) {
		this.queue=queue;
	}

	@Override
	public void run() {
		try {
			//String event = (String) queue.take();
			// thread will block here
			System.out.printf("[%s] consumed event : %s %n", Thread
					.currentThread().getName(), null);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
}
