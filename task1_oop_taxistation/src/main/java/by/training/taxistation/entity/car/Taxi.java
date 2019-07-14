package by.training.taxistation.entity.car;

public class Taxi extends PassengerTaxi {

    /**
     * .
     */
    private boolean isMinivan;

    /**
     * .
     *
     * @param newBrand                d
     * @param newModel                d
     * @param newCargoCapacity        d
     * @param newPassengerCapacity    d
     * @param newPlateNumber          d
     * @param newMileage              d
     * @param newCost                 d
     * @param isAccessibleForChildren d
     * @param isAccessibleForDisabled d
     * @param isMinivanInfo           d
     */
    public Taxi(final CarBrand newBrand,
                final String newModel,
                final int newCargoCapacity,
                final int newPassengerCapacity,
                final String newPlateNumber,
                final int newMileage,
                final int newCost,
                final boolean isAccessibleForChildren,
                final boolean isAccessibleForDisabled,
                final boolean isMinivanInfo) {
        super(newBrand,
                newModel,
                newCargoCapacity,
                newPassengerCapacity,
                newPlateNumber,
                newMileage,
                newCost,
                isAccessibleForChildren,
                isAccessibleForDisabled);
        this.isMinivan = isMinivanInfo;
    }

    /**
     * .
     *
     * @return dd
     */
    public boolean isMinivan() {
        return isMinivan;
    }

    /**
     * .
     *
     * @param newMinivan d
     */
    public void setMinivan(final boolean newMinivan) {
        isMinivan = newMinivan;
    }

    /**
     * Inner class that build taxi instance.
     */
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
         * the car has a baby seat.
         */
        private boolean accessibleForChildren;
        /**
         * car can transport disabled.
         */
        private boolean accessibleForDisabled;
        /**
         * there are extra seats in the car.
         */
        private boolean isMinivan;

        /**
         * set car brand.
         * @param newBrand car brand
         * @return builder object with set brand
         */
        public Builder setBrand(final CarBrand newBrand) {
            brand = newBrand;
            return this;
        }

        /**
         * set car model.
         * @param newModel car model
         * @return builder object with set model
         */
        public Builder setModel(final String newModel) {
            model = newModel;
            return this;
        }

        /**
         * set cargo capacity.
         * @param newCargoCapacity cargo capacity
         * @return builder object with set cargo capacity
         */
        public Builder setCargoCapacity(final int newCargoCapacity) {
            cargoCapacity = newCargoCapacity;
            return this;
        }

        /**
         * set passenger capacity.
         * @param newPassengerCapacity passenger capacity
         * @return builder object with set passenger capacity
         */
        public Builder setPassengerCapacity(final int newPassengerCapacity) {
            passengerCapacity = newPassengerCapacity;
            return this;
        }

        /**
         * set plate number.
         * @param newPlateNumber plate number
         * @return builder object with set plate number
         */
        public Builder setPlateNumber(final String newPlateNumber) {
            plateNumber = newPlateNumber;
            return this;
        }

        /**
         * set mileage.
         * @param newMileage mileage
         * @return builder object with set mileage
         */
        public Builder setMileage(final int newMileage) {
            mileage = newMileage;
            return this;
        }

        /**
         * set cost.
         * @param newCost cost
         * @return builder object with set cost
         */
        public Builder setCost(final int newCost) {
            cost = newCost;
            return this;
        }

        /**
         * set true if car equipped with a child seat.
         * @param newAccessibleForChildren true if car has child seat
         * @return builder object with set accessibleForChildren value
         */
        public Builder setAccessibleForChildren(
                final boolean newAccessibleForChildren) {
            accessibleForChildren = newAccessibleForChildren;
            return this;
        }

        /**
         * set true if car adapted for the transport of disabled people.
         * @param newAccessibleForDisabled true if car adapted for the transport of disabled people
         * @return builder object with set accessibleForDisabled value
         */
        public Builder setAccessibleForDisabled(
                final boolean newAccessibleForDisabled) {
            accessibleForDisabled = newAccessibleForDisabled;
            return this;
        }

        /**
         * set true if car is minivan.
         * @param newMinivan true if car is minivan
         * @return builder object with set minivan value
         */
        public Builder setMinivan(final boolean newMinivan) {
            isMinivan = newMinivan;
            return this;
        }

        /**
         * Build taxi object.
         * @return instance of taxi
         */
        public Taxi build() {
            return new Taxi(brand,
                    model,
                    cargoCapacity,
                    passengerCapacity,
                    plateNumber,
                    mileage,
                    cost,
                    accessibleForChildren,
                    accessibleForDisabled,
                    isMinivan);
        }
    }
}
