package headfirstdesignpatterns.singleton;

public class Singleton {

    private static Singleton uniqueInstance;
    //eager initialization
    //Using this approach, we rely on JVM to create the instance when the class is loaded. The JVM guarantees that the
    //instance will be created before any thread accesses it.
    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    //lazy initialization
    //https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
    //The below is callled double checked locking principle. In this approach,
    // the synchronized block is used inside the if condition with an additional check
    // to ensure that only one instance of a singleton class is created.
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
