package com.atexo.cartes.service;

import com.atexo.cartes.entity.Card;
import com.atexo.cartes.exceptions.GamesException;

import java.util.List;

public interface GeneratorCardGames {

    List<Card> generateCard() throws GamesException;
}
