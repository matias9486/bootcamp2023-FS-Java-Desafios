package ar.com.educacionit.connectors.placeholders;

import java.util.List;

import ar.com.educacionit.connectors.placeholders.dto.UserDTO;

public class PlaceholderConsumerServiceImp implements PlaceholderConsumerService{
private PlaceholderConnector executor;

	public PlaceholderConsumerServiceImp(String url) {
		this.executor = new PlaceholderConnector(url);
	}
	
	@Override
	public UserDTO getUser(String id) {		
		return executor.get("/users/"+id);
	}
	
	@Override
	public List<UserDTO> getAllUsers() {		
		return executor.getAll("/users");
	}
		
}
