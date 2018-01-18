public class ProducerConsumer {
	
	private static final int BUFFER_SIZE = 100;
	private static final int PROCESS_SIZE = 1000000;
	private static final int DIFF = 19;
	
	private static Object lock = new Object();
	
	private static int[] buffer;
	private static int count;
	
	static class Producer {
		void produce() throws InterruptedException {
			synchronized(lock) {
				if(isFull(buffer)) {
					lock.wait();
				}
				buffer[count++] = 1;
				lock.notify();
			}
		}
	}
	
	static class Consumer {
		void consume() throws InterruptedException {
			synchronized(lock) {
				if(isEmpty(buffer)) {
					lock.wait();
				}
				buffer[--count] = 0;
				lock.notify();
			}
		}
	}
	
	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}
	
	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}
	
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[BUFFER_SIZE];
		count = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable produceTask = () -> {
			for(int i = 0; i < PROCESS_SIZE; i++)
				try {
					producer.produce();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			System.out.println("Done producing");
		};
		
		Runnable consumeTask = () -> {
			for(int i = 0; i < PROCESS_SIZE-DIFF; i++)
				try {
					consumer.consume();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			System.out.println("Done consuming");
		};
		
		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);
		
		consumerThread.start();
		producerThread.start();
		
		consumerThread.join();
		producerThread.join();
		
		System.out.println("Data in the buffer: " + count);
	}

}