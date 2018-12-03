package webservice.fiap;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

@Path("Consultas")
public class ConsultasResource {

	
	private List<Consulta> listaConsultas;
	
	 
	
	static private HashMap consultasMap;
	
	
	static {

		consultasMap = new HashMap<Integer, Consulta>();
		
		Paciente p1 = new Paciente("Oswaldo","40406816816");
		Paciente p2 = new Paciente("Astolfo","40406816817");
		Paciente p3 = new Paciente("Aroldo","40406816818");
		
		Medico m1 = new Medico ("Geraldo","Clinico Geral");
		Medico m2 = new Medico ("Demetrio","Gastro");
		Medico m3 = new Medico ("Messias","Neuro");
		
		Date diaConsulta = new Date(2018,11,15,12,55,33);
		Date diaConsulta2 = new Date(2018,11,15,13,55,33);
		Date diaConsulta3 = new Date(2018,11,15,14,55,33);
		
		diaConsulta = new Date();
		diaConsulta2 = new Date(2018, 12, 15);
		diaConsulta3 = new Date(2018, 12, 18);
		
		Consulta consulta = new Consulta(1, p1,m1,diaConsulta);
		
		Consulta consulta2 = new Consulta(2, p2,m2,diaConsulta2);
		
		Consulta consulta3 = new Consulta(3, p3,m3,diaConsulta3);
		
				consultasMap.put(1, consulta);
				consultasMap.put(2, consulta2);
				consultasMap.put(3, consulta3);
				
	}
	
	@GET
	@Produces("text/xml")
	public ArrayList<Consulta> getListaConsultas() {

		return new ArrayList<Consulta>(consultasMap.values());
	}

	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String adicionaConsulta(Consulta consulta) {
		consulta.setId(consultasMap.size() + 1);
		consultasMap.put(consulta.getId(), consulta);
		
		return "Paciente : " + consulta.getPaciente().getNome() + " Cadastrado com Sucesso!";
	}
	
	@Path("{nome}")
	@GET
	@Produces("text/xml")
	public ArrayList<Consulta> getListaConsultasPorMedico(@PathParam("nome") String nome) {
		
		List consultasMedicoList= new ArrayList<Consulta>();
		
		ArrayList<Consulta> consultas = 	getListaConsultas();
		
		for(int i = 0; i<consultas.size() ; i++) {
			if(consultas.get(i).getMedico().getNome().equals(nome)) {
				consultasMedicoList.add(consultas.get(i));
			}
			
		}
		return  (ArrayList<Consulta>) consultasMedicoList;
	}

}
