package by.training.taxistation.dao;

import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;

public interface ITaxiStationDao {

    TaxiStation loadTaxiStation();
    void addTaxi(Taxi carParameters);
    void addMinibus(Minibus carParameters);
    void addCargoTaxi(CargoTaxi carParameters);
}
