package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda3 {
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        //using lambda
        roster.forEach(p -> System.out.println(p.getAge()));
        roster.forEach(p -> System.out.println(p.getAge() >= age));

    }
    public static void main (String args[]){
        Person p = new Person();
        p.setAge(30);
        p.setName("abc");
        Person p1 = new Person();
        p1.setAge(12);
        p1.setName("mno");
        Person p2 = new Person();
        p2.setAge(35);
        p2.setName("pqr");
        Person p3 = new Person();
        p3.setAge(16);
        p3.setName("xyz");
        List<Person> roster = new ArrayList<>();
        roster.add(p);
        roster.add(p1);
        roster.add(p2);
        roster.add(p3);
       // printPersonsOlderThan(roster, 20);

        // map to Person
        Stream<Person> map = roster.stream()
                .filter(s -> s.getAge() > 18
                ).map(s -> new Person());
        // create filtered list
        List<Person> list = roster.stream()
                .filter(ps -> ps.getAge() >= 30)
                .collect(Collectors.toList());
        System.out.println(list.size());
        list.forEach(l -> System.out.println(l.getName()));
        // OR
        roster.stream().filter(per -> per.getAge() >= 15)
                        .forEach(per -> System.out.print(per.getName() + " "));


    }
}
 class Person {

     String name;
     int age;
     Integer x;

     int getAge() {
         return age;
     }

     void setAge(int age) {
         this.age = age;
     }

     public void greater() {
         System.out.println("Greater" + this.name + this.age);
     }

     public void smaller() {
         System.out.println("Smaller" + this.name + this.age);
     }

     public enum Sex {
        MALE, FEMALE
    }

     String getName() {
         return name;
     }

     void setName(String name) {
         this.name = name;
     }





}

