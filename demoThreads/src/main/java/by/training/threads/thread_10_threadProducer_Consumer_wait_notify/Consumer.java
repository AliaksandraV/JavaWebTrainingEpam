package by.training.threads.thread_10_threadProducer_Consumer_wait_notify;

//Класс Потребитель
class Consumer extends Thread {//implements Runnable {

    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}


