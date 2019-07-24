//package by.training.taxistation.сontroller.actions;
//
//import by.training.taxistation.entity.car.CarBrand;
//import by.training.taxistation.service.MenuHandlerService;
//import by.training.taxistation.view.AddCarView;
//import by.training.taxistation.сontroller.InputFormatException;
//import by.training.taxistation.сontroller.MainMenuController;
//import by.training.taxistation.сontroller.MenuChoiceException;
//import org.apache.log4j.Logger;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AddCarController extends BaseActionController {
//
//    private static final Logger log = Logger.getLogger(AddCarController.class);
//    private final AddCarView view = new AddCarView();
//    private final MenuHandlerService menuHandler = new MenuHandlerService();
//    private List<String> carParametrs = new ArrayList<>();
//
//    public AddCarController(final MainMenuController mainMenuController) {
//        super(mainMenuController);
//    }
//
//    @Override
//    public void internalRun() {
//        view.printCarChoiceMenu();
//        int carTypeChoise = getCarTypeIndex();
//        addCarWizard(carTypeChoise);
//
//
//    }
//
//    private Integer getCarTypeIndex() {
//        String input = view.readInput();
//        try {
//            validateCarTypeIndex(input);
//        } catch (InputFormatException e) {
//            log.info("Выбран несуществующий пункт меню.");
//            System.out.println("Повторите ввод: ");
//            return getCarTypeIndex();
//        }
//        return Integer.parseInt(input);
//    }
//
//    private void validateCarTypeIndex(String index) throws InputFormatException {
//        validateInt(index);
//        int input = Integer.valueOf(index);
//        if (input < 0 || input > 3) {
//            throw new MenuChoiceException();
//        }
//    }
//
//
//    private void addCarWizard(int carType) {
//        switch (carType) {
//            case 1:
//                carParametrs.add("taxi");
//                addCarParameters();
//                addTaxiParameters();
//                break;
//            case 2:
//                carParametrs.add("minibus");
//                addCarParameters();
//                addMinibusParameters();
//                break;
//            case 3:
//                carParametrs.add("cargotaxi");
//                addCarParameters();
//                addCargoTaxiParameters();
//                break;
//            default:
//                log.error("Введен несуществующий пункт меню");
//                throw new IllegalArgumentException("Введен несуществующий пункт меню");
//        }
//    }
//
//    private List<String> addCarParameters(){
//        List<String> carParametrs = new ArrayList<>();
//        carParametrs.add(carBrandInput());
//        carParametrs.add(view.modelInput());
//        carParametrs.add(view.cargoCapacityInput());
//        carParametrs.add(view.passengerCapacityInput());
//        carParametrs.add(view.plateNumberInput());
//        carParametrs.add(view.mileageInput());
//        carParametrs.add(view.costInput());
//        return carParametrs;
//    }
//
//    private String carBrandInput() {
//        String carBrand = view.carBrandInput(CarBrand.values()).toUpperCase();
//        try {
//            CarBrand.valueOf(carBrand);
//            return carBrand;
//        } catch (IllegalArgumentException e) {
//            log.error("Неверный ввод. Повторите.");
//            return carBrandInput();
//        }
//    }
//
//    private void carTypeWizard(int menuIndex) {
////        switch (menuIndex) {
////            case 1:
////                addTaxi();
////                break;
////            case 2:
////                addMinibus();
////                break;
////            case 3:
////                addCargoTaxi();
////                break;
////            default:
////                log.error("Введен несуществующий пункт меню");
////                throw new IllegalArgumentException("Введен несуществующий пункт меню");
////        }
//    }
//
//    private String inputValue(String label) {
//        System.out.print(label);
//        return readInput();
//        try {
//            return Integer.valueOf(readInput());
//        } catch (NumberFormatException e) {
//            log.error("Неверный ввод. Повторите.");
//            return inputValue(label);
//        }
//    }
//
//
//    protected void internalRun1() {
////        System.out.println(model.getCarChoiceMenu());
//
//        int index = getCarTypeIndex();
//
//        showAddCarWizard(index);
//
//        log.info("Автомобиль добавлен.");
//    }
//
//    private int getCarTypeIndex1(String carTypeIndex) {
//        try {
//            validateCarTypeIndex(carTypeIndex);
//            return Integer.valueOf(carTypeIndex);
//        } catch (InputFormatException exception) {
//            System.out.println(exception.getMessage());
//            return getCarTypeIndex();
//        }
//    }
//
//
//    private void carTypeWizard(int menuIndex) {
//        switch (menuIndex) {
//            case 1:
//                addTaxiParameters();
//                break;
//            case 2:
//                addMinibusParameters();
//                break;
//            case 3:
//                addCargoTaxiParameters();
//                break;
//            default:
//                log.error("Введен несуществующий пункт меню");
//                throw new IllegalArgumentException("Введен несуществующий пункт меню");
//        }
//    }
//
//    private void addTaxiParameters() {
////        CarBrand carBrand = CarBrand.valueOf(carBrandInput());
////        String carModel = modelInput();
////        int cost = costInput();
////        int mileage = mileageInput();
////        int passengerCapacity = passengerCapacityInput();
////
////        Taxi taxi = new Taxi(carBrand, carModel, cost, mileage, passengerCapacity);
////        model.addTaxi(taxi);
//    }
//
//    private void addMinibusParameters() {
////        CarBrand carBrand = CarBrand.valueOf(carBrandInput());
//        String carModel = modelInput();
//        int cost = costInput();
//        int mileage = mileageInput();
//        int passengerCapacity = passengerCapacityInput();
//
////        Minibus minibus = new Minibus(carBrand, carModel, cost, mileage, passengerCapacity);
////        model.addMinibus(minibus);
//    }
//
//    private void addCargoTaxiParameters() {
////        CarBrand carBrand = CarBrand.valueOf(carBrandInput());
//        String carModel = modelInput();
//        int cost = costInput();
//        int mileage = mileageInput();
//        int loadCapacity = inputLoadCapacity();
//
////        CargoTaxi cargoTaxi = new CargoTaxi(carBrand, carModel, cost, mileage, loadCapacity);
////        model.addCargoTaxi(cargoTaxi);
//    }
//
////    private String carBrandInput() {
//////        System.out.print("Введите брэнд" + Arrays.toString(CarBrand.values()) + ":");
////        String carBrand = readInput().toUpperCase();
////        try {
//////            CarBrand.valueOf(carBrand);
////            return carBrand;
////        } catch (IllegalArgumentException e) {
////            log.error("Неверный ввод. Повторите.");
////            return carBrandInput();
////        }
////    }
//
//
//}
