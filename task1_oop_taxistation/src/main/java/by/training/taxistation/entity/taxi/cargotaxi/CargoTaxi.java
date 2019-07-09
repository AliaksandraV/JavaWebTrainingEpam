package by.training.taxistation.entity.taxi.cargotaxi;

import by.training.taxistation.entity.taxi.Car;
import by.training.taxistation.entity.taxi.CarBrand;

import java.util.Objects;

public class CargoTaxi extends Car {

    /**
     * loadCapacity.
     */
    private int loadCapacity;

    public CargoTaxi(){

    }
    public CargoTaxi(int load){
this.loadCapacity = load;
    }

    /**
     * constructor.
     * @param brand brand
     * @param model model
     * @param cost cost
     * @param mileage mileage
     * @param load load
     */
    public CargoTaxi(final CarBrand brand,
                     final String model,
                     final int cost,
                     final int mileage,
                     final int load) {
        super(brand, model, cost, mileage);
        this.loadCapacity = load;
    }

    /**
     * get load capacity.
     * @return load capacity
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * set load capacity.
     * @param loadCapacity1 load capacity
     */
    public void setLoadCapacity(final int loadCapacity1) {
        this.loadCapacity = loadCapacity1;
    }

    /**
     * true if objects equals.
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
        CargoTaxi cargoTaxi = (CargoTaxi) object;
        return loadCapacity == cargoTaxi.loadCapacity;
    }

    /**
     * hashCode.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

    /**
     * to String.
     * @return String
     */
    @Override
    public String toString() {
        return "CargoTaxi "
                + super.print()
                + ", loadCapacity="
                + loadCapacity;
    }
}
