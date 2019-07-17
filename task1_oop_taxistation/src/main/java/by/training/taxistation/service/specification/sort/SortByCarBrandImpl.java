package by.training.taxistation.service.specification.sort;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.SortCarSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByCarBrandImpl implements SortCarSpecification {

//    public List<Car> sortByCarBrand(TaxiStation station) {
//        return station.getAll()
//                .stream()
//                .sorted(Comparator.comparing(car -> car.getBrand().name()))
//                .collect(Collectors.toList());
//    }

    public List<Car> sort(List<Car> cars) {
        cars.sort(Comparator.comparing((Car o) -> o.getBrand().getTitle()));
        return cars;
    }
}
