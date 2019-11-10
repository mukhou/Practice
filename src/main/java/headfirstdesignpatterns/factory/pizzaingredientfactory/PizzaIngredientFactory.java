package headfirstdesignpatterns.factory.pizzaingredientfactory;

import headfirstdesignpatterns.factory.veggies.Veggies;
import headfirstdesignpatterns.factory.cheese.Cheese;
import headfirstdesignpatterns.factory.clams.Clams;
import headfirstdesignpatterns.factory.dough.Dough;
import headfirstdesignpatterns.factory.pepperoni.Pepperoni;
import headfirstdesignpatterns.factory.sauce.Sauce;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();


}
