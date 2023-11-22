package ar.com.educacionit.controllers.jersey;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.Dto.ResponsePlaceholderDTO;

import ar.com.educacionit.connectors.placeholders.PlaceholderConsumerServiceImp;
import ar.com.educacionit.connectors.placeholders.dto.UserDTO;

import ar.com.educacionit.domain.Placeholder;

import ar.com.educacionit.service.PlaceholderService;
import ar.com.educacionit.service.ServiceLocator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@SuppressWarnings({"serial", "rawtypes", "unchecked"})		//"ignora" las advertencias
@WebServlet("/api/placeholder")
public class PlaceholderController extends HttpServlet{	
	private static final long serialVersionUID = -6156794217266930927L;

	public boolean validarTextoNumerico(String numero) {
        String regex = "\\d*";
        return numero.matches(regex);
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		UserDTO user = null;
		ObjectMapper mapper = new ObjectMapper();
		String mensaje;
		
		//recuperar parametro de la consulta
		String id = req.getParameter("id");
		
		if(id == null || id.isEmpty() || !validarTextoNumerico(id)) {
			mensaje = "Id invalido";			
		}else {				
			//Buscar en BD
			PlaceholderService serviceDB = (PlaceholderService) ServiceLocator.getService(PlaceholderService.class);
			Placeholder buscado = serviceDB.buscarPorCampo("userId", "'"+id +"'");
			
			if(buscado != null) {			
				//generar UserDtoResume
				user = new UserDTO();
				user.setId(buscado.getUserId());
				user.setName(buscado.getName());
				user.setUsername(buscado.getUsername());
				user.setEmail(buscado.getEmail());
				user.setPhone(buscado.getPhone());
				user.setWebsite(buscado.getWebsite());
				mensaje = "Encontrado en base de datos.";		
			}else {
				//Buscar en API externa
				PlaceholderConsumerServiceImp service = new PlaceholderConsumerServiceImp("https://jsonplaceholder.typicode.com");
								
				//Obtener dato y Generar objeto a partir de la API
				user = service.getUser(id);						
				if(user != null) {
					//generar Objeto a guardar
					Placeholder nuevo = new Placeholder(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPhone(), user.getWebsite() );								
					serviceDB.guardar(nuevo);
					mensaje = "Encontrado en API y guardado en base de datos.";
				}else {
					mensaje = "Usuario no encontrado en API ni en base de datos.";
				}
				
			}
		}
		//Generar respuesta
		ResponsePlaceholderDTO response = new ResponsePlaceholderDTO(mensaje, user);
		//Generar JSON
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		//devolver respuesta
		resp.getWriter().print(json);
	}
}


//buscar todos los usuarios
//List<UserDtoResume> usuarios = service.getAllUsers();
//String jsonList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(usuarios);			
//resp.getWriter().print(jsonList);
		