
public class ThreadVolatile implements Runnable{
	
	volatile int counter=1;
	
	@Override
	public void run() {
		System.out.println(counter);
		counter++;
	}

	public static void main(String[] args) {
		ThreadVolatile threadVolatile = new ThreadVolatile();
		Thread t1 = new Thread(threadVolatile);
		Thread t2 = new Thread(threadVolatile);
		Thread t3 = new Thread(threadVolatile);
		Thread t4 = new Thread(threadVolatile);
		Thread t5 = new Thread(threadVolatile);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
}
