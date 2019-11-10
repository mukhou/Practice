package headfirstdesignpatterns.strategy;

public class TestDuck {
    public static void main(String[] args){
        MallardDuck mallardDuck = new MallardDuck();
        //fly with wings
        mallardDuck.performFly();
        //squeak
        mallardDuck.performQuack();
    }
}
