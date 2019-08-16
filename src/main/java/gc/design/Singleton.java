package gc.design;

import java.util.concurrent.TimeUnit;

public class Singleton {
    private static  Singleton singleton = null; //必须加入volatile

    private Singleton() {
        System.out.println(Thread.currentThread().getName()+"...........");
    }

    public static Singleton newInstance() throws InterruptedException {
        if (singleton == null) {
            TimeUnit.SECONDS.sleep(1);
            synchronized (Singleton.class) {
                if (singleton == null) {
                    TimeUnit.SECONDS.sleep(1);
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    Singleton.newInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
