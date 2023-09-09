package homeworkCucumber.enums.onliner;

public enum MenuItemCity {

    MINSK("Минск"),

    GOMEL("Гомель"),

    MOGILEV("Могилев"),

    GRODNO("Гродно"),

    VITEBSK("Витебск"),

    BREST("Брест");


    private String value;

    MenuItemCity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

