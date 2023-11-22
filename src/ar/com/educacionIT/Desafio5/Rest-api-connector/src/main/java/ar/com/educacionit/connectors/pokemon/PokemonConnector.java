package ar.com.educacionit.connectors.pokemon;

import java.util.List;

import ar.com.educacionit.connectors.RestClientConnector;
import ar.com.educacionit.connectors.pokemon.dto.PokemonDTO;
import jakarta.ws.rs.core.GenericType;

public class PokemonConnector extends RestClientConnector<PokemonDTO> {

	public PokemonConnector(String url) {
		super(url, PokemonDTO.class, new GenericType< List<PokemonDTO>>() {});		
	}

}
