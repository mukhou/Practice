package headfirstdesignpatterns.decorator;

import java.util.WeakHashMap;

public class Whip extends CondimentDecorator{

    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.90;
    }
}
