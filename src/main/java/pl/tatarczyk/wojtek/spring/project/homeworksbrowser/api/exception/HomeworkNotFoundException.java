package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception;

public class HomeworkNotFoundException extends Exception{
    public HomeworkNotFoundException(String message) {
        super(message);
    }

    public HomeworkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
