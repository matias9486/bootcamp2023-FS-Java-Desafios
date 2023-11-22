package ar.com.educacionit.controllers.jersey;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.Dto.ResponsePokemonDTO;
import ar.com.educacionit.connectors.pokemon.PokemonConsumerServiceImp;
import ar.com.educacionit.connectors.pokemon.dto.PokemonDTO;
import ar.com.educacionit.domain.Pokemon;

import ar.com.educacionit.service.PokemonService;
import ar.com.educacionit.service.ServiceLocator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/pokemon")

public class PokemonController extends HttpServlet{
	
	private static final long serialVersionUID = -8994421737612249178L;
	
	public boolean validarTexto(String numero) {
        String regex = "\\d*";
        return numero.matches(regex);
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		PokemonDTO pokemon = null;
		ObjectMapper mapper = new ObjectMapper();
		String mensaje;
		
		//recuperar parametro de la consulta
		String name = req.getParameter("name");
		
		if(name == null || name.isEmpty() || validarTexto(name)) {
			mensaje = "Name invalido";			
		}else {				
			//Buscar en BD
			PokemonService serviceDB = (PokemonService) ServiceLocator.getService(PokemonService.class);
			Pokemon buscado = serviceDB.buscarPorCampo("name", "'"+name+"'");
			
			if(buscado != null) {			
				//generar pokemon
				pokemon = new PokemonDTO();
				pokemon.setId(buscado.getId());
				pokemon.setName(buscado.getName());
				pokemon.setHeight(buscado.getHeight());
				pokemon.setWeight(buscado.getWeight());
								
				mensaje = "Encontrado en base de datos.";		
			}else {
				//Buscar en API externa				
				PokemonConsumerServiceImp service = new PokemonConsumerServiceImp("https://pokeapi.co/api/v2");
								
				//Obtener dato y Generar objeto a partir de la API
				pokemon = service.getPokemon(name);						
				if(pokemon != null) {
					//generar Objeto a guardar
					Pokemon nuevo = new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getHeight(), pokemon.getWeight());								
					serviceDB.guardar(nuevo);
					mensaje = "Encontrado en API y guardado en base de datos.";
				}else {
					mensaje = "Pokemon no encontrado en API ni en base de datos.";
				}		
			}
		}
		//Generar respuesta
		ResponsePokemonDTO response = new ResponsePokemonDTO(mensaje, pokemon);
		//Generar JSON
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		//devolver respuesta
		resp.getWriter().print(json);
				
	}
}


//PokemonServiceImp service = new PokemonServiceImp("https://pokeapi.co/api/v2");
//ObjectMapper mapper = new ObjectMapper();
//
////buscar pokemon por nombre
//String nombre = req.getParameter("nombre");
//PokemonDTO pokemon = service.getPokemon(nombre);
//String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pokemon);
//resp.getWriter().print(json);