
public class ThreadsWithStaticAndVolatile{
	
	private volatile int counter;
	
	class Thread1 extends Thread{
		public void run(){
			counter++;
		}
	}
	
	class Thread2 extends Thread{
		public void run(){
			counter++;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
