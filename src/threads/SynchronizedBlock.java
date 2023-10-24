package threads;

public class SynchronizedBlock {

    public static void main(String[] args) {

        //task: 14 defa [ [ [ [ [ ] ] ] ] ] satırını yazdıralım
        Brackets2 brackets=new Brackets2();

        long start=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=7;i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=1;i<=7;i++){
                    brackets.generateBrackets();
                }

            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish=System.currentTimeMillis();

        //System.out.println("blok ile geçen süre : "+(finish-start));//2199
        System.out.println("metod ile geçen süre : "+(finish-start));//4363

    }
}
class Brackets2{

    public /*synchronized*/ void generateBrackets(){

        synchronized (this){
            for (int i=1;i<=10;i++){
                if (i<6){
                    System.out.print("[ ");
                }else {
                    System.out.print("] ");
                }
            }
            System.out.println(" - "+Thread.currentThread().getName());

        }

        //senkron olması gerekmeyen diğer kodlar
        for (int i=1;i<6;i++){
            System.out.println(i);

        //bekletip akışı görmek için sleep yapıldı

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}