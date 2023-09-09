package homeworkCucumber.enums.onliner.house;

public enum MenuItemPrice {

    BEFORE("До 30 000 $"),

    PRICE("30 000–80 000 $"),

    TO("От 80 000 $");

    private String value;

    MenuItemPrice(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

