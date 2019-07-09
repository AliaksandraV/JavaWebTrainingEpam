package by.training.taxistation.dao.factory;

import by.training.taxistation.entity.taxi.CarBrand;
import by.training.taxistation.entity.taxi.cargotaxi.CargoTaxi;
import by.training.taxistation.entity.taxi.passengertaxi.Minibus;
import by.training.taxistation.entity.taxi.passengertaxi.Taxi;

public class CarFactory implements ICarFactory {

    @Override
    public Taxi createTaxi(String[] arr) {
        return new Taxi(
                CarBrand.valueOf(arr[1]),
                arr[2],
                getIntValue(arr[3]),
                getIntValue(arr[4]),
                getIntValue(arr[5]));
    }

    @Override
    public Minibus createMinibus(String[] arr) {
        return new Minibus(
                CarBrand.valueOf(arr[1]),
                arr[2],
                getIntValue(arr[3]),
                getIntValue(arr[4]),
                getIntValue(arr[5]));
    }

    @Override
    public CargoTaxi createCargoTaxi(String[] arr) {
        return new CargoTaxi(
                CarBrand.valueOf(arr[1]),
                arr[2],
                getIntValue(arr[3]),
                getIntValue(arr[4]),
                getIntValue(arr[5]));
    }

    private Integer getIntValue(String s) {
        return Integer.valueOf(s);
    }
}
