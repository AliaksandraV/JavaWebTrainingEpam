package by.training.threads.thread_2_threadRunnablePerson;

import java.util.concurrent.TimeUnit;

public class PersonRunner extends Person implements Runnable {

    public PersonRunner(final String name) {
        super(name);
    }


    public void run() {
        for(int i = 0; i< 10 ; i++){
            System.out.println(getName() + ": Hello world");

            try {
//                Thread.sleep(100);
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "is stopped");
    }
}
