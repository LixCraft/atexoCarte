package com.atexo.cartes;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;
import com.atexo.cartes.implementation.CardHandImpl;
import com.atexo.cartes.implementation.GeneratorOrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class CartesApplication {

    @Autowired
    GeneratorOrderImpl generatorOrderImpl;
    @Autowired
    CardHandImpl cardHandImpl;

    public static void main(String[] args) {
        SpringApplication.run(CartesApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("-----Génération d'un ordre aléatoire des couleurs-----");
        List<CardSymbol> cardSymbols = generatorOrderImpl.generateRandomCardSymbols();
        for (CardSymbol cardSymbol : cardSymbols) {
            System.out.println(cardSymbol.toString());
        }
        System.out.println("-----Génération d'un ordre aléatoire des valeurs-----");
        List<CardValue> cardValues = generatorOrderImpl.generateRandomCardValues();
        for (CardValue cardValue : cardValues) {
            System.out.println(cardValue.toString());
        }
        int numberOfCards = 10;
        System.out.println("-----Génération aléatoire d'une main de " + numberOfCards + " cartes -----");
        try {
            List<Card> rowCardPackage = cardHandImpl.generateCardHand(numberOfCards);
            for (Card card : rowCardPackage) {
                System.out.println(card.toString());
            }
            System.out.println("-----Tri de la main de " + numberOfCards + " cartes -----");
            List<Card> sortedCardPackage = cardHandImpl.sortCardHandByValueSymbols(rowCardPackage, cardValues, cardSymbols);
            for (Card card : sortedCardPackage) {
                System.out.println(card.toString());
            }
        } catch (GamesException e) {
            System.out.println("Erreur lors de la generation d'une main de " + numberOfCards + " cartes)");
        }


    }


}
