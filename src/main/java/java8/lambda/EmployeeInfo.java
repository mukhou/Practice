package java8.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {

    private final String name;

    private final List<String> accounts;

    public EmployeeInfo(String name, List<String> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public EmployeeInfo(){
        this(null, null);
    }

    public String getName() {
        return name;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public EmployeeInfo addToList(EmployeeInfo employeeInfo) {
        List<String> l = new ArrayList<>();
        l.addAll(this.getAccounts());
        l.addAll(employeeInfo.getAccounts());
        return new EmployeeInfo(employeeInfo.name, l);
    }

    public List<String> addToValues(Employee e) {
        List<String> l = new ArrayList<>();
        l.addAll(this.getAccounts());
        l.add(e.getAccount());
        return l;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
