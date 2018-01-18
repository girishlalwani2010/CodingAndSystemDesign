

public class TestVolatile {

 volatile int x = 0;
 int y = 0;

class MyThread1 extends Thread{	
	public void run(){
		
		y = 5;
		try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		x = 67;	
				
		
	}
}
class MyThread2 extends Thread{
	public void run(){
		 System.out.println(x+","+y); 
	}
}
    
    public static void main(String[] args) throws InterruptedException {
    	TestVolatile ob = new TestVolatile(); 
    	  /*Thread thread1=new Thread(){
                  public void run(){                        
                	  x = 19;                                             
                  }
           };
 
           Thread thread2=new Thread(){
                  public void run(){
                	  System.out.println(x);
                  }
           };*/
    	TestVolatile.MyThread1 thread1=ob.new MyThread1();
    	TestVolatile.MyThread2 thread2=ob.new MyThread2();
           
           thread1.start();
           Thread.sleep(5);
           thread2.start();
    }
}
