package spring.DAO;

import spring.entity.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> getAllCars();
    public void saveCar(Car car);
    public Car getCar(int id);
    public void deleteCar(int id);
}
