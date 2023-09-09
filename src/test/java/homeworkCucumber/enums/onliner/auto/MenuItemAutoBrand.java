package homeworkCucumber.enums.onliner.auto;

public enum MenuItemAutoBrand {

    AUDI("Audi"),

    BMW("BMW"),

    CITROEN("Citroen"),

    FORD("Ford"),

    MAZDA("Mazda"),

    MERCEDES_BENZ("Mercedes-Benz"),

    NISSAN("Nissan"),

    OPEL("Opel"),

    PEUGEOT("Peugeot"),

    RENAULT("Renault"),

    TOYOTA("Toyota"),

    VOLKSWAGEN("Volkswagen");


    private String value;

    MenuItemAutoBrand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

