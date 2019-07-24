package by.training.taxistation.entity.car;

import java.util.Objects;

public abstract class Car {

    /**
     * brand.
     */
    //TODO add search by id
    private CarBrand brand;
    /**
     * model.
     */
    private String model;
    /**
     *
     */
    private int cargoCapacity;
    /**
     *
     */
    private int passengerCapacity;

    /**
     * Plate number is also ID for car, must be unique.
     */
    private String plateNumber;
    /**
     * mileage.
     */
    private int mileage;
    /**
     * cost.
     */
    private int cost;

    public Car(final CarBrand newBrand,
               final String newModel,
               final int newCargoCapacity,
               final int newPassengerCapacity,
               final String newPlateNumber,
               final int newMileage,
               final int newCost) {
        brand = newBrand;
        model = newModel;
        cargoCapacity = newCargoCapacity;
        passengerCapacity = newPassengerCapacity;
        plateNumber = newPlateNumber;
        mileage = newMileage;
        cost = newCost;
    }

    /**
     * get brand.
     *
     * @return brand
     */
    public CarBrand getBrand() {
        return brand;
    }

    /**
     * set brand.
     *
     * @param carBrand brand
     */
    public void setBrand(final CarBrand carBrand) {
        brand = carBrand;
    }

    /**
     * get model.
     *
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * set model1.
     *
     * @param model1 model1
     */
    public void setModel(final String model1) {
        this.model = model1;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(final int newCargoCapacity) {
        cargoCapacity = newCargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(final int newPassengerCapacity) {
        passengerCapacity = newPassengerCapacity;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(final String newPlateNumber) {
        plateNumber = newPlateNumber;
    }

    /**
     * get mileage.
     *
     * @return mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * set mileage1.
     *
     * @param mileage1 mileage1
     */
    public void setMileage(final int mileage1) {
        this.mileage = mileage1;
    }

    /**
     * get cost.
     *
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * set cost1.
     *
     * @param cost1 cost1
     */
    public void setCost(final int cost1) {
        this.cost = cost1;
    }

    /**
     * equals.
     *
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
        Car car = (Car) object;
        return cost == car.cost
                && mileage == car.mileage
                && brand == car.brand
                && Objects.equals(model, car.model);
    }

    /**
     * hashCode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, cost, mileage);
    }

    /**
     * toString.
     *
     * @return toString
     */
    @Override
    public String toString() {
        return "Car " + print();
    }

    /**
     * toString.
     *
     * @return String
     */
    public String print() {
        return "brand="
                + brand
                + ", model='"
                + model + '\''
                + ", cargoCapacity="
                + cargoCapacity
                + ", passengerCapacity="
                + passengerCapacity
                + ", plateNumber='"
                + plateNumber + '\''
                + ", mileage="
                + mileage
                + ", cost="
                + cost + '}';
    }


}

