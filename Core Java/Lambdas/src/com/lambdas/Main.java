package com.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
//        new Thread(()-> {
//            System.out.println("Printing from Runnable");
//            System.out.println("Line 2");
//            System.out.println("This is a line 3");
//        }).start();

        Employee emp1 = new Employee("John Doe", 22);
        Employee emp2 = new Employee("Tim Berners", 31);
        Employee emp3 = new Employee("Snow White", 25);
        Employee emp4 = new Employee("Jack Hill", 30);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee emp1, Employee emp2) {
//                return emp1.getName().compareTo(emp2.getName());
//            }
//        });

//        Collections.sort(employees,
//                (em1, em2) -> em1.getName().compareTo(em2.getName()));
//
//        for(Employee emp : employees)
//        {
//            System.out.println(emp.getName()+" : "+emp.getAge());
//        }
//
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//
//        System.out.println(manipulate(uc, employees.get(0).getName(), employees.get(1).getName()));

    }

//    final static String manipulate(UpperConcat uc, String s1, String s2)
//    {
//        return uc.upperConcat(s1, s2);
//    }

}

interface UpperConcat
{
    public String upperConcat(String s1,  String s2);
}

