package gc.design;

public class Singleton {
    private static Singleton singleton = null;
    private Singleton(){

    }
    public Singleton newInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null)
                    return new Singleton();
            }
        }
        return singleton;
    }

}
