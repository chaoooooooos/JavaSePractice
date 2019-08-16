package gc.withSyn.one;

public class ProductionAndCustomer {

    public static void main(String[] args) {
        Apple apple = new Apple(0,20);
        for(int i=0;i<10;i++){
            Production p = new Production(apple);
            Customer c = new Customer(apple);
            Thread t1 = new Thread(p,"生产者"+i);
            Thread t2 = new Thread(c,"消费者"+i);
            t1.start();
            t2.start();
        }

    }

}

class Production implements Runnable{
    Apple apple ;
    public Production(Apple apple){
        this.apple = apple;
    }
    @Override
    public void run() {
        while (true)
            apple.put();
    }
}

class Customer implements Runnable{
    Apple apple ;
    public Customer(Apple apple){
        this.apple = apple;
    }
    @Override
    public void run() {
        while (true)
            apple.get();
    }
}

class Apple{
    private int num ;
    private int capaticy;
    public Apple(){
        num = 0;
        capaticy = 5;
    }
    public Apple(int num,int capaticy){
        this.num = num;
        this.capaticy = capaticy;
    }

    public synchronized void put(){
        while (num >= capaticy){
            try {
                wait();
            }catch (Exception e){

            }
        }
        try {
            Thread.sleep((long) (Math.random()*100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"生产1个苹果，剩余"+num+"个苹果");

        notifyAll();
    }

    public synchronized void get(){
        while (num<=0){
            try {
                wait();
            }catch (Exception e){

            }
        }
        try {
            Thread.sleep((long) (Math.random()*100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"消费1个苹果，剩余"+num+"个苹果");

        notifyAll();
    }
}















