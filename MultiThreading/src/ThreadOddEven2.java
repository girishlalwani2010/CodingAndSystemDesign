
class MyRunnable implements Runnable{

	private Object object = new Object();
	private int i =1;
		@Override
		public void run() {
				synchronized (object) {
					while(i<=50){
						System.out.println(Thread.currentThread().getName() +": "+ i);
						object.notify();
						i++;
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}
	}


public class ThreadOddEven2{
	
	public static void main(String[] args) throws InterruptedException {
		
		MyRunnable myRunnable = new MyRunnable();
		
		Thread odd = new Thread(myRunnable,"odd");
		Thread even = new Thread(myRunnable,"even");
		
		odd.start();
		even.start();
		
	}

}
