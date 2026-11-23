Simple multithreaded program using two ways of implementing thread.

* Class T1 extends Thread.
* Class T2 implements Runnable.

When the program executes:
 1 Create and start a thread from class T1.
 2 Wait for five seconds.
 3 Create and start a thread from class T2.
 4 Wait for five seconds.
 5 Pause the thread from class T2.
 6 Wait for five seconds.
 7 Activate the thread from class T2.
 8 Wait for five seconds.
 9 Stop the thread from class T1.
10 Wait for five seconds.
11 Stop the thread from class T2.


Both threads will once per seconds print:
class T1: Thread 1  
class T2: Thread 2


The results may vary in the details, but generally it should produce the following:  
````
Thread 1
Thread 1
Thread 1
Thread 1
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 1
Thread 1
Thread 1
Thread 1
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 1
Thread 2
Thread 2
Thread 2
Thread 2
Thread 2
````


Using volatile flag:
https://www.geeksforgeeks.org/java/killing-threads-in-java/