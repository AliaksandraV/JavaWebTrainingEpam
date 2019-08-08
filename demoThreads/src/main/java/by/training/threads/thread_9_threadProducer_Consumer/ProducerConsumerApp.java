package by.training.threads.thread_9_threadProducer_Consumer;

public class ProducerConsumerApp
{
    public static void main(String[] args) {

        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();

    }
}
