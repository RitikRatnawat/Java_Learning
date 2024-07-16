package com.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Functional_Interfaces
{
    public static void main(String[] args)
    {
        Employee emp1 = new Employee("John Doe", 22);
        Employee emp2 = new Employee("Tim Berners", 31);
        Employee emp3 = new Employee("Snow White", 25);
        Employee emp4 = new Employee("Jack Hill", 30);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

//        printEmployeesByAge(employees, "Employees over 30", emp -> emp.getAge() > 30);
//        printEmployeesByAge(employees, "\nEmployees below 30", emp -> emp.getAge() <= 30);
//        printEmployeesByAge(employees, "\nEmployees below 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() <= 25;
//            }
//        });
//
//        IntPredicate gt15 = i -> i > 15;
//        System.out.println(gt15.test(10));
//
//        IntPredicate lt100 = i -> i < 100;
//        System.out.println(gt15.and(lt100).test(50));
//        System.out.println(gt15.and(lt100).test(15));
//
//        System.out.println();
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for(int i = 0; i < 10; i++)
//            System.out.println(randomSupplier.get());
//
//        employees.forEach(employee -> {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });
//
//        System.out.println();
//        employees.forEach(employee -> {
//            String lastname = employee.getName().substring(employee.getName().indexOf(' ')+1);
//            System.out.println(lastname);
//        });

        Function<Employee, String> getLastName = (Employee emp) -> {
            return emp.getName().substring(emp.getName().indexOf(' ')+1);
        };

        System.out.println(getLastName.apply(employees.get(1)));

        Function<Employee, String> getFirstName = (Employee emp) -> {
            return emp.getName().substring(0, emp.getName().indexOf(' '));
        };

        System.out.println(getFirstName.apply(employees.get(1)));

        Function<Employee, String> uppercase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chained = uppercase.andThen(firstName);

        System.out.println(chained.apply(employees.get(3)));

        String upperName = uppercase.apply(employees.get(2));
        BiFunction<String, Employee, String> concate = (name, employee) -> {
            return name.concat(" "+employee.getAge());
        };

        System.out.println(concate.apply(upperName, employees.get(2)));

        IntUnaryOperator incby5 = i -> i + 5;
        System.out.println(incby5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c2.accept("Hello World!");
    }

    private static void printEmployeesByAge(List<Employee> employees, String agrText,
                                            Predicate<Employee> condition)
    {
        System.out.println(agrText);
        System.out.println("++++++++++++++++++");
        for(Employee emp : employees)
            if(condition.test(emp))
                System.out.println(emp.getName());
    }
}
