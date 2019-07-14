package by.training.taxistation.service.specification.search;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.service.specification.SearchCarSpecification;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByPassengerCapacityCarSpecificationImpl implements SearchCarSpecification {

//    public List<Car> find(TaxiStation station, int from, int to) {
//        return station.getPassengerTaxi()
//                .stream()
//                .filter(taxi -> {
//                    int capacity = taxi.getPassengerCapacity();
//                    return capacity >= from && capacity <= to;
//                })
//                .collect(Collectors.toList());
//    }
}
