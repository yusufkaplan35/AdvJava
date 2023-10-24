package threads;
/*
 Birden fazla thread kullanılan bir uygulamada ,değişkenler performans nedeniyle CPU
 cache'inde tutulabilir.
 Bilgisayarın birden fazla CPU'su(çekirdek) olduğunu düşünürsek her thread farklı
 CPU üzerinde çalısabilir
 bu nedenle her thread değişkenlerin değerini CPU cache'ine farklı değerde yazabilir.

 "volatile" keywordü değişken üzerinde bir değişiklik olduğunda diğer threadler tarafından
 görünmesini garanti eder.
 "volatile" ile bir değişken CPU cache yerine bilgisayarın main memory'sinden okunur ve
 CPU cache yerine main memory'sine yazılır.
 non-volatile değişkenler için böyle bir garanti yoktur.
 */
public class Volatile01 {

    public volatile static int flag = 0; //bu değişken main memoryden okunsun ve yazılsın

    public static void main(String[] args) {

        Thread thread1= new Thread(new Runnable() { // core 1:cache --> birinci çekirdekte çalışıyor
            @Override
            public void run() {

                while(flag!=1){
                    System.out.println("Threadlerle çalışmak harika :)");
                }

            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() { //// core 2 : cache--> ikinci çekirdekte çalışıyor
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag++; // cache: flag=1 --- main flag=0
                System.out.println("flag değeri 1 oldu.");
            }
        });
           thread2.start();


    }





}
