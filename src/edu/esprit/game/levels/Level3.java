package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {
    public static void main(String[] args) {
        List<Employee> employees = Data.employees();

        /* TO DO 1: Return a string containing all employee names */
        String names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("String containing all employee names: " + names);

        /* TO DO 2: Return a string containing all employee names in uppercase separated by # */
        String namesMajSplit = employees.stream()
                .map(employee -> employee.getName().toUpperCase())
                .collect(Collectors.joining("#"));
        System.out.println("String containing all employee names in uppercase separated by # : " + namesMajSplit);

        /* TO DO 3: Return a set of employees */
        Set<Employee> emps = employees.stream().collect(Collectors.toSet());
        System.out.println("Set of employees:");
        emps.forEach(System.out::println);

        /* TO DO 4: Return a TreeSet of employees (sorted by name) */
        TreeSet<Employee> emps2 = employees.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
        System.out.println("TreeSet of employees (sorted by name):");
        emps2.forEach(System.out::println);

        /* TO DO 5: Return a Map that groups employees by salary */
        Map<Integer, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("Map that groups employees by salary:");
        for (Map.Entry<Integer, List<Employee>> entry : map.entrySet()) {
            System.out.println("Salary: " + entry.getKey());
            for (Employee employee : entry.getValue()) {
                System.out.println("\t" + employee.getName());
            }
        }

        /* TO DO 6: Return a Map that groups employee names by salary */
        Map<Integer, String> mm = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println("Map that groups employee names by salary:");
        for (Map.Entry<Integer, String> entry : mm.entrySet()) {
            System.out.println("Salary: " + entry.getKey());
            System.out.println("\tNames: " + entry.getValue());
        }

        /* TO DO 7: Return the min, max, average, sum, and count of salaries */
        String s = employees.stream()
                .mapToInt(Employee::getSalary)
                .summaryStatistics()
                .toString();
    }
}
