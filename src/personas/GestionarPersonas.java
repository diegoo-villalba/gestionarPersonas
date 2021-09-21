package personas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionarPersonas {
	
	public static LinkedList<Persona> getPersonas(String archivo){
		LinkedList<Persona> personas = new LinkedList<Persona>();
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(archivo));
			
			while (sc.hasNext()) {
				//Leo cada una de las lineas del archivo
				String linea = sc.nextLine();
				//Spliteo por separacion " "
				String datos[] = linea.split(" ");
				//Instancio un objeto Persona a partir de los datos leidos
				int dni = Integer.parseInt(datos[0]);
				String apellido = datos[1];
				int edad = Integer.parseInt(datos[2]);
				
				Persona p = new Persona(dni, apellido, edad);
				
				//Agrego la persona p instancia a la lista siempre y cuando no este
				if (!personas.contains(p))
					personas.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Cierro el archivo
		sc.close();
		return personas;
	}
	
	//METODO DE IMPRESION: genera un archivo.
	private static void escribirPersonas(List<Persona> personas, String file) throws IOException{
		//Trato la excepcion IOException porque podria ocurrir que intentemos escribir un espacio "read only"
		
		//Inicializamos el printWriter
		PrintWriter salida = new PrintWriter(new FileWriter(file));
		
		for(Persona persona : personas) {
			salida.println(persona); //A c/u de las personas (gracias al metodo ToString) la puedo escribir en el archivo
		}
		
		salida.close();
	}
	
	//METODOS PARA ORDENAR:
	public static void ordenarPersonasPorDNI(List<Persona> lista) {
		//Le paso al Collections la lista que quiero ordenar y el comparador que vamos a usar
		Collections.sort(lista, new DniComparator());
	}
	
	public static void ordenarPersonasPorEdad(List<Persona> lista) {
		Collections.sort(lista, new EdadComparator());
	}
	
	public static void ordenarPersonasPorApellido(List<Persona> lista) {
		Collections.sort(lista, new ApellidoComparator());
	}
	
	//Hacemos un filtro a partir de una lista de personas que le pasamos y una edad
	public static List<Persona> getPersonasMayoresDeEdad(List<Persona> personas, Integer edad) {
		
		//Declaro una lista auxiliar PersonasMayores donde van a parar aquellas con edad mayor a "> edad"
		List<Persona> personasMayores = new ArrayList<Persona>();
		for(Persona cu : personas)
			if (cu.getEdad() > edad)
				personasMayores.add(cu);
		
		return personasMayores;
	}
	
	public static void escribirMayoresDeEdadOrdenadasPorDNI(List<Persona> personas, int edad) throws IOException {
		List<Persona> personasMayores = getPersonasMayoresDeEdad(personas, edad);
		ordenarPersonasPorDNI(personasMayores);
		escribirPersonas(personasMayores, "MayoresDe" + edad + "OrdenadosPorDNI" + ".csv");
	}
	
	public static void escribirMayoresDeEdadOrdenadasPorEdad(List<Persona> personas, int edad) throws IOException {
		List<Persona> personasMayores = getPersonasMayoresDeEdad(personas, edad);
		ordenarPersonasPorEdad(personasMayores);
		escribirPersonas(personasMayores, "MayoresDe" + edad + "OrdenadosPorEdad" + ".csv");
	}
	
}

