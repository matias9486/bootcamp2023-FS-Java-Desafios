package ar.com.educacionit.service;

import ar.com.educacionit.domain.Covid;
import ar.com.educacionit.repository.CovidRepositoryImpl;

public class CovidServiceImpl extends AbstractEntidadBaseService<Covid> implements CovidService{
	public CovidServiceImpl() {
		super(new CovidRepositoryImpl());
	}
}
