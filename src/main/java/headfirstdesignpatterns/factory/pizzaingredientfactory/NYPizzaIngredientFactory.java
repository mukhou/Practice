package headfirstdesignpatterns.factory.pizzaingredientfactory;

import headfirstdesignpatterns.factory.veggies.Veggies;
import headfirstdesignpatterns.factory.cheese.Cheese;
import headfirstdesignpatterns.factory.cheese.RegginaoCheese;
import headfirstdesignpatterns.factory.clams.Clams;
import headfirstdesignpatterns.factory.clams.FreshClams;
import headfirstdesignpatterns.factory.dough.Dough;
import headfirstdesignpatterns.factory.dough.ThinCrustDough;
import headfirstdesignpatterns.factory.pepperoni.Pepperoni;
import headfirstdesignpatterns.factory.pepperoni.SlicedPepperoni;
import headfirstdesignpatterns.factory.sauce.MarinaraSauce;
import headfirstdesignpatterns.factory.sauce.Sauce;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new RegginaoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
