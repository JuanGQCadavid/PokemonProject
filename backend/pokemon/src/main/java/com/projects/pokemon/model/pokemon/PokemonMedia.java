package com.projects.pokemon.model.pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonMedia {
    private String mediumSizePicture;
    private String normalSizePicture;
}
