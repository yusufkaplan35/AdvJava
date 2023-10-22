package threads;

public class Multithreading01 {
    public static void main(String[] args) {

        //TASK:1 den 10 a 2 defa yazdırma
        long start=System.currentTimeMillis();
        Counter counter1=new Counter("Jack");
        Counter counter2=new Counter("Harry");
        counter1.countMe();
        counter2.countMe();
        long finish=System.currentTimeMillis();

        System.out.println("Thread kullanmadan geçen süre: "+(finish-start));//10269

        System.out.println("-------------Multihreading---------------------------------");

        long start1=System.currentTimeMillis();

        CounterWithMultiThread counter3=new CounterWithMultiThread("Betty");
        CounterWithMultiThread counter4=new CounterWithMultiThread("Wilma");
        counter3.start();
        counter4.start();

        try {
            counter3.join();//hangi thread(main) içinde çağrılmışsa bu threadi counter3 işini bitirene kadar bekletir.
            counter4.join();//hangi thread(main) içinde çağrılmışsa bu threadi counter4 işini bitirene kadar bekletir.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish1=System.currentTimeMillis();

        System.out.println("Multithreading ile geçen süre: "+(finish1-start1));//5109



    }
}
class Counter{

    public String name;

    //param const
    public Counter(String name) {
        this.name = name;
    }

    //1 den 10 a kadar sayıları yazdırma
    public void countMe(){

        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" - "+this.name);
        }

    }
}

class CounterWithMultiThread extends Thread{

    public String name;

    //param const
    public CounterWithMultiThread(String name) {
        this.name = name;
    }
    //run metoduna threadin görevi


    @Override
    public void run() {
        countMe();
    }

    //1 den 10 a kadar sayıları yazdırma
    public void countMe(){

        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" - "+this.name);
        }

    }
}