package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Service.CarService;
import spring.entity.Car;
import spring.exception_handling.CarIncorrectData;
import spring.exception_handling.NoSuchCarException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable int id){
        Car car = carService.getCar(id);
        if (car == null){
            throw new NoSuchCarException("Машины с id = " + id + " не существует");
        }

        return car;
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car){
        carService.saveCar(car);
        return car;
    }
    @PutMapping("/cars")
    public Car editCar(@RequestBody Car car){
        carService.saveCar(car);
        return car;
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable int id){
        Car car = carService.getCar(id);
        if (car != null) {
            carService.deleteCar(id);
            return "Машина с id = " + id + " была успешно удалена";
        }else{
            throw new NoSuchCarException("Машины с id = " + id + " не существует");
        }
    }
}
