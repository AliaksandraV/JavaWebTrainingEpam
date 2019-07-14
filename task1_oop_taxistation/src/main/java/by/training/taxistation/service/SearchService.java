package by.training.taxistation.service;

import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

//    public List<Car> findByLoadCapacity(TaxiStation station, int from, int to) {
//        return station.getCargoTaxis()
//                .stream()
//                .filter(cargoTaxi -> {
//                    int capacity = cargoTaxi.getCargoCapacity();
//                    return capacity >= from && capacity <= to;
//                })
//                .collect(Collectors.toList());
//    }
//
//    public List<Car> findByPassengerCapacity(TaxiStation station, int from, int to) {
//        return station.getPassengerTaxi()
//                .stream()
//                .filter(taxi -> {
//                    int capacity = taxi.getPassengerCapacity();
//                    return capacity >= from && capacity <= to;
//                })
//                .collect(Collectors.toList());
//    }
}
