package homeworks.employeecompany.storage;

import homeworks.employeecompany.model.Company;
import homeworks.employeecompany.model.Employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(employee.getEmployeeID())) {
                System.out.println("Employee with ID " + employee.getEmployeeID() + " already exists.");
                return;
            }
        }
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }

    private void extend() {
        Employee[] temp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, temp, 0, employees.length);
        employees = temp;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee getById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void printByCompanyName(String name) {
        boolean found = false;
        boolean headerPrinted = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany() != null && employees[i].getCompany().getName().equalsIgnoreCase(name)) {
                if (!headerPrinted) {
                    System.out.println("Employees:");
                    headerPrinted = true;
                }
                System.out.println(employees[i].getEmployeeID() + " - " + employees[i].getName() + " " + employees[i].getSurname());
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employees with company " + name + " not found.");
            System.out.println();
        }
    }

    public void printByCompanyId(String id) {
        boolean found = false;
        boolean headerPrinted = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany() != null && employees[i].getCompany().getCompanyID().equalsIgnoreCase(id)) {
                if (!found) {
                    System.out.println("Company: " + employees[i].getCompany().getName());
                    System.out.println();
                    found = true;
                }
                if (!headerPrinted) {
                    System.out.println("Employees:");
                    System.out.println();
                    headerPrinted = true;
                }
                System.out.println(employees[i].getEmployeeID() + " - " + employees[i].getName() + " " + employees[i].getSurname());
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No employees found for company ID: " + id);
        }
    }

    public void ChangeCompany(String employeeID, String newCompanyID, CompanyStorage companyStorage) {
        Employee employee = getById(employeeID);
        if (employee == null) {
            System.out.println("Employee with ID " + employeeID + " not found.");
            return;
        }
        Company newCompany = companyStorage.getById(newCompanyID);
        if (newCompany == null) {
            System.out.println("Company with ID " + newCompanyID + " not found.");
            return;
        }

        employee.setCompany(newCompany);
        System.out.println("Employee company successfully changed!\nNew company: " + newCompany.getName());
        System.out.println();
    }
}
