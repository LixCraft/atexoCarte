package com.atexo.cartes.constante;

public enum CardValue {

    AS(1, "AS"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "JACK"),
    QUEEN(12, "QUEEN"),
    KING(13, "KING");

    private Integer value;
    private String label;

    CardValue(Integer value, String symbol) {
        this.value = value;
        this.label = symbol;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "CardValue{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
