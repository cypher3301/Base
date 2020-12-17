package study.multithreading;

public class States {
    public static void main(String[] args) {
//        Thread thread = Thread.currentThread();
//        System.out.println(thread);

        System.out.println("Main thread started...");
        for (int i = 0; i < 10; i++) {
            new JThread("Jthread: "+i).start();
        }
        System.out.println("Main thread finished...");
    }
}


