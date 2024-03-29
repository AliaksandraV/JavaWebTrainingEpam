package by.training.xml_xsd_web_parsing.service.papser;

public enum PostEnum {
    POSTS("posts"),
    IS_SENT("is-sent"),
    YEAR("year"),
    ID("id"),
    POST("post"),
    IMAGE_THEME("image_theme"),
    COUNTRY("country"),
    VALUABLE("valuable"),
    ZIP_CODE("zip_code"),
    CITY("city"),
    STREET("street"),
    HOUSE("house"),
    APARTMENTS("apartments"),
    ADDRESS_TO("address_to"),
    ADDRESS_FROM("address_from"),
    RECIPIENT("recipient"),
    ARTISTS("artists"),
    ARTIST("artists"),
    TYPE("type"),
    TEXT("text"),
    AUTHOR("author"),
    DATE("date"),
    EVENT("event"),
    THEME("theme"),
    PRODUCT("product");

    private String value;

    PostEnum(final String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }

    public static boolean contains(String test) {
        for (PostEnum c : PostEnum.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
