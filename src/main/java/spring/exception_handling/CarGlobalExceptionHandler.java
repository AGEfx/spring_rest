package spring.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CarIncorrectData> handleException(NoSuchCarException exception) {
        CarIncorrectData incorrectData = new CarIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<CarIncorrectData>(incorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CarIncorrectData> handleException(Exception exception){
        CarIncorrectData incorrectData = new CarIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<CarIncorrectData>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}
