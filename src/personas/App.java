package personas;

import java.io.IOException;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws IOException{
		
		List<Persona> personas = GestionarPersonas.getPersonas("personas.txt");
		GestionarPersonas.escribirMayoresDeEdadOrdenadasPorDNI(personas, 35);
		GestionarPersonas.escribirMayoresDeEdadOrdenadasPorEdad(personas, 35);
	}

}
