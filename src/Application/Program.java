package Application;

import Entities.Employee;


import java.util.*;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();
        int id;
        String name;
        Double salary;
        Double percentage;

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("How many employees will be registered? ");
            System.out.println("Emplyoee #" + i);

            System.out.print("id: " );
            id = sc.nextInt();

            System.out.print("Name: " );
            name = sc.next();

            System.out.print("Salary: " );
            salary = sc.nextDouble();

            Employee empArmazened = new Employee(id, name, salary);
            list.add(empArmazened);
        }
        System.out.println();


        System.out.print("Enter the employee ID that will have salary increase: ");
        int idIncrease = sc.nextInt();

        Integer positionID = position(list, idIncrease); // ref (List<Employee> list, int id)...
        if (positionID == null){
            System.out.printf("Entered ID [%d] || This ID does not exist..." , idIncrease);
        } else {
            System.out.print("Enter the percentage: ");
            percentage = sc.nextDouble();
            list.get(positionID).increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of Employees:");
        for(Employee x : list){
            System.out.println(x);
        }
        sc.close();
    }

    // funcao que encontrara a posicao do id, caso contrario retornará null
    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == id) { return i; }
        }
        return null;
    }

    }
