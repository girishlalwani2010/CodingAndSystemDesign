
public class ThreadSleepExample1 implements Runnable{

	@Override
	public void run() {
		System.out.println("In Run ");
	}
		
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ThreadSleepExample1 threadSleepExample1 = new ThreadSleepExample1();
		Thread t1 = new Thread(threadSleepExample1);
		System.out.println(t1.getName());
		t1.start();
		System.out.println(t1.getName());
		try {
			t1.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End Of Main");
	}

}
