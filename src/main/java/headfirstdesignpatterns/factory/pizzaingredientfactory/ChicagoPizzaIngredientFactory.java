package headfirstdesignpatterns.factory.pizzaingredientfactory;

import headfirstdesignpatterns.factory.veggies.Veggies;
import headfirstdesignpatterns.factory.cheese.Cheese;
import headfirstdesignpatterns.factory.cheese.MozzarelaCheese;
import headfirstdesignpatterns.factory.clams.Clams;
import headfirstdesignpatterns.factory.clams.FrozenClams;
import headfirstdesignpatterns.factory.dough.Dough;
import headfirstdesignpatterns.factory.dough.ThickCrustDough;
import headfirstdesignpatterns.factory.pepperoni.Pepperoni;
import headfirstdesignpatterns.factory.pepperoni.SlicedPepperoni;
import headfirstdesignpatterns.factory.sauce.PlumTomatoSauce;
import headfirstdesignpatterns.factory.sauce.Sauce;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarelaCheese();
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
        return new FrozenClams();
    }
}
