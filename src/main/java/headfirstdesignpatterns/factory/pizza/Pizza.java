package headfirstdesignpatterns.factory.pizza;

import headfirstdesignpatterns.factory.veggies.Veggies;
import headfirstdesignpatterns.factory.cheese.Cheese;
import headfirstdesignpatterns.factory.clams.Clams;
import headfirstdesignpatterns.factory.dough.Dough;
import headfirstdesignpatterns.factory.pepperoni.Pepperoni;
import headfirstdesignpatterns.factory.sauce.Sauce;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Veggies[] toppings;
    Pepperoni pepperoni;
    Clams clams;

    public abstract void prepare();

    public void bake() {
    }

    public void box() {
    }

    public void cut() {
        System.out.println("Cutting into diagonal sizes");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
