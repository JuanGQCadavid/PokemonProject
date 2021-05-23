package com.projects.pokemon.service;

import com.projects.pokemon.model.PokemonCardInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    public List<PokemonCardInfo> fetchCards(Integer startPoint, Integer packageSize) {

        PokemonCardInfo cardInfo = new PokemonCardInfo();
        cardInfo.setPokeId(1);

        ArrayList arrayList = new ArrayList();
        arrayList.add(cardInfo);

        return arrayList;
    }
}
