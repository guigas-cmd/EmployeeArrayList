package Application;

import Entities.Employee;

import java.net.IDN;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> emp = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();
        int ide;
        String nome;
        double salario;
        double percentage = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("How many employees will be registered? ");
            System.out.println("Emplyoee #" + i);

            System.out.print("id: " );
            ide = sc.nextInt();

            System.out.print("Name: " );
            nome = sc.next();

            System.out.print("Salary: " );
            salario = sc.nextDouble();

            Employee empArmazened = new Employee(ide, nome, salario);
            emp.add(empArmazened);
        }
        System.out.println();



        System.out.print("Enter the employee ID that will have salary increase: ");
        int idSearch = sc.nextInt();

        int count = 0;
        Employee employe = null; // instanciacao de objeto valendo nulo
        for (Employee x : emp){
            count++;
            if (x.getID() == idSearch){
                employe = x;

                System.out.print("Enter the percentage: ");
                percentage = sc.nextDouble();
                employe.increaseSalary(percentage);


                System.out.println("ID's correct = " + x);
                break;
            }
            else if (count == emp.size()){
                System.out.println("This ID does not exist!");
            }
        }

        System.out.println("List of Employees:");
        for(Employee x : emp){
            System.out.println(x);
        }
        sc.close();
    }
}
