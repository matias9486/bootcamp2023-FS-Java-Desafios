package ar.com.educacionit.repository;

import java.util.Collection;

public interface BaseRepository<T> {
	public void save(T entidad);

	public void delete(Long id);

	public void update(T entidad);

	public T getById(Long id);
	
	public T getByCampo(String campo, String valorBuscado);

	public Collection<T> findAll();
}
