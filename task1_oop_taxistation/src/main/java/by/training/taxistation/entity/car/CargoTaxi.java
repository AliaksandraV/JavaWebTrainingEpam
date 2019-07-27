package by.training.taxistation.entity.car;

import java.util.Objects;

public class CargoTaxi extends Car {

    /**
     * dimensions of area for placing cargo or equipment, measured in meters.
     */
    private double length;
    /**
     * dimensions of area for placing cargo or equipment, measured in meters.
     */
    private double width;
    /**
     * dimensions of area for placing cargo or equipment, measured in meters.
     */
    private double height;
    /**
     * dimensions of area for placing cargo or equipment,
     * measured in cubic meters.
     */
    private double volume;

    /**
     * constructor.
     *
     * @param newBrand             brand
     * @param newModel             model
     * @param newCargoCapacity     cargo capacity
     * @param newPassengerCapacity passenger capacity
     * @param newPlateNumber       plate number
     * @param newMileage           mileage
     * @param newCost              cost
     *                             //     * @param newLength length
     *                             //     * @param newWidth width
     *                             //     * @param newHeight height
     *                             //     * @param newVolume volume
     */
    protected CargoTaxi(final CarBrand newBrand,
                     final String newModel,
                     final int newCargoCapacity,
                     final int newPassengerCapacity,
                     final String newPlateNumber,
                     final int newMileage,
                     final int newCost) { //,
//                     final double newLength,
//                     final double newWidth,
//                     final double newHeight,
//                     final double newVolume) {
        super(newBrand,
                newModel,
                newCargoCapacity,
                newPassengerCapacity,
                newPlateNumber,
                newMileage,
                newCost);
//        length = newLength;
//        width = newWidth;
//        height = newHeight;
//        volume = newVolume;
    }

    /**
     * get Length.
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * set length.
     *
     * @param newLength length
     */
    public void setLength(final double newLength) {
        length = newLength;
    }

    /**
     * get width.
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * set width.
     *
     * @param newWidth width
     */
    public void setWidth(final double newWidth) {
        width = newWidth;
    }

    /**
     * get height.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * set height.
     *
     * @param newHeight height
     */
    public void setHeight(final double newHeight) {
        height = newHeight;
    }

    /**
     * get volume.
     *
     * @return volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * set volume.
     *
     * @param newVolume volume
     */
    public void setVolume(final double newVolume) {
        volume = newVolume;
    }

    /**
     * equals.
     *
     * @param o car
     * @return true if objects are equals
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CargoTaxi cargoTaxi = (CargoTaxi) o;
        return Double.compare(cargoTaxi.length, length) == 0
                && Double.compare(cargoTaxi.width, width) == 0
                && Double.compare(cargoTaxi.height, height) == 0
                && Double.compare(cargoTaxi.volume, volume) == 0;
    }

    /**
     * hashCode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, width, height, volume);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()
        + "CargoTaxi{"
                + "length=" + length
                + ", width=" + width
                + ", height=" + height
                + ", volume=" + volume
                + '}';
    }

    public static class Builder {
        /**
         * car brand.
         */
        private CarBrand brand;
        /**
         * car model.
         */
        private String model;
        /**
         * cargo capacity in in kilograms.
         */
        private int cargoCapacity;
        /**
         * passenger capacity number of seats except driver's seat.
         */
        private int passengerCapacity;
        /**
         * car plate number.
         */
        private String plateNumber;
        /**
         * number of kilometers travelled or covered by car.
         */
        private int mileage;
        /**
         * dollar value.
         */
        private int cost;
        /**
         * length of area for placing cargo, measured in meters.
         */
        private double length;
        /**
         * width of area for placing cargo, measured in meters.
         */
        private double width;
        /**
         * height of area for placing cargo, measured in meters.
         */
        private double height;
        /**
         * volume of area for placing cargo, measured in cubic meters.
         */
        private double volume;

        /**
         * set car brand.
         *
         * @param newBrand car brand
         * @return builder object with set brand
         */
        public Builder setBrand(final CarBrand newBrand) {
            brand = newBrand;
            return this;
        }

        /**
         * set car model.
         *
         * @param newModel car model
         * @return builder object with set model
         */
        public Builder setModel(final String newModel) {
            model = newModel;
            return this;
        }

        /**
         * set cargo capacity.
         *
         * @param newCargoCapacity cargo capacity
         * @return builder object with set cargo capacity
         */
        public Builder setCargoCapacity(final int newCargoCapacity) {
            cargoCapacity = newCargoCapacity;
            return this;
        }

        /**
         * set passenger capacity.
         *
         * @param newPassengerCapacity passenger capacity
         * @return builder object with set passenger capacity
         */
        public Builder setPassengerCapacity(final int newPassengerCapacity) {
            passengerCapacity = newPassengerCapacity;
            return this;
        }

        /**
         * set plate number.
         *
         * @param newPlateNumber plate number
         * @return builder object with set plate number
         */
        public Builder setPlateNumber(final String newPlateNumber) {
            plateNumber = newPlateNumber;
            return this;
        }

        /**
         * set mileage.
         *
         * @param newMileage mileage
         * @return builder object with set mileage
         */
        public Builder setMileage(final int newMileage) {
            mileage = newMileage;
            return this;
        }

        /**
         * set cost.
         *
         * @param newCost cost
         * @return builder object with set cost
         */
        public Builder setCost(final int newCost) {
            cost = newCost;
            return this;
        }

        /**
         * set length of area for placing cargo.
         *
         * @param newLength length of area for placing cargo in meters
         * @return builder object with set length
         */
        public Builder setLength(final double newLength) {
            length = newLength;
            return this;
        }

        /**
         * set width of area for placing cargo, measured in meters.
         *
         * @param newWidth width of area for placing cargo in meters
         * @return builder object with set width
         */
        public Builder setWidth(final double newWidth) {
            width = newWidth;
            return this;
        }

        /**
         * set height of area for placing cargo, measured in meters.
         *
         * @param newHeight height of area for placing cargo in meters
         * @return builder object with set height
         */
        public Builder setHeight(final double newHeight) {
            height = newHeight;
            return this;
        }

        /**
         * set volume of area for placing cargo, measured in cubic meters.
         *
         * @param newVolume volume of area for placing cargo in cubic meters
         * @return builder object with set volume
         */
        public Builder setVolume(final double newVolume) {
            volume = newVolume;
            return this;

        }

        /**
         * Build minibus object.
         *
         * @return instance of taxi
         */
        public CargoTaxi build() {
            CargoTaxi cargoTaxi = new CargoTaxi(brand,
                    model,
                    cargoCapacity,
                    passengerCapacity,
                    plateNumber,
                    mileage,
                    cost);
            cargoTaxi.height = height;
            cargoTaxi.length = length;
            cargoTaxi.width = width;
            cargoTaxi.volume = volume;
            return cargoTaxi;
            //,
//                    length,
//                    width,
//                    height,
//                    volume);
        }
    }

}
