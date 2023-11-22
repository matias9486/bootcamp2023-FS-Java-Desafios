package ar.com.educacionit.connectors.covid;

import ar.com.educacionit.connectors.covid.dto.CovidDTO;

public interface CovidConsumerService {
	public CovidDTO getDate(String date);	
}
