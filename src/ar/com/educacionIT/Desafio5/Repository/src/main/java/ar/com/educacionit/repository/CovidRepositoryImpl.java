package ar.com.educacionit.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.domain.Covid;


public class CovidRepositoryImpl extends BaseCrud<Covid> implements CovidRepository{
	public CovidRepositoryImpl() {
		super(Covid.class, "covid");
	}
	@Override
	protected Covid fromResultSetToEntity(ResultSet res) throws SQLException {
		Long id = (res.getLong(1));
		Integer date = res.getInt(2);	
		Integer states = res.getInt(3);	
		Integer positive = res.getInt(4);	
		Integer negative = res.getInt(5);	
		Integer pending = res.getInt(6);
		Integer death = res.getInt(7);	
		Integer hospitalized = res.getInt(8);
		Integer totalTestResults = res.getInt(9);
		
		return new Covid(id, date, states, positive, negative, pending, death, hospitalized, totalTestResults);
	}
	@Override
	protected String getSaveSQL() {
		return "(date,states,positive,negative,pending,death,hospitalized,totalTestResults  ) values (?,?,?,?,?,?,?,?)";	
	}
	@Override
	protected void saveEntity(Covid entidad, PreparedStatement pst) throws SQLException {
		pst.setInt(1, entidad.getDate());	
		pst.setInt(2, entidad.getStates());
		pst.setInt(3, entidad.getPositive());
		pst.setInt(4, entidad.getNegative());
		pst.setInt(5, entidad.getPending());
		pst.setInt(6, entidad.getDeath());
		pst.setInt(7, entidad.getHospitalized());
		pst.setInt(8, entidad.getTotalTestResults());		
			
	}
	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void setUpdateSQL(Covid entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
