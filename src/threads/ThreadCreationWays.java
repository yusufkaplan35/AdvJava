package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        //her java programında 1 tane thread default olarak çalıştırılır.
        System.out.println("Mevcut thread: "+ Thread.currentThread().getName());

        MyThread thread1= new MyThread();
        thread1.start(); // Yeni oluşturduğumuz Threadi oluşturur, başlatır ve run methodunu çağırır
        //kendimiz threade isim verebiliriz
        thread1.setName("threadcik");

        //2.YOL :Runnable : functional interface
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2= new Thread(myRunnable);
        thread2.start();

        //anonymus class: isimsiz sınıf
        Thread thread3=new Thread(new Runnable() { //Runnable'ın sadece bir tane methodu var oda run
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Anonim thread: " + Thread.currentThread().getName());
                System.out.println("Anonim sınıf ile thread oluştu. ");
            }
        }
        );
        thread3.start();

        //Runnable: functional interface : sadece run implemente edilecek. lambda exp.
        Thread thread4 = new Thread(()->{
            System.out.println("lambda ile run methodunu override ettik ve runnable parametresi verdik. ");
        });
        thread4.start();


        try {
            Thread.sleep(3000); // hangi thread çalışırken kullanılırsa bu threadi uyutur veya verilen süre kadar bekletir.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("burada main thread işini bitirdi.");

    }
}

//thread oluşturmanın 2 tane yolu var.
// 1.YOL: Thread classını extend ederek kendi threadimizi oluşturabiliriz.

class MyThread extends Thread{
    @Override
    public void run() {
        //threade yaptırmak istediğimiz işlemler
        System.out.println("Çalışan thread: "+Thread.currentThread().getName()); // default thread name = Thread-0
        System.out.println("My thread threadi çalışıyor.");
    }
}

//2.YOL: Runnable interfaceini implemente etmek

class MyRunnable implements Runnable{
    @Override
    public void run() {//Runnable classta bulunan run methodu override ediyoruz
        //threade yaptırmak istediğimiz işlemler
        System.out.println("Çalışan thread runnable: "+Thread.currentThread().getName());
        System.out.println("Runnable interface ile oluşturulan thread çalışıyor.");
    }

}







