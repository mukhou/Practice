package java8.lambda;

public class Employee {

    private final int dept;

    private final String name;

    private final String city;

    private final String account;

    public Employee(int dept, String name, String city, String account) {
        this.dept = dept;
        this.name = name;
        this.city = city;
        this.account = account;
    }

    public int getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAccount() {
        return account;
    }
}
