

import java.util.concurrent.SynchronousQueue;

/**
 * 
 * @author anirudh
 *
 */
public class JavaSynchronousQueueExample {

	public static void main(String args[]) {
		final SynchronousQueue queue = new SynchronousQueue();
		
		// start publisher thread
		new Thread(new QueueProducer(queue)).start();
		
		// start consumer thread
		new Thread(new QueueConsumer(queue)).start();
	
	}

}