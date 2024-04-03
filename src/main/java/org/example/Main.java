package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "Jane", "Doe"));
        employeeList.add(new Employee(2, "Jack", "Black"));
        employeeList.add(new Employee(3, "John", "Doe"));
        employeeList.add(new Employee(1, "Jane", "Doe"));
        employeeList.add(new Employee(4, "Becky", "Smith"));
        employeeList.add(new Employee(2, "Jack", "Black"));

        List<Employee> duplicates = findDuplicates(employeeList);
        System.out.println("Duplicates:");
        for(Employee emp : duplicates){
            System.out.println(emp);
        }
        System.out.println("************************");

        Map<Integer, Employee> uniques = findUniques(employeeList);
        System.out.println("Unique Names:");
        for (Map.Entry<Integer, Employee> entry : uniques.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("************************");

    }
    public static List<Employee>  findDuplicates(List<Employee>  list){
        Set<Employee> notDuplicate = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();
        for(Employee employee : list){
            if(!notDuplicate.add(employee)){
                duplicates.add(employee);
            }
        }
        return duplicates;
    }
    public static Map<Integer, Employee>  findUniques(List<Employee>  list){
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Iterator<Employee> iterator = list.iterator();
        while(iterator.hasNext()){
            Employee emp = iterator.next();
            if(emp == null){
                System.out.println("Öyle biri yok");
                continue;
            }
            if(!uniqueMap.containsKey(emp.getId())){
                uniqueMap.put(emp.getId(), emp);
            }
        }
        return uniqueMap;
    }
    public static List<Employee>  removeDuplicates(List<Employee>  list){
        List<Employee> duplicates = findDuplicates(list);
        Map<Integer, Employee> uniqueMap = findUniques(list);

        List<Employee> uniques = new LinkedList<>(uniqueMap.values());
        uniques.removeAll(duplicates);
        return uniques;

    }
}