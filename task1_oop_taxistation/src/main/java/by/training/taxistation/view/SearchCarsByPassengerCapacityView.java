package by.training.taxistation.view;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public class SearchCarsByPassengerCapacityView extends BaseMenuView {
    /**
     * print list of found cars.
     * @param cars list of found cars
     */
    public void print(final List<Car> cars) {
        System.out.println(
                "По указанным параметрам обнаружены следующие автомобили: ");
        printCars(cars);
    }

    /**
     * print label for input searching range.
     */
    public void printLabel() {
        System.out.println("Введите диапазон для поиска:");
    }

    /**
     * read input for <from> value.
     *
     * @return input
     */
    public String readFromInput() {
        System.out.print("от: ");
        return readInput();
    }

    /**
     * read input for <to> value.
     *
     * @return input
     */
    public String readToInput() {
        System.out.print("до: ");
        return readInput();
    }
}
