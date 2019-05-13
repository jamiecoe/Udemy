package com.jamiecoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // How does Thread know what to do with a Lambda?
        // One of Thread class constructors accepts a Runnable parameter
        // Also it knows that Runnable interface only has one method (eg: run()) which takes no parameters
        // So its able to match the lambda expression (which also has no parameters) with the run() method
        // Lambda expressions can only be used like this with an interface that contains one method
	    new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Printing another from the Runnable");
        }).start();

	    Employee john = new Employee("John Doe", 30);
	    Employee jamie = new Employee("Jamie", 28);
	    Employee steve = new Employee("steve", 50);
	    Employee gel = new Employee("gel", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(jamie);
        employees.add(steve);
        employees.add(gel);

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }

        UpperConcat uc = (name1, name2) -> name1.toUpperCase() + name2.toUpperCase();

        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());

        System.out.println(sillyString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}
