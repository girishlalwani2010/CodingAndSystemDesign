
public class ThreadInterruptExample extends Thread{

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadInterruptExample threadInterruptExample = new ThreadInterruptExample();
		threadInterruptExample.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadInterruptExample.interrupt();
		try {
			threadInterruptExample.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
