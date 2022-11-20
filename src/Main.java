import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("Welcome to employee database!");
            System.out.println("Choose 1,2 or 3.");
            main.showOptions();
            option = scan.nextInt();

            switch (option) {
                case 1 -> {
                    Employee employee = main.takeEmployeeInput();
                    main.addEmployee(employee);
                }
                case 2 -> main.showEmployeeList();
                case 3 -> System.exit(1);
            }

        }while (option != 3);
    }
    private static final ArrayList<Employee> employeeList = new ArrayList<>();
    private void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    public void showEmployeeList() {
        sortEmployeesById();
        System.out.println("Employee List:");
        if (employeeList.isEmpty()) {
            System.out.println("You haven't entered any employees.");
            System.out.println();
        } else {
            for (Employee employee : employeeList) {
                System.out.println("Id: " + employee.getId() + " Name: " + employee.getName() + " Salary per month: " + employee.getSalary());
            }
            System.out.println();
        }
    }
    private void showOptions() {
        System.out.println("1. Add a new employee");
        System.out.println("2. Print employee list");
        System.out.println("3. Exit the system");
    }
    private Employee takeEmployeeInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        System.out.println("Enter salary:");
        int salary = scan.nextInt();
        System.out.println("Enter id: ");
        int id = scan.nextInt();

        return new Employee(name, salary, id);
    }
    static Employee[] ListToArray() {
        Employee[] employeeArray = new Employee[Main.employeeList.size()];
        for (int j = 0; j < Main.employeeList.size(); j++) {
            employeeArray[j] = Main.employeeList.get(j);
        }
        return employeeArray;
    }//these (ListToArray and ArrayToList) help to put employees in order according to their ids when you choose see all the employees (number 2).

    static void ArrayToList(Employee[] employeeArray) {
        for (int m = 0; m < employeeArray.length; m++) {
            Main.employeeList.set(m, employeeArray[m]);
        }
    }
    static void sortEmployeesById() {
        Employee[] employeeArray = ListToArray();
        for (int v = 0; v < employeeArray.length - 1; v++) {
            int smallestInd = v;
            for (int d = v + 1; d < employeeArray.length; d++) {
                if (employeeArray[smallestInd].id > (employeeArray[d].id)) {
                    smallestInd = d;
                }
                if (v != smallestInd) {
                    Employee tmp = employeeArray[smallestInd];
                    employeeArray[smallestInd] = employeeArray[v];
                    employeeArray[v] = tmp;
                }
            }
        }
        ArrayToList(employeeArray);
    }
    static class Employee {
        private final String name;
        private final int salary;
        private final int id;

        Employee(String name, int salary, int id) {
            this.name = name;
            this.salary = salary;
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public Integer getSalary() {
            return salary;
        }
        public Integer getId() {
            return id;
        }
    }
}