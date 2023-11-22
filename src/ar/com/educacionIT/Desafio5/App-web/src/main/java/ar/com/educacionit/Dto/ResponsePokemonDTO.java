package ar.com.educacionit.Dto;

import ar.com.educacionit.connectors.pokemon.dto.PokemonDTO;

public class ResponsePokemonDTO {
	private String mensaje;
	private PokemonDTO pokemon;
	
	public ResponsePokemonDTO(String mensaje, PokemonDTO pokemon) {				
		this.mensaje = mensaje;
		this.pokemon = pokemon;
	}
		
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public PokemonDTO getPokemon() {
		return pokemon;
	}

	public void setPokemon(PokemonDTO pokemon) {
		this.pokemon = pokemon;
	}


}
