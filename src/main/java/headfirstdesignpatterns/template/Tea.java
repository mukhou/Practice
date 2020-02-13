/* 
User: Urmi
Date: 2/13/2020 
Time: 4:58 PM
*/

package headfirstdesignpatterns.template;

public class Tea extends CaffeineBeverage {

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }

    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }
}
