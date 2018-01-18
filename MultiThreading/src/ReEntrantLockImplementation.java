public class ReEntrantLockImplementation {
    private int count = 0;
    private boolean isLocked = false;
    private Thread lockedByThread = null;
    

    public synchronized void lock() throws InterruptedException{
        while(isLocked && Thread.currentThread() != lockedByThread){
            this.wait();
        }
        isLocked = true;
        lockedByThread = Thread.currentThread();
        count++;
    }

   public synchronized void unlock(){
        if (!isLocked || lockedByThread != Thread.currentThread()) {
            return;
        }
        count--;
        if(count == 0){
            isLocked = false;
            this.notify();
        }
    }
}