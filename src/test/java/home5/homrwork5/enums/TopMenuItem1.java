package home5.homrwork5.enums;

public enum TopMenuItem1 {


    ELECTRONICS (1),

    COMPUTERS_AND_NETWORKS(2);


    public Integer getValue() {
        return value;
    }

    private Integer value;

    TopMenuItem1(Integer value) {

        this.value = value;
    }
}
