package gc.design;

public class Singleton2 {
    private Singleton2(){
        System.out.println("...");
    }

    private static class SingletonInstance{
        private final static Singleton2 singleton = new Singleton2();
    }
    public static Singleton2 newInstance(){
        return SingletonInstance.singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    Singleton2.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
