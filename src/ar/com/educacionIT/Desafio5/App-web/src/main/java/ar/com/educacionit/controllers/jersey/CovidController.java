package ar.com.educacionit.controllers.jersey;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.Dto.ResponseCovidDTO;
import ar.com.educacionit.connectors.covid.dto.CovidDTO;
import ar.com.educacionit.connectors.covid.CovidConsumerServiceImp;
import ar.com.educacionit.domain.Covid;
import ar.com.educacionit.service.CovidService;
import ar.com.educacionit.service.ServiceLocator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/covid")
public class CovidController extends HttpServlet{
	private static final long serialVersionUID = 6311514831060995463L;
	
	public boolean validarTextoNumerico(String numero) {
        String regex = "\\d*";
        return numero.matches(regex);
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		CovidDTO covid = null;
		ObjectMapper mapper = new ObjectMapper();
		String mensaje;
		
		//recuperar parametro de la consulta
		String date = req.getParameter("date");
		
		System.out.println("date " + date);
		date = date.replace("-", "");
		if(date == null || date.isEmpty() || !validarTextoNumerico(date)) {
			mensaje = "Fecha invalida";			
		}else {				
			//Buscar en BD
			CovidService serviceDB = (CovidService) ServiceLocator.getService(CovidService.class);
			Covid buscado = serviceDB.buscarPorCampo("date", "'"+date +"'");
			
			if(buscado != null) {			
				//generar CovidDTO
				covid = new CovidDTO();
				covid.setDate(buscado.getDate());
				covid.setDeath(buscado.getDeath());
				covid.setHospitalized(buscado.getHospitalized());
				covid.setNegative(buscado.getNegative());
				covid.setPending(buscado.getPending());
				covid.setPositive(buscado.getPositive());
				covid.setStates(buscado.getStates());
				covid.setTotalTestResults(buscado.getTotalTestResults());
				mensaje = "Encontrado en base de datos.";		
			}else {
				//Buscar en API externa
				CovidConsumerServiceImp service = new CovidConsumerServiceImp("https://api.covidtracking.com/v1/us/");
								
				//Obtener dato y Generar objeto a partir de la API
				covid = service.getDate(date);						
				if(covid != null) {
					//generar Objeto a guardar
					Covid nuevo = new Covid( covid.getDate(), covid.getStates(), covid.getPositive(), covid.getNegative(), covid.getPending(), covid.getDeath(), covid.getHospitalized(), covid.getTotalTestResults());								
					serviceDB.guardar(nuevo);
					mensaje = "Encontrado en API y guardado en base de datos.";
				}else {
					mensaje = "Fecha no encontrada en API ni en base de datos.";
				}
				
			}			
		}
		
		
		//Generar respuesta
		ResponseCovidDTO response = new ResponseCovidDTO(mensaje, covid);
		//Generar JSON
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		//devolver respuesta
		resp.getWriter().print(json);
	}

}

//https://api.covidtracking.com/v1/us/