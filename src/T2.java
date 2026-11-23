/**
 * Class T2 implements Runnable interface.
 * field: terminate regulates termination of Thread.
 * field: active regulates pausing the Thread via methods pause() and resume().
 */
public class T2 implements Runnable {

    private volatile boolean terminate = false;
    private volatile boolean active = true;

    /**
     * method run() prints "Tråd 2" in intervals of one (1) second.
     * if terminate -> end Thread loop.
     * if !active -> pause Thread loop.
     * Thread.sleep(100); relieves the load on CPU while pausing.
     */
    @Override
    public void run() {
        while(!terminate) {
            if(active) {
                System.out.println("Thread 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Paused - rest
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Terminates Thread.
     */
    public void terminateThread() {
        terminate = true;
    }

    /**
     * Pause Thread.
     */
    public void pause() {
        active = false;
    }

    /**
     * Resume Thread.
     */
    public void resume() {
        active = true;
    }
}
