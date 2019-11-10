package headfirstdesignpatterns.strategy;

public class MallardDuck extends Duck {

    public MallardDuck(){
        //behavior classes encapsulated, as those parts change with each duck
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("Mallard duck");
    }
}
