package com.projects.pokemon.service;

import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
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

    @GET("api/v2/pokemon-species/{id}")
    Call<PokeApiPokemonSpecies> getPokemonSpecie(@Path("id") Integer id);

    @GET("api/v2/evolution-chain/{id}")
    Call<PokeApiPokemonEvolutionChain> getPokemonEvolution(@Path("id") Integer id);

}
