package pl.sda.poznan;

public class Main {

    public static void main(String[] args) {

//                 ---DEMO---
//        System.out.println("Hello");
//
//        Thread newThread = new Thread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Hello from another thread");
//        });
//
//        newThread.setName("New thread");
//        newThread.start();
//
//        System.out.println("Main function works further");
//
//        try {
//            newThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//

        Buffer buffer = new Buffer();
        Thread producerThread = new ProducerThread(buffer);
        Thread consumerThread = new ConsumerThread(buffer);
        producerThread.setName("producerThread");
        consumerThread.setName("consumerThread");
        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Koniec");

    }
}
