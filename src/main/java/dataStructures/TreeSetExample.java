/* 
User: Urmi
Date: 1/29/2020 
Time: 4:26 PM
*/

package dataStructures;

import java.util.TreeSet;

class Human{
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class TreeSetExample {
    public static void main(String[] args){
        TreeSet<Human> humans = new TreeSet<>();
        humans.add(new Human("urmi"));
        humans.add(new Human("jhini"));
        humans.add(new Human("sharmi"));
        System.out.println(humans);
    }

}
