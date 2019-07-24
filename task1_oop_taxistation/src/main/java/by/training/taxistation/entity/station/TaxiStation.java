package by.training.taxistation.entity.station;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.PassengerTaxi;
import by.training.taxistation.entity.car.Taxi;
import by.training.taxistation.repository.factory.TaxiStationFactory;
import by.training.taxistation.repository.factory.TaxiStationFactoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaxiStation {
    //TODO это хранилище
    private List<Car> cars;

    private static TaxiStation taxiStationInstance;

    private TaxiStation(){
        cars = new ArrayList<>();
    }

    public static TaxiStation getTaxiStationInstance(){
        if(taxiStationInstance == null){
            return taxiStationInstance = new TaxiStation();
        }
        return taxiStationInstance;
    }

    public List<Car> getCars() {
        return cars;
    }
}
