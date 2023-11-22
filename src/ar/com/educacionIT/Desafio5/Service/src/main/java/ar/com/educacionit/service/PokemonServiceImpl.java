package ar.com.educacionit.service;

import ar.com.educacionit.domain.Pokemon;
import ar.com.educacionit.repository.PokemonRepositoryImpl;

public class PokemonServiceImpl extends AbstractEntidadBaseService<Pokemon> implements PokemonService{

	public PokemonServiceImpl() {
		super(new PokemonRepositoryImpl());
	}

}
