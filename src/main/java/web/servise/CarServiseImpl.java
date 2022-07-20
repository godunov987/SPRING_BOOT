package web.servise;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiseImpl {
    private final List<Car> cars;


    public CarServiseImpl(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList(int count) {
        return cars.size() >= count ?
                cars.stream().limit(count).collect(Collectors.toList()) : cars;


    }
}
