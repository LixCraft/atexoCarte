package com.atexo.cartes.implementation;

import com.atexo.cartes.constante.CardSymbol;
import com.atexo.cartes.constante.CardValue;
import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;
import com.atexo.cartes.service.GeneratorCardGames;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GeneratorCardGamesImpl implements GeneratorCardGames {

    @Override
    public List<Card> generateCard() throws GamesException {
        List<Card> cardPackage = new ArrayList<>();
        if(CardValue.values().length > 0 && CardSymbol.values().length > 0){
            for(CardValue cardValue : CardValue.values()){
                for(CardSymbol cardSymbol : CardSymbol.values()){
                    cardPackage.add(new Card(cardValue, cardSymbol));
                }
            }
        } else {
            throw new GamesException("CardValue/CardSymbol is empty");
        }
        return cardPackage;
    }
}
