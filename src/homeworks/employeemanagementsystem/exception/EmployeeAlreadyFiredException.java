package homeworks.employeemanagementsystem.exception;

public class EmployeeAlreadyFiredException extends RuntimeException {
    public EmployeeAlreadyFiredException() {

    }

    public EmployeeAlreadyFiredException(String message) {
        super(message);
    }
}
