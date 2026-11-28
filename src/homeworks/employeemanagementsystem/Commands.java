package homeworks.employeemanagementsystem;

public interface Commands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String PRINT_ALL_EMPLOYEES = "2";
    String SEARCH_EMPLOYEE_BY_ID = "3";
    String SEARCH_EMPLOYEES_BY_COMPANY_NAME = "4";
    String ADD_COMPANY = "5";
    String PRINT_ALL_COMPANIES = "6";
    String SEARCH_COMPANY_BY_ID = "7";
    String PRINT_EMPLOYEES_BY_COMPANY_ID = "8";
    String CHANGE_EMPLOYEE_COMPANY = "9";
    String PRINT_EMPLOYEE_COMPANY = "10";
    String CHANGE_EMPLOYEE_STATUS = "11";
    String SEARCH_EMPLOYEES_BY_STATUS = "12";
    String SEARCH_EMPLOYEES_BY_DEPARTMENT = "13";
    String CHANGE_EMPLOYEE_SALARY = "14";
    String AVAILABLE_STATUSES = "15";
    String AVAILABLE_DEPARTMENTS = "16";

    static void printCommands() {
        System.out.println(EXIT + " - EXIT");
        System.out.println();
        System.out.println(ADD_EMPLOYEE + " - ADD EMPLOYEE");
        System.out.println(PRINT_ALL_EMPLOYEES + " - PRINT ALL EMPLOYEES");
        System.out.println(SEARCH_EMPLOYEE_BY_ID + " - SEARCH EMPLOYEE BY ID");
        System.out.println(SEARCH_EMPLOYEES_BY_COMPANY_NAME + " - SEARCH EMPLOYEES BY COMPANY NAME");
        System.out.println();
        System.out.println(ADD_COMPANY + " - ADD COMPANY");
        System.out.println(PRINT_ALL_COMPANIES + " - PRINT ALL COMPANIES");
        System.out.println(SEARCH_COMPANY_BY_ID + " - SEARCH COMPANY BY ID");
        System.out.println(PRINT_EMPLOYEES_BY_COMPANY_ID + " - PRINT EMPLOYEES BY COMPANY ID");
        System.out.println(CHANGE_EMPLOYEE_COMPANY + " - CHANGE EMPLOYEE COMPANY");
        System.out.println(PRINT_EMPLOYEE_COMPANY + " - PRINT EMPLOYEE COMPANY");
        System.out.println(CHANGE_EMPLOYEE_STATUS + " - CHANGE EMPLOYEE STATUS");
        System.out.println(SEARCH_EMPLOYEES_BY_STATUS + " - SEARCH EMPLOYEES BY STATUS");
        System.out.println(SEARCH_EMPLOYEES_BY_DEPARTMENT + " - SEARCH EMPLOYEES BY DEPARTMENT");
        System.out.println(CHANGE_EMPLOYEE_SALARY + " - CHANGE EMPLOYEE SALARY");
        System.out.println(AVAILABLE_STATUSES + " - PRINT AVAILABLE STATUSES");
        System.out.println(AVAILABLE_DEPARTMENTS + " - PRINT AVAILABLE DEPARTMENTS");
        System.out.println();
    }
}
