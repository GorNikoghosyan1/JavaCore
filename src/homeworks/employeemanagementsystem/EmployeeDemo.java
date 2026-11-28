package homeworks.employeemanagementsystem;

import homeworks.employeemanagementsystem.storage.*;
import homeworks.employeemanagementsystem.exception.*;
import homeworks.employeemanagementsystem.model.*;

import java.util.Scanner;

public class EmployeeDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static CompanyStorage companyStorage = new CompanyStorage();
    private static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.printAll();
                    break;
                case SEARCH_EMPLOYEE_BY_ID:
                    searchEmployeeById();
                    break;
                case SEARCH_EMPLOYEES_BY_COMPANY_NAME:
                    searchEmployeeByCompanyName();
                    break;
                case ADD_COMPANY:
                    addCompany();
                    break;
                case PRINT_ALL_COMPANIES:
                    printAllCompanies();
                    break;
                case SEARCH_COMPANY_BY_ID:
                    searchCompanyById();
                    break;
                case PRINT_EMPLOYEES_BY_COMPANY_ID:
                    printEmployeesByCompanyID();
                    break;
                case CHANGE_EMPLOYEE_COMPANY:
                    changeEmployeeCompany();
                    break;
                case PRINT_EMPLOYEE_COMPANY:
                    printEmployeeCompany();
                    break;
                case CHANGE_EMPLOYEE_STATUS:
                    changeEmployeeStatus();
                    break;
                case SEARCH_EMPLOYEES_BY_STATUS:
                    searchEmployeesByStatus();
                    break;
                case SEARCH_EMPLOYEES_BY_DEPARTMENT:
                    searchEmployeesByDepartment();
                    break;
                case CHANGE_EMPLOYEE_SALARY:
                    changeEmployeeSalary();
                    break;
                case AVAILABLE_STATUSES:
                    printAvailableStatuses();
                    break;
                case AVAILABLE_DEPARTMENTS:
                    printAvailableDepartments();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    System.out.println();
            }
        }
    }

    private static void printAvailableDepartments() {
        System.out.println("Available departments:");
        System.out.println();
        for (Department department : Department.values()) {
            System.out.println(department);
        }
        System.out.println();
    }

    private static void printAvailableStatuses() {
        System.out.println("Available statuses:");
        System.out.println();
        for (EmployeeStatus status : EmployeeStatus.values()) {
            System.out.println(status);
        }
        System.out.println();
    }

    private static void changeEmployeeSalary() {
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        System.out.println();
        Employee employee;
        try {
            employee = employeeStorage.getById(employeeID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }

        System.out.println("Current salary: " + employee.getSalary());
        System.out.println();

        System.out.println("Enter new salary:");
        double newSalary = 0;
        try {
            newSalary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid salary. Please enter valid salary.");
            System.out.println();
            return;
        }
        try {
            employee.setSalary(newSalary);
        } catch (InvalidSalaryException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }
        System.out.println();

        System.out.println("Salary successfully updated.");
        System.out.println();
    }

    private static void searchEmployeesByStatus() {
        System.out.println("Enter Employee status:");
        for (EmployeeStatus status : EmployeeStatus.values()) {
            System.out.println(status);
        }
        System.out.println();
        String status = scanner.nextLine();
        EmployeeStatus employeeStatus;
        try {
            employeeStatus = EmployeeStatus.valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Please input valid status.");
            System.out.println();
            return;
        }
        employeeStorage.searchByStatus(employeeStatus);
    }

    private static void changeEmployeeStatus() {
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        Employee employee;
        try {
            employee = employeeStorage.getById(employeeID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }
        System.out.println("Current status: " + employee.getStatus());
        System.out.println();
        System.out.println("Enter new status:");
        for (EmployeeStatus status : EmployeeStatus.values()) {
            System.out.println(status);
        }
        System.out.println();
        String newStatusStr = scanner.nextLine();
        EmployeeStatus newStatus;
        try {
            newStatus = EmployeeStatus.valueOf(newStatusStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Please input valid status.");
            System.out.println();
            return;
        }

        try {
            if (employee.getStatus() == EmployeeStatus.FIRED && newStatus == EmployeeStatus.FIRED) {
                throw new EmployeeAlreadyFiredException("Error: Employee " + employeeID + " is already fired.");
            }
            employee.setStatus(newStatus);
            System.out.println("Employee status successfully updated.");
            System.out.println();
        } catch (EmployeeAlreadyFiredException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    private static void searchEmployeesByDepartment() {
        System.out.println("Enter employee department:");
        for (Department department : Department.values()) {
            System.out.println(department);
        }
        System.out.println();
        Department department;
        try {
            department = Department.valueOf(scanner.nextLine().trim().toUpperCase());
            employeeStorage.printEmployeesWithDepartment(department);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid department. Please input valid department.");
            System.out.println();
        }
    }

    private static void printEmployeeCompany() {
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        Employee employee;
        try {
            employee = employeeStorage.getById(employeeID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(employee.getName() + " " + employee.getSurname());
        System.out.println("Company information:");
        if (employee.getCompany() != null) {
            System.out.println(employee.getCompany());
        } else {
            System.out.println("Employee is not with the company.");
        }
    }

    private static void changeEmployeeCompany() {
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        System.out.println("Enter new company ID:");
        String newCompanyID = scanner.nextLine();
        employeeStorage.changeCompany(employeeID, newCompanyID, companyStorage);
    }

    private static void printEmployeesByCompanyID() {
        System.out.println("Enter company ID:");
        String companyID = scanner.nextLine();
        employeeStorage.printByCompanyId(companyID);
    }

    private static void searchCompanyById() {
        System.out.println("Enter company ID:");
        String companyID = scanner.nextLine();
        Company company;
        try {
            company = companyStorage.getById(companyID);
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }
        System.out.println("Company found:");
        System.out.println(company);
    }

    private static void printAllCompanies() {
        System.out.println("Companies:");
        companyStorage.printAllCompanies();
    }

    private static void searchEmployeeByCompanyName() {
        System.out.println("Enter company name:");
        String companyName = scanner.nextLine();
        employeeStorage.printByCompanyName(companyName);
    }

    private static void addCompany() {
        System.out.println("Enter company ID:");
        String companyID = scanner.nextLine();
        System.out.println();
        System.out.println("Enter company name:");
        String companyName = scanner.nextLine();
        System.out.println();
        System.out.println("Enter industry:");
        String companyIndustry = scanner.nextLine();
        System.out.println();
        System.out.println("Enter country:");
        String companyCountry = scanner.nextLine();

        Company company = new Company(companyName, companyID, companyIndustry, companyCountry);
        companyStorage.add(company);
    }

    private static void searchEmployeeById() {
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        Employee employee;
        try {
            employee = employeeStorage.getById(employeeID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }
        System.out.println("Employee found:");
        System.out.println(employee.getName() + " " + employee.getSurname());
        System.out.println("Position: " + employee.getPosition());
        if (employee.getCompany() != null) {
            System.out.println("Company: " + employee.getCompany().getName());
            System.out.println();
        } else {
            System.out.println("Employee is not with the company.");
            System.out.println();
        }
    }

    private static void addEmployee() {
        System.out.println("Enter Employee name:");
        String name = scanner.nextLine();

        System.out.println();
        System.out.println("Enter Employee surname:");
        String surname = scanner.nextLine();

        System.out.println();
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        System.out.println();
        try {
            employeeStorage.checkDuplicateId(employeeID);
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }

        boolean isRunSalary = true;
        double salary = 0;
        while (isRunSalary) {
            try {
                System.out.println("Enter Employee salary:");
                salary = Double.parseDouble(scanner.nextLine());
                isRunSalary = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary. Please enter valid salary now.");
            }
        }
        System.out.println();

        System.out.println("Enter Employee position:");
        String position = scanner.nextLine();
        System.out.println();

        System.out.println("Enter company ID:");
        String companyID = scanner.nextLine();
        Company company;
        try {
            company = companyStorage.getById(companyID);
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        } finally {
            System.out.println();
            System.out.println("Operation finished.");
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter Employee status:");
        for (EmployeeStatus status : EmployeeStatus.values()) {
            System.out.println(status);
        }
        System.out.println();
        EmployeeStatus employeeStatus;
        try {
            employeeStatus = EmployeeStatus.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Please input valid status.");
            System.out.println();
            return;
        }
        System.out.println();

        System.out.println("Enter Employee department:");
        for (Department department : Department.values()) {
            System.out.println(department);
        }
        System.out.println();
        Department department;
        try {
            department = Department.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid department. Please input valid department.");
            return;
        }

        try {
            Employee employee = new Employee(name, surname, employeeID, salary, company, position, employeeStatus, department);
            employeeStorage.add(employee);
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
            System.out.println();
        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
