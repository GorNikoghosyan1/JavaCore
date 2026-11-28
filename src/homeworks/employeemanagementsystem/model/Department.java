package homeworks.employeemanagementsystem.model;

public enum Department {
    ENGINEERING("Software Development"),
    HR("Human Resources"),
    SALES("Sales Department"),
    MARKETING("Marketing Department"),
    FINANCE("Finance Department"),
    SUPPORT("Customer Support");

    private final String description;

    Department(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
