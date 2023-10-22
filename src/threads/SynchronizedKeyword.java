package threads;

public class SynchronizedKeyword {
    public static void main(String[] args) {

        //task: 14 defa [ [ [ [ [ ] ] ] ] ] satırını yazdıralım
        Brackets brackets=new Brackets();

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



    }
}
//iki threadde aynı anda aynı objeyi kullanmaya çalıştığında istenmeyen sonuçlar
//elde ettik. çözüm:generateBrackets metoduna aynı anda sadece 1 thread ulaşsın(senkron olsun)
class Brackets{

    public synchronized void generateBrackets(){

        for (int i=1;i<=10;i++){
            if (i<6){
                System.out.print("[ ");
            }else {
                System.out.print("] ");
            }
        }
        System.out.println(" - "+Thread.currentThread().getName());

    }

}
