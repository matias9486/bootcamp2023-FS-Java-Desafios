package ar.com.educacionit.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.domain.Placeholder;

public class PlaceholderRepositoryImpl extends BaseCrud<Placeholder> implements PlaceholderRepository{
	
	public PlaceholderRepositoryImpl() {
		super(Placeholder.class, "placeholder");
	}
	
	@Override
	protected Placeholder fromResultSetToEntity(ResultSet res) throws SQLException {
		Long id = (res.getLong(1));
		Integer userId = (res.getInt(2));
		String name = (res.getString(3));
		String username = (res.getString(4));
		String email = (res.getString(5));
		String phone = (res.getString(6));
		String website = (res.getString(7));
		
		return new Placeholder( id, userId, name, username, email, phone, website);		
	}

	@Override
	protected String getSaveSQL() {		
		return "(userId,name,username,email,phone,website) values (?,?,?,?,?,?)";
	}

	@Override
	protected void saveEntity(Placeholder entidad, PreparedStatement pst) throws SQLException {
		pst.setLong(1, entidad.getUserId());	
		pst.setString(2, entidad.getName());
		pst.setString(3, entidad.getUsername());
		pst.setString(4, entidad.getEmail());
		pst.setString(5, entidad.getPhone());
		pst.setString(6, entidad.getWebsite());		
		
	}

	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setUpdateSQL(Placeholder entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
