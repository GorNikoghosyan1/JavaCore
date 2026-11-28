package homeworks.employeemanagementsystem.model;

import homeworks.employeemanagementsystem.exception.InvalidSalaryException;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String employeeID;
    private double salary;
    private Company company;
    private String position;
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;
    private Department department;

    public Employee(String name, String surname, String employeeID, double salary, Company company, String position, EmployeeStatus employeeStatus, Department department) {
        this.name = name;
        this.surname = surname;
        this.employeeID = employeeID;
        if (salary <= 0) {
            throw new InvalidSalaryException("Error: Salary must be greater than 0.");
        } else if (salary > 10_000_000) {
            throw new InvalidSalaryException("Error: Salary cannot exceed 10000000.");
        }
        this.salary = salary;
        this.company = company;
        this.position = position;
        this.employeeStatus = employeeStatus;
        this.department = department;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new InvalidSalaryException("Error: Salary must be greater than 0");
        } else if (salary > 10_000_000) {
            throw new InvalidSalaryException("Error: Salary cannot exceed 10000000.");
        }
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public EmployeeStatus getStatus() {
        return employeeStatus;
    }

    public void setStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        String companyName = "None";
        if (company != null && company.getName() != null) {
            companyName = company.getName();
        }
        return "Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Employee ID: " + employeeID + "\n"
                + "Salary: " + salary + "\n"
                + "Company: " + companyName + "\n"
                + "Position: " + position + "\n"
                + "Status: " + employeeStatus + "\n"
                + "Department: " + department + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeID, employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}
