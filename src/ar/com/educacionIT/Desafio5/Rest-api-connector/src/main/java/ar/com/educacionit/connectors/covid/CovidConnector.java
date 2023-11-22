package ar.com.educacionit.connectors.covid;

import java.util.List;

import ar.com.educacionit.connectors.RestClientConnector;
import ar.com.educacionit.connectors.covid.dto.CovidDTO;
import jakarta.ws.rs.core.GenericType;


public class CovidConnector extends RestClientConnector<CovidDTO>{

	public CovidConnector(String url) {
		super(url, CovidDTO.class, new GenericType< List<CovidDTO>>() {});		
	}
}
