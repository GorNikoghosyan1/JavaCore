package homeworks.employee;

public class EmployeeStorage {
    private Employee[] employeeArray = new Employee[10];
    private int size = 0;

    public void add(Employee e) {
        if (size == employeeArray.length) {
            extend();
        }
        employeeArray[size++] = e;
    }

    private void extend() {
        Employee[] temp = new Employee[employeeArray.length + 10];
        System.arraycopy(employeeArray, 0, temp, 0, employeeArray.length);
        employeeArray = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println(employeeArray[i]);
        }
    }

    public void searchById(String employeeID) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (employeeArray[i].getEmployeeID().equalsIgnoreCase(employeeID)) {
                System.out.println("Employee found");
                System.out.println(employeeArray[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + employeeID + " not found.");
            System.out.println();
        }
    }

    public void searchByCompany(String company) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (employeeArray[i].getCompany().equalsIgnoreCase(company)) {
                System.out.println(employeeArray[i].getName() + " - " + employeeArray[i].getPosition());
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found for company " + company);
            System.out.println();
        }
    }

    public boolean validationById(String id) {
        for (int i = 0; i < size; i++) {
            if (employeeArray[i].getEmployeeID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void searchByMinSalary(double minSalary) {
        boolean found = false;
        boolean headerPrinted = false;
        for (int i = 0; i < size; i++) {
            double employeeSalary = employeeArray[i].getSalary();
            if (employeeSalary >= minSalary) {
                if (!headerPrinted) {
                    System.out.println("Employees:");
                    System.out.println();
                    headerPrinted = true;
                }
                System.out.println(employeeArray[i].getName() + " " + employeeArray[i].getSurname() + " - " + employeeArray[i].getSalary());
                found = true;
            }
        }
        System.out.println();
        if (!found) {
            System.out.println("Employees with >= " + minSalary + " not found.");
        }
    }

    public void deleteById(String id) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employeeArray[i].getEmployeeID().equalsIgnoreCase(id)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID: " + id + " not found.");
            System.out.println();
            return;
        }

        for (int i = indexToDelete; i < size - 1; i++) {
            employeeArray[i] = employeeArray[i + 1];
        }

        employeeArray[size - 1] = null;
        size--;
        System.out.println("Employee with ID: " + id + " deleted.");
        System.out.println();
    }
}
