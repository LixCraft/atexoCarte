package com.atexo.cartes.entity;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import lombok.Data;

import java.util.Objects;

@Data
public class Card {
    private CardValue value;
    private CardSymbol color;

    public Card() {
    }

    public Card(CardValue value, CardSymbol color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && color == card.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value.getLabel() +
                ", color=" + color.toString() +
                '}';
    }
}
