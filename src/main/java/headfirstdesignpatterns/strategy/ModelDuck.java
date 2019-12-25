/* 
User: Urmi
Date: 12/23/2019 
Time: 5:46 PM
*/

package headfirstdesignpatterns.strategy;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I can't fly");
    }


}
