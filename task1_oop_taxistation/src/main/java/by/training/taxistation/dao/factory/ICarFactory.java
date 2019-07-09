package by.training.taxistation.dao.factory;

import by.training.taxistation.entity.taxi.cargotaxi.CargoTaxi;
import by.training.taxistation.entity.taxi.passengertaxi.Minibus;
import by.training.taxistation.entity.taxi.passengertaxi.Taxi;

public interface ICarFactory {

    CargoTaxi createCargoTaxi(String[] arr);

    Minibus createMinibus(String[] arr);

    Taxi createTaxi(String[] arr);
}
