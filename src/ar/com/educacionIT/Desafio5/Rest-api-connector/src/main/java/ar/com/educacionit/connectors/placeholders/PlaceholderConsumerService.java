package ar.com.educacionit.connectors.placeholders;

import java.util.List;

import ar.com.educacionit.connectors.placeholders.dto.UserDTO;

public interface PlaceholderConsumerService {
	public UserDTO getUser(String id);
	public List<UserDTO> getAllUsers();
}
