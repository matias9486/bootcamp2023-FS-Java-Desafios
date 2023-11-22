package ar.com.educacionit.connectors.pokemon;

import java.util.List;

import ar.com.educacionit.connectors.pokemon.dto.PokemonDTO;

public interface PokemonConsumerService {
	public PokemonDTO getPokemon(String nombre);
	public List<PokemonDTO> getAllPokemon();
}
