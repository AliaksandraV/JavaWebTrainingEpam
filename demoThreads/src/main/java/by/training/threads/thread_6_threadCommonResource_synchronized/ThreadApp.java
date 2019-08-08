package by.training.threads.thread_6_threadCommonResource_synchronized;

public class ThreadApp {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Поток " + i);
            t.start();
        }
    }
}
