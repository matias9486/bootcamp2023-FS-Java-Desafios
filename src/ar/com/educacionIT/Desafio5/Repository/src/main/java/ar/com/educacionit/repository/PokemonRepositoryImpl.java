package ar.com.educacionit.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.domain.Pokemon;

public class PokemonRepositoryImpl extends BaseCrud<Pokemon> implements PokemonRepository{
	
	public PokemonRepositoryImpl() {
		super(Pokemon.class, "pokemon");
	}
	
	@Override
	protected Pokemon fromResultSetToEntity(ResultSet res) throws SQLException {
		Long id = (res.getLong(1));
		Integer pokemonId = (res.getInt(2));	
		String name = (res.getString(3));	
		Integer height = (res.getInt(4));	
		Integer weight = (res.getInt(5));
				
		return new Pokemon(pokemonId, name, height, weight);		
	}

	@Override
	protected String getSaveSQL() {		
		return "(pokemonId,name,height,weight) values (?,?,?,?)";
	}

	@Override
	protected void saveEntity(Pokemon entidad, PreparedStatement pst) throws SQLException {
		pst.setLong(1, entidad.getId());	
		pst.setString(2, entidad.getName());
		pst.setLong(3, entidad.getHeight());
		pst.setLong(4, entidad.getWeight());
		
	}

	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setUpdateSQL(Pokemon entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
