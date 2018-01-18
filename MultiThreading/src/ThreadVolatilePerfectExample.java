public class ThreadVolatilePerfectExample{
	
	private volatile boolean running = true;
	
	
	class MyThread1 extends Thread{
		
		public void run(){
			int i =0;
			while(running){
				System.out.println("Running"+ i++);
			}
			System.out.println("Thread 1 is interrupted");
		}
	}
	
	class MyThread2 extends Thread{
		public void run(){
			running = false;
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		ThreadVolatilePerfectExample threadVolatilePerfectExample = new ThreadVolatilePerfectExample();
		ThreadVolatilePerfectExample.MyThread1 t1 = threadVolatilePerfectExample.new MyThread1();
		ThreadVolatilePerfectExample.MyThread2 t2 = threadVolatilePerfectExample.new MyThread2();
		t1.start();
		t2.start();
		
	}

}
