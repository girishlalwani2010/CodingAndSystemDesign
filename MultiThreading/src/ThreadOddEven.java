class ObjectEvenOdd {
	
	private boolean isEven;

	public boolean isEven() {
		return isEven;
	}

	public void setEven(boolean isOdd) {
		this.isEven = isOdd;
	}
	
	
	
}


public class ThreadOddEven {
	ObjectEvenOdd objectEvenOdd = new ObjectEvenOdd();
	
	class ThreadOdd implements Runnable {

		@Override
		public void run() {
			int i = 1;
			while(i<=20){
			synchronized(objectEvenOdd){
						
							while(objectEvenOdd.isEven()){
								try {
									objectEvenOdd.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							System.out.println(i);
							i = i+2;
							objectEvenOdd.setEven(true);
							objectEvenOdd.notify();
						}
				}
			}
		}
		
	class ThreadEven implements Runnable {

		@Override
		public void run() {
			int i=2;
			while(i<=20){
				synchronized(objectEvenOdd){
					
						while(!objectEvenOdd.isEven()){
							try {
								objectEvenOdd.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println(i);
						i = i+2;
						objectEvenOdd.setEven(false);
						objectEvenOdd.notify();
				}
				}
		}
		
	}
	
	public static void main(String[] args) {
		ThreadOddEven threadOddEven = new ThreadOddEven();
		ThreadOdd threadOddRunnable = threadOddEven.new ThreadOdd();
		ThreadEven threadEvenRunnable = threadOddEven.new ThreadEven();
		Thread oddThread = new Thread(threadOddRunnable);
		Thread evenThread = new Thread(threadEvenRunnable);
		oddThread.start();
		evenThread.start();
		
	}
	
	
	
	
	
	
	
}
