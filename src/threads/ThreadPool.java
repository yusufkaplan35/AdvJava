package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);

        ThreadCreator kurye1= new ThreadCreator("A",5000);
        ThreadCreator kurye2= new ThreadCreator("B",9000);
        ThreadCreator kurye3= new ThreadCreator("C",7000);
        ThreadCreator kurye4= new ThreadCreator("D",3000);
        ThreadCreator kurye5= new ThreadCreator("E",6000);
        ThreadCreator kurye6= new ThreadCreator("F",7000);
        ThreadCreator kurye7= new ThreadCreator("G",2000);

//        kurye1.start();
//        kurye2.start();
//        kurye3.start();
//        kurye4.start();
//        kurye5.start();
//        kurye6.start();
//        kurye7.start();

        service.execute(kurye1);
        service.execute(kurye2);
        service.execute(kurye3);
        service.execute(kurye4);
        service.execute(kurye5);
        service.execute(kurye6);
        service.execute(kurye7);

        service.shutdown(); // havuzu sonlandırır, aksi halde threadler havuzda beklemeye devam eder

    }
}
class ThreadCreator extends Thread{

    private String task;

    private int duration;

    public ThreadCreator(String task,int duration){
        this.task=task;
        this.duration=duration;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " işe başladı. Görev: "+ task );
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+ " işini bitirdi. Görev: "+ task );
    }

}











