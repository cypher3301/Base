package study.multithreading.VideoGoshaDudar;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        jThread thread1 = new jThread();
        thread1.start();

        jThread thread2 = new jThread();
        thread2.start();
    }
}


class jThread extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}