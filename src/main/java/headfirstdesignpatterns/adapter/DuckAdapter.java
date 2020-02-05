/* 
User: Urmi
Date: 2/5/2020 
Time: 6:04 PM
*/

package headfirstdesignpatterns.adapter;

public class DuckAdapter implements Turkey {

    private Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
