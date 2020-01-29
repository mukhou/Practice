package headfirstdesignpatterns.factory;

import headfirstdesignpatterns.factory.pizza.CheesePizza;
import headfirstdesignpatterns.factory.pizza.ClamPizza;
import headfirstdesignpatterns.factory.pizza.Pizza;
import headfirstdesignpatterns.factory.pizzaingredientfactory.ChicagoPizzaIngredientFactory;
import headfirstdesignpatterns.factory.pizzaingredientfactory.PizzaIngredientFactory;

public class ChicagoStylePizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        if(type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        }else if(type.equals("clams")){
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Fresh Clams Pizza");
        }//other pizza types

        return pizza;

    }
}
