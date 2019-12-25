/* 
User: Urmi
Date: 12/23/2019 
Time: 5:47 PM
*/

package headfirstdesignpatterns.strategy;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can’t fly");
    }
}
