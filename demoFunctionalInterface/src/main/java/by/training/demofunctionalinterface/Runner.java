package by.training.demofunctionalinterface;

public class Runner {

    public static void main(String[] args) {
        Car audiA3 = new Car("AudiA3", true, true);
        Car audiA6 = new Car("AudiA6", false, false);

        CheckCar checkCar = new CheckCar() {
            public boolean test(final Car car) {
                return car.isFullDrive();
            }
        };

        printTest(audiA3, checkCar);

        printTest(audiA3, new CheckCar() {
            public boolean test(final Car car) {
                return car.isFullDrive();
            }
        });

        printTest(audiA3, car -> car.isFullDrive());

        printTest(audiA3, Car::isFullDrive);
    }

    private static void printTest(Car car, CheckCar cheker){
        if (cheker.test(car)){
            System.out.println(car);
        }
    }
}
