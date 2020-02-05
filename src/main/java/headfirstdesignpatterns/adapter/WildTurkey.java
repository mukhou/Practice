/* 
User: Urmi
Date: 2/5/2020 
Time: 5:16 PM
*/

package headfirstdesignpatterns.adapter;

public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("Turkey flying");
    }
}
