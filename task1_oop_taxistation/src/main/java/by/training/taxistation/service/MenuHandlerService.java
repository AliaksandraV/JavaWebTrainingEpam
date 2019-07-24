package by.training.taxistation.service;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;
import by.training.taxistation.service.specification.search.SearchByLoadCapacityCarSpecificationImpl;
import by.training.taxistation.service.specification.search.SearchByPassengerCapacityCarSpecificationImpl;
import by.training.taxistation.service.specification.sort.SortByCarBrandAndCostImpl;
import by.training.taxistation.service.specification.sort.SortByCarBrandImpl;

import java.util.ArrayList;
import java.util.List;

public class MenuHandlerService {

    private final CarService carService = new CarServiceImpl();
    private List<Car> cars = new ArrayList<>(); //TODO подумать наверное не надо это поле сюда выносить
    private CarSpecification specification;

    public int carsCost(){
        cars.addAll(carService.read());
        int sum = 0;
        for (Car car: cars){
            sum += car.getCost();
        }
        return sum;
    }

    public List<Car> carsSortedByBrand(){
        specification = new SortByCarBrandImpl();
        return carService.query(specification);
    }

    public List<Car> carsSortedByBrandAndCost(){
        specification = new SortByCarBrandAndCostImpl();
        return carService.query(specification);
    }

    public List <Car> searchCarsByPassengerCapacity(int from, int to){
        specification = new SearchByPassengerCapacityCarSpecificationImpl(from, to);
        return carService.query(specification);
    }

    public List<Car> searchCarsByLoadCapacity(int from, int to){
        specification = new SearchByLoadCapacityCarSpecificationImpl(from, to);
        return carService.query(specification);
    }


}
