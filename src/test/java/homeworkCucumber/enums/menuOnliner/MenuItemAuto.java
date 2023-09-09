package homeworkCucumber.enums.menuOnliner;

public enum MenuItemAuto {

    CAR_REVIEWS("Отзывы об авто"),

    NEW_CAR("Новые авто"),

    WITH_MILEAGE("С пробегом"),

    PRICE_WITH_VAT("Цена с НДС"),

    AUTO_TO("Авто до 4000 р."),

    AUTO_MORE("Авто до 10 000 р.");


    private String value;

    MenuItemAuto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

