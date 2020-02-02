/* 
User: Urmi
Date: 1/30/2020 
Time: 5:45 PM
*/

package byteBybyte;

public class ImmutableStudent {

    private final int id;
    private final String name;
    private final Age age;

    public ImmutableStudent(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        Age clone = new Age();
        clone.setDay(age.getDay());
        clone.setMonth(age.getMonth());
        clone.setYear(age.getYear());
        this.age = clone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age clone = new Age();
        clone.setDay(this.age.getDay());
        clone.setMonth(this.age.getMonth());
        clone.setYear(this.age.getYear());
        return clone;
    }

    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);
        ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
        System.out.println("Alex age year before modification = " + student.getAge().getYear());
        //mutation
        age.setYear(1993);
        System.out.println("Alex age year after modification = " + student.getAge().getYear());
        //mutation through getter
        student.getAge().setYear(1993);
        System.out.println("Alex age year after modification = " + student.getAge().getYear());
    }
}

class Age {
    private int day;
    private int month;
    private int year;
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}

