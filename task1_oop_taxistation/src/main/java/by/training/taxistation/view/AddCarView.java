//package by.training.taxistation.view;
//
//import by.training.taxistation.entity.car.CarBrand;
//
//import java.util.Arrays;
//
//public class AddCarView extends BaseMenuView {
//
//    private String carChoiceMenu = "Выберите тип автомобиля:\n"
//            + "1. Пасажирское такси.\n"
//            + "2. Пасажирский микроавтобус.\n"
//            + "3. Грузовое такси.\n"
//            + "Выберите тип:";
//
//
//    public String printCarChoiceMenu() {
//        return inputValue(carChoiceMenu);
//    }
//
//    public String carBrandInput(CarBrand [] carBrands) {
//        System.out.print("Введите один из брэндов " + Arrays.toString(carBrands) + ":");
//        return readInput();
//    }
//
//    public String modelInput() {
//        return inputValue("Введите модель: ");
//    }
//
//    public String costInput() {
//        return inputValue("Введите стоимость: ");
//    }
//
//    public String mileageInput() {
//        return inputValue("Введите пробег: ");
//    }
//
//    public String passengerCapacityInput() {
//        return inputValue("Введите пасажирскую вместимость: ");
//    }
//
//    public String cargoCapacityInput() {
//        return inputValue("Введите грузоподъемность: ");
//    }
//
//    public String plateNumberInput(){
//        return inputValue("Введите номерной знак автомобиля: ");
//    }
//
//    private String inputValue(String label) {
//        System.out.print(label);
//        return readInput();
//    }
//
//
//}
