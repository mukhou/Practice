package headfirstdesignpatterns.iterator.compositeiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Composite Pattern allows you to compose objects into tree structures to
 * represent part-whole hierarchies. Composite lets clients treat individual objects and
 * compositions of objects uniformly.
 */
public class Menu extends MenuComponent {

    List<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i){
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void print(){
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent component = iterator.next();
            component.print();
        }
    }
}
