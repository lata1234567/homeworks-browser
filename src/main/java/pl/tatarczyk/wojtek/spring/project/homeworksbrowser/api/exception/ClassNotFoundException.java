package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception;

public class ClassNotFoundException extends Exception{
    public ClassNotFoundException(String message){
        super(message);
    }

    public ClassNotFoundException (String message, Throwable cause){
        super(message, cause);
    }
}
