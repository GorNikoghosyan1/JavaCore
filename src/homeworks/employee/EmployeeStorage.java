package homeworks.employee;

public class EmployeeStorage {
    private Employee[] employeesArray = new Employee[10];
    private int size = 0;
    private Employee employee = new Employee();

    public void add(Employee e) {
        if (size == employeesArray.length) {
            extend();
        }
        employeesArray[size++] = e;
    }

    public boolean validationById(String id) {
        for (int i = 0; i < size; i++) {
            if (employeesArray[i].getEmployeeID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private void extend() {
        Employee[] temp = new Employee[employeesArray.length + 10];
        System.arraycopy(employeesArray, 0, temp, 0, employeesArray.length);
        employeesArray = temp;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("employees not found");
            System.out.println();
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println();
                System.out.println("Employee " + (i + 1) + ":");
                System.out.println(employeesArray[i]);
            }
        }
    }

    public void searchById(String id) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (employeesArray[i].getEmployeeID().toUpperCase().contains(id.toUpperCase())) {
                System.out.println("Employee is found: ");
                System.out.println("Name: " + employeesArray[i].getName());
                System.out.println("Surname: " + employeesArray[i].getSurname());
                System.out.println("Employee ID: " + employeesArray[i].getEmployeeID());
                System.out.println("Salary: " + employeesArray[i].getSalary());
                System.out.println("Company: " + employeesArray[i].getCompany());
                System.out.println("Position: " + employeesArray[i].getPosition());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void searchByCompany(String company) {
        boolean found = false;
        boolean headerPrinted = false;
        for (int i = 0; i < size; i++) {
            if (employeesArray[i].getCompany().toUpperCase().contains(company.toUpperCase())) {
                if (!headerPrinted) {
                    System.out.println("Employees:");
                    headerPrinted = true;
                }
                System.out.println(employeesArray[i].getName() + " - " + employeesArray[i].getPosition());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found for company " + company);
        }
    }

    public void searchByMinSalary(int minSalary) {
        boolean headerPrinted = false;
        boolean found = false;
        for (int i = 0; i < size; i++) {
            int employeeSalary = Integer.parseInt(employeesArray[i].getSalary());
            if (employeeSalary >= minSalary) {
                if (!headerPrinted) {
                    System.out.println("Employees:");
                    headerPrinted = true;
                }
                System.out.println(employeesArray[i].getName() + " - " + employeesArray[i].getSalary());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employees with salary >= " + minSalary + " not found.");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
