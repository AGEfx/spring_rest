package spring.exception_handling;

public class NoSuchCarException extends RuntimeException{
    public NoSuchCarException(String message){
        super(message);
    }

}
