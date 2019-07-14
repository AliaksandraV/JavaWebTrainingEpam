package by.training.taxistation.entity.car;

import java.util.Optional;

public enum CarBrand {
    /**
     * reno.
     */
    RENO("RENO"),
    /**
     * ford.
     */
    FORD("FORD"),
    /**
     * .
     */
    AUDI("AUDI"),
    /**
     * .
     */
    BMW("BMW"),
    /**
     * .
     */
    VOLKSWAGEN("VOLKSWAGEN"),
    /**
     * .
     */
    MAZDA("MAZDA"),
    /**
     * .
     */
    MERCEDES("MERCEDES"),

    MAN("MAN");

    /**
     * .
     */
    private String title;

    CarBrand(final String title1) {
        this.title = title1;
    }

    /**
     * String format for brand.
     *
     * @return string fomat for brand
     */
    public String getTitle() {
        return title;
    }

    /**
     * Look and return car brand.
     *
     * @param title string fomat for brand
     * @return brand
     */
    public static Optional<CarBrand> getByTitle(final String title) {
        for (CarBrand brand : values()) {
            if (brand.getTitle().equals(title)) {
                return Optional.of(brand);
            }
        }
        return Optional.empty();
    }

}
