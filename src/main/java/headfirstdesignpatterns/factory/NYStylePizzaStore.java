package headfirstdesignpatterns.factory;

import headfirstdesignpatterns.factory.pizza.CheesePizza;
import headfirstdesignpatterns.factory.pizza.ClamPizza;
import headfirstdesignpatterns.factory.pizza.Pizza;
import headfirstdesignpatterns.factory.pizzaingredientfactory.NYPizzaIngredientFactory;
import headfirstdesignpatterns.factory.pizzaingredientfactory.PizzaIngredientFactory;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if(type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("NY Style Cheese Pizza");
        }else if(type.equals("clams")){
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("NY Style Fresh Clams Pizza");
        }//other pizza types

        return pizza;
    }
}
