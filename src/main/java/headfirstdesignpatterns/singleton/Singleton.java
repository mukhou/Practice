package headfirstdesignpatterns.singleton;

public class Singleton {

    private volatile static Singleton uniqueInstance;
    //eager initialization
    //Using this approach, we rely on JVM to create the instance when the class is loaded. The JVM guarantees that the
    //instance will be created before any thread accesses it.
    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    //lazy initialization
    public static Singleton getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
