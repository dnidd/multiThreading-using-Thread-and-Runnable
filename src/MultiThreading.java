/**
 * Entry point.
 * Class creating, starting (with a 5 seconds gap) and exiting:
 * T1 extends Thread.
 * T2 implements Runnable.
 */
public class MultiThreading {
    public static void main(String[] args) {

        // 1. Create and start a thread from class T1
        T1 t1Thread = new T1();
        t1Thread.start();

        // 2. Wait for 5 seconds
        // T1 runs while main is sleeping
        waitFiveSeconds();

        // 3. Create and start a thread from class T2
        T2 t2Runnable = new T2();
        Thread t2 = new Thread(t2Runnable);
        t2.start();

        // 4. Wait for 5 seconds
        // T1 and T2 runs while main is sleeping
        waitFiveSeconds();

        // 5. Pause T2 thread (class T2)
        t2Runnable.pause();

        // 6. Wait for 5 seconds
        // T1 runs while main is sleeping and T2 is paused
        waitFiveSeconds();

        // 7. Activate thread from class T2
        t2Runnable.resume();

        // 8. Wait for 5 seconds
        // T1 and T2 while main is sleeping
        waitFiveSeconds();

        // 9. Stop thread from class T1
        // T2 runs while T1 terminates
        t1Thread.terminateThread();

        // 10. Wait for 5 seconds
        // T2 runs while main is sleeping
        waitFiveSeconds();

        // 11. Stop thread from class T2
        t2Runnable.terminateThread();
    }

    /**
     * Helper method invokes sleep().
     * sleep() on active Thread (this/main).
     * method controls timing of other method calls in main.
     */
    private static void waitFiveSeconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}