package home5.enums;

public enum TopMenuItem {

    CATALOG("Каталог"),

    NEWS("Новости"),

    AUTOSALES("Автобарахолка"),

    FLATSALES("Дома и квартиры"),

    SERVICES("Услуги"),;

    public String getValue() {
        return value;
    }

    private String value;

    TopMenuItem(String value) {
        this.value = value;
    }
}
