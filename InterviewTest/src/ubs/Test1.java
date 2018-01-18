package ubs;

public class Test1 {
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		synchronized (Thread.currentThread()) {
			System.out.println("hello");
			obj.wait();
			obj.notify();
			
		}
	} 

}
