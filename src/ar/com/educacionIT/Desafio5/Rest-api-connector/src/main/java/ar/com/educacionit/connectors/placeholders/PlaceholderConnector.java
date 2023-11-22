package ar.com.educacionit.connectors.placeholders;

import java.util.List;

import ar.com.educacionit.connectors.RestClientConnector;
import ar.com.educacionit.connectors.placeholders.dto.UserDTO;
import jakarta.ws.rs.core.GenericType;

public class PlaceholderConnector extends RestClientConnector<UserDTO>{

	public PlaceholderConnector(String url) {
		super(url, UserDTO.class, new GenericType< List<UserDTO>>() {});		
	}

}
