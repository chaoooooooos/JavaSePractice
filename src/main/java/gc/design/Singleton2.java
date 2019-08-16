package gc.design;

public class Singleton2 {
    private Singleton2(){}

    private static class SingletonInstance{
        private final static Singleton2 singleton = new Singleton2();
    }
    public Singleton2 newInstance(){
        return SingletonInstance.singleton;
    }
}
