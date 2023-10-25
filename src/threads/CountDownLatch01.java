package threads;

import java.util.concurrent.CountDownLatch;
/*
bazı threadlerin diğer threadlerden ve main threadden önce çalışıp işini
bitirmesini ve bu arada diğer threadlerin beklemesini(first worker threads) istedğimizde;
CountDownLatch objesiyle bir sayaç oluşturulur, ve her bir worker thread işini tamamladığında
sayacın bir azaltılması için objenin countDown metodu kullanılır. Sayaç=0 olduğunda
latch objesinin await metodu ile bekleyen threadler çalışmaya devam eder.
 */

public class CountDownLatch01 { //menteşe kavramı gibi. Belirli aralığa kadar açan araç

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4);

        System.out.println("main thread çalışıyor.");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı, kod yazıyor");
                try {
                    latch.await(); //sayacın tamamlanmasını bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" çalışmaya devam ediyor");
            }
        },"developer");
        thread1.start();

        WorkerThreads worker1 = new WorkerThreads("worker1",5000,latch);
        WorkerThreads worker2 = new WorkerThreads("worker2",2000,latch);
        WorkerThreads worker3 = new WorkerThreads("worker3",7000,latch);
        WorkerThreads worker4 = new WorkerThreads("worker4",3000,latch);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        //main thread de workerları beklesin

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main thread yeniden devam ediyor.");

    }

}


class WorkerThreads extends Thread{
    private int duration;

    private CountDownLatch latch;

    //param const
    public WorkerThreads(String name, int duration, CountDownLatch latch){
        super(name);
        this.duration=duration;
        this.latch=latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+ " çalışmaya başladı...");
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName()+ " işini bitirdi...");
            latch.countDown(); // sayacı 1 azalt demiş olduk. 4-3-2-1-->0
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
