package com.atexo.cartes.service;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class CardHandTests {

    @Autowired
    CardHand cardHand;

    @Autowired
    GeneratorOrder generatorOrder;

    @Test
    void testInstanceService() {
        Assertions.assertNotNull(cardHand);
        Assertions.assertNotNull(generatorOrder);
    }


    private List<CardSymbol> randomCardSymbols;
    private List<CardValue> randomCardValues;

    @BeforeEach
    void generateVariables(){
        randomCardSymbols =  generatorOrder.generateRandomCardSymbols();
        randomCardValues = generatorOrder.generateRandomCardValues();
    }

    @Test
    void testGeneratorCardHand(){
        try{
            int numberHandCards = Integer.valueOf(10);
            List<Card> hands = cardHand.generateCardHand(numberHandCards);
            Set<Card> handsSet = new HashSet<>(hands);
            Assertions.assertEquals(numberHandCards, hands.size());
            //Check if not duplicate value
            Assertions.assertEquals(handsSet.size(), hands.size());
        } catch(GamesException e ){
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testSortedCardHand(){

        try{
            int numberHandCards = Integer.valueOf(10);
            List<Card> hands = cardHand.generateCardHand(numberHandCards);
            List<Card> sortedHandCards = cardHand.sortCardHandByValueSymbols(hands, randomCardValues, randomCardSymbols );
            List<Card> refCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol( randomCardValues, randomCardSymbols);
            for(int i = 0; i<numberHandCards-1; i++){
                Assertions.assertTrue(refCustomOrder.indexOf(sortedHandCards.get(i)) < refCustomOrder.indexOf(sortedHandCards.get(i+1)));
            }
        } catch(GamesException e ){
            Assertions.fail(e.getMessage());
        }
    }

}
