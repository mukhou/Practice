/* 
User: Urmi
Date: 2/13/2020 
Time: 4:59 PM
*/

package headfirstdesignpatterns.template;

public class Coffee extends CaffeineBeverage {

    @Override
    public void addCondiments() {
        System.out.println("Adding milk and sugar");
    }

    @Override
    public void brew() {
        System.out.println("Dripping coffee through filter");
    }
}
