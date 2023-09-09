package homeworkCucumber.enums.onliner.house;

public enum MenuItemFlats {

    ONE_ROOM("1-комнатные"),

    TWO_ROOMS("2-комнатные"),

    THREE_ROOMS("3-комнатные"),

    FOUR_PLUS_MINUS("4+-комнатные");


    private String value;

    MenuItemFlats(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

