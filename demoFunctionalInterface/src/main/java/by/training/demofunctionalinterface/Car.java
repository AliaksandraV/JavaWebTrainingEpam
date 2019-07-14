package by.training.demofunctionalinterface;

public class Car {
    private String name;
    private boolean isFullDrive;
    private boolean isGasEngine;

    public Car(final String newName, final boolean newIsFullDrive, final boolean newIsGasEngine) {
        name = newName;
        isFullDrive = newIsFullDrive;
        isGasEngine = newIsGasEngine;
    }



    public String getName() {
        return name;
    }

    public void setName(final String newName) {
        name = newName;
    }

    public boolean isFullDrive() {
        return isFullDrive;
    }

    public void setFullDrive(final boolean newFullDrive) {
        isFullDrive = newFullDrive;
    }

    public boolean isGasEngine() {
        return isGasEngine;
    }

    public void setGasEngine(final boolean newGasEngine) {
        isGasEngine = newGasEngine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", isFullDrive=" + isFullDrive +
                ", isGasEngine=" + isGasEngine +
                '}';
    }
}
