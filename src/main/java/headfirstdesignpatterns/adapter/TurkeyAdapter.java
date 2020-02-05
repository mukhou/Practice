/* 
User: Urmi
Date: 2/5/2020 
Time: 5:17 PM
*/

package headfirstdesignpatterns.adapter;

public class TurkeyAdapter implements Duck {

    //we need to get a reference to the object that we are adapting,
    //so that we call invoke methods on it
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();

    }

    @Override
    public void fly() {
        for(int i=0; i < 5; i++) {
            turkey.fly();
        }
    }
}
