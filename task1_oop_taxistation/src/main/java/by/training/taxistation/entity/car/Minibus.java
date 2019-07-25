package by.training.taxistation.entity.car;

import java.util.Objects;

public class Minibus extends PassengerTaxi {
    /**
     * true car make intercityT ransportation.
     */
    private boolean intercityTransportation;

    /**
     * constructor.
     * @param newBrand brand
     * @param newModel model
     * @param newCargoCapacity cargo capacity
     * @param newPassengerCapacity passenger capacity
     * @param newPlateNumber plate number
     * @param newMileage mileage
     * @param newCost cost
     * @param isAccessibleForChildren true or false
     * @param isAccessibleForDisabled true or false
     * @param isIntercityTransportation true or false
     */
    public Minibus(final CarBrand newBrand,
                   final String newModel,
                   final int newCargoCapacity,
                   final int newPassengerCapacity,
                   final String newPlateNumber,
                   final int newMileage,
                   final int newCost,
                   final boolean isAccessibleForChildren,
                   final boolean isAccessibleForDisabled,
                   final boolean isIntercityTransportation) {
        super(newBrand,
                newModel,
                newCargoCapacity,
                newPassengerCapacity,
                newPlateNumber,
                newMileage,
                newCost,
                isAccessibleForChildren,
                isAccessibleForDisabled);
        intercityTransportation = isIntercityTransportation;

    }

    /**
     * get is Intercity Transportation.
     * @return true or false
     */
    public boolean isIntercityTransportation() {
        return intercityTransportation;
    }

    /**
     * set value of Intercity Transportation.
     * @param newIntercityTransportation true or false
     */
    public void setIntercityTransportation(
            final boolean newIntercityTransportation) {
        intercityTransportation = newIntercityTransportation;
    }

    /**
     * equals.
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
        Minibus minibus = (Minibus) o;
        return intercityTransportation == minibus.intercityTransportation;
    }

    /**
     * hashCode.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), intercityTransportation);
    }

    /**
     * Inner class that build minibus instance.
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
        private boolean intercityTransportation;

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
         * set true if car equipped with a child seat.
         *
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
         * @param newAccessibleForDisabled true if car adapted for the transport
         *                                 of disabled people
         * @return builder object with set accessibleForDisabled value
         */
        public Builder setAccessibleForDisabled(
                final boolean newAccessibleForDisabled) {
            accessibleForDisabled = newAccessibleForDisabled;
            return this;
        }

        /**
         * set true if car involved in intercity transportation.
         * @param isIntercityTransportation true if car involved in intercity
         *                                  transportation
         * @return builder object with set intercityTransportation value
         */
        public Builder setIsIntercityTransportation(
                final boolean isIntercityTransportation) {
            intercityTransportation = isIntercityTransportation;
            return this;
        }

        /**
         * Build minibus object.
         *
         * @return instance of taxi
         */
        public Minibus build() {
            Minibus minibus = new Minibus(brand,
                    model,
                    cargoCapacity,
                    passengerCapacity,
                    plateNumber,
                    mileage,
                    cost,
                    accessibleForChildren,
                    accessibleForDisabled,
                    intercityTransportation);
            minibus.setBrand(brand);
            return minibus;

        }
    }


}
