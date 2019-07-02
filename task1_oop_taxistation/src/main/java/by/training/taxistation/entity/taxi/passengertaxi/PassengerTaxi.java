package by.training.taxistation.entity.taxi.passengertaxi;

import by.training.taxistation.entity.taxi.Car;
import by.training.taxistation.entity.taxi.CarBrand;

import java.util.Objects;

public class PassengerTaxi extends Car {

    /**
     * passenger capacity.
     */
    private int passengerCapacity;

    /**
     * PassengerTaxi constructor.
     * @param brand brand
     * @param model model
     * @param cost cost
     * @param mileage mileage
     * @param passengerCapacity1 passenger capacity
     */
    public PassengerTaxi(final CarBrand brand,
                         final String model,
                         final int cost,
                         final int mileage,
                         final int passengerCapacity1) {
        super(brand, model, cost, mileage);
        this.passengerCapacity = passengerCapacity1;
    }

    /**
     * get passenger capacity.
     * @return passenger capacity
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * set passenger capacity.
     * @param pasCapacity passenger capacity
     */
    public void setPassengerCapacity(final int pasCapacity) {
        passengerCapacity = pasCapacity;
    }

    /**
     * equals.
     * @param object car
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
        if (!super.equals(object)) {
            return false;
        }
        PassengerTaxi that = (PassengerTaxi) object;
        return passengerCapacity == that.passengerCapacity;
    }

    /**
     * hashCode.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerCapacity);
    }

    /**
     * toString.
     * @return string
     */
    @Override
    public String toString() {
        return "PassengerTaxi "
                + super.print()
                + ", passengerCapacity="
                + passengerCapacity;
    }
}

