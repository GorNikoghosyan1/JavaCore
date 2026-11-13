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
                    addEmployee();
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
                    searchByMinSalary();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    System.out.println();
            }
        }
    }

    private static void searchByMinSalary() {
        System.out.println("Please input minimum salary");
        String minSalaryStr = scanner.nextLine();
        double minSalaryDouble = Double.parseDouble(minSalaryStr);
        employeeStorage.searchByMinSalary(minSalaryDouble);
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Please input company");
        String company = scanner.nextLine();
        employeeStorage.searchByCompany(company);
    }

    private static void searchEmployeeById() {
        System.out.println("Please input ID");
        String id = scanner.nextLine();
        employeeStorage.searchById(id);
    }

    private static void addEmployee() {
        System.out.println("Please input employee ID:");
        String employeeID = scanner.nextLine();
        if (employeeStorage.validationById(employeeID)) {
            System.out.println("Employee with ID " + employeeID + " already exists.");
            return;
        }
        System.out.println("Please input employee name:");
        String employeeName = scanner.nextLine();
        System.out.println("Please input employee surname:");
        String employeeSurname = scanner.nextLine();
        System.out.println("Please input employee salary:");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input employee company:");
        String employeeCompany = scanner.nextLine();
        System.out.println("Please input employee position:");
        String employeePosition = scanner.nextLine();

        Employee employee = new Employee(employeeName, employeeSurname, employeeID, employeeSalary, employeeCompany, employeePosition);
        employeeStorage.add(employee);
        System.out.println("Employee added");
    }

    private static void printCommands() {
        System.out.println();
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_EMPLOYEE + " for ADD EMPLOYEE");
        System.out.println("Please input " + PRINT_ALL_EMPLOYEES + " for PRINT ALL EMPLOYEES");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_ID + " for SEARCH EMPLOYEE BY ID");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_COMPANY + " for SEARCH EMPLOYEES BY COMPANY NAME");
        System.out.println("Please input " + SEARCH_BY_MIN_SALARY + " for SEARCH EMPLOYEES BY MINIMUM SALARY");
        System.out.println();
    }
}
