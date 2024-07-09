class NewThread2 extends Thread {
    NewThread2() {
        super("Extends Thread");
        start();
    }
    // This is the entry point for the thread.
    public void run() {
        System.out.println("Starting child thread.");
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

public class ExtendsThread {
    public static void main(String[] args) throws Exception {
        new NewThread2();
        for(int i = 10; i > 0; i--) {
            System.out.println("Main Thread: " + i);
            Thread.sleep(5000);
        }
    }
}
