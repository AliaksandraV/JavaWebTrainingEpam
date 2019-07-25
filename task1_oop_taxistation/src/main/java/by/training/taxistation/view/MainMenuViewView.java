package by.training.taxistation.view;

public class MainMenuViewView extends BaseMenuView {
    /**
     * main meni string for print.
     */
    private String menu = "___________________________"
            + "__________________________\n"
            + "Список доступных действий:\n"
            + "1. Вывести список автомобилей.\n"
            + "2. Расчитать стоимость таксопарка.\n"
            + "3. Отсортировать автомобили по бренду.\n"
            + "4. Отсортировать автомобили по бренду и стоимости.\n"
            + "5. Найти автомобили с заданной пасажировместимостью.\n"
            + "6. Найти автомобили с заданной грузоподъемностью.\n"
            + "7. Добавить автомобиль на станцию.\n"
            + "8. Закончить работу.\n"
            + "Выберите действие: ";

    /**
     * print menu.
     */
    public void print() {
        System.out.print(menu);
    }

    /**
     * read input in console.
     *
     * @return input
     */
    public String readSelectedItemIndex() {
        return readInput();
    }
}
