package by.training.threads.thread_2_threadRunnablePerson;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        PersonRunner person = new PersonRunner("Bob");
        PersonRunner person2 = new PersonRunner("Alice");
        System.out.println("Main thread started");

        Thread thread1 = new Thread(person);
        Thread thread2 = new Thread(person2);

        thread1.setPriority(10);

        thread1.start();
        System.out.println(thread1.getName() + "started");

        thread2.setPriority(1);
        thread2.start();
        System.out.println(thread1.getName() + "started");

        thread1.join();
        thread2.join();

        System.out.println("Main end");

    }


//    public static void main(String[] args) throws InterruptedException {
//        PersonRunner person = new PersonRunner("Bob");
//        PersonRunner person2 = new PersonRunner("Alice");
//        System.out.println("Main thread started");
//
//        Thread thread1 = new Thread(person);
//        Thread thread2 = new Thread(person2);
//
//        thread1.setPriority(10);
//
//        thread1.start();
//        System.out.println(thread1.getName() + "started");
//
//        thread2.setPriority(1);
//        thread2.start();
//        System.out.println(thread1.getName() + "started");
//
//        thread1.join();
//        thread2.join();
//
//        System.out.println("Main end");
//
//    }
}
