package by.training.threads.thread_6_threadCommonResource_synchronized;

public class CommonResource {
    int x;

    synchronized public int getX() {
        return x;
    }
}
