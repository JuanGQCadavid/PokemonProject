package com.projects.pokemon.service;

import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApi {

    @GET("api/v2/pokemon/")
    Call<PokeApiPokemonResponse> getPokemon(@Query("offset") String offset, @Query("limit") String limit);

}
