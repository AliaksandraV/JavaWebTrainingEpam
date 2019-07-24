package by.training.taxistation.entity.car;

import java.util.Optional;

public enum CarBrand {
    /**
     * car brand name.
     */
    RENO("RENO"),
    /**
     * car brand name.
     */
    FORD("FORD"),
    /**
     * car brand name.
     */
    AUDI("AUDI"),
    /**
     * car brand name.
     */
    BMW("BMW"),
    /**
     * car brand name.
     */
    VOLKSWAGEN("VOLKSWAGEN"),
    /**
     * car brand name.
     */
    MAZDA("MAZDA"),
    /**
     * car brand name.
     */
    MERCEDES("MERCEDES"),
    /**
     * car brand name.
     */
    MAN("MAN");
    /**
     * car brand name string view.
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
