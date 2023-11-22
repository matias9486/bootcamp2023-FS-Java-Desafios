package ar.com.educacionit.service;

import java.util.Collection;

import ar.com.educacionit.repository.BaseRepository;

public abstract class AbstractEntidadBaseService<T> implements EntidadBaseService<T> {

	protected BaseRepository<T> repository;
	
	public AbstractEntidadBaseService(BaseRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Collection<T> buscarTodos() {		
		return this.repository.findAll();
	}
	
	@Override
	public T buscarPoId(Long id) {
		return this.repository.getById(id);
	}
	
	@Override
	public T buscarPorCampo(String campo, String valorBuscado) {
		return this.repository.getByCampo(campo, valorBuscado);
	}
	
	@Override
	public void eliminarPorId(Long id) {
		this.repository.delete(id);
	}
	
	@Override
	public void guardar(T entity) {
		this.repository.save(entity);
	}
	
	@Override
	public void actualizar(T newUser) {
		this.repository.update(newUser);
	}
	
	
}
