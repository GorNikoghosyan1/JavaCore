package homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();

    private static final String EXIT = "0";
    private static final String ADD_EMPLOYEE = "1";
    private static final String PRINT_ALL_EMPLOYEES = "2";
    private static final String SEARCH_EMPLOYEE_BY_ID = "3";
    private static final String SEARCH_EMPLOYEE_BY_COMPANY = "4";
    private static final String SEARCH_BY_MIN_SALARY = "5";
    private static final String DELETE_EMPLOYEE_BY_ID = "6";

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_EMPLOYEE:
                    employeeAdd();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_ID:
                    searchEmployeeById();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY:
                    searchEmployeeByCompany();
                    break;
                case SEARCH_BY_MIN_SALARY:
                    searchEmployeeByMinSalary();
                    break;
                case DELETE_EMPLOYEE_BY_ID:
                    deleteEmployeeById();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    System.out.println();
            }
        }
    }

    private static void deleteEmployeeById() {
        System.out.println("Please input employee ID:");
        String employeeID = scanner.nextLine();
        System.out.println();
        employeeStorage.deleteById(employeeID);
    }

    private static void searchEmployeeByMinSalary() {
        System.out.println("Please input minimum salary:");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        System.out.println();
        employeeStorage.searchByMinSalary(employeeSalary);
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Please input company name:");
        String company = scanner.nextLine();
        System.out.println();
        employeeStorage.searchByCompany(company);
    }

    private static void searchEmployeeById() {
        System.out.println("Please input employee ID:");
        String employeeID = scanner.nextLine();
        System.out.println();
        employeeStorage.searchById(employeeID);
    }

    private static void employeeAdd() {
        System.out.println("Please input employee id");
        String employeeID = scanner.nextLine();
        System.out.println();
        if (employeeStorage.validationById(employeeID)) {
            System.out.println("Employee with ID " + employeeID + " already exists.");
            System.out.println();
            return;
        }
        System.out.println("Please input employee name:");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("Please input employee surname:");
        String surname = scanner.nextLine();
        System.out.println();
        System.out.println("Please input employee salary:");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println();
        System.out.println("Please input employee company:");
        String company = scanner.nextLine();
        System.out.println();
        System.out.println("Please input employee position:");
        String position = scanner.nextLine();
        System.out.println();
        Employee employee = new Employee(name, surname, employeeID, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("Employee successfully added!");
        System.out.println();
    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_EMPLOYEE + " for ADD EMPLOYEE");
        System.out.println("Please input " + PRINT_ALL_EMPLOYEES + " for PRINT ALL EMPLOYEES");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_ID + " for SEARCH EMPLOYEE BY ID");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_COMPANY + " for SEARCH EMPLOYEE BY COMPANY");
        System.out.println("Please input " + SEARCH_BY_MIN_SALARY + " for SEARCH BY MINIMUM SALARY");
        System.out.println("Please input " + DELETE_EMPLOYEE_BY_ID + " for DELETE EMPLOYEE BY ID");
        System.out.println();
    }
}
