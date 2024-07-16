package com.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMaps
{
    public static void main(String[] args)
    {
        Employee emp1 = new Employee("John Doe", 22);
        Employee emp2 = new Employee("Tim Berners", 31);
        Employee emp3 = new Employee("Snow White", 25);
        Employee emp4 = new Employee("Jack Hill", 30);

        Department hr = new Department("Human Resources");
        hr.addEmployee(emp2);
        hr.addEmployee(emp3);
        hr.addEmployee(emp4);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(emp1);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println("------------------------------------------------");

        departments.stream().flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
    }
}
