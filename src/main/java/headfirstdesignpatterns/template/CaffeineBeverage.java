/* 
User: Urmi
Date: 2/13/2020 
Time: 4:43 PM
*/

package headfirstdesignpatterns.template;

/**
 * The Template Method Pattern defines the skeleton of an algorithm in a method,
 * deferring some steps to subclasses. Template Method lets subclasses redefine
 * certain steps of an algorithm without changing the algorithm’s structure.
 */
public abstract class CaffeineBeverage {

    //the template method
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void addCondiments();

    protected abstract void brew();

    void boilWater() {
        System.out.println("Boiling water");
    }
    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
