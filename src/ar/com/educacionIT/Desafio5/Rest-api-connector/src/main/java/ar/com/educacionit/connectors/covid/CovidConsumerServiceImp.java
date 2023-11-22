package ar.com.educacionit.connectors.covid;

import ar.com.educacionit.connectors.covid.dto.CovidDTO;

public class CovidConsumerServiceImp implements CovidConsumerService {
	private CovidConnector executor;

	public CovidConsumerServiceImp(String url) {
		this.executor = new CovidConnector(url);
	}

	@Override
	public CovidDTO getDate(String date) { 
		return executor.get("/"+date +".json");
	}
}
