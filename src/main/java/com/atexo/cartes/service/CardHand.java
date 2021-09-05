package com.atexo.cartes.service;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;

import java.util.List;
import java.util.Set;

public interface CardHand {

    List<Card> generateCardHand(Integer numberCards) throws GamesException;

    List<Card> sortCardHandByValueSymbols(List<Card> cardsToSort, List<CardValue> orderValues, List<CardSymbol> orderSymbols);
}
