package com.atexo.cartes.implementation;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;
import com.atexo.cartes.service.GeneratorCardGames;
import com.atexo.cartes.service.CardHand;
import com.atexo.cartes.service.GeneratorOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CardHandImpl implements CardHand {

    @Autowired
    GeneratorCardGames generatorCardGames;

    @Autowired
    GeneratorOrder generatorOrder;

    @Override
    public List<Card> generateCardHand(Integer numberCards) throws GamesException {

        List<Card> handCards = new ArrayList<>();
        List<Card> cardPackage =generatorCardGames.generateCard();
        if(numberCards >0 && !CollectionUtils.isEmpty(cardPackage) &&
                numberCards <= cardPackage.size()) {
            for(int i=0; i<numberCards; i++) {
                int indexCard = (int) (Math.random() * (cardPackage.size()));
                handCards.add(cardPackage.get(indexCard));
                cardPackage.remove(indexCard);
            }
        }

        return handCards;
    }

    @Override
    public List<Card> sortCardHandByValueSymbols(List<Card> cardsToSort, List<CardValue> orderValues , List<CardSymbol> orderSymbols) {

        List<Card> sortedHands = new ArrayList<>();
        if(!CollectionUtils.isEmpty(cardsToSort)
            && !CollectionUtils.isEmpty(orderSymbols)
            && !CollectionUtils.isEmpty(orderValues)){
            List<Card> refCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(orderValues, orderSymbols);
            Comparator<Card> comparatorCard = Comparator.comparing(item -> refCustomOrder.indexOf(item));
            sortedHands = cardsToSort.stream().sorted(comparatorCard).collect(Collectors.toList());
        }

        return sortedHands;
    }

    private List<Card> refSortedListCard(List<CardValue> orderValues, List<CardSymbol> orderSymbols, Class firstOrderClass){
        final List<CardValue> orderValuesList = new ArrayList<>(orderValues);
        final List<CardSymbol> orderSymbolList = new ArrayList<>(orderSymbols);
        List<Card> orderCardValues = new ArrayList<>();
        if(firstOrderClass.getClass().equals(CardSymbol.class)){{
            for(CardSymbol cardSymbol : orderSymbolList){
                for(CardValue cardValue : orderValuesList){
                    orderCardValues.add(new Card(cardValue, cardSymbol));
                }
            }
        }
            for(CardValue cardValue : orderValuesList){
                for(CardSymbol cardSymbol : orderSymbolList){
                    orderCardValues.add(new Card(cardValue, cardSymbol));
                }
            }

        }
        return orderCardValues;
    }
}
