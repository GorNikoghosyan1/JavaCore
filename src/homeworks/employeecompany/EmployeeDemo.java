package homeworks.employeecompany;

import homeworks.employeecompany.model.Company;
import homeworks.employeecompany.model.Employee;
import homeworks.employeecompany.storage.CompanyStorage;
import homeworks.employeecompany.storage.EmployeeStorage;

import java.text.ParseException;
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
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void printEmployeeCompany() {
        System.out.println("Enter Employee ID:");
        String employeeID = scanner.nextLine();
        Employee employee = employeeStorage.getById(employeeID);
        if (employee == null) {
            System.out.println("Employee with ID " + employeeID + " not found.");
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
        Company company = companyStorage.getById(companyID);
        if (company == null) {
            System.out.println("Company with ID " + companyID + " not found.");
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
        Employee employee = employeeStorage.getById(employeeID);
        if (employee == null) {
            System.out.println("Employee with ID " + employeeID + " not found.");
            return;
        }
        System.out.println("Employee found:");
        System.out.println(employee.getName() + " " + employee.getSurname());
        System.out.println("Position: " + employee.getPosition());
        if (employee.getCompany() != null) {
            System.out.println("Company: " + employee.getCompany().getName());
        } else {
            System.out.println("Employee is not with the company.");
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
        Company company = companyStorage.getById(companyID);
        if (company == null) {
            System.err.println("Company with ID " + companyID + " not found.\nPlease add the company first.");
            System.out.println();
            return;
        }
        Employee employee = new Employee(name, surname, employeeID, salary, company, position);
        employeeStorage.add(employee);
    }
}
