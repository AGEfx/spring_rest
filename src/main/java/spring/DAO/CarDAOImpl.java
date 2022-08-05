package spring.DAO;

import spring.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Car> getAllCars() {
        Session session = sessionFactory.getCurrentSession();

        List<Car> cars = session.createQuery("from Car", Car.class).getResultList();

        return cars;
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(car);
    }

    @Override
    @Transactional
    public Car getCar(int id) {
        Session session = sessionFactory.getCurrentSession();
        Car car = session.get(Car.class, id);
        return car;
    }

    @Override
    @Transactional
    public void deleteCar(int id) {
        Session session = sessionFactory.getCurrentSession();
        Car car = session.get(Car.class, id);
        session.delete(car);
    }
}
