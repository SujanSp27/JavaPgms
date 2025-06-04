class EvenThread extends Thread {
    public void run() {
        try {
            for (int i = 2; i <= 100; i += 2) {
                System.out.println("Even Thread: " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Even Thread Interrupted");
        }
    }
}

class OddThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 100; i += 2) {
                System.out.println("Odd Thread: " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Odd Thread Interrupted");
        }
    }
}

public class pgm19 {
    public static void main(String[] args) {
        // Create thread objects
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();

        // Start both threads
        evenThread.start();
        oddThread.start();

        // Main thread: Print multiples of 5 from 100 to 200
        for (int i = 100; i <= 200; i++) {
            if (i % 5 == 0) {
                System.out.println("Main Thread (Multiple of 5): " + i);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    System.out.println("Main Thread Interrupted");
                }
            }
        }
    }
}
