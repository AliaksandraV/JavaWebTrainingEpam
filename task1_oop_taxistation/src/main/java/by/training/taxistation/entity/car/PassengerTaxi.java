package by.training.taxistation.entity.car;

import java.util.Objects;

public abstract class PassengerTaxi extends Car {
    /**
     * true if car is accessible For Children transportation.
     */
    private boolean accessibleForChildren;
    /**
     * true if car is accessible For Disabled transportation.
     */
    private boolean accessibleForDisabled;

    /**
     * constructor.
     * @param newBrand brand
     * @param newModel model
     * @param newCargoCapacity cargo capacity
     * @param newPassengerCapacity passenger capacity
     * @param newPlateNumber plate number
     * @param newMileage mileage
     * @param newCost cost
     * @param newAccessibleForChildren true or false
     * @param newAccessibleForDisabled true or false
     */
    public PassengerTaxi(final CarBrand newBrand,
                         final String newModel,
                         final int newCargoCapacity,
                         final int newPassengerCapacity,
                         final String newPlateNumber,
                         final int newMileage,
                         final int newCost,
                         final boolean newAccessibleForChildren,
                         final boolean newAccessibleForDisabled) {
        super(newBrand,
                newModel,
                newCargoCapacity,
                newPassengerCapacity,
                newPlateNumber,
                newMileage,
                newCost);

        accessibleForChildren = newAccessibleForChildren;
        accessibleForDisabled = newAccessibleForDisabled;
    }

    /**
     * is car Accessible For Children.
     * @return true or false
     */
    public boolean isAccessibleForChildren() {
        return accessibleForChildren;
    }

    /**
     * set true if car Accessible For children transportation.
     * @param newAccessibleForChildren true or false
     */
    public void setAccessibleForChildren(
            final boolean newAccessibleForChildren) {
        accessibleForChildren = newAccessibleForChildren;
    }

    /**
     * info about car's Accessible For Disabled transportation.
     * @return true or false
     */
    public boolean isAccessibleForDisabled() {
        return accessibleForDisabled;
    }

    /**
     * set true if car Accessible For Disabled transportation.
     * @param newAccessibleForDisabled true or false
     */
    public void setAccessibleForDisabled(
            final boolean newAccessibleForDisabled) {
        accessibleForDisabled = newAccessibleForDisabled;
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
        PassengerTaxi that = (PassengerTaxi) o;
        return accessibleForChildren == that.accessibleForChildren
                && accessibleForDisabled == that.accessibleForDisabled;
    }

    /**
     * hashCode.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accessibleForChildren,
                accessibleForDisabled);
    }
}

