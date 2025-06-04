// A class that prints a table WITHOUT synchronization
class TablePrinter implements Runnable {
    int number;

    TablePrinter(int number) {
        this.number = number;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("NoSync - Table of " + number + ": " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); // Pause to simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// A class that prints a table WITH synchronization
class SyncTable {
    // synchronized ensures only one thread can use this method at a time
    synchronized void printTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Sync - Table of " + number + ": " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); // Pause to simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// A class that uses SyncTable to print the table using a thread
class SyncTablePrinter implements Runnable {
    int number;
    SyncTable table;

    SyncTablePrinter(SyncTable table, int number) {
        this.table = table;
        this.number = number;
    }

    public void run() {
        table.printTable(number);
    }
}

// Main class
public class pgm21 {
    public static void main(String[] args) {
        // ---------- Without Synchronization ----------
        System.out.println("=== Without Synchronization ===");
        Thread t1 = new Thread(new TablePrinter(5));
        Thread t2 = new Thread(new TablePrinter(6));

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for t1 to finish
            t2.join(); // Wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ---------- With Synchronization ----------
        System.out.println("\n=== With Synchronization ===");
        SyncTable syncTable = new SyncTable();

        Thread t3 = new Thread(new SyncTablePrinter(syncTable, 5));
        Thread t4 = new Thread(new SyncTablePrinter(syncTable, 6));

        t3.start();
        t4.start();
    }
}
