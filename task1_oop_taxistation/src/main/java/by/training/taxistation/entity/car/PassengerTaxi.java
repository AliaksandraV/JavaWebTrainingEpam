package by.training.taxistation.entity.car;

public class PassengerTaxi extends Car {

    private boolean accessibleForChildren;
    private boolean accessibleForDisabled;

    protected PassengerTaxi(){
        super();
    }

    public PassengerTaxi(final CarBrand newBrand,
                         final String newModel,
                         final int newLoadCapacity,
                         final int newPassengerCapacity,
                         final String newPlateNumber,
                         final int newMileage,
                         final int newCost,
                         final boolean newAccessibleForChildren,
                         final boolean newAccessibleForDisabled) {
        super(newBrand,
                newModel,
                newLoadCapacity,
                newPassengerCapacity,
                newPlateNumber,
                newMileage,
                newCost);

        accessibleForChildren = newAccessibleForChildren;
        accessibleForDisabled = newAccessibleForDisabled;
    }

    public boolean isAccessibleForChildren() {
        return accessibleForChildren;
    }

    public void setAccessibleForChildren(final boolean newAccessibleForChildren) {
        accessibleForChildren = newAccessibleForChildren;
    }

    public boolean isAccessibleForDisabled() {
        return accessibleForDisabled;
    }

    public void setAccessibleForDisabled(final boolean newAccessibleForDisabled) {
        accessibleForDisabled = newAccessibleForDisabled;
    }
}

