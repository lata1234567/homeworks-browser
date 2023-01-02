package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
