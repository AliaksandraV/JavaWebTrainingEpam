package by.training.threads.thread_6_threadCommonResource_synchronized;

public class IncrementThread implements Runnable {

    CommonIncrementResource res;

    IncrementThread(CommonIncrementResource res) {
        this.res = res;
    }

    public void run() {
        res.increment();
    }
}
