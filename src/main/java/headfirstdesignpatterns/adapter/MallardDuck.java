/* 
User: Urmi
Date: 2/5/2020 
Time: 5:15 PM
*/

package headfirstdesignpatterns.adapter;

public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("Duck Flying");
    }
}
