package homeworks.employeemanagementsystem.storage;

import homeworks.employeemanagementsystem.exception.CompanyNotFoundException;
import homeworks.employeemanagementsystem.exception.DuplicateEmployeeException;
import homeworks.employeemanagementsystem.exception.EmployeeNotFoundException;
import homeworks.employeemanagementsystem.model.*;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee employee) throws DuplicateEmployeeException {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(employee.getEmployeeID())) {
                throw new DuplicateEmployeeException("Error: Employee with id " + employee.getEmployeeID() + " already exists.");
            }
        }
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
        System.out.println("Employee successfully added!");
        System.out.println();
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

    public Employee getById(String id) throws EmployeeNotFoundException {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(id)) {
                return employees[i];
            }
        }
        throw new EmployeeNotFoundException("Error: Employee with id " + id + " not found.");
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

    public void changeCompany(String employeeID, String newCompanyID, CompanyStorage companyStorage) {
        Employee employee;
        try {
            employee = getById(employeeID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        Company newCompany;
        try {
            newCompany = companyStorage.getById(newCompanyID);
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return;
        }

        employee.setCompany(newCompany);
        System.out.println("Employee company successfully changed!\nNew company: " + newCompany.getName());
        System.out.println();
    }

    public void printEmployeesWithDepartment(Department department) {
        boolean found = false;
        boolean headerPrinted = false;
        for (int i = 0; i < size; i++) {
            if (department != null && department.equals(employees[i].getDepartment())) {
                if (!headerPrinted) {
                    System.out.println("Employees in " + department + ":");
                    System.out.println();
                    headerPrinted = true;
                }
                System.out.println(employees[i].getEmployeeID() + " - " + employees[i].getName() + " " + employees[i].getSurname());
                found = true;
            }
        }
        System.out.println();
        if (!found) {
            System.out.println("Employee with department " + department + " not found.");
            System.out.println();
        }
    }

    public void searchByStatus(EmployeeStatus status) {
        boolean found = false;
        boolean headerPrinted = false;
        if (status == null) {
            System.out.println("No employees found with status null.");
            System.out.println();
            return;
        }
        for (int i = 0; i < size; i++) {
            if (status.equals(employees[i].getStatus())) {
                if (!headerPrinted) {
                    System.out.println(employees[i].getStatus() + " employees:");
                    System.out.println();
                    headerPrinted = true;
                }
                System.out.println(employees[i].getEmployeeID() + " - " + employees[i].getName() + " " + employees[i].getSurname());
                found = true;
            }
        }
        System.out.println();
        if (!found) {
            System.out.println("No employees found with status " + status);
            System.out.println();
        }
    }
}
