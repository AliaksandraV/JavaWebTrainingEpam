package by.training.taxistation.dao;

import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.taxi.cargotaxi.CargoTaxi;
import by.training.taxistation.entity.taxi.passengertaxi.Minibus;
import by.training.taxistation.entity.taxi.passengertaxi.Taxi;

public interface ITaxiStationDao {

    TaxiStation loadTaxiStation();
    void addTaxi(Taxi carParameters);
    void addMinibus(Minibus carParameters);
    void addCargoTaxi(CargoTaxi carParameters);
}
