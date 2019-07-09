package by.training.taxistation.entity.station;

import by.training.taxistation.entity.taxi.Car;
import by.training.taxistation.entity.taxi.cargotaxi.CargoTaxi;
import by.training.taxistation.entity.taxi.passengertaxi.Minibus;
import by.training.taxistation.entity.taxi.passengertaxi.PassengerTaxi;
import by.training.taxistation.entity.taxi.passengertaxi.Taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaxiStation {

    /**
     * list of taxis.
     */
    private final List<Taxi> taxis = new ArrayList<>();
    /**
     * list of minibuses.
     */
    private final List<Minibus> minibuses = new ArrayList<>();
    /**
     * list of cargo taxis.
     */
    private final List<CargoTaxi> cargoTaxis = new ArrayList<>();

    /**
     * default constructor.
     */
    public TaxiStation() {

    }

    /**
     * get list of all cars at taxi station.
     *
     * @return list of cars
     */
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        cars.addAll(taxis);
        cars.addAll(minibuses);
        cars.addAll(cargoTaxis);
        return cars;
    }

    /**
     * get list of passenger taxis.
     *
     * @return list of passenger taxis
     */
    public List<PassengerTaxi> getPassengerTaxi() {
        List<PassengerTaxi> passengerTaxis = new ArrayList<>();
        passengerTaxis.addAll(taxis);
        passengerTaxis.addAll(minibuses);
        return passengerTaxis;
    }

    /**
     * get list of taxis.
     *
     * @return list of taxis
     */
    public List<Taxi> getTaxis() {
        return taxis;
    }

    /**
     * get list of minibuses.
     *
     * @return list of minibuses
     */
    public List<Minibus> getMinibuses() {
        return minibuses;
    }

    /**
     * get list of cargo taxis.
     *
     * @return list of cargo taxis
     */
    public List<CargoTaxi> getCargoTaxis() {
        return cargoTaxis;
    }

    /**
     * equals.
     *
     * @param object taxi station
     * @return true if objects equals
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        TaxiStation that = (TaxiStation) object;
        return Objects.equals(taxis, that.taxis)
                && Objects.equals(minibuses, that.minibuses)
                && Objects.equals(cargoTaxis, that.cargoTaxis);
    }

    /**
     * hashCode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(taxis, minibuses, cargoTaxis);
    }

    /**
     * toString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "TaxiStation{"
                + "taxis=" + taxis
                + ", minibuses=" + minibuses
                + ", cargoTaxis=" + cargoTaxis + '}';
    }
}
