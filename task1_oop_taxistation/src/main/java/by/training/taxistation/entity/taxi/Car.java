package by.training.taxistation.entity.taxi;

import java.util.Objects;

public class Car {
    /**
     * brand.
     */
    private CarBrand brand;
    /**
     * model.
     */
    private String model;
    /**
     * cost.
     */
    private int cost;
    /**
     * mileage.
     */
    private int mileage;

    public Car(){

    }

    /**
     * Constructor.
     *
     * @param brand1   brand1
     * @param model1   model1
     * @param cost1    cost1
     * @param mileage1 mileage1
     */
    public Car(final CarBrand brand1,
               final String model1,
               final int cost1,
               final int mileage1) {
        brand = brand1;
        model = model1;
        cost = cost1;
        mileage = mileage1;
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
                + ", cost="
                + cost
                + ", mileage="
                + mileage;
    }
}

