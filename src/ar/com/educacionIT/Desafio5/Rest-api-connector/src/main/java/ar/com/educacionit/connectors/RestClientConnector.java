package ar.com.educacionit.connectors;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public abstract class RestClientConnector<T> {

	private String url;
	//tipo de la clase con la cual trabajara
	private Class<T> type;
	private GenericType<List<T>> listType;

	public RestClientConnector(String url, Class<T> type, GenericType<List<T>> listType) {
		this.url = url;
		this.type = type;
		this.listType = listType;
	}

	//obtener Objeto respuesta de API  - consumir API
	public T get(String path) {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(url);
		
		if(path != null) {
			target = target.path(path);
		}

		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocation.get();
				
		//agregado			
		if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {			
			return null;
		}
				
		//--------------
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());			
		}
		
		T responseDto = this.buildFromResponse(response);
		
		return responseDto;
		
		
	}

	//obtener Lista respuesta de API  - consumir API
	public List<T> getAll(String path) {

		Invocation.Builder invoBuilder = buildInvocationBuilder(path);
		
		Response response = invoBuilder.get(); 
		
		List<T> responseDto = this.buildListFromResponse(response);

		return responseDto;
	}
	
	//ejecutar el post
	public Object create(Object dto) {

		Invocation.Builder invocation = buildInvocationBuilder(null);
		
		Response response = this.buildPost(invocation, dto);

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}
		
		return this.buildFromResponse(response);
	}
	
	//construir el post de la invocacion
	protected Response buildPost(Builder invocation, Object dto) {
		return invocation.post(Entity.entity(dto,MediaType.APPLICATION_JSON));
	}
	
	// crear invocacion
	protected Invocation.Builder buildInvocationBuilder(String path) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(url); 
				
		if(path != null) {
			target = target.path(path);
		}
	
		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);

		/*Response response = this.buildResponse(invocation);

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}
		return response;
		*/
		return invocation;
	}

	//crear objeto segun respuesta
	protected T buildFromResponse(Response response) {
		// un objeto simple
		return response.readEntity(this.type);
	}

	//crear lista segun respuesta
	protected List<T> buildListFromResponse(Response response) {
		return response.readEntity(this.listType);
	}
}
