package java8.lambda;


public class ConstructorReference {
    public static void main (String args[]){
        //create a reference to the Person constructor via Person::new.
        // The Java compiler automatically chooses the right constructor by
        // matching the signature of PersonFactory.create.
        PersonFactory<Person1> personFactory = Person1::new;
        personFactory.create("Urmi", "Banerjee");
    }
}
class Person1 {
    String firstName;
    String lastName;

    Person1() {}

    Person1(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person1>{
    P create(String fName, String lName);
}
