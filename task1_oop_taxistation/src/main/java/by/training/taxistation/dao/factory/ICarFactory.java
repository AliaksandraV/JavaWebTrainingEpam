package by.training.taxistation.dao.factory;

import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;

public interface ICarFactory {

    CargoTaxi createCargoTaxi(String[] arr);

    Minibus createMinibus(String[] arr);

    Taxi createTaxi(String[] arr);
}
