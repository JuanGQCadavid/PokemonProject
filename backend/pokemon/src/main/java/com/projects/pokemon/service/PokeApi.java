package com.projects.pokemon.service;

import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApi {

    @GET("api/v2/pokemon/")
    Call<PokeApiPokemonResponse> getPokemon(@Query("offset") Integer offset, @Query("limit") Integer limit);

    @GET("api/v2/pokemon/{name}")
    Call<PokeApiPokemonFullInfoResponse> getPokemonByName(@Path("name") String name);

    @GET("api/v2/pokemon/{id}")
    Call<PokeApiPokemonFullInfoResponse> getPokemonById(@Path("id") Integer id);

}
