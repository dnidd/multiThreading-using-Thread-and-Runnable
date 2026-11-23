/**
 * Class T1 extends Thread super class.
 * field: terminate regulates termination of Thread.
 */
public class T1 extends Thread{

    // Using volatile flag
    // https://www.geeksforgeeks.org/java/killing-threads-in-java/
    private volatile boolean terminate = false;

    /**
     * method run() prints "Tråd 1" in intervals of one (1) second
     * if terminate -> end Thread loop
     */
    @Override
    public void run() {
        while(!terminate) {
            System.out.println("Tråd 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    /**
     * Terminates Thread
     */
    public void terminateThread() {
        terminate = true;
    }
}
