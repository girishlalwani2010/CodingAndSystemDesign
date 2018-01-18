public class ThreadVolatilePerfectExample2 {
  public static volatile boolean  stop = false;
  public static void main(String args[]) throws InterruptedException {
      Thread testThread = new Thread(){
            @Override
            public void run(){
              int i = 1;
              while(!stop){
                  i++;
              }
              System.out.println("Thread stop i="+ i);
           }
         };
         testThread.start();
         Thread.sleep(1);
         stop = true;
         System.out.println("now, in main thread stop is: " + stop);
         testThread.join();
     }
 }
	