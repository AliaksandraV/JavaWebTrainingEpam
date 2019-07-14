package by.training.demofunctionalinterface;

import javafx.beans.DefaultProperty;

@FunctionalInterface
public interface CheckCar {

    public boolean test (Car car);

    default public boolean test1(Car car){
        return true;
    }

}
