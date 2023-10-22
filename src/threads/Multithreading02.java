package threads;

public class Multithreading02 {

    public static int counter=0;

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                //başka kodlar
                System.out.println("kodlar1");
                for (int i=0;i<5;i++){
                    System.out.println(i);
                }
                Counter01.count();
                //başka kodlar

            }
        });
        thread1.setName("Tom");
        thread1.start();



        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {


                //başka kodlar
                System.out.println("kodlar2");
                for (int i=0;i<5;i++){
                    System.out.println(i);
                }
                Counter01.count();
                //başka kodlar

            }
        });
        thread2.setName("Jerry");
        thread2.start();

//bu problemi join ile diğer threadi bekletmek çözmez,
//multithreding uygulama olmamış olur.
    }
}
class Counter01{
    //iki thread de aynı anda aynı kaynağı okuma ve yazdırma
    //işlemi yapmaya çalıştığı için istenmeyen sonuçlar elde edildi.
    //synchronized:bu metoda aynı anda sadece 1 thread erişebilsin
    public synchronized static void count(){

        for (int i=1;i<=1000;i++){

            Multithreading02.counter++;
            System.out.println(Thread.currentThread().getName()+"--->counter : "+Multithreading02.counter);

        }

    }


}
