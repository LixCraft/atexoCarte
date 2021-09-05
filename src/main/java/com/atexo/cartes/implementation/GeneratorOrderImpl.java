package com.atexo.cartes.implementation;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.service.GeneratorOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GeneratorOrderImpl implements GeneratorOrder {

    @Override
    public List<CardSymbol> generateRandomCardSymbols() {
        List<CardSymbol> listCardSymbols = Arrays.asList(CardSymbol.values());
        Collections.shuffle(listCardSymbols);
        return listCardSymbols;
    }

    @Override
    public List<CardValue> generateRandomCardValues() {
        List<CardValue> listCardValues = Arrays.asList(CardValue.values());
        Collections.shuffle(listCardValues);

        return listCardValues;
    }

    @Override
    public List<Card> generateCustomOrderCardByValueThenSymbol(List<CardValue> orderValues, List<CardSymbol> orderSymbols) {
        List<Card> customOrderCard = new ArrayList<>();
        if (!CollectionUtils.isEmpty(orderValues) && !CollectionUtils.isEmpty(orderSymbols)) {
            for (CardValue cardValue : orderValues) {
                for (CardSymbol cardSymbol : orderSymbols) {
                    customOrderCard.add(new Card(cardValue, cardSymbol));
                }
            }
        }
        return customOrderCard;
    }
}
