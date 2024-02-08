package op.controller;

public enum LineValues {
    COMPANY(0),
    SYMBOL(1),
    CURRENTPRICE(2),
    PRICECHANGE(3),
    PERCENTCHANGE(4),
    YTDPERCENTCHANGE(5),
    YEARLYHIGH(6),
    YEARLYLOW(7),
    PERATIO(8);

    private final int value;

    LineValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
