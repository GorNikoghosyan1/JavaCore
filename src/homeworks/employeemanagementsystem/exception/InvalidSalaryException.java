package homeworks.employeemanagementsystem.exception;

public class InvalidSalaryException extends RuntimeException {
    public InvalidSalaryException() {

    }

    public InvalidSalaryException(String message) {
        super(message);
    }
}
