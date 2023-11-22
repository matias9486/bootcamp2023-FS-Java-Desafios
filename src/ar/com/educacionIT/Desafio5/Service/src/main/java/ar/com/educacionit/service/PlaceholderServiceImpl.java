package ar.com.educacionit.service;

import ar.com.educacionit.domain.Placeholder;
import ar.com.educacionit.repository.PlaceholderRepositoryImpl;

public class PlaceholderServiceImpl extends AbstractEntidadBaseService<Placeholder> implements PlaceholderService{
	

	public PlaceholderServiceImpl() {
		super(new PlaceholderRepositoryImpl());
	}

}
