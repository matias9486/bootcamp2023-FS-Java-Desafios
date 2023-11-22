package ar.com.educacionit.connectors.pokemon;

import java.util.List;

import ar.com.educacionit.connectors.pokemon.dto.PokemonDTO;

public class PokemonConsumerServiceImp implements PokemonConsumerService{
	private PokemonConnector executor;
	
	public PokemonConsumerServiceImp(String url) {
		this.executor = new PokemonConnector(url);
	}
	
	@Override
	public PokemonDTO getPokemon(String nombre) {		
		return executor.get("/pokemon/"+nombre);
	}
	
	@Override
	public List<PokemonDTO> getAllPokemon() {		
		return executor.getAll("/pokemon");
	}
}
