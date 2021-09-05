package com.atexo.cartes.service;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class GeneratorOrderTests {

    @Autowired
    GeneratorOrder generatorOrder;

    private List<CardSymbol> randomCardSymbols;
    private List<CardValue> randomCardValues;

    @BeforeEach
    void generateVariables(){
        randomCardSymbols =  generatorOrder.generateRandomCardSymbols();
        randomCardValues = generatorOrder.generateRandomCardValues();
    }
    @Test
    void testInitiateGenerator(){
        Assertions.assertNotNull(generatorOrder);
    }

    @Test
    void testGeneratorRandomSymbol(){
        for(CardSymbol cardSymbol : randomCardSymbols){
            System.out.println(cardSymbol.toString());
        }
        Assertions.assertEquals(4,  randomCardSymbols.size());

    }

    @Test
    void testGeneratorRandomValues(){
        for(CardValue cardValue : this.randomCardValues){
            System.out.println(cardValue.toString());
        }
        System.out.println(this.randomCardValues.get(0));
        Assertions.assertEquals( 13, randomCardValues.size());
    }


    @Test
    void testGenerateCustomOrderListOrderCustomSymbolEqualOrderCustomCard(){

        //Element to compare
        CardSymbol cardSymbol = randomCardSymbols.get(0);

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertEquals(cardSymbol, generateCustomOrder.get(0).getColor());
        Assertions.assertEquals(cardSymbol, generateCustomOrder.get(4).getColor());
    }

    @Test
    void testGenerateCustomOrderListOrderCustomValueEqualOrderCustomCard(){

        //Element to compare
        CardValue cardSymbol0 = randomCardValues.get(0);
        CardValue cardSymbol1 = randomCardValues.get(1);

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertEquals(cardSymbol0, generateCustomOrder.get(0).getValue());
        Assertions.assertEquals(cardSymbol0, generateCustomOrder.get(1).getValue());
        Assertions.assertEquals(cardSymbol0, generateCustomOrder.get(2).getValue());
        Assertions.assertEquals(cardSymbol0, generateCustomOrder.get(3).getValue());
        Assertions.assertEquals(cardSymbol1, generateCustomOrder.get(4).getValue());
        Assertions.assertEquals(cardSymbol1, generateCustomOrder.get(5).getValue());
        Assertions.assertEquals(cardSymbol1, generateCustomOrder.get(6).getValue());
        Assertions.assertEquals(cardSymbol1, generateCustomOrder.get(7).getValue());
    }

    @Test
    void testGenerateCustomOrderListCardDifferentValueSymbol(){

        //Element to compare
        Card card1 = new Card(randomCardValues.get(4), randomCardSymbols.get(2));
        Card card2 = new Card(randomCardValues.get(2), randomCardSymbols.get(1));

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertTrue(generateCustomOrder.indexOf(card2) < generateCustomOrder.indexOf(card1));
    }


    @Test
    void testGenerateCustomOrderListCardDifferentSameValueDifferentSymbol(){

        int indexValueCard1 = 4;
        int indexSymbolCard1 = 2;
        int indexValueCard2 = 4;
        int indexSymbolCard2 = 1;

        //Element to compare
        Card card1 = new Card(randomCardValues.get(indexValueCard1), randomCardSymbols.get(indexSymbolCard1));
        Card card2 = new Card(randomCardValues.get(indexValueCard2), randomCardSymbols.get(indexSymbolCard2));

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        System.out.println(card1);
        System.out.println(card2);

        Assertions.assertEquals(indexValueCard1*CardSymbol.values().length+ indexSymbolCard1,generateCustomOrder.indexOf(card1));
        Assertions.assertEquals(indexValueCard2*CardSymbol.values().length+ indexSymbolCard2,generateCustomOrder.indexOf(card2));
        Assertions.assertTrue(generateCustomOrder.indexOf(card2) < generateCustomOrder.indexOf(card1));
    }

    @Test
    void testGenerateCustomOrderListCardDifferentDifferentValueSameSymbol(){


        //Element to compare
        Card card1 = new Card(randomCardValues.get(2), randomCardSymbols.get(2));
        Card card2 = new Card(randomCardValues.get(5), randomCardSymbols.get(2));

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertTrue(generateCustomOrder.indexOf(card2) > generateCustomOrder.indexOf(card1));
    }

    @Test
    void testGenerateCustomOrderListCardDifferentSameValueSameSymbol(){


        //Element to compare
        Card card1 = new Card(randomCardValues.get(5), randomCardSymbols.get(2));
        Card card2 = new Card(randomCardValues.get(5), randomCardSymbols.get(2));

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertTrue(generateCustomOrder.indexOf(card2) == generateCustomOrder.indexOf(card1));
    }

    @Test
    void testGenerateCustomOrderListCardFirstFourCardWithSameValue(){

        //Element to compare

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertEquals(generateCustomOrder.get(0).getValue().getValue(),generateCustomOrder.get(1).getValue().getValue());
        Assertions.assertEquals(generateCustomOrder.get(0).getValue().getValue(),generateCustomOrder.get(2).getValue().getValue());
        Assertions.assertEquals(generateCustomOrder.get(0).getValue().getValue(),generateCustomOrder.get(3).getValue().getValue());
    }

    @Test
    void testGenerateCustomOrderListCardFirstFourCardWithDifferentSymbol(){

        //Element to compare

        List<Card> generateCustomOrder = generatorOrder.generateCustomOrderCardByValueThenSymbol(randomCardValues, randomCardSymbols);

        Assertions.assertNotEquals(generateCustomOrder.get(0).getColor(),generateCustomOrder.get(1).getColor());
        Assertions.assertNotEquals(generateCustomOrder.get(0).getColor(),generateCustomOrder.get(2).getColor());
        Assertions.assertNotEquals(generateCustomOrder.get(0).getColor(),generateCustomOrder.get(3).getColor());
    }
}
