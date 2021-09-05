package com.atexo.cartes.service;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class GeneratorCardGamesTests {

    @Autowired
    GeneratorCardGames generatorCardGames;

    @Test
    void testInstanceService() {
        Assertions.assertNotNull(generatorCardGames);
    }

    @Test
    void testGeneratorCardGamesServices() {

        try {
            List<Card> card = generatorCardGames.generateCard();
            for(Card cardd : card){
                System.out.println(cardd.toString());
            }
            Assertions.assertEquals( 52, card.size());
        } catch (GamesException e) {
            Assertions.fail(e.getMessage());
        }

    }
}
