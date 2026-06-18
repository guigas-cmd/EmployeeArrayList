package Application;
import Entities.Employee;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // PART1 ---

        List<Employee> list = new ArrayList<>();
        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();
        Integer id;
        String name;
        Double salary;
        Double percentage;

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("How many employees will be registered? ");
            System.out.println("Emplyoee #" + i);

            System.out.print("id: " );
            id = sc.nextInt();
            while(hasID(list, id)){
                System.out.println("ID already taken, try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: " );
            name = sc.next();

            System.out.print("Salary: " );
            salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }
        System.out.println();


        // PART 2 ---

        System.out.print("Enter the employee ID that will have salary increase: ");
        int idSalary = sc.nextInt();

        // (list, idSalary) -> ref de args da funcao position
        // ** Integer pos = position(list, idSalary); or --
        Employee emp = list.stream().filter(x -> x.getID() == idSalary).findFirst().orElse(null); // stream que encontra o id em idSalary

        if (emp == null){
            System.out.printf("Entered ID [%d] || This ID does not exist..." , idSalary);
        } else {
            System.out.print("Enter the percentage: ");
            percentage = sc.nextDouble();
            emp.increaseSalary(percentage); // ... or --->
            // list.get(pos).increaseSalary(percentage); //
        }

        // FINAL --
        System.out.println();
        System.out.println("List of Employees:");
        for(Employee l : list){
            System.out.println(l);
        }
        sc.close();
    }

    public static boolean hasID(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getID() == id).findFirst().orElse(null);
        return emp != null;
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == id) { return i; }
        }
        return null;
    }

    }
