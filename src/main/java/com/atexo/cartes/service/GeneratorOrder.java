package com.atexo.cartes.service;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;

import java.util.List;

public interface GeneratorOrder {

    List<CardSymbol> generateRandomCardSymbols();

    List<CardValue> generateRandomCardValues();

    List<Card> generateCustomOrderCardByValueThenSymbol(List<CardValue> orderValues, List<CardSymbol> orderSymbols);
}
