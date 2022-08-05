package spring.Service;

import spring.DAO.CarDAO;
import spring.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDAO carDAO;

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public void saveCar(Car car) {
        carDAO.saveCar(car);
    }

    @Override
    public Car getCar(int id) {
        return carDAO.getCar(id);
    }

    @Override
    public void deleteCar(int id) {
        carDAO.deleteCar(id);
    }


}
