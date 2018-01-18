import org.omg.PortableServer.ThreadPolicyOperations;

//Print series 010203040506. Using multi-threading 1st thread will print only 0 2nd thread will print only even numbers and 3rd thread print only odd numbers.

class Number{
	
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}


class ThreadZeroRunnable implements Runnable{

	private Number number;
	
	public  ThreadZeroRunnable(Number number){
		this.number = number;
	}
	
	@Override
	public void run() {
		int i=1;
		synchronized(number){
			while(i<=6){
				while(number.getNumber()!=0){
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print(0);
				if(i%2==1){
					number.setNumber(1);
				}
				else{
					number.setNumber(2);
				}
				i++;
				number.notifyAll();
			}
		}
	}
	
}

class ThreadOddRunnable implements Runnable{

	private Number number;
	
	public  ThreadOddRunnable(Number number){
		this.number = number;
	}
	
	@Override
	public void run() {
		int i=1;
		synchronized(number){
			while(i<=6){
				while(number.getNumber()!=1){
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print(i);
				i=i+2;
				number.setNumber(0);
				number.notifyAll();
			}
		}
	
	}
	
}

class ThreadEvenRunnable implements Runnable{

	private Number number;
	
	public  ThreadEvenRunnable(Number number){
		this.number = number;
	}
	
	@Override
	public void run() {
		int i=2;
		synchronized(number){
			while(i<=6){
				while(number.getNumber()!=2){
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print(i);
				i=i+2;
				number.setNumber(0);
				number.notifyAll();
			}
		}
	
	}
	
}


public class PrintSeriesUsingThreads {

	
	
	public static void main(String[] args) {
		Number number = new Number();
		ThreadZeroRunnable threadZeroRunnable = new ThreadZeroRunnable(number);
		Thread zero = new Thread(threadZeroRunnable,"zero");
		ThreadOddRunnable threadOddRunnable = new ThreadOddRunnable(number);
		Thread oneOdd = new Thread(threadOddRunnable,"oneOdd");
		ThreadEvenRunnable threadEvenRunnable = new ThreadEvenRunnable(number);
		Thread twoEven = new Thread(threadEvenRunnable,"twoEven");
		zero.start();
		oneOdd.start();
		twoEven.start();
		
	}
	
}

