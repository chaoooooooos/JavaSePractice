package gc.multiThread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static final CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()+"->running");
                        latch.countDown();
                    }catch (Exception e){

                    }
                }
            },String.valueOf(i)).start();
        }
        System.out.println("main->running");
    }

}
