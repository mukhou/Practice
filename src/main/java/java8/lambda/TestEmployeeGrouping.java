package java8.lambda;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class TestEmployeeGrouping {

    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();
        //tradeId, secPool, datasetid, restricValue
        employees.add(new Employee(1, "Mary", "Boston", "A1"));
        employees.add(new Employee(1, "Mary", "Boston", "A2"));
        employees.add(new Employee(1, "Alex", "NYC", ""));
        employees.add(new Employee(2, "Peter", "DC", ""));
        employees.add(new Employee(2, "Sophia", "DC", "A4"));

        TestEmployeeGrouping testEmployeeGrouping = new TestEmployeeGrouping();

        Map<Integer, List<EmployeeInfo>> result = new HashMap<>();
        Map<Integer, Map<String, List<Employee>>> map =  employees.stream().collect(
                groupingBy(Employee::getDept, groupingBy(testEmployeeGrouping::createKey)));
        map.forEach((integer, stringListMap) -> {
            List<EmployeeInfo> employeeInfos = createInfo(stringListMap);
            result.put(integer, employeeInfos);
        });

        result.forEach((integer, employeeInfos) -> {

            System.out.println(integer + ": " + employeeInfos.toString());

        });

        System.out.println("************************************");



        List<EmployeeInfo> empInfo = employees.stream().collect(Collectors.groupingBy(e->e.getDept()+e.getName()))
                .values().stream().map(emps->new EmployeeInfo(emps.stream().findFirst().get().getName(), emps.stream().map(Employee::getAccount)
                        .collect(Collectors.toList()))).collect(Collectors.toList());

       // employees.stream().collect(groupingBy(Employee::getDept, groupingBy(testEmployeeGrouping::createKey, reducing(EmployeeInfo::addToList))));

        Map<Integer, List<EmployeeInfo>> result1 = employees.stream().collect(Collectors.groupingBy(Employee::getDept)).entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, value->value.getValue().stream().collect(Collectors.groupingBy(Employee::getName)).values()
                        .stream().map(emp->new EmployeeInfo(emp.stream().findFirst().get().getName(), emp.stream().map(Employee::getAccount).collect(Collectors.toList())))
                        .collect(Collectors.toList())));

        result1.forEach((integer, employeeInfos) -> {

            System.out.println(integer + ": " + employeeInfos.toString());

        });

        System.out.println("************************************");

        Map<Integer, List<EmployeeInfo>> result2 = employees.stream().collect(groupingBy(Employee::getDept,
                collectingAndThen(groupingBy(Employee::getName, reducing(new EmployeeInfo("", new ArrayList<>()),
                        employee -> new EmployeeInfo(employee.getName(), Lists.newArrayList(employee.getAccount())),
                        EmployeeInfo::addToList)),
                        entries -> new ArrayList<>(entries.values()))));

        result2.forEach((integer, employeeInfos) -> {

            System.out.println(integer + ": " + employeeInfos.toString());

        });



        System.out.println("************************************");



    }

    private static List<EmployeeInfo> createInfo(Map<String,List<Employee>> stringListMap) {
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        stringListMap.forEach((s, employees) -> {
            List<String> accounts = employees.stream().map(Employee::getAccount).collect(Collectors.toList());
            employeeInfos.add(new EmployeeInfo(employees.get(0).getName(), accounts));
        });

        return employeeInfos;
    }


    private String createKey(Employee employee) {
        return employee.getDept() + employee.getName();
    }
}
