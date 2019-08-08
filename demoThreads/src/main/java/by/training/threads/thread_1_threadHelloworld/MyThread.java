package by.training.threads.thread_1_threadHelloworld;

public class MyThread extends Thread {

    public void run() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
