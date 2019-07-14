package by.training.taxistation.service.specification.sort;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.service.specification.SortCarSpecification;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByCarBrandImpl implements SortCarSpecification {

//    public List<Car> sortByCarBrand(TaxiStation station) {
//        return station.getAll()
//                .stream()
//                .sorted(Comparator.comparing(car -> car.getBrand().name()))
//                .collect(Collectors.toList());
//    }
}
