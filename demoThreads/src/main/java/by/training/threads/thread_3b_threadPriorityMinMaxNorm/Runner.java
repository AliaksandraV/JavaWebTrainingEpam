package by.training.threads.thread_3b_threadPriorityMinMaxNorm;

import by.training.threads.thread_3a_threadPriority.PriorThread;

public class Runner {
    public static void main(String[] args) {
        PriorThread min = new PriorThread("Min");
        PriorThread max = new PriorThread("Max");
        PriorThread norm = new PriorThread("Norm");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        norm.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        norm.start();
        max.start();
        try {
            min.join();
            norm.join();
            max.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
